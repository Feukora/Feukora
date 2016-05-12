package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.HeaterPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

public class HeaterPersisterTest {


	private static HeaterPersisterImpl heaterTest = new HeaterPersisterImpl();

	@Before
	public void setUp() throws Exception {
		HeaterPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Heater> heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 2);
		
		/* Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function = cf.findCustomerfunctionByCustomerfunctionid(0);
		
		*/

		Heater h = new Heater("Konstruktor von Heater");

		heaterTest.saveHeater(h);

		heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Heater> heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		/*TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function = cf.findCustomerfunctionByCustomerfunctionid(1);
		*/

		Heater h = new Heater("Konstruktor von Heater");

		heaterTest.saveHeater(h);

		heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 3);

		h.setName("Heater1");

		heaterTest.updateHeater(h);

		Heater heaterFromDB = heaterTest.findHeaterByName("I").get(0);
		assertNotNull(heaterFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Heater> heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 2);

		heaterTest.deleteHeater(heaterlist.get(0));

		heaterlist = heaterTest.findAllHeaters();
		assertTrue(heaterlist.size() == 1);

	}
	//Ab hier müsst ihr das testen, was ihr in den NamedQueries hingeschrieben habt
	@Test
	public void testFindByName() {

		String name = "Heater";

		assertTrue(heaterTest.findHeaterByName(name).size() == 1);
	}

	//Das brauchen wieder alle
	public static List<Heater> init() throws Exception {

		HeaterPersisterTest.deleteAll();
		
		/*
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyTownzip(6000);
		Town plz2 = tp.findbyTownzip(6005);
		
		CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		Customerfunction function1 = cf.findCustomerfunctionByCustomerfunctionid(0);
		Customerfunction function2 = cf.findCustomerfunctionByCustomerfunctionid(1);
		*/

		Heater h1 = new Heater("Konstruktor von Heater");
		Heater h2 = new Heater("Konstruktor von Heater");

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