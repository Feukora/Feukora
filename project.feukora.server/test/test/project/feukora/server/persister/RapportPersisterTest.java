package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Users;
import projekt.feukora.server.persister.AppointmentPersister;
import projekt.feukora.server.persister.AppointmentPersisterImpl;
import projekt.feukora.server.persister.ControltypePersister;
import projekt.feukora.server.persister.ControltypePersisterImpl;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.CustomerheaterPersister;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;
import projekt.feukora.server.persister.RapportPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;

/**
 * @author Sandro Fasser
 * @version 1.0
 */

public class RapportPersisterTest {


	private static RapportPersisterImpl rapportTest = new RapportPersisterImpl();

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
		Controltype controltype = ct.findControltypeByControltypeid(0);
				
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		Customerheater customerheater = ch.findCustomerheaterByCustomerheaterid(0);
		
		UserPersister us = new UserPersisterImpl();
		Users user = us.findUserByUserid(1);
		
		AppointmentPersister ap = new AppointmentPersisterImpl();
		Appointment appointment = ap.findAppointmentByAppointmentid(0);
		
		GregorianCalendar cal = new GregorianCalendar(2015, 3, 3);
		
		Rapport r = new Rapport(controltype, customerheater, user, appointment, cal, false, false, "Kommentar des Tests Save", true, true,true, true, true);
		

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
		Controltype controltype = ct.findControltypeByControltypeid(0);
		assertNotNull(controltype);
		
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		Customerheater customerheater = ch.findCustomerheaterByCustomerheaterid(0);
		assertNotNull(customerheater);
		
		UserPersister us = new UserPersisterImpl();
		Users user = us.findUserByUserid(1);
		assertNotNull(user);
		
		AppointmentPersister ap = new AppointmentPersisterImpl();
		Appointment appointment = ap.findAppointmentByAppointmentid(0);
		assertNotNull(appointment);
		
		GregorianCalendar cal = new GregorianCalendar(2015, 3, 3);
		assertNotNull(cal);
		
		Rapport r = new Rapport(controltype, customerheater, user, appointment, cal, true, false, "Kommentar des Tests Update", true, true,true, true, true);

		rapportTest.saveRapport(r);

		rapportlist = rapportTest.findAllRapports();
		assertTrue(rapportlist.size() == 3);

		GregorianCalendar calup = new GregorianCalendar(2012, 2, 2);
		r.setMeasuringdate(calup);

		rapportTest.updateRapport(r);

		Rapport rapportFromDB = (Rapport) rapportTest.findRapportByMeasuringdate(calup);
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
	public void testFindByRapportid() {

		Integer id = 0;

		assertTrue(rapportTest.findRapportByRapportid(id).getComments() == "Kein Kommentar");
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
		Controltype controltype1 = ct.findControltypeByControltypeid(0);
		Controltype controltype2 = ct.findControltypeByControltypeid(1);
		
		CustomerheaterPersister ch = new CustomerheaterPersisterImpl();
		Customerheater customerheater1 = ch.findCustomerheaterByCustomerheaterid(0);
		Customerheater customerheater2 = ch.findCustomerheaterByCustomerheaterid(1);

		UserPersister us = new UserPersisterImpl();
		Users user1 = us.findUserByUserid(1);
		Users user2 = us.findUserByUserid(1);
		
		AppointmentPersister ap = new AppointmentPersisterImpl();
		Appointment appointment1 = ap.findAppointmentByAppointmentid(0);
		Appointment appointment2 = ap.findAppointmentByAppointmentid(1);
	
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