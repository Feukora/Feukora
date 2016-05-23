package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Heater;
import projekt.feukora.server.persister.HeaterPersisterImpl;
import projekt.feukora.server.persister.TownData;

/**
 * Class to test the methods of the class HeaterPersister.
 * 
 * @author Patrick
 * @version 1.0
 */
public class HeaterPersisterTest {


	private static HeaterPersisterImpl heaterTest = new HeaterPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		Testdata.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		HeaterPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * tests if the Heater is saved
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		
		List<Heater> heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 2);

		Heater h = new Heater("Konstruktor von Heater");

		heaterTest.saveHeater(h);

		heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 3);

	}
	
	/**
	 * tests if the Heater id updated
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Heater> heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 2);

		Heater h = new Heater("Neuer Heater");

		heaterTest.saveHeater(h);

		heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 3);

		h.setName("Alter Heater");

		heaterTest.updateHeater(h);

		Heater heaterFromDB = heaterTest.findHeaterByName("Heater 1").get(0);
		assertNotNull(heaterFromDB);

	}

	/**
	 * tests if the Heater is deleted
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Heater> heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 2);

		heaterTest.deleteHeater(heaterlist.get(0));

		heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 1);

	}

	/**
	 * tests if the Heater can be found by name
	 */
	@Test
	public void testFindByName() {

		String name = "Heater 1";

		assertTrue(heaterTest.findHeaterByName(name).size() == 1);
	}

	public static List<Heater> init() throws Exception {

		HeaterPersisterTest.deleteAll();

		Heater h1 = new Heater("Heater 1");
		Heater h2 = new Heater("Heater 2");

		heaterTest.saveHeater(h1);
		heaterTest.saveHeater(h2);

		List<Heater> heaterlist = new ArrayList<>();
		heaterlist.add(h1);
		heaterlist.add(h2);

		return heaterlist;
	}

	private static void deleteAll() throws Exception {

		for (Heater h : heaterTest.findAllHeaters()) {
			heaterTest.deleteHeater(h);
		}
	}
}