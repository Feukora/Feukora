package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

public class HeaterPersisterTest {


	private static EntityPersisterImpl entityTest = new EntityPersisterImpl();

	@Before
	public void setUp() throws Exception {
		EntityPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Entity> entitylist = entityTest.findAllCustomers();
		assertTrue(entitylist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function = cf.findCustomerfunctionByCustomerfunctionid(0);

		Entity e = new Entity("Konstruktor von Entity");

		entityTest.saveEntity(e);

		entitylist = entityTest.findAllEntities();
		assertTrue(entitylist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Entity> entitylist = entityTest.findAllEntites();
		assertTrue(entitylist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function = cf.findCustomerfunctionByCustomerfunctionid(1);

		Entity e = new Entity("Konstruktor von Entity");

		customerTest.saveCustomer(c);

		entitylist = entityTest.findAllEntities();
		assertTrue(entitylist.size() == 3);

		e.setLastname("Irrub");

		entityTest.updateCustomer(e);

		Entity entityFromDB = entityTest.findEntityByWasAuchImmerIhrHierHabt("Irrub",
				"Pascal").get(0);
		assertNotNull(entityFromDB);

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