package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.persister.FacilitymanagerPersisterImpl;

public class FacilitymanagerPersisterTest {


	private static FacilitymanagerPersisterImpl facilitymanagerTest = new FacilitymanagerPersisterImpl();

	@Before
	public void setUp() throws Exception {
		FacilitymanagerPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Facilitymanager> facilitymanagerlist = facilitymanagerTest.findAllFacilitymanagers();
		assertTrue(facilitymanagerlist.size() == 2);

		Facilitymanager fm = new Facilitymanager("Hauswart", "Werner", "12345678", "hauswart@hauswart.ch");

		facilitymanagerTest.saveFacilitymanager(fm);

		facilitymanagerlist = facilitymanagerTest.findAllFacilitymanagers();
		assertTrue(facilitymanagerlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Facilitymanager> facilitymanagerlist = facilitymanagerTest.findAllFacilitymanagers();
		assertTrue(facilitymanagerlist.size() == 2);
		
		Facilitymanager fm = new Facilitymanager("Burri", "Pascal", "98765432", "pascal@burri.ch");

		facilitymanagerTest.saveFacilitymanager(fm);

		facilitymanagerlist = facilitymanagerTest.findAllFacilitymanagers();
		assertTrue(facilitymanagerlist.size() == 3);

		fm.setLastname("Irrub");

		facilitymanagerTest.updateFacilitymanager(fm);

		Facilitymanager facilitymanagerFromDB = facilitymanagerTest.findFacilitymanagerByLastname("Irrub").get(0);
		assertNotNull(facilitymanagerFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Facilitymanager> facilitymanagerlist = facilitymanagerTest.findAllFacilitymanagers();
		assertTrue(facilitymanagerlist.size() == 2);

		facilitymanagerTest.deleteFacilitymanager(facilitymanagerlist.get(0));

		facilitymanagerlist = facilitymanagerTest.findAllFacilitymanagers();
		assertTrue(facilitymanagerlist.size() == 1);

	}

	@Test
	public void testFindByLastname() {

		String lastname = "Fasser";

		assertTrue(facilitymanagerTest.findFacilitymanagerByLastname(lastname).size() == 1);
	}

	@Test
	public void testFindByFirstname() {

		String firstname = "Allan";

		assertTrue(facilitymanagerTest.findFacilitymanagerByFirstname(firstname).size() == 1);
	}
	
	public static List<Facilitymanager> init() throws Exception {

		FacilitymanagerPersisterTest.deleteAll();
		

		Facilitymanager fm1 = new Facilitymanager("Fasser", "Sandro", "565656565", "sandro@fasser.ch");
		Facilitymanager fm2 = new Facilitymanager("Blessing", "Allan", "123456", "allan@blessing.ch");

		facilitymanagerTest.saveFacilitymanager(fm1);
		facilitymanagerTest.saveFacilitymanager(fm2);

		List<Facilitymanager> facilitymanagerlist = new ArrayList<>();
		facilitymanagerlist.add(fm1);
		facilitymanagerlist.add(fm2);

		return facilitymanagerlist;
	}

	private static void deleteAll() throws Exception {

		for (Facilitymanager fm : facilitymanagerTest.findAllFacilitymanagers()) {
			facilitymanagerTest.deleteFacilitymanager(fm);
		}
	}
}