package test.project.feukora.server.persister;

import org.apache.log4j.Logger;
import org.junit.Test;

import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.persister.BlowertypePersister;
import projekt.feukora.server.persister.BlowertypePersisterImpl;
import projekt.feukora.server.persister.CompanyPersister;
import projekt.feukora.server.persister.CompanyPersisterImpl;
import projekt.feukora.server.persister.ControltypePersister;
import projekt.feukora.server.persister.ControltypePersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.FuelPersister;
import projekt.feukora.server.persister.FuelPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

public class TestdataUsers {
	
	public static CustomerfunctionPersister customerfunction = new CustomerfunctionPersisterImpl();
	public static UsergroupPersister usergroup = new UsergroupPersisterImpl();
	public static ControltypePersister controltype = new ControltypePersisterImpl();
	public static FuelPersister fuel = new FuelPersisterImpl();
	public static BlowertypePersister blowertype = new BlowertypePersisterImpl();
	public static TownPersister tp = new TownPersisterImpl();
	public static CompanyPersister company = new CompanyPersisterImpl();
	
	private static final Logger logger = Logger
			.getLogger(TestdataUsers.class);
	
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
		
		Town zip1 = tp.findbyZip(6000);
		Town zip2 = tp.findbyZip(6005);
		
		Company com1 = new Company("Firma 1", "Niergendwo", "124356577", "info@firma.ch", zip1);
		Company com2 = new Company("Firma 2", "Überall", "7777777", "info@company.ch", zip2);

		
		
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
			
			company.saveCompany(com1);
			company.saveCompany(com2);
			
		} catch (Exception e) {
			logger.error("Testdaten konnten nicht geladen werden\'",
					e);
		}	
	}
}
