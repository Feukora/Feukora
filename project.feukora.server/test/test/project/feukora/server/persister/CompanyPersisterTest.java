package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.CompanyPersisterImpl;
import projekt.feukora.server.persister.TownData;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

/**
 * Class to test the methods of the class CompanyPersister.
 * 
 * @author Robin
 * @version 1.0
 *
 */
public class CompanyPersisterTest {


	private static CompanyPersisterImpl companyTest = new CompanyPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		Testdata.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		CompanyPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * tests if the Company is saved
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		
		List<Company> companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 2);
		
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyZip(6000);
		

		Company com = new Company("Name", "Ort", "Telefon", "Email", plz);

		companyTest.saveCompany(com);

		companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 3);

	}
	
	/**
	 * tests if the Company is updated
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Company> companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 2);
		
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyZip(6000);
		
		Company com = new Company("Name", "Ort", "Telefon", "Email", plz);

		companyTest.saveCompany(com);

		companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 3);

		com.setName("Robin AG");

		companyTest.updateCompany(com);

		Company companyFromDB = companyTest.findCompanyByName("Robin AG").get(0);
		assertNotNull(companyFromDB);

	}

	/**
	 * tests if the Company is deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Company> companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 2);

		companyTest.deleteCompany(companylist.get(0));

		companylist = companyTest.findAllCompanies();
		assertTrue(companylist.size() == 1);

	}
	/**
	 * tests if the Company can be found by name
	 */
	@Test
	public void testFindByName() {

		String name = "Name1";

		assertTrue(companyTest.findCompanyByName(name).size() == 1);
	}

	public static List<Company> init() throws Exception {

		CompanyPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyZip(6000);
		Town plz2 = tp.findbyZip(6005);
		
		Company com1 = new Company("Name1", "Ort1", "Telefon1", "Email1", plz1);
		Company com2 = new Company("Name2", "Ort2", "Telefon2", "Email2", plz2);

		companyTest.saveCompany(com1);
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