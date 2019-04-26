package com.dhammatorn.test;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Dao.StudentRepository;
import com.dhammatorn.Entity.Role;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.BookingService;
import com.dhammatorn.Service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void test_getStudent(){
        Student temp = new Student();
        temp.setEmail("dr@bristol.ac.uk");
        temp.setUcard("12345");
        temp.setName("Zen");
        temp.setLastname("Riew");
        temp.setPassword("12345");
        temp.setBooking(1);
        temp.setCourse("EE");
        temp.setStrikes(0);
        //for ROLE
        temp.setId(1);
        Role user = new Role();
        user.setRole("USER");
        user.setId(1);
        Set<Role> role_temp = new HashSet<Role>();
        role_temp.add(user);
        temp.setRoles(role_temp);
        temp.setActive(1);
        temp.setUsername("zen");

        Mockito.when(studentRepository.findById(1)).thenReturn(Optional.of(temp));
        Optional<Student> feedback = studentService.getStudentById(1);
        Student answer = feedback.get();
        assertThat(answer).isEqualTo(temp);

    }

    @Test
    public void test_getStudentbyUCARD(){
        Student temp = new Student();
        temp.setEmail("dr@bristol.ac.uk");
        temp.setUcard("12345");
        temp.setName("Zen");
        temp.setLastname("Riew");
        temp.setPassword("12345");
        temp.setBooking(1);
        temp.setCourse("EE");
        temp.setStrikes(0);
        //for ROLE
        temp.setId(1);
        Role user = new Role();
        user.setRole("USER");
        user.setId(1);
        Set<Role> role_temp = new HashSet<Role>();
        role_temp.add(user);
        temp.setRoles(role_temp);
        temp.setActive(1);
        temp.setUsername("zen");

        List<Student> all_students = new ArrayList<Student>();
        all_students.add(temp);

        Mockito.when(studentRepository.findByUcard(temp.getUcard())).thenReturn(all_students);
        assertThat(studentService.getStudentByUcard(temp.getUcard())).isEqualTo(temp);


    }

    @Test
    public void test_MaybeStudentbyUSERNAME(){
        Student temp = new Student();
        temp.setEmail("dr@bristol.ac.uk");
        temp.setUcard("12345");
        temp.setName("Zen");
        temp.setLastname("Riew");
        temp.setPassword("12345");
        temp.setBooking(1);
        temp.setCourse("EE");
        temp.setStrikes(0);
        //for ROLE
        temp.setId(1);
        Role user = new Role();
        user.setRole("USER");
        user.setId(1);
        Set<Role> role_temp = new HashSet<Role>();
        role_temp.add(user);
        temp.setRoles(role_temp);
        temp.setActive(1);
        temp.setUsername("zen");

        List<Student> all_students = new ArrayList<Student>();
        all_students.add(temp);
        Mockito.when(studentRepository.findByUsername(temp.getUsername())).thenReturn(all_students);
        assertThat(studentService.getStudentByUsername(temp.getUsername())).isEqualTo(temp);

    }

    @Test
    public void get_INTmaybestudentbyUSER(){

        Student temp = new Student();
        temp.setEmail("dr@bristol.ac.uk");
        temp.setUcard("12345");
        temp.setName("Zen");
        temp.setLastname("Riew");
        temp.setPassword("12345");
        temp.setBooking(1);
        temp.setCourse("EE");
        temp.setStrikes(0);
        //for ROLE
        temp.setId(1);
        Role user = new Role();
        user.setRole("USER");
        user.setId(1);
        Set<Role> role_temp = new HashSet<Role>();
        role_temp.add(user);
        temp.setRoles(role_temp);
        temp.setActive(1);
        temp.setUsername("zen");

        List<Student> all_students = new ArrayList<Student>();
        all_students.add(temp);
        Mockito.when(studentRepository.findByUsername(temp.getUsername())).thenReturn(all_students);
        assertThat(studentService.getMaybeStudentByUsername(temp.getUsername())).isEqualTo(1);

    }

    @Test
    public void test_getallStudents(){
        Student temp = new Student();
        temp.setEmail("dr@bristol.ac.uk");
        temp.setUcard("12345");
        temp.setName("Zen");
        temp.setLastname("Riew");
        temp.setPassword("12345");
        temp.setBooking(1);
        temp.setCourse("EE");
        temp.setStrikes(0);
        //for ROLE
        temp.setId(1);
        Role user = new Role();
        user.setRole("USER");
        user.setId(1);
        Set<Role> role_temp = new HashSet<Role>();
        role_temp.add(user);
        temp.setRoles(role_temp);
        temp.setActive(1);
        temp.setUsername("zen");

        Student temp2 = new Student();
        temp2.setEmail("local2@bristol.ac.uk");
        temp2.setUcard("13456");
        temp2.setName("John");
        temp2.setLastname("Wick");
        temp2.setPassword("54321");
        temp2.setBooking(1);
        temp2.setCourse("CS");
        temp2.setStrikes(0);
        //for ROLE
        temp2.setId(2);
        Role user2 = new Role();
        user2.setRole("USER");
        user2.setId(1);
        Set<Role> role_temp2 = new HashSet<Role>();
        role_temp2.add(user);
        temp.setRoles(role_temp2);
        temp.setActive(1);
        temp.setUsername("hallumi");

        List<Student> all_students = new ArrayList<Student>();
        all_students.add(temp);
        all_students.add(temp2);
        Mockito.when(studentRepository.findAll()).thenReturn(all_students);
        assertThat(studentService.getAllStudent()).isEqualTo(all_students);
    }


}
