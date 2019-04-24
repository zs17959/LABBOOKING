package com.dhammatorn.Controller;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.dhammatorn.Entity.Attendance;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Entity.Tempbooking;
import com.dhammatorn.Service.BookingService;
import com.dhammatorn.Service.StudentService;
//import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Controller
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    //Autowired means springboot will instantiate the injection automatically
    private StudentService studentService;

    @GetMapping("/book")
    public String bookingForm(Model model){
        model.addAttribute("tempbooking", new Tempbooking());
        return "booking";
    }

    @GetMapping("/length_error")
    public ModelAndView length_error(Tempbooking tempbooking){
        ModelAndView mav = new ModelAndView("bookings/book");
        mav.addObject("error", "Start and End time error");
        return mav;
    }

    @RequestMapping(value="/attendance", method = RequestMethod.GET)
    public ModelAndView attendance(){
        ModelAndView modelAndView = new ModelAndView();
        Attendance attend = new Attendance();
        modelAndView.addObject("attendance", attend);
        modelAndView.setViewName("attendance");
        return modelAndView;
    }

    @RequestMapping(value = "/attendance", method = RequestMethod.POST)
    public String check_attendance(@Valid Attendance attend) {

        String UCARD_id = attend.getUCARD();
//        System.out.println("This is ok ! 67");

        Student exist = studentService.getStudentByUcard(UCARD_id);
        if(!exist.getName().equals("-1")){
                Optional<Booking> booked_student = bookingService.getBookingbyStudent(exist.getId());

                if(booked_student.isPresent()) {
                    Booking present = booked_student.get();
                    if(present.getStudent() == exist.getId()) {
                        //Current Time
                        ZoneId zone = ZoneId.systemDefault();
                        LocalDateTime now = LocalDateTime.now(zone);

                        LocalDateTime startTime = present.getStartTime();
                        LocalDateTime endTime = present.getEndTime();
                        //check if start time and end time is correct
                        if(now.isBefore(endTime) && now.isAfter(startTime)){
                            present.setAttendance(true);
                            bookingService.updateBookingwithAttendance(present);
                            return "attendance_success";
                        }
                        else{
                            return "attendance_failed";
                        }

                    }
                    else{
                        return "attendance_failed";
                    }
                }

                else{
                    return "attendance_failed";
                }

        }
        else {
            return "not_registered";
        }
    }

    @PostMapping("/book")
//    @ResponseBody
    String bookingSubmit(@ModelAttribute @Valid Tempbooking tempbooking,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){

        int endTime = tempbooking.getEndTime();
        int length = endTime - tempbooking.getStartTime();

        Authentication authen = SecurityContextHolder.getContext().getAuthentication();
        Student loggedinstudent = studentService.getStudentByUsername(authen.getName());
        if (loggedinstudent.getStrikes() == 3){
            return "blacklisted";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createAccountModel", bindingResult);
            redirectAttributes.addFlashAttribute("tempbooking", tempbooking);
            return "booking";

//            return new RedirectView("/bookings/book");
        }
        else if(length <= 0){
            model.addAttribute("error","End time must be after Start time");
            return "booking";
        }
        else {
            Booking booking = new Booking();
            String day = tempbooking.getDay();
            ZoneId zone = ZoneId.systemDefault();


            LocalDateTime now = LocalDateTime.now(zone);


            DayOfWeek userBookedDay = translatorStringtoDOW(day);

            LocalDateTime startTime = LocalDateTime.now(zone);
            LocalDateTime finalEndTime = LocalDateTime.now(zone);
            for(int i = 0 ; i < 7; i++){
                DayOfWeek currentDay = now.getDayOfWeek();
                if(currentDay.equals(userBookedDay)) startTime = now;
                else now = now.plusDays(1);
            }

            for(int i = 0; i < 24; i++){
                int starthour = startTime.getHour();
                if(starthour != tempbooking.getStartTime()) startTime = startTime.plusHours(1);
            }

            finalEndTime = startTime.plusHours(length);
            //set min of both end time and start time
            finalEndTime = finalEndTime.withNano(0);
            finalEndTime = finalEndTime.withMinute(0);
            finalEndTime = finalEndTime.withSecond(0);

            startTime =  startTime.withNano(0);
            startTime = startTime.withMinute(0);
            startTime = startTime.withSecond(0);

            booking.setStartTime(startTime);
            booking.setEndTime(finalEndTime);
            booking.setLength(length);
            booking.setSeatNo(tempbooking.getSeatNo());
            booking.setNotes(tempbooking.getNotes());

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Student student = studentService.getStudentByUsername(auth.getName());
//            Student student = studentService.getStudentByUsername(auth.getName());
            int student_id = student.getId();
            booking.setStudent(student_id);
            booking.setAttendance(false);

            //equipments
            if (tempbooking.getCapacitors() == null) booking.setCapacitors(0);
            else {
//                System.out.println("Capacitor received ok!");
                booking.setCapacitors(tempbooking.getCapacitors());
            }

            if (tempbooking.getBnc_Tpiece() == null) booking.setBnc_Tpiece(0);
            else booking.setBnc_Tpiece(tempbooking.getBnc_Tpiece());

            if (tempbooking.getPrototyping_board() == null) booking.setPrototyping_board(0);
            else booking.setPrototyping_board(tempbooking.getPrototyping_board());

            if (tempbooking.getSolidCoreWire() == null) booking.setSolidCoreWire(0);
            else booking.setSolidCoreWire(tempbooking.getSolidCoreWire());

            if (tempbooking.getResistors() == null) booking.setResistors(0);
            else booking.setResistors(tempbooking.getResistors());

            if (tempbooking.getLcr400_bridge() == null) booking.setLcr400_bridge(0);
            else booking.setLcr400_bridge(tempbooking.getLcr400_bridge());

            if (tempbooking.getWire_strippers() == null) booking.setWire_strippers(0);
            else booking.setWire_strippers(tempbooking.getWire_strippers());

            if (tempbooking.getActive8() == null) booking.setActive8(0);
            else booking.setActive8(tempbooking.getActive8());

            if (tempbooking.getOscilloscope_trim() == null) booking.setOscilloscope_trim(0);
            else booking.setOscilloscope_trim(tempbooking.getOscilloscope_trim());

            if (tempbooking.getRsop() == null) booking.setRsop(0);
            else booking.setRsop(tempbooking.getRsop());

            if (tempbooking.getPower_supp() == null) booking.setPower_supp(0);
            else {
//                System.out.println("power Supp ok!");
                booking.setPower_supp(tempbooking.getPower_supp());
            }

            if (tempbooking.getBnc_croclead() == null) booking.setBnc_croclead(0);
            else booking.setBnc_croclead(tempbooking.getBnc_croclead());

            if (tempbooking.getBnc_lead() == null) booking.setBnc_lead(0);
            else booking.setBnc_lead(tempbooking.getBnc_lead());

            if (tempbooking.getRsop() == null) booking.setRsop(0);
            else booking.setRsop(tempbooking.getRsop());

            int feedback =   bookingService.saveBooking(booking);
            if(feedback == 1) {

                bookingService.sendNotification(booking);
                return "booking_success";
            }
            else{
                return "bookingfailed";
            }

            //return "booking_success";
//        return new RedirectView("/bookings/all");

        }
        }
//        else {
//            return new RedirectView("/bookings/bookingfailed");
//        }
//    }


    @GetMapping("/all")
    @ResponseBody
    public List<Booking> viewAllBookings(){
        return bookingService.getAllBookings();
    }

    public List<Booking> view_onlyUser(){
        List<Booking> user = viewAllBookings();
        List<Booking> to_return = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentService.getStudentByUsername(auth.getName());
        int student_id = student.getId();
        for(Booking temp: user){
            if(temp.getStudent() == student_id){
                to_return.add(temp);
            }
        }
        if(user.isEmpty()) System.out.println("NULL");
        return to_return;
    }

    @GetMapping(value = "/error")
    public String error(){return "error"; }

    @GetMapping(value = "/bookingfailed")
    public String booking_failed(){return "bookingfailed";}

    @RequestMapping("/admin_all_booking")
    public String display(Model model){
        model.addAttribute("admin_all_booking", viewAllBookings());
        return "admin_all_booking";
    }

//    @RequestMapping("/user_booking")
//    public String user_booking(Model model){
//        model.addAttribute("admin_all_booking", viewAllBookings());
//        return "admin_all_booking";
//    }

    @GetMapping(value = "/booking_success")
    public String booking_success(){return "booking_success"; }

    @GetMapping(value = "/not_registered")
    public String not_registed(){return "not_registered"; }

    @GetMapping(value = "/attendance_success")
    public String attendance_success(){return "attendance_success"; }


    @GetMapping(value = "/attendance_failed")
    public String attendance_failed(){return "attendance_failed"; }



    //value /{id} means we are going to pass an id from the URL and this method is going to output
    // a student according to that id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //Pathvariable means u actually want the id to be the one you send from the url
    public @ResponseBody Booking getBookingById(@PathVariable("id") int id) {
        Optional<Booking> maybeBooking = bookingService.getBookingById(id);
        if (maybeBooking.isPresent()) {
            Booking student = maybeBooking.get();
            return student;
        } else {
            //error
            Booking student = new Booking();
            return student;
        }
    }

    @RequestMapping("/userallbooking")
    public String display_useronly(Model model){
        model.addAttribute("userallbooking", view_onlyUser());
        return "userallbooking";
    }

    // Delete by Id
    @GetMapping(value = "/{id}/dlt")
    @ResponseBody
    public RedirectView deleteUser(@PathVariable("id") int id){
//        List<Booking> all_bookings = viewAllBookings();
//        int id;
//        for(Booking temp:all_bookings){
//            if(student == temp.getStudent()) id = temp.getID();
//        }
        bookingService.deleteBookingById(id);
        return new RedirectView("/bookings/admin_all_booking");
    }

    @GetMapping(value = "/{id}/delete")
    @ResponseBody
    public RedirectView deleteBookingforUser(@PathVariable("id") int id){
//        List<Booking> all_bookings = viewAllBookings();
//        int id;
//        for(Booking temp:all_bookings){
//            if(student == temp.getStudent()) id = temp.getID();
//        }
        ZoneId zone = ZoneId.systemDefault();

        LocalDateTime now = LocalDateTime.now(zone);
       Optional<Booking> op_user = bookingService.getBookingById(id);
       Booking user = op_user.get();
       if(user.getStartTime().isBefore(now)){
           return new RedirectView("/bookings/error");
       }
       else {
           bookingService.deleteBookingById(id);
           return new RedirectView("/bookings/userallbooking");
       }
    }

    public DayOfWeek translatorStringtoDOW(String day){
        if(day.equals("MON")) return DayOfWeek.MONDAY;
        else if (day.equals("TUE")) return DayOfWeek.TUESDAY;
        else if (day.equals("WED")) return DayOfWeek.WEDNESDAY;
        else if (day.equals("THU")) return DayOfWeek.THURSDAY;
        else return DayOfWeek.FRIDAY;
     }

}
