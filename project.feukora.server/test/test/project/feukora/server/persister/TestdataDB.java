package test.project.feukora.server.persister;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.junit.Test;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.model.User;
import projekt.feukora.server.persister.AppointmentPersister;
import projekt.feukora.server.persister.AppointmentPersisterImpl;
import projekt.feukora.server.persister.BlowerPersister;
import projekt.feukora.server.persister.BlowerPersisterImpl;
import projekt.feukora.server.persister.BlowertypePersister;
import projekt.feukora.server.persister.BlowertypePersisterImpl;
import projekt.feukora.server.persister.CompanyPersister;
import projekt.feukora.server.persister.CompanyPersisterImpl;
import projekt.feukora.server.persister.ControltypePersister;
import projekt.feukora.server.persister.ControltypePersisterImpl;
import projekt.feukora.server.persister.CustomerPersister;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.CustomerheaterPersister;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;
import projekt.feukora.server.persister.FacilitymanagerPersister;
import projekt.feukora.server.persister.FacilitymanagerPersisterImpl;
import projekt.feukora.server.persister.FuelPersister;
import projekt.feukora.server.persister.FuelPersisterImpl;
import projekt.feukora.server.persister.HeaterPersister;
import projekt.feukora.server.persister.HeaterPersisterImpl;
import projekt.feukora.server.persister.RapportPersister;
import projekt.feukora.server.persister.RapportPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

public class TestdataDB {
	
	public static CustomerfunctionPersister customerfunction = new CustomerfunctionPersisterImpl();
	public static UsergroupPersister usergroup = new UsergroupPersisterImpl();
	public static ControltypePersister controltype = new ControltypePersisterImpl();
	public static FuelPersister fuel = new FuelPersisterImpl();
	public static BlowertypePersister blowertype = new BlowertypePersisterImpl();
	public static BlowerPersister blower = new BlowerPersisterImpl();
	public static HeaterPersister heater = new HeaterPersisterImpl();
	public static FacilitymanagerPersister facilitymanager = new FacilitymanagerPersisterImpl();
	public static CustomerPersister customer = new CustomerPersisterImpl();
	public static TownPersister tp = new TownPersisterImpl();
	public static CustomerheaterPersister customerheater = new CustomerheaterPersisterImpl();
	public static CompanyPersister company = new CompanyPersisterImpl();
	public static UserPersister users = new UserPersisterImpl();
	public static AppointmentPersister appointment = new AppointmentPersisterImpl();
	public static RapportPersister rapport = new RapportPersisterImpl();
	
	private static final Logger logger = Logger
			.getLogger(TestdataDB.class);
	
	@Test
	public static void loadTestdata() {
		
		
		Customerfunction function1 = new Customerfunction("Verwaltung");
		Customerfunction function2 = new Customerfunction("Eigentümer");
		
		Usergroup group1 = new Usergroup("Administrator");
		Usergroup group2 = new Usergroup("Feuerungskontrolleur");
		Usergroup group3 = new Usergroup("Sachbearbeiter");
		
		Controltype typ1 = new Controltype("Routinekontrolle");
		Controltype typ2 = new Controltype("Abnahmekontrolle");
		
		Fuel fuel1 = new Fuel("Öl");
		Fuel fuel2 = new Fuel("Erdgas");
		Fuel fuel3 = new Fuel("Flüssiggas");
		
		Blowertype bTyp1 = new Blowertype("Gebläse");
		Blowertype bTyp2 = new Blowertype("Athmosphärisch");
		Blowertype bTyp3 = new Blowertype("Verdampfer");
		
		
		
		Blower blower1 = new Blower(bTyp1, fuel1, "Sixmadun SL21");
		Blower blower2 = new Blower(bTyp3, fuel3, "Sixmadun SL23-2D");
		
		Heater heater1 = new Heater("Sixmadun TG 21");
		Heater heater2 = new Heater("CTC");
		
		Facilitymanager fm1 = new Facilitymanager("Hausmeister", "Robert");
		Facilitymanager fm2 = new Facilitymanager("Meister", "Jakob");
		
		Town zip1 = tp.findbyZip(6000);
		Town zip2 = tp.findbyZip(6005);
		assertNotNull(zip1);

		Customer c1 = new Customer("Fasser AG", "Sandro", "Fasser",  "Bergün", "1234", "sf@sf.ch", function1, zip1);
		Customer c2 = new Customer("Perry AG", "Patrick", "Pereira",  "Aargau", "5678", "pdp@pdp.ch", function2, zip2);

		Customerheater ch1 = new Customerheater(c1, heater1, blower1, fm1, 1990, 2000, 78);
		Customerheater ch2 = new Customerheater(c2, heater2, blower2, fm2, 2010, 2010, 200);
		
		Company com1 = new Company("Centralhof", "Zentralstrasse 24", "045 440 67 43", "centralhof@gmail.ch", zip1);
		Company com2 = new Company("PHAdmin", "Zürichstrasse 13", "043 387 32 31", "phadmin@outlook.ch", zip2);
		
		User user1 = new User(group2, "Müller", "Catalina", "Zugerweg 3", zip1, com1, "mca", "user1", "042 765 34 73", "catalinamüller@outlook.ch");
		User user2 = new User(group1, "Hofstetter", "Gida", "Hofmatt 90", zip2, com2, "admin", "admin", "043 657 98 54", "gidahofstetter@outlook.com");
		
		GregorianCalendar date1 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date3 = new GregorianCalendar(2016, 05, 16, 10, 0);
		GregorianCalendar date4 = new GregorianCalendar(2016, 05, 16, 10, 0);
		
		Appointment app1 = new Appointment(ch1, user1, user1, date1, date2, "Kein Kommentar");
		Appointment app2 = new Appointment(ch2, user2, user2, date3, date4, "Hallo");
		
		Rapport rap1 = new Rapport(typ1, ch1, user1, app1, date1, true, false, "Kein Kommentar", true, true, true, true, true);
		Rapport rap2 = new Rapport(typ2, ch2, user2, app2, date3, false, true, "Richtiger Kommentar", true, true, true, true, true);

		Measuringresult mr1 = new Measuringresult(rap1, 1, 2, 0, 8, false, 127, 100, 58, 16, 3.5, 6.0 );
		Measuringresult mr2 = new Measuringresult(rap2, 2, 1, 0, 20, true, 150, 105, 60, 18, 3.0, 6.2 );
		
		try {
			customerfunction.saveCustomerfunction(function1);
			customerfunction.saveCustomerfunction(function2);
			
			usergroup.saveUsergroup(group1);
			usergroup.saveUsergroup(group2);
			usergroup.saveUsergroup(group3);
			
			controltype.saveControltype(typ1);
			controltype.saveControltype(typ2);
			
			fuel.saveFuel(fuel1);
			fuel.saveFuel(fuel2);
			fuel.saveFuel(fuel3);
			
			blowertype.saveBlowertype(bTyp1);
			blowertype.saveBlowertype(bTyp2);
			blowertype.saveBlowertype(bTyp3);
			
			blower.saveBlower(blower1);
			blower.saveBlower(blower2);
			
			heater.saveHeater(heater1);
			heater.saveHeater(heater2);
			
			facilitymanager.saveFacilitymanager(fm1);
			facilitymanager.saveFacilitymanager(fm2);
			
			customer.saveCustomer(c1);
			customer.saveCustomer(c2);
			
			customerheater.saveCustomerheater(ch1);
			customerheater.saveCustomerheater(ch2);
			
			company.saveCompany(com1);
			company.saveCompany(com2);
			
			users.saveUser(user1);
			users.saveUser(user2);
			
			appointment.saveAppointment(app1);
			appointment.saveAppointment(app2);
			
			rapport.saveRapport(rap1);
			rapport.saveRapport(rap2);
			
		} catch (Exception e) {
			logger.error("Testdaten konnten nicht geladen werden\'",
					e);
		}	
	}
}
