package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.TownData;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

public class CustomerPersisterTest {

	private static CustomerPersisterImpl customerTest = new CustomerPersisterImpl();
	
	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		Testdata.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		CustomerPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Customer> customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 2);
		
		TownPersister tp = new TownPersisterImpl();
		Town zip = tp.findbyZip(6000);
		System.out.println(zip);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function = cf.findCustomerfunctionByName("Verwaltung");

		Customer c = new Customer("Firmenname", "Vorname", "Nachname", "Ort", "Telefonnummer", "Email", function, zip);

		customerTest.saveCustomer(c);

		customerlist = customerTest.findAllCustomers();
		for (Customer customer : customerlist) {
			System.out.println(customer.getCompanyname());
		}
		assertTrue(customerlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Customer> customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 2);
		
		TownPersister tp = new TownPersisterImpl();
		Town zip = tp.findbyZip(6000);
		assertNotNull(zip);
		Town plz = tp.findbyZip(6000);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function = cf.findCustomerfunctionByName("Eigentümer");

		Customer c = new Customer("Burri AG", "Pascal", "Burri",  "Schachen", "04112345456", "sfasg@afgafg.ch", function, zip);

		customerTest.saveCustomer(c);

		customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 3);

		c.setLastname("Irrub");

		customerTest.updateCustomer(c);

		Customer customerFromDB = customerTest.findCustomerByLastnameAndFirstname("Irrub",
				"Pascal").get(0);
		assertNotNull(customerFromDB);

	}
	
	@Test
	public void testDelete() throws Exception {

		List<Customer> customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 2);

		customerTest.deleteCustomer(customerlist.get(0));

		customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 1);

	}

	@Test
	public void testFindByLastname() {

		String lastname = "Fasser";

		assertTrue(customerTest.findCustomerByLastname(lastname).size() == 1);
	}

	@Test
	public void testFindByFirstname() {

		String firstname = "Sandro";

		assertTrue(customerTest.findCustomerByFirstname(firstname).size() == 1);

		firstname = "Max";

		assertTrue(customerTest.findCustomerByFirstname(firstname).isEmpty());
	}

	@Test
	public void testFindByLastnameAndFirstname() {

		String lastname = "Pereira";
		String firstname = "Patrick";

		assertTrue(customerTest.findCustomerByLastnameAndFirstname(lastname, firstname).size() == 1);

		firstname = "Max";

		assertTrue(customerTest.findCustomerByLastnameAndFirstname(lastname, firstname)
				.isEmpty());
	}

	@Test
	public void testFindByCompanyname() {
		
		String companyname = "Perry AG";

		assertTrue(customerTest.findCustomerByCompanyname(companyname).size() == 1);
		
		companyname = "Parry AG";

		assertTrue(customerTest.findCustomerByCompanyname(companyname)
				.isEmpty());

	}

	public static List<Customer> init() throws Exception {

		CustomerPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town zip1 = tp.findbyZip(6000);
		Town zip2 = tp.findbyZip(6005);
		assertNotNull(zip1);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function1 = cf.findCustomerfunctionByName("Verwaltung");
		Customerfunction function2 = cf.findCustomerfunctionByName("Eigentümer");
		assertNotNull(function1);

		Customer c1 = new Customer("Fasser AG", "Sandro", "Fasser",  "Bergün", "1234", "sf@sf.ch", function1, zip1);
		Customer c2 = new Customer("Perry AG", "Patrick", "Pereira",  "Aargau", "5678", "pdp@pdp.ch", function2, zip2);

		customerTest.saveCustomer(c1);
		customerTest.saveCustomer(c2);

		List<Customer> customerlist = new ArrayList<>();
		customerlist.add(c1);
		customerlist.add(c2);

		return customerlist;
	}

	private static void deleteAll() throws Exception {

		for (Customer c : customerTest.findAllCustomers()) {
			customerTest.deleteCustomer(c);
		}
	}
}
