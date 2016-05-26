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
import projekt.feukora.server.persister.MeasuringresultPersister;
import projekt.feukora.server.persister.MeasuringresultPersisterImpl;
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
	public static MeasuringresultPersister measuringresult = new MeasuringresultPersisterImpl();

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
		Blower blower3 = new Blower(bTyp2, fuel2, "Budens BREI");

		Heater heater1 = new Heater("Sixmadun TG 21");
		Heater heater2 = new Heater("CTC");
		Heater heater3 = new Heater("Buderns GII5 REI7");

		Facilitymanager fm1 = new Facilitymanager("Hans Meister");
		Facilitymanager fm2 = new Facilitymanager("Meister Proper");
		Facilitymanager fm3 = new Facilitymanager("Don Geier");

		Town zip1 = tp.findbyZip(6000);
		Town zip2 = tp.findbyZip(6005);
		Town zip3 = tp.findbyZip(6300);
		assertNotNull(zip1);

		Customer c1 = new Customer("Fasser AG", "Sandro", "Fasser",  "Bergün", "1234", "sf@sf.ch", function1, zip1);
		Customer c2 = new Customer("Perry AG", "Patrick", "Pereira",  "Aargau", "5678", "pdp@pdp.ch", function2, zip2);
		Customer c3 = new Customer("Klein AG", "Kevin", "Klein", "Zug", "042 440 98 76", "kleinkev@gmail.com", function1, zip3);
		Customer c4 = new Customer("Blessing AG", "Chantal", "Blessing", "Luzern", "042 367 07 74", "blechant@gamil.com", function2, zip2);
		Customer c5 = new Customer("Oragon AG", "Tina", "Grün", "Luzern", "042 756 54 54", "tinagrün@gamil.com", function1, zip2);
		Customer c6 = new Customer("Levin AG", "Hans", "Meissner", "Zug", "042 564 56 45", "hansmeissner@gamil.com", function1, zip3);

		Customerheater ch1 = new Customerheater(c1, heater1, blower1, fm1, 1990, 2000, 78);
		Customerheater ch2 = new Customerheater(c2, heater2, blower2, fm2, 2010, 2010, 200);
		Customerheater ch3 = new Customerheater(c3, heater3, blower3, fm3, 1999, 2001, 190);
		Customerheater ch4 = new Customerheater(c1, heater2, blower3, fm1, 1995, 2016, 12);

		Company com1 = new Company("Centralhof", "Zentralstrasse 24", "045 440 67 43", "centralhof@gmail.ch", zip1);
		Company com2 = new Company("PHAdmin", "Zürichstrasse 13", "043 387 32 31", "phadmin@outlook.ch", zip2);
		Company com3 = new Company("Meissner GmbH", "Leihenstrasse 33", "043 234 65 34", "meissnergmbh@outlook.ch", zip3);
		Company com4 = new Company("Company AG", "Meilenweg 76", "044 387 34 43", "companyag@outlook.ch", zip2);
		Company com5 = new Company("appelwindow AG", "Jungstrasse 55", "046 357 32 31", "appelwindow@outlook.ch", zip1);
		Company com6 = new Company("Unfreezing AG", "Luzernstrasse 73", "043 387 89 32", "unfreezingag@outlook.ch", zip3);

		User user1 = new User(group2, "Müller", "Catalina", "Zugerweg 3", zip1, com1, "mca", "user1", "042 765 34 73", "catalinamüller@outlook.ch");
		User user2 = new User(group1, "Hofstetter", "Gida", "Hofmatt 90", zip2, com2, "admin", "admin", "043 657 98 54", "gidahofstetter@outlook.com");
		User user3 = new User(group3, "Hansen", "Katarina", "Heimweg 4", zip3, com3, "hka", "user3", "042 878 43 34", "katarinahanseen@outlook.ch");
		User user4 = new User(group1, "Hartman", "Viola", "Kasperlistrasse 34", zip1, com4, "hav", "user4", "042 789 76 32", "hartmannviola@outlook.ch");
		User user5 = new User(group2, "Amrein", "Eveline", "Sommerstrasse 2", zip2, com5, "eva", "user5", "042 765 34 73", "evelineamrein@outlook.ch");
		User user6 = new User(group3, "Helsinker", "Stefan", "Zugerweg 3", zip3, com6, "hes", "user6", "042 232 34 34", "stefanhelsinker@outlook.ch");

		GregorianCalendar date1 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date2 = new GregorianCalendar(2016, 05, 13, 8, 0);
		GregorianCalendar date3 = new GregorianCalendar(2016, 05, 16, 10, 0);
		GregorianCalendar date4 = new GregorianCalendar(2016, 05, 16, 10, 0);

		Appointment app1 = new Appointment(ch1, user1, user1, date1, date2, "Kein Kommentar");
		Appointment app2 = new Appointment(ch2, user2, user2, date3, date4, "Hallo");
		Appointment app3 = new Appointment(ch3, user3, user3, date1, date3, "Termin");
		Appointment app4 = new Appointment(ch4, user1, user1, date3, date3, "Test");

		Rapport rap1 = new Rapport("LU", "Strasse 24", typ1, ch1, user1, app1, date1, true, false, "Kein Kommentar", true, true, true, true, true);
		Rapport rap2 = new Rapport("GR", "Strasse 25",typ2, ch2, user2, app2, date3, false, true, "Richtiger Kommentar", true, true, true, true, true);
		Rapport rap3 = new Rapport("AG", "Stinktstrasse 24",typ1, ch3, user5, app3, date4, false, true, "Kein Kommentar", true, true, true, true, true);

		Measuringresult mr1 = new Measuringresult(rap1, 1, 2, 0, 8, false, 127, 100, 58, 16, 3.5, 6.0 );
		Measuringresult mr2 = new Measuringresult(rap2, 2, 1, 0, 20, true, 150, 105, 60, 18, 3.0, 6.2 );
		Measuringresult mr3 = new Measuringresult(rap3, 1, 1, 0, 24, true, 156, 155, 70, 18, 3.6, 6.8 );

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
			blower.saveBlower(blower3);

			heater.saveHeater(heater1);
			heater.saveHeater(heater2);
			heater.saveHeater(heater3);

			facilitymanager.saveFacilitymanager(fm1);
			facilitymanager.saveFacilitymanager(fm2);
			facilitymanager.saveFacilitymanager(fm3);

			customer.saveCustomer(c1);
			customer.saveCustomer(c2);
			customer.saveCustomer(c3);
			customer.saveCustomer(c4);
			customer.saveCustomer(c5);
			customer.saveCustomer(c6);

			customerheater.saveCustomerheater(ch1);
			customerheater.saveCustomerheater(ch2);
			customerheater.saveCustomerheater(ch3);
			customerheater.saveCustomerheater(ch4);

			company.saveCompany(com1);
			company.saveCompany(com2);
			company.saveCompany(com3);
			company.saveCompany(com4);
			company.saveCompany(com5);
			company.saveCompany(com6);


			users.saveUser(user1);
			users.saveUser(user2);
			users.saveUser(user3);
			users.saveUser(user4);
			users.saveUser(user5);
			users.saveUser(user6);

			appointment.saveAppointment(app1);
			appointment.saveAppointment(app2);
			appointment.saveAppointment(app3);
			appointment.saveAppointment(app4);

			rapport.saveRapport(rap1);
			rapport.saveRapport(rap2);
			rapport.saveRapport(rap3);

			measuringresult.saveMeasuringresult(mr1);
			measuringresult.saveMeasuringresult(mr2);
			measuringresult.saveMeasuringresult(mr3);

		} catch (Exception e) {
			logger.error("Testdaten konnten nicht geladen werden ",
					e);
		}	
	}
}