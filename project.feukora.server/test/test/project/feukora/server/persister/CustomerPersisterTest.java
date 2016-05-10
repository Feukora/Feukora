package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.persister.CustomerPersisterImpl;

public class CustomerPersisterTest {

	private static CustomerPersisterImpl customerTest = new CustomerPersisterImpl();

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
		
		Town town1 = new Town(6000, "Luzern");
		Customerfunction cf1 = new Customerfunction(1, "Eigentümer");

		Customer c = new Customer("Firmenname", "Nachname", "Vorname", "Ort", "Telefonnummer", "Email", town1, cf1);

		customerTest.saveCustomer(c);

		customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Customer> customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 2);

		Customer c = new Customer("Burri AG", "Burri", "Pascal", "Schachen", "04112345456", "sfasg@afgafg.ch");

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
	public void testFindByAdress() {
		
		String companyname = "Perry AG";

		assertTrue(customerTest.findCustomerByCompanyname(companyname).size() == 1);
		
		companyname = "Fasser AG";

		assertTrue(customerTest.findCustomerByCompanyname(companyname)
				.isEmpty());

	}

	@Ignore
	@Test
	public void testDeleteByCustomerid() throws Exception {

		List<Customer> customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 2);
				
		customerTest.deleteCustomerByCustomerid(1);

		customerlist = customerTest.findAllCustomers();
		assertTrue(customerlist.size() == 1);
	}

	public static List<Customer> init() throws Exception {

		CustomerPersisterTest.deleteAll();

		Customer c1 = new Customer("Fasser AG", "Fasser", "Sandro", "Bergün", "1234", "sf@sf.ch");
		Customer c2 = new Customer("Perry AG", "Pereira", "Patrick", "Aargau", "5678", "pdp@pdp.ch");

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
