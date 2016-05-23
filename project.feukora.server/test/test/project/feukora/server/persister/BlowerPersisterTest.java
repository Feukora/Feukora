package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.persister.BlowerPersisterImpl;
import projekt.feukora.server.persister.BlowertypePersister;
import projekt.feukora.server.persister.BlowertypePersisterImpl;
import projekt.feukora.server.persister.FuelPersister;
import projekt.feukora.server.persister.FuelPersisterImpl;
import projekt.feukora.server.persister.TownData;

/**
 * Class to tests the methods of the class BlowerPersister.
 * 
 * @author Robin
 * @version 1.0
 */
public class BlowerPersisterTest {


	private static BlowerPersisterImpl blowerTest = new BlowerPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData("resources/ZIP.txt");
		Testdata.loadTestdata();
	}
	
	@Before
	public void setUp() throws Exception {
		BlowerPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * tests if the Blower is saved
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		
		List<Blower> blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 2);
		
		FuelPersister fp = new FuelPersisterImpl();
		Fuel fuel = fp.findFuelByName("Öl");
		
		BlowertypePersister bp = new BlowertypePersisterImpl();
		Blowertype blowertype = bp.findBlowertypeByName("Verdampfer");
		
		Blower b = new Blower(blowertype, fuel, "Name");

		blowerTest.saveBlower(b);

		blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 3);

	}
	
	/**
	 * tests if the Blower is updated
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Blower> blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 2);
		
		FuelPersister fp = new FuelPersisterImpl();
		Fuel fuel = fp.findFuelByName("Erdgas");
		
		BlowertypePersister bp = new BlowertypePersisterImpl();
		Blowertype blowertype = bp.findBlowertypeByName("Gebläse");
		
		Blower b = new Blower(blowertype, fuel, "Name");

		blowerTest.saveBlower(b);

		blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 3);

		b.setName("Blower");

		blowerTest.updateBlower(b);

		Blower blowerFromDB = blowerTest.findBlowerByName("Blower").get(0);
		assertNotNull(blowerFromDB);

	}

	/**
	 * tests if the Blower is deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Blower> blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 2);

		blowerTest.deleteBlower(blowerlist.get(0));

		blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 1);

	}
	/**
	 * tests if the Blower can be found by name
	 */
	@Test
	public void testFindByName() {

		String name = "Name";

		assertTrue(blowerTest.findBlowerByName(name).size() == 1);
	}
	public static List<Blower> init() throws Exception {

		BlowerPersisterTest.deleteAll();
		
		FuelPersister fp = new FuelPersisterImpl();
		Fuel fuel1 = fp.findFuelByName("Öl");
		Fuel fuel2 = fp.findFuelByName("Erdgas");
		
		BlowertypePersister bp = new BlowertypePersisterImpl();
		Blowertype blowertype1 = bp.findBlowertypeByName("Gebläse");
		Blowertype blowertype2 = bp.findBlowertypeByName("Verdampfer");
		
		Blower b1 = new Blower(blowertype1, fuel1,"Name");
		Blower b2 = new Blower(blowertype2,fuel2,"Name2");

		blowerTest.saveBlower(b1);
		blowerTest.saveBlower(b2);

		List<Blower> blowerlist = new ArrayList<>();
		blowerlist.add(b1);
		blowerlist.add(b2);

		return blowerlist;
	}

	private static void deleteAll() throws Exception {

		for (Blower b : blowerTest.findAllBlowers()) {
			blowerTest.deleteBlower(b);
		}
	}
}