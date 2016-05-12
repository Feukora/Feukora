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
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.model.Users;
import projekt.feukora.server.persister.CompanyPersister;
import projekt.feukora.server.persister.CompanyPersisterImpl;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.UserPersisterImpl;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

/**
 * 
 * @author Tamara
 * @version 1.0
 *
 */
public class UsersPersisterTest {


	private static UserPersisterImpl userTest = new UserPersisterImpl();

	@Before
	public void setUp() throws Exception {
		UsersPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Users> userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		UsergroupPersister ug = new UsergroupPersisterImpl();
		Usergroup usergroup = ug.findUsergroupByUsergroupid(0);
		
		CompanyPersister c = new CompanyPersisterImpl();
		Company company = (Company) c.findCompanyByName("Feukora");
		

		Users u = new Users(usergroup,"Nachname","Vorname", "Ort",plz,company, "Username","Passwort","Telefon","Email");

		userTest.saveUser(u);

		userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Users> userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		UsergroupPersister ug = new UsergroupPersisterImpl();
		Usergroup usergroup = ug.findUsergroupByUsergroupid(0);
		
		CompanyPersister c = new CompanyPersisterImpl();
		Company company = (Company) c.findCompanyByName("Feukora");
		

		Users u = new Users(usergroup,"Nachname","Vorname", "Ort",plz,company, "Username","Passwort","Telefon","Email");

		userTest.saveUser(u);

		userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 3);

		u.setLastname("Nachname");

		userTest.updateUser(u);

		Users userFromDB = userTest.findUserByLastname("Nachname").get(0);
		assertNotNull(userFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Users> userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 2);

		userTest.deleteUser(userlist.get(0));

		userlist = userTest.findAllUsers();
		assertTrue(userlist.size() == 1);

	}
	//Ab hier müsst ihr das testen, was ihr in den NamedQueries hingeschrieben habt
	@Test
	public void testFindByLastname() {

		String lastname = "Nachname";

		assertTrue(userTest.findUserByLastname(lastname).size() == 1);
	}
	
	@Test
	public void testByFirstname(){
		
		String firstname = "Vorname";
		
		assertTrue(userTest.findUserByFirstname(firstname).size()==1);
		
		
		
	}
	
	@Test
	public void testByLastnameAndFirstname(){
		
		String lastname ="Nachname";
		String firstname = "Firstname";
		
		assertTrue(userTest.findUserByLastnameAndFirstname(lastname, firstname).size()==1
				);
	
		firstname = "Max";
		
		assertTrue(userTest.findUserByLastnameAndFirstname(lastname, firstname)
				.isEmpty());
	
	}
	
	@Test
	public void testByUsername(){
		
		String username = "Username";
		
		assertTrue(userTest.findUserByUsername(username).size() ==1);
	}

	//Das brauchen wieder alle
	public static List<Users> init() throws Exception {

		UsersPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyTownzip(6000);
		Town plz2 = tp.findbyTownzip(6005);
		
		UsergroupPersister ug = new UsergroupPersisterImpl();
		Usergroup ug1 = ug.findUsergroupByName("Feuerungskontrolleur");
		Usergroup ug2 = ug.findUsergroupByName("Sachbearbeiter");
		
		CompanyPersister c = new CompanyPersisterImpl();
		Company c1 = (Company) c.findCompanyByName("Feuko");
		Company c2 = (Company) c.findCompanyByName("Kora");
		

		Users u1 = new Users(ug1,"Nachname","Vorname", "Ort",plz1,c1, "Username","Passwort","Telefon","Email");
		Users u2 = new Users(ug2,"Nachname","Vorname", "Ort",plz2,c2, "Username","Passwort","Telefon","Email");

		userTest.saveUser(u1);
		userTest.saveUser(u2);

		List<Users> userlist = new ArrayList<>();
		userlist.add(u1);
		userlist.add(u2);

		return userlist;
	}

	private static void deleteAll() throws Exception {

		for (Users u : userTest.findAllUsers()) {
			userTest.deleteUser(u);
		}
	}
}