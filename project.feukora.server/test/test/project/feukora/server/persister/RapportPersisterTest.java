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
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.User;
import projekt.feukora.server.persister.AppointmentPersister;
import projekt.feukora.server.persister.AppointmentPersisterImpl;
import projekt.feukora.server.persister.ControltypePersister;
import projekt.feukora.server.persister.ControltypePersisterImpl;
import projekt.feukora.server.persister.CustomerheaterPersister;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;
import projekt.feukora.server.persister.RapportPersisterImpl;
import projekt.feukora.server.persister.TownData;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;

/**
 * @author Sandro Fasser
 * @version 1.1
 */

public class RapportPersisterTest {


	private static RapportPersisterImpl rapportTest = new RapportPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		TestdataRapport.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		RapportPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Rapport> rapportlist = rapportTest.findAllRapports();
		assertTrue(rapportlist.size() == 2);
		
		ControltypePersister ct = new ControltypePersisterImpl();
		Controltype controltype1 = ct.findControltypeByName("Abnahmekontrolle");
		
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		Customerheater customerheater1 = ch.findCustomerheaterByPerformance(200).get(0);

		UserPersister us = new UserPersisterImpl();
		User user1 = us.findUserByLastname("Nachname").get(0);
		
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		
		AppointmentPersister ap = new AppointmentPersisterImpl();
		Appointment appointment1 = ap.findAppointmentByAppointmentdate(date2).get(0);
	
		GregorianCalendar cal1 = new GregorianCalendar(2016, 3, 3);
		
		Rapport r = new Rapport(controltype1, customerheater1, user1, appointment1, cal1, true, false, "Kommentar Nummer 1", true, true,false, false, true);

		rapportTest.saveRapport(r);

		rapportlist = rapportTest.findAllRapports();
		for (Rapport rapport : rapportlist) {
			System.out.println(rapport.getComments());
		}
		assertTrue(rapportlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Rapport> rapportlist = rapportTest.findAllRapports();
		assertTrue(rapportlist.size() == 2);
		
		ControltypePersister ct = new ControltypePersisterImpl();
		Controltype controltype1 = ct.findControltypeByName("Abnahmekontrolle");
		
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		Customerheater customerheater1 = ch.findCustomerheaterByPerformance(200).get(0);

		UserPersister us = new UserPersisterImpl();
		User user1 = us.findUserByLastname("Nachname").get(0);
		
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		
		AppointmentPersister ap = new AppointmentPersisterImpl();
		Appointment appointment1 = ap.findAppointmentByAppointmentdate(date2).get(0);
	
		GregorianCalendar cal1 = new GregorianCalendar(2016, 3, 3);
		
		Rapport r = new Rapport(controltype1, customerheater1, user1, appointment1, cal1, true, false, "Kommentar Nummer 2", true, true,false, false, true);

		rapportTest.saveRapport(r);

		rapportlist = rapportTest.findAllRapports();
		assertTrue(rapportlist.size() == 3);

		GregorianCalendar calup = new GregorianCalendar(2012, 2, 2);
		r.setMeasuringdate(calup);

		rapportTest.updateRapport(r);

		Rapport rapportFromDB = rapportTest.findRapportByMeasuringdate(calup).get(0);
		assertNotNull(rapportFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Rapport> rapportlist = rapportTest.findAllRapports();
		assertTrue(rapportlist.size() == 2);

		rapportTest.deleteRapport(rapportlist.get(0));

		rapportlist = rapportTest.findAllRapports();
		assertTrue(rapportlist.size() == 1);

	}
	
	@Test
	public void testFindByMeasuringdate() {

		GregorianCalendar caltest = new GregorianCalendar(2016, 3, 3);

		assertTrue(rapportTest.findRapportByMeasuringdate(caltest).size() == 1);
	}
	
	@Test
	public void testFindByResults() {

		Boolean result = true;

		assertTrue(rapportTest.findRapportByResults(result).size() == 2);
	}

	
	public static List<Rapport> init() throws Exception {

		RapportPersisterTest.deleteAll();
		
		ControltypePersister ct = new ControltypePersisterImpl();
		Controltype controltype1 = ct.findControltypeByName("Abnahmekontrolle");
		Controltype controltype2 = ct.findControltypeByName("Routinekontrolle");
		
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		Customerheater customerheater1 = ch.findCustomerheaterByPerformance(200).get(0);
		Customerheater customerheater2 = ch.findCustomerheaterByPerformance(78).get(0);

		UserPersister us = new UserPersisterImpl();
		User user1 = us.findUserByLastname("Nachname").get(0);
		User user2 = us.findUserByLastname("Lastname").get(0);
		
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date4 = new GregorianCalendar(2016, 05, 16, 10, 0);
		
		AppointmentPersister ap = new AppointmentPersisterImpl();
		Appointment appointment1 = ap.findAppointmentByAppointmentdate(date2).get(0);
		Appointment appointment2 = ap.findAppointmentByAppointmentdate(date4).get(0);
	
		GregorianCalendar cal1 = new GregorianCalendar(2016, 3, 3);
		GregorianCalendar cal2 = new GregorianCalendar(2016, 1, 4);
		
		Rapport r1 = new Rapport(controltype1, customerheater1, user1, appointment1, cal1, true, false, "Kein Kommentar", true, true,true, true, true);
		Rapport r2 = new Rapport(controltype2, customerheater2, user2, appointment2, cal2, true, false, "Kein Kommentar 2", true, true,true, true, true);
		
		rapportTest.saveRapport(r1);
		rapportTest.saveRapport(r2);

		List<Rapport> rapportlist = new ArrayList<>();
		rapportlist.add(r1);
		rapportlist.add(r2);

		return rapportlist;
	}

	private static void deleteAll() throws Exception {

		for (Rapport e : rapportTest.findAllRapports()) {
			rapportTest.deleteRapport(e);
		}
	}
}