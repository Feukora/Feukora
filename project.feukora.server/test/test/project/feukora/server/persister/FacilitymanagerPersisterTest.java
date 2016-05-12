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
		facilitymanagerTest.init();
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

		List<Entity> entitylist = entityTest.findAllEntities();
		assertTrue(entitylist.size() == 2);

		entityTest.deleteEntity(entitylist.get(0));

		entitylist = entityTest.findAllEntities();
		assertTrue(entitylist.size() == 1);

	}
	//Ab hier müsst ihr das testen, was ihr in den NamedQueries hingeschrieben habt
	@Test
	public void testFindByLastname() {

		String lastname = "Fasser";

		assertTrue(entityTest.findEntityByLastname(lastname).size() == 1);
	}

	public static List<Entity> init() throws Exception {

		EntityPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyTownzip(6000);
		Town plz2 = tp.findbyTownzip(6005);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function1 = cf.findCustomerfunctionByCustomerfunctionid(0);
		Customerfunction function2 = cf.findCustomerfunctionByCustomerfunctionid(1);

		Entity e1 = new new Entity("Konstruktor von Entity");
		Entity e2 = new new Entity("Konstruktor von Entity");

		entityTest.saveEntity(e1);
		entityTest.saveEntity(e2);

		List<Entity> entitylist = new ArrayList<>();
		entitylist.add(e1);
		entitylist.add(e2);

		return entitylist;
	}

	private static void deleteAll() throws Exception {

		for (Entity e : entityTest.findAllEntities()) {
			entityTest.deleteEntity(e);
		}
	}
}