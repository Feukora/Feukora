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
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.model.Users;
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
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

public class TestdataRapport {
	
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
	
	private static final Logger logger = Logger
			.getLogger(TestdataRapport.class);
	
	@Test
	public static void loadTestdata() {
		
		
		Customerfunction function1 = new Customerfunction("Verwaltung");
		Customerfunction function2 = new Customerfunction("Eigentümer");
		
		Usergroup group1 = new Usergroup("Administrator");
		Usergroup group2 = new Usergroup("Feuerungskontrolleur");
		Usergroup group3 = new Usergroup("Backoffice");
		
		Controltype typ1 = new Controltype("Routinekontrolle");
		Controltype typ2 = new Controltype("Abnahmekontrolle");
		
		Fuel fuel1 = new Fuel("Öl");
		Fuel fuel2 = new Fuel("Erdgas");
		Fuel fuel3 = new Fuel("Flüssiggas");
		
		Blowertype bTyp1 = new Blowertype("Gebläse");
		Blowertype bTyp2 = new Blowertype("Athmosphärisch");
		Blowertype bTyp3 = new Blowertype("Verdampfer");
		
		
		
		Blower blower1 = new Blower(bTyp1, fuel1, "Blower 1");
		Blower blower2 = new Blower(bTyp3, fuel3, "Blower 2");
		
		Heater heater1 = new Heater("Heizung 1");
		Heater heater2 = new Heater("Heizung 2");
		
		Facilitymanager fm1 = new Facilitymanager("Hausmeister", "Robert");
		Facilitymanager fm2 = new Facilitymanager("Meister", "Jakob");
		
		Town zip1 = tp.findbyZip(6000);
		Town zip2 = tp.findbyZip(6005);
		assertNotNull(zip1);

		Customer c1 = new Customer("Fasser AG", "Sandro", "Fasser",  "Bergün", "1234", "sf@sf.ch", function1, zip1);
		Customer c2 = new Customer("Perry AG", "Patrick", "Pereira",  "Aargau", "5678", "pdp@pdp.ch", function2, zip2);

		Customerheater ch1 = new Customerheater(c1, heater1, blower1, fm1, 1990, 2000, 78);
		Customerheater ch2 = new Customerheater(c2, heater2, blower2, fm2, 2010, 2010, 200);
		
		Company com1 = new Company("Firma1", "Strasse1", "1111111", "asdf@asdf.ch", zip1);
		Company com2 = new Company("Firma2", "Strasse2", "2222222", "asdf@asdf.ch", zip2);
		
		Users user1 = new Users(group1, "Nachname", "Vorname", "Adresse", zip1, com1, "Username", "Passwort", "123445656", "asdf@asd.ch");
		Users user2 = new Users(group2, "Lastname", "Firstname", "Adress", zip2, com2, "username", "password", "00000000", "email.com");
		
		GregorianCalendar date1 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date3 = new GregorianCalendar(2016, 05, 16, 10, 0);
		GregorianCalendar date4 = new GregorianCalendar(2016, 05, 16, 10, 0);
		
		Appointment app1 = new Appointment(ch1, user1, user1, date1, date2, "Kein Kommentar");
		Appointment app2 = new Appointment(ch2, user2, user2, date3, date4, "Hallo");

		
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
			
		} catch (Exception e) {
			logger.error("Testdaten konnten nicht geladen werden\'",
					e);
		}	
	}
}
