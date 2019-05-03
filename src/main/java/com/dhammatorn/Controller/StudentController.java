/*
LAB BOOKING AND ATTENDANCE - SPE 2018/19
This file is the controller file for the student and their actions which do not
include booking functionality.
This file is where the logic for the functions happens. It makes use of the file
StudentService, which is how it talks to the database and entities.
*/


package com.dhammatorn.Controller;

import com.dhammatorn.Entity.Student;
import com.dhammatorn.Entity.TempStudent;
import com.dhammatorn.Service.StudentService;
import com.dhammatorn.Entity.Register;
//import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collection;
import java.util.Optional;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*
    The index function.
    Returns the index page when the path "/" is
    requested.
    */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*
    The login funciton.
    Returns the login page which has a HTML form when the
    path "/login" is requested.
    */
    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /*
    This is the modified user index page which is displayed once a user logs in.
    The URL here is "/loggedinindex" and any page which can only be accessed
    by a logged in user the 'return to home' function would return this page,
    not the normal index.
    Returns model and view of "loggedinindex" page.
    */
    @RequestMapping(value="/loggedinindex", method = RequestMethod.GET)
    public ModelAndView loggedinindex(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentService.getStudentByUsername(auth.getName());
        modelAndView.addObject("userName", "Logged in: " + student.getName() + " " + student.getLastname() + " (" + student.getUsername() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.addObject("id", student.getId());
        modelAndView.setViewName("loggedinindex");
        return modelAndView;
    }



    /*
    The registration get method.
    Returns a model and view of the registration page.
    */
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Student student = new Student();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /*
    The registration post method.
    Here is where the validation for the registration page happens. It checks
    if the user currently exists and has validation on most of the fields in
    the registration form.
    Returns a model and view of the registration page.
    */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Student student, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        int studentExists = studentService.getMaybeStudentByUsername(student.getUsername());
        if (studentExists != 0) {
            bindingResult
                    .rejectValue("username", "error.student",
                            "There is already a user registered with the username provided                .");
        }

        String emailCheck = student.getEmail();
        if ((emailCheck.contains("@my.bristol.ac.uk") == false) && (emailCheck.contains("@bristol.ac.uk") == false)){
            bindingResult
                    .rejectValue("email", "error.student",
                            "Please use your Bristol email, ending in @(my.)bristol.ac.uk                   .");
        }

        String firstCheck = student.getName();
        if (firstCheck.contains("0") || firstCheck.contains("1") || firstCheck.contains("2")
            || firstCheck.contains("3") || firstCheck.contains("4") || firstCheck.contains("5")
            || firstCheck.contains("6") || firstCheck.contains("7") || firstCheck.contains("8")
            || firstCheck.contains("9")){
            bindingResult
                    .rejectValue("name", "error.student",
                            "Please do not include numbers in your first name.              .");
        }

        String lastCheck = student.getLastname();
        if (lastCheck.contains("0") || lastCheck.contains("1") || lastCheck.contains("2")
            || lastCheck.contains("3") || lastCheck.contains("4") || lastCheck.contains("5")
            || lastCheck.contains("6") || lastCheck.contains("7") || lastCheck.contains("8")
            || lastCheck.contains("9")){
            bindingResult
                    .rejectValue("lastname", "error.student",
                            "Please do not include numbers in your last name.               .");
        }


        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            studentService.saveStudent(student);
            modelAndView.addObject("successMessage", "Student has been registered successfully, return to home:    ");
            modelAndView.addObject("student", new Student());
            modelAndView.setViewName("index");
        }

        return modelAndView;
    }

    /*
    This function returns a list of all students.
    */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public @ResponseBody List<Student> getAllStudent() {
        return studentService.getAllStudent();

    }

    /*
    A test function, used for testing perposes.
    */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentByUsername() {
        Student student = studentService.getStudentByUsername("jim");
        return student;
    }


    /*
    Edit user function. This is the get method for edit user.
    It gets the current logged in user and passes that to the next function via
    the HTML form.
    Returns model and view of the edit user page.
    */
    @RequestMapping(value="/edituser", method = RequestMethod.GET)
    public ModelAndView edituser(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student current = studentService.getStudentByUsername(auth.getName());
//        System.out.println(current.getId());
        modelAndView.addObject("current", current);
        modelAndView.addObject("student", new TempStudent());
        modelAndView.setViewName("edit_users");
        return modelAndView;
    }

    /*
    Edit user function POST method.
    Here it updates the student object in the database with what they have
    entered in the HTML form
    Returns model and view of the edit user page.
    */
    @RequestMapping(value = "/edituserpost", method = RequestMethod.POST)
    public RedirectView completeEdituser(@Valid TempStudent student, BindingResult bindingResult) {

            int pid = Integer.parseInt(student.getId());
//            System.out.println(pid);

            Optional<Student> maybeStudent = studentService.getStudentById(pid);
            Student old = maybeStudent.get();

            old.setLastname(student.getLastname());
            old.setName(student.getName());
            old.setEmail(student.getEmail());
            old.setUcard(student.getUcard());

            studentService.updateStudent(old);


        return new RedirectView("/edit_success");
    }

    /*
    ADMIN PAGES
    Any page here starts with the URL "/admin", which can only be reached
    by users with the role ADMIN.
    */

    /*
    Function for the admin to view any student by ID.
    Returns the student object.
    */
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public @ResponseBody Student getStudentById(@PathVariable("id") int id) {
        Optional<Student> maybeStudent = studentService.getStudentById(id);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            return student;
        } else {
            //error
            Student student = new Student();
            return student;
        }
    }


    /*
    Function for the admin to delete any student by ID.
    Returns the display page.
    */
    @GetMapping(value = "/admin/{id}/deleteuser")
    @ResponseBody
    public RedirectView deleteUser(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
        return new RedirectView("/display");
    }

    /*
    Function for the admin to add a strike to a user by using their ID.
    Returns the the display page.
    */
    @GetMapping(value = "/admin/{id}/addstrike")
    @ResponseBody
    public RedirectView addStrike(@PathVariable("id") int id){
        Optional<Student> maybeStudent = studentService.getStudentById(id);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            int strikes = student.getStrikes();
            if (strikes == 3){
//                return "Max Strikes";
                return new RedirectView("/display");
            } else {
                strikes = strikes + 1;
                student.setStrikes(strikes);
                studentService.updateStudentStrikesByID(student);

//                return "Strike Added":
                return new RedirectView("/display");
            }
        } else {
            //error
//            return "error";
            return new RedirectView("/display");
        }

    }

    /*
    Function for the admin to remove a strike from a user by using their ID.
    Returns the the display page.
    */
    @GetMapping(value = "/admin/{id}/removestrike")
    @ResponseBody
    public RedirectView removeStrike(@PathVariable("id") int id){
        Optional<Student> maybeStudent = studentService.getStudentById(id);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            int strikes = student.getStrikes();
            if (strikes == 0){
                return new RedirectView("/display");
            } else {
                strikes = strikes - 1;
                student.setStrikes(strikes);
                studentService.updateStudentStrikesByID(student);
                 return new RedirectView("/display");
            }
        } else {
            //error
            return new RedirectView("/display");
        }
    }

    /*
    Returns adminbooking page.
    */
    @GetMapping(value = "/admin/booking")
    public String adminbooking(){
        return "adminbooking";
    }

    /*
    Returns manage account page
    */
    @GetMapping(value = "/admin/manageaccounts")
    public String manageaccounts(){
        return "manage_account";
    }


    /*
    Extra functionality functions, could be admin or normal student access.
    */

    /*
    Returns display page.
    */
    @RequestMapping("/display")
    public String display(Model model){
        model.addAttribute("display", getAllStudent());
        return "display";
    }

    /*
    Returns equimpent page.
    */
    @GetMapping(value = "/equipment")
    public String equipment(){
        return "equipment";
    }

    /*
    Returns booking page.
    */
    @GetMapping(value = "/booking")
    public String booking(){
        return "booking";
    }

    /*
    Returns manage account page.
    */
    @GetMapping(value = "/manage_account")
    public String manage_account(){
        return "manage_account";
    }

    /*
    Returns error page.
    */
    @GetMapping(value = "/error")
    public String error(){
        return "error";
    }

    /*
    Returns edit success page.
    */
    @GetMapping(value="/edit_success")
    public String edit_success(){
        return "edit_user_success";
    }


}
