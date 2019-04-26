package com.dhammatorn.test;

import com.dhammatorn.Controller.BookingController;
import com.dhammatorn.Controller.StudentController;
import com.dhammatorn.Dao.StudentRepository;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Role;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value=StudentController.class,secure = false)
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    StudentController studentController;


    @Test
    public void testshowAllStudent() throws Exception {

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

        Mockito.when(studentService.getAllStudent()).thenReturn(all_students);

        String URI = "/students";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(all_students);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void test_getStudentbyID() throws Exception{
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

        Mockito.when(studentService.getStudentById(1)).thenReturn(Optional.of(temp));

        String URI = "/admin/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(temp);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);

    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }





}
