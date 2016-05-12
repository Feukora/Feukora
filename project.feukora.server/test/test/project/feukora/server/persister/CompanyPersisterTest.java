package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.CompanyPersisterImpl;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

public class CompanyPersisterTest {


	private static CompanyPersisterImpl companyTest = new CompanyPersisterImpl();

	@Before
	public void setUp() throws Exception {
		CompanyPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Company> companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		

		Company com = new Company("Name", "Ort", "Telefon", "Email", plz);

		companyTest.saveCompany(com);

		companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Company> companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		Company com = new Company("Name", "Ort", "Telefon", "Email", plz);

		companyTest.saveCompany(com);

		companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 3);

		com.setName("Robin AG");

		companyTest.updateCompany(com);

		Company companyFromDB = companyTest.findCompanyByName("Robin AG").get(0);
		assertNotNull(companyFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Company> companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 2);

		companyTest.deleteCompany(companylist.get(0));

		companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 1);

	}
	//Ab hier müsst ihr das testen, was ihr in den NamedQueries hingeschrieben habt
	@Test
	public void testFindByName() {

		String name = "Robin AG";

		assertTrue(companyTest.findCompanyByName(name).size() == 1);
	}

	//Das brauchen wieder alle
	public static List<Company> init() throws Exception {

		CompanyPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyTownzip(6000);
		Town plz2 = tp.findbyTownzip(6005);
		
		Company com1 = new Company("Name1", "Ort1", "Telefon1", "Email1", plz1);
		Company com2 = new Company("Name2", "Ort2", "Telefon2", "Email2", plz2);

		companyTest.saveCompany(com2);

		List<Company> companylist = new ArrayList<>();
		companylist.add(com1);
		companylist.add(com2);

		return companylist;
	}

	private static void deleteAll() throws Exception {

		for (Company com : companyTest.findAllCompanies()) {
			companyTest.deleteCompany(com);
		}
	}
}