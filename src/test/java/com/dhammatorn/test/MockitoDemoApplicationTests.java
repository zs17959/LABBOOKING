package com.dhammatorn.test;

	import com.dhammatorn.Dao.BookingRepository;
	import com.dhammatorn.Service.BookingService;
	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.Assert.assertFalse;

	import java.lang.reflect.Array;
	import java.time.LocalDateTime;
	import java.time.ZoneId;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;

//	import jdk.vm.ci.meta.Local;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.context.junit4.SpringRunner;

	import com.dhammatorn.Entity.Booking;
	import java.util.Optional;


	@SpringBootTest
	//@ActiveProfiles("test")
	@RunWith(SpringRunner.class)
	public class MockitoDemoApplicationTests {

	    @Autowired
	    private BookingService bookingService;

	    @MockBean
	    private BookingRepository bookingRepository;

	    @Test
	    public void testGetAllBooking() {
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

			temp.setStartTime(now.plusHours(2));
			temp.setEndTime(now.plusHours(4));
			temp.setAuto_checked(false);
			temp.setAttendance(false);
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

	        Mockito.when(bookingRepository.findAll()).thenReturn(test_booking);
	        assertThat(bookingService.getAllBookings()).isEqualTo(test_booking);
	    }

	    @Test
	    public void testGetbyID(){
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

	        Mockito.when(bookingRepository.findById(1)).thenReturn(opt_book);
	        assertThat(bookingService.getBookingById(1)).isEqualTo(opt_book);
	    }

	    @Test
	    public void testcreateTicket(){
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
	        Mockito.when(bookingRepository.save(temp)).thenReturn(temp);
	        assertThat(bookingService.saveBooking(temp)).isEqualTo(1);
	    }

	    @Test
		public void time_valid(){
			Booking temp = new Booking();
			ZoneId zone = ZoneId.systemDefault();
			LocalDateTime now = LocalDateTime.now(zone);
			temp.setStartTime(now);
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

			Booking temp2 = new Booking();
			temp2.setStartTime(now.plusHours(2));
			temp2.setEndTime(now.plusHours(3));
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
			temp2.setId(1);
			Boolean check = bookingService.timeValid(temp,temp2);
			assertThat(check).isEqualTo(false);
		}

		@Test
		public void time_not_valid(){
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
			temp2.setId(1);

			Boolean check = bookingService.timeValid(temp,temp2);
			assertThat(check).isEqualTo(true);
		}

		@Test
		public void bookingbyStudent(){
			Booking temp2 = new Booking();
			ZoneId zone = ZoneId.systemDefault();
			LocalDateTime now = LocalDateTime.now(zone);
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
			temp2.setLength(1);
			temp2.setRs_4mmplug(0);
			temp2.setPrototyping_board(0);
			temp2.setBnc_Tpiece(0);
			temp2.setBnc_lead(0);
			temp2.setLcr400_bridge(0);
			temp2.setWire_strippers(0);
			temp2.setOscilloscope_trim(0);
			temp2.setId(1);

			Optional<Booking> opt_book = Optional.of(temp2);
			List<Booking> opt = new ArrayList<>();
			opt.add(temp2);


			Mockito.when(bookingRepository.findByStudent(1)).thenReturn(opt);
			assertThat(bookingService.getBookingbyStudent(1)).isEqualTo(Optional.of(opt.get(0)));

		}

		@Test
		public void test_saveBooking1() throws Exception{
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

			Booking temp2 = new Booking();
			temp2.setStartTime(now.plusHours(6));
			temp2.setEndTime(now.plusHours(7));
			temp2.setAuto_checked(false);
			temp2.setAttendance(false);
			temp2.setRsop(0);
			temp2.setBnc_croclead(0);
			temp2.setPower_supp(0);
			temp2.setActive8(0);
			temp2.setResistors(0);
			temp2.setSolidCoreWire(0);
			temp2.setCapacitors(0);
			temp2.setStudent(4);
			temp2.setSeatNo("A2");
			temp2.setLength(1);
			temp2.setRs_4mmplug(0);
			temp2.setPrototyping_board(0);
			temp2.setBnc_Tpiece(0);
			temp2.setBnc_lead(0);
			temp2.setLcr400_bridge(0);
			temp2.setWire_strippers(0);
			temp2.setOscilloscope_trim(0);
			temp2.setId(3);

			List<Booking> all_book = new ArrayList<>();
			all_book.add(temp);

			Mockito.when(bookingRepository.findAll()).thenReturn(all_book);
			assertThat(bookingService.saveBooking(temp2)).isEqualTo(1);
		}

		@Test
		public void test_saveBooking2() throws Exception{
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
			temp.setStudent(2);
			temp.setSeatNo("A2");
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
			temp2.setStudent(2);
			temp2.setSeatNo("A2");
			temp2.setLength(1);
			temp2.setRs_4mmplug(0);
			temp2.setPrototyping_board(0);
			temp2.setBnc_Tpiece(0);
			temp2.setBnc_lead(0);
			temp2.setLcr400_bridge(0);
			temp2.setWire_strippers(0);
			temp2.setOscilloscope_trim(0);
			temp2.setId(3);

			List<Booking> all_book = new ArrayList<>();
			all_book.add(temp);

			Mockito.when(bookingRepository.findAll()).thenReturn(all_book);
			assertThat(bookingService.saveBooking(temp)).isEqualTo(0);
		}

		@Test
		public void test_admin1() throws Exception{
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
			temp.setStudent(2);
			temp.setSeatNo("A2");
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
			temp2.setStudent(2);
			temp2.setSeatNo("A2");
			temp2.setLength(1);
			temp2.setRs_4mmplug(0);
			temp2.setPrototyping_board(0);
			temp2.setBnc_Tpiece(0);
			temp2.setBnc_lead(0);
			temp2.setLcr400_bridge(0);
			temp2.setWire_strippers(0);
			temp2.setOscilloscope_trim(0);
			temp2.setId(3);

			Booking temp3 = new Booking();
			temp3.setStartTime(now.plusHours(8));
			temp3.setEndTime(now.plusHours(9));
			temp3.setAuto_checked(false);
			temp3.setAttendance(false);
			temp3.setRsop(0);
			temp3.setBnc_croclead(0);
			temp3.setPower_supp(0);
			temp3.setActive8(0);
			temp3.setResistors(0);
			temp3.setSolidCoreWire(0);
			temp3.setCapacitors(0);
			temp3.setStudent(2);
			temp3.setSeatNo("B2");
			temp3.setLength(1);
			temp3.setRs_4mmplug(0);
			temp3.setPrototyping_board(0);
			temp3.setBnc_Tpiece(0);
			temp3.setBnc_lead(0);
			temp3.setLcr400_bridge(0);
			temp3.setWire_strippers(0);
			temp3.setOscilloscope_trim(0);
			temp3.setId(3);

			List<Booking> all_book = new ArrayList<>();
			all_book.add(temp);
			all_book.add(temp2);

			Mockito.when(bookingRepository.findAll()).thenReturn(all_book);
			assertThat(bookingService.saveBooking(temp3)).isEqualTo(1);
		}

		@Test
		public void test_admin2() throws Exception{
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
			temp.setStudent(2);
			temp.setSeatNo("A2");
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
			temp2.setStudent(2);
			temp2.setSeatNo("A2");
			temp2.setLength(1);
			temp2.setRs_4mmplug(0);
			temp2.setPrototyping_board(0);
			temp2.setBnc_Tpiece(0);
			temp2.setBnc_lead(0);
			temp2.setLcr400_bridge(0);
			temp2.setWire_strippers(0);
			temp2.setOscilloscope_trim(0);
			temp2.setId(3);

			Booking temp3 = new Booking();
			temp3.setStartTime(now.plusHours(2));
			temp3.setEndTime(now.plusHours(4));
			temp3.setAuto_checked(false);
			temp3.setAttendance(false);
			temp3.setRsop(0);
			temp3.setBnc_croclead(0);
			temp3.setPower_supp(0);
			temp3.setActive8(0);
			temp3.setResistors(0);
			temp3.setSolidCoreWire(0);
			temp3.setCapacitors(0);
			temp3.setStudent(2);
			temp3.setSeatNo("A2");
			temp3.setLength(1);
			temp3.setRs_4mmplug(0);
			temp3.setPrototyping_board(0);
			temp3.setBnc_Tpiece(0);
			temp3.setBnc_lead(0);
			temp3.setLcr400_bridge(0);
			temp3.setWire_strippers(0);
			temp3.setOscilloscope_trim(0);
			temp3.setId(3);

			List<Booking> all_book = new ArrayList<>();
			all_book.add(temp);
			all_book.add(temp2);

			Mockito.when(bookingRepository.findAll()).thenReturn(all_book);
			assertThat(bookingService.saveBooking(temp3)).isEqualTo(0);
		}



	}
