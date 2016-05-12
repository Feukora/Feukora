package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
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
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;

public class AppointmentPersisterTest {


	private static AppointmentPersisterImpl appointmentTest = new AppointmentPersisterImpl();

	@Before
	public void setUp() throws Exception {
		AppointmentPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Appointment> appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		// fi_costumerheaterid 
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		ch.findCustomerheaterByCustomerheaterid(null);
		
		// Users fi_userid 
		UserPersister usid = new UserPersisterImpl();
		usid.findUserByUserid(null);

		//nicht fertig
		Appointment a = new Appointment(ch, usid, usid, GregorianCalendar created,
				GregorianCalendar appointmentdate, "Kommentar");

		appointmentTest.saveAppointment(a);

		// weiss nicht was machen
		appointmentlist = appointmentTest.findAllAppointments();
		for (Appointment appointment : appointmentlist)
		assertTrue(appointmentlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Appointment> appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		// fi_costumerheaterid 
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		ch.findCustomerheaterByCustomerheaterid(null);
		
		// Users fi_userid 
		UserPersister usid = new UserPersisterImpl();
		usid.findUserByUserid(null);

		//nicht fertig
		Appointment a = new Appointment(ch, usid, usid, GregorianCalendar created,
				GregorianCalendar appointmentdate, "Kommentar");

		appointmentTest.updateAppointment(a);

		// weiss nicht was machen
		appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 3);

		appointmentTest.updateAppointment(a);

		Appointment appointmentFromDB = appointmentTest.deleteAppointmentByAppointmentid
				(appointmentid).get(0);
		assertNotNull(appointmentFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Appointment> appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 2);

		appointmentTest.deleteAppointment(appointmentlist.get(0));

		appointmentlist = appointmentTest.findAllAppointments();
		assertTrue(appointmentlist.size() == 1);

	}
	
	// "Appointment.findByAppointmentdate" ist der Query (ID Query nicht gemacht)
	@Test
	public void testFindByAppointmentdate() {

		GregorianCalendar appointmentdate;
		// Gregorian Kalender reinholen
		assertTrue(appointmentTest.findAppointmentByAppointmentdate(appointmentdate.size() == 1);
	}

	//Das brauchen wieder alle
	public static List<Appointment> init() throws Exception {

		AppointmentPersisterTest.deleteAll();
		
		// fi_costumerheaterid 
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		ch.findCustomerheaterByCustomerheaterid(null);
		
		// Users fi_userid 
		UserPersister usid = new UserPersisterImpl();
		usid.findUserByUserid(null);

		Appointment a1 = new Appointment(ch, usid, usid, GregorianCalendar created,
				GregorianCalendar appointmentdate, "Kommentar");
		Appointment a2 = new Appointment(ch, usid, usid, GregorianCalendar created,
				GregorianCalendar appointmentdate, "Kommentar");

		appointmentTest.saveAppointment(a1);
		appointmentTest.saveAppointment(a2);

		List<Appointment> appointmentlist = new ArrayList<>();
		appointmentlist.add(a1);
		appointmentlist.add(a2);

		return appointmentlist;
	}

	private static void deleteAll() throws Exception {

		for (Appointment a : appointmentTest.findAllAppointments()) {
			appointmentTest.deleteAppointment(a);
		}
	}
}
