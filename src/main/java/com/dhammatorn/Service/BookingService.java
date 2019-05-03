package com.dhammatorn.Service;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Collection;
import java.util.Optional;

//the service which maps logic from Controller to the specific function in the Repository + Email service
@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;

    private JavaMailSender javaMailSender;

    @Autowired
    public StudentService studentService;

    /* The following includes all functions to send email to user when the booking is successful */
    @Autowired
    public BookingService(JavaMailSender javaMailSender){
                this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Booking booking) throws MailException

    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentService.getStudentByUsername(auth.getName());
        String email = student.getEmail();
        //send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("ee.lab.system@gmail.com");
        mail.setSubject("Booking Success!");
        mail.setText("You currently booked on : " + booking.getStartTime() + " to "+ booking.getEndTime()
                        + ":00 with seats : " + booking.getSeatNo() +
        " __for " + booking.getLength() + " hr(s)." + " Please bring your UCARD " +
                        "and scan the system before using the lab. There will be penalities for not being present as " +
                        "in agreement and will result in your account being blacklisted."
        );

        javaMailSender.send(mail);

    }

    //saves specific booking for both user and admin
    public int saveBooking(Booking booking){
        //check if there is any booking on the same date
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        Boolean booked = false;
        if(booking.getStudent() == 0){
            for(Booking temp: bookings){
                if((temp.getSeatNo().equals(booking.getSeatNo())
                        && timeValid(booking,temp)
                        && temp.getLength() == booking.getLength()
                )){
                    booked = true;
                    System.out.println("Failed here admin ");
                }
            }
        }
        else {
            List<Booking> personal = new ArrayList<>();
            bookingRepository.findByStudent(booking.getStudent()).forEach(personal::add);
            for(Booking temp : personal){
                if(same_week(booking,temp) || single_date_validation(booking,temp)){
                    booked = true;
                }
            }

            for (Booking temp : bookings) {
                if (
                                temp.getSeatNo().equals(booking.getSeatNo())
                                && timeValid(booking, temp)
                                && temp.getLength() == booking.getLength()
                        )
                {
                    booked = true;
                    System.out.println("Failed here ");
                }
            }
        }

        if(booked == false) {
            bookingRepository.save(booking);
            return 1;
        }
        else {
            return 0;
        }
    }

    //check if the booking does not conflict with any other bookings on the system
    public Boolean timeValid(Booking booking, Booking temp) {


        LocalDateTime bookingStart = booking.getStartTime();
        LocalDateTime bookingEnd = booking.getEndTime();
        LocalDateTime tempStart = temp.getStartTime();
        LocalDateTime tempEnd = temp.getEndTime();

        if (booking.getEndTime().equals(temp.getEndTime())) return true;
        else if (booking.getStartTime().equals(temp.getStartTime())) return true;
        else {
            while (bookingEnd.equals(bookingStart) == false) {
                System.out.println("Loops 1");
                if (bookingStart.equals(tempStart)) return true;
                else bookingStart = bookingStart.plusHours(1);
            }
            while (tempStart.equals(temp.getEndTime()) == false) {
                System.out.println("Loops 2");
                if (tempStart.equals(bookingStart)) return true;
                else tempStart = tempStart.plusHours(1);
            }
        }
        System.out.println("Done 1");

        return false;
    }

    public List<Booking> getAllBookings(){
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

    public Optional<Booking> getBookingbyStudent(int Student){
         List<Booking> all_bookings = bookingRepository.findByStudent(Student);
         if(all_bookings.isEmpty()) return Optional.empty();
         else return Optional.of(all_bookings.get(0));
    }


    // Delete a booking by using a given ID
    public void deleteBookingById(int id) {
        bookingRepository.deleteById(id);
    }

    //function to get Student by ID
    //copy this to service to connect them
    public Optional<Booking> getBookingById(int id){
        return bookingRepository.findById(id);
    }

    public void updateBookingwithAttendance(Booking booking){
        bookingRepository.save(booking);
    }

    //validates if the date is correct on the booking
    public Boolean single_date_validation(Booking current, Booking temp){
        if(temp.getStartTime().getDayOfYear() - current.getStartTime().getDayOfYear() > 2) {
            return false;
        }
        else return true;
    }
    //checks if the booking is on the same week with another
    public Boolean same_week(Booking current, Booking temp){
        if(temp.getStartTime().getDayOfWeek().getValue() - current.getStartTime().getDayOfWeek().getValue() < 5) return true;
        else return false;
    }

    //check if calendar is not a leap year 
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

}
