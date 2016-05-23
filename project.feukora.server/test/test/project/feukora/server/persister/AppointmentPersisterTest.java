package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Users;
import projekt.feukora.server.persister.AppointmentPersisterImpl;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.CustomerheaterPersister;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;
import projekt.feukora.server.persister.TownData;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;

/**
 * Class to test the methodes of the class AppointmentPersister.
 * 
 * @author Allan
 * @version 1.0
 */
public class AppointmentPersisterTest {


	private static AppointmentPersisterImpl appointmentTest = new AppointmentPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		TestdataAppointment.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		AppointmentPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * tests if the Appointment is saved
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		
		List<Appointment> appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 2);
		
		CustomerheaterPersister chp = new CustomerheaterPersisterImpl();
		Customerheater ch = chp.findCustomerheaterByPerformance(200).get(0);
		
		UserPersister up = new UserPersisterImpl();
		Users user = up.findUserByLastname("Nachname").get(0);

		Appointment a = new Appointment(ch, user, user, new GregorianCalendar(2016, 05, 13, 8, 0),
				new GregorianCalendar(2016, 05, 14, 13, 0), "Neuer Termin");
		
		appointmentTest.saveAppointment(a);

		appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 3);

	}
	
	/**
	 * tests if the Appointment is updated
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Appointment> appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 2);
		
		CustomerheaterPersister chp = new CustomerheaterPersisterImpl();
		Customerheater ch = chp.findCustomerheaterByPerformance(200).get(0);
		
		UserPersister up = new UserPersisterImpl();
		Users user = up.findUserByLastname("Nachname").get(0);

		Appointment a = new Appointment(ch, user, user, new GregorianCalendar(2016, 05, 13, 8, 0),
				new GregorianCalendar(2016, 05, 13, 8, 0), "Update Test");
		
		appointmentTest.saveAppointment(a);

		appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 3);
		
		a.setComments("Ganz neuer Kommentar");

		appointmentTest.updateAppointment(a);
	}

	/**
	 * test if the Appointment is deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Appointment> appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 2);

		appointmentTest.deleteAppointment(appointmentlist.get(0));

		appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 1);

	}
	
	/**
	 * tests if the Appointment is found by the date
	 */
	@Test
	public void testFindByAppointmentdate() {

		GregorianCalendar appointmentdate = new GregorianCalendar(2016, 05, 13, 8, 0);
		
		assertTrue(appointmentTest.findAppointmentByAppointmentdate(appointmentdate).size() == 1);
	}	

	public static List<Appointment> init() throws Exception {

		AppointmentPersisterTest.deleteAll();
		
		CustomerheaterPersister chp = new CustomerheaterPersisterImpl();
		Customerheater ch = chp.findCustomerheaterByPerformance(200).get(0);
		
		UserPersister up = new UserPersisterImpl();
		Users user = up.findUserByLastname("Nachname").get(0);
		
		GregorianCalendar date1 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date3 = new GregorianCalendar(2016, 05, 16, 10, 0);
		GregorianCalendar date4 = new GregorianCalendar(2016, 05, 16, 10, 0);

		Appointment a1 = new Appointment(ch, user, user, date1, date2, "Kommentar");
		Appointment a2 = new Appointment(ch, user, user, date3, date4, "Kein Kommentar");

		appointmentTest.saveAppointment(a1);
		appointmentTest.saveAppointment(a2);

		List<Appointment> appointmentlist = new ArrayList<>();
		appointmentlist.add(a1);
		appointmentlist.add(a2);

		return appointmentlist;
	}

	/**
	 * tests if all Appointment are deleted
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for (Appointment a : appointmentTest.findAllAppointments()) {
			appointmentTest.deleteAppointment(a);
		}
	}
}
