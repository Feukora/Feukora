
package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.User;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.model.User;
import projekt.feukora.server.persister.CompanyPersister;
import projekt.feukora.server.persister.CompanyPersisterImpl;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.TownData;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersisterImpl;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

/**
 * Class to test the methods of the class UserPersister.
 * 
 * @author Tamara
 * @version 1.0
 *
 */
public class UsersPersisterTest {


	private static UserPersisterImpl userTest = new UserPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		TestdataUsers.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		UsersPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<User> userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 2);
		
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyZip(6000);
		
		UsergroupPersister ug = new UsergroupPersisterImpl();
		Usergroup usergroup = ug.findUsergroupByUsergroupid(0);
		
		CompanyPersister c = new CompanyPersisterImpl();
		Company company = c.findCompanyByName("Firma 1").get(0);
		
		User u = new User(usergroup,"Nachname","Vorname", "Ort",plz,company, "Username","Passwort","Telefon","Email");

		userTest.saveUser(u);

		userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<User> userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 2);
		
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyZip(6000);
		
		UsergroupPersister ug = new UsergroupPersisterImpl();
		Usergroup usergroup = ug.findUsergroupByUsergroupid(0);
		
		CompanyPersister c = new CompanyPersisterImpl();
		Company company = c.findCompanyByName("Firma 2").get(0);

		User u = new User(usergroup,"Nachname","Vorname", "Ort",plz,company, "Username","Passwort","Telefon","Email");

		userTest.saveUser(u);

		userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 3);

		u.setLastname("Name");

		userTest.updateUser(u);

		User userFromDB = userTest.findUserByLastname("Name").get(0);
		assertNotNull(userFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<User> userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 2);

		userTest.deleteUser(userlist.get(0));

		userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 1);

	}
	@Test
	public void testFindByLastname() {

		String lastname = "Nachname1";

		assertTrue(userTest.findUserByLastname(lastname).size() == 1);
	}
	
	@Test
	public void testByFirstname(){
		
		String firstname = "Vorname2";
		
		assertTrue(userTest.findUserByFirstname(firstname).size()==1);	
	}
	
	@Test
	public void testByLastnameAndFirstname(){
		
		String lastname ="Nachname1";
		String firstname = "Vorname1";
		
		assertTrue(userTest.findUserByLastnameAndFirstname(lastname, firstname).size()==1
				);
	
		firstname = "Max";
		
		assertTrue(userTest.findUserByLastnameAndFirstname(lastname, firstname)
				.isEmpty());
	
	}
	
	@Test
	public void testByUsername(){
		
		String username = "Username1";
		
		assertTrue(userTest.findUserByUsername(username) != null);
	}

	public static List<User> init() throws Exception {

		UsersPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyZip(6000);
		Town plz2 = tp.findbyZip(6005);
		
		UsergroupPersister ug = new UsergroupPersisterImpl();
		Usergroup ug1 = ug.findUsergroupByName("Feuerungskontrolleur");
		Usergroup ug2 = ug.findUsergroupByName("Backoffice");
		
		CompanyPersister c = new CompanyPersisterImpl();
		Company c1 = c.findCompanyByName("Firma 1").get(0);
		Company c2 = c.findCompanyByName("Firma 2").get(0);
		

		User u1 = new User(ug1, "Nachname1", "Vorname1", "Ort1", plz1, c1, "Username1", "Passwort1", "Telefon1", "Email1");
		User u2 = new User(ug2, "Nachname2", "Vorname2", "Ort2", plz2, c2, "Username2", "Passwort2", "Telefon2", "Email2");

		userTest.saveUser(u1);
		userTest.saveUser(u2);

		List<User> userlist = new ArrayList<>();
		userlist.add(u1);
		userlist.add(u2);

		return userlist;
	}

	private static void deleteAll() throws Exception {

		for (User u : userTest.findAllUsers()) {
			userTest.deleteUser(u);
		}
	}
}