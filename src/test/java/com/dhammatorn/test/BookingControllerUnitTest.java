package com.dhammatorn.test;

import com.dhammatorn.Controller.BookingController;
import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Entity.Attendance;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Entity.Tempbooking;
import com.dhammatorn.Service.BookingService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import com.dhammatorn.Entity.Booking;

import java.lang.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dhammatorn.Service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@RunWith(SpringRunner.class)
@WebMvcTest(value=BookingController.class,secure = false)
public class BookingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookingService bookingService;

    @MockBean
    StudentService studentService;

    @Autowired
    BookingController bookingController;

    @Test
    public void testshowAllBooking() throws Exception {
        List<Booking> test_booking = new ArrayList<>();
        Booking temp = new Booking();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zone);
        temp.setStartTime(now.plusHours(1));
        temp.setEndTime(now.plusHours(3));
        temp.setAuto_checked(false);
        temp.setAttendance(false);
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(0);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);

        Booking temp2 = new Booking();
//        Booking temp = new Booking();
//        ZoneId zone = ZoneId.systemDefault();
//        LocalDateTime now = LocalDateTime.now(zone);
        temp2.setStartTime(now.plusHours(2));
        temp2.setEndTime(now.plusHours(4));
        temp2.setAuto_checked(false);
        temp2.setAttendance(false);
        temp2.setRsop(0);
        temp2.setBnc_croclead(0);
        temp2.setPower_supp(0);
        temp2.setActive8(0);
        temp2.setResistors(0);
        temp2.setSolidCoreWire(0);
        temp2.setCapacitors(0);
        temp2.setStudent(0);
        temp2.setSeatNo("A1");
        temp2.setLength(1);
        temp2.setRs_4mmplug(0);
        temp2.setPrototyping_board(0);
        temp2.setBnc_Tpiece(0);
        temp2.setBnc_lead(0);
        temp2.setLcr400_bridge(0);
        temp2.setWire_strippers(0);
        temp2.setOscilloscope_trim(0);

        test_booking.add(temp);
        test_booking.add(temp2);
        Mockito.when(bookingService.getAllBookings()).thenReturn(test_booking);

        String URI = "/bookings/all";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(test_booking);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void controlgetbyID() throws Exception{
        Booking temp = new Booking();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zone);
        temp.setStartTime(now.plusHours(2));
        temp.setEndTime(now.plusHours(4));
        temp.setAuto_checked(false);
        temp.setAttendance(false);
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(0);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);
        temp.setId(1);

        Optional<Booking> opt_book = Optional.of(temp);
        Mockito.when(bookingService.getBookingById(Mockito.anyInt())).thenReturn(opt_book);

        String URI = "/bookings/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(temp);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    @WithMockUser(username="zen",roles={"USER"},password = "12345")
    public void testgetUSERbooking() throws Exception{
        Booking temp = new Booking();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zone);
        temp.setStartTime(now.plusHours(2));
        temp.setEndTime(now.plusHours(4));
        temp.setAuto_checked(false);
        temp.setAttendance(false);
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(9);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);
        temp.setId(1);

        Booking temp2 = new Booking();
        temp2.setStartTime(now.plusHours(2));
        temp2.setEndTime(now.plusHours(4));
        temp2.setAuto_checked(false);
        temp2.setAttendance(false);
        temp2.setRsop(0);
        temp2.setBnc_croclead(0);
        temp2.setPower_supp(0);
        temp2.setActive8(0);
        temp2.setResistors(0);
        temp2.setSolidCoreWire(0);
        temp2.setCapacitors(0);
        temp2.setStudent(1);
        temp2.setSeatNo("A1");
        temp2.setLength(2);
        temp2.setRs_4mmplug(0);
        temp2.setPrototyping_board(0);
        temp2.setBnc_Tpiece(0);
        temp2.setBnc_lead(0);
        temp2.setLcr400_bridge(0);
        temp2.setWire_strippers(0);
        temp2.setOscilloscope_trim(0);

        Optional<Booking> opt_book = Optional.of(temp);
        Student for_test = new Student();
        List<Booking> all_bookings = new ArrayList<>();
        all_bookings.add(temp);
        all_bookings.add(temp2);
        for_test.setId(1);
        Mockito.when(studentService.getStudentByUsername("zen")).thenReturn(for_test);
        Mockito.when(bookingService.getAllBookings()).thenReturn(all_bookings);
        List<Booking> result = bookingController.view_onlyUser();
        System.out.println("RESULT )" + result.get(0).getStudent() + result.get(0).getLength() );
        assertThat(result.get(0).getStudent()).isEqualTo(temp2.getStudent());


    }

    @Test
    public void test_attendance(){


        Attendance attend = new Attendance();
        attend.setUCARD("12345");

        Booking temp = new Booking();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zone);
        temp.setStartTime(now.minusMinutes(10));
        temp.setEndTime(now.plusHours(1));
        temp.setAuto_checked(false);
        temp.setAttendance(false);
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(1);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);
        temp.setId(1);

        Student stu = new Student();
        stu.setId(1);
        stu.setName("Hello");
        Mockito.when(studentService.getStudentByUcard(attend.getUCARD())).thenReturn(stu);
        Mockito.when(bookingService.getBookingbyStudent(stu.getId())).thenReturn(Optional.of(temp));

        String feedback = bookingController.check_attendance(attend);
        assertThat(feedback).isEqualTo("attendance_success");

    }
    @Test
    public void test_attendance_mustFail(){


        Attendance attend = new Attendance();
        attend.setUCARD("12345");

        Booking temp = new Booking();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zone);
        temp.setStartTime(now.plusMinutes(10));
        temp.setEndTime(now.plusHours(1));
        temp.setAuto_checked(false);
        temp.setAttendance(false);
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(1);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);
        temp.setId(1);

        Student stu = new Student();
        stu.setId(1);
        stu.setName("Hello");
        Mockito.when(studentService.getStudentByUcard(attend.getUCARD())).thenReturn(stu);
        Mockito.when(bookingService.getBookingbyStudent(stu.getId())).thenReturn(Optional.of(temp));

        String feedback = bookingController.check_attendance(attend);
        assertThat(feedback).isEqualTo("attendance_failed");

    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}
