package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.BlowerPersisterImpl;
import projekt.feukora.server.persister.BlowertypePersister;
import projekt.feukora.server.persister.BlowertypePersisterImpl;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.FuelPersister;
import projekt.feukora.server.persister.FuelPersisterImpl;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

public class BlowerPersisterTest {


	private static BlowerPersisterImpl blowerTest = new BlowerPersisterImpl();

	@Before
	public void setUp() throws Exception {
		BlowerPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Blower> blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		FuelPersister fp = new FuelPersisterImpl();
		Fuel fuelid = fp.findFuelByFuelid(0);
		
		BlowertypePersister bp = new BlowertypePersisterImpl();
		Blowertype blowertypeid = bp.findBlowertypeByBlowertypeid(0);
		
		Blower b = new Blower(blowertypeid, fuelid, "Name");

		blowerTest.saveBlower(b);

		blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 3);

	}
	
	@Test
	public void testUpdate() throws Exception {

		List<Blower> blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		TownPersister tp = new TownPersisterImpl();
		Town plz = tp.findbyTownzip(6000);
		
		FuelPersister fp = new FuelPersisterImpl();
		Fuel fuelid = fp.findFuelByFuelid(0);
		
		BlowertypePersister bp = new BlowertypePersisterImpl();
		Blowertype blowertypeid = bp.findBlowertypeByBlowertypeid(0);
		
		Blower b = new Blower(blowertypeid, fuelid, "Name");

		blowerTest.saveBlower(b);

		blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 3);

		b.setName("Blower");

		blowerTest.updateBlower(b);

		Blower blowerFromDB = blowerTest.findBlowerByName("Blower").get(0);
		assertNotNull(blowerFromDB);

	}

	@Test
	public void testDelete() throws Exception {

		List<Blower> blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 2);

		blowerTest.deleteBlower(blowerlist.get(0));

		blowerlist = blowerTest.findAllBlowers();
		assertTrue(blowerlist.size() == 1);

	}
	//Ab hier müsst ihr das testen, was ihr in den NamedQueries hingeschrieben habt
	@Test
	public void testFindByName() {

		String name = "Blower";

		assertTrue(blowerTest.findBlowerByName(name).size() == 1);
	}

	//Das brauchen wieder alle
	public static List<Blower> init() throws Exception {

		BlowerPersisterTest.deleteAll();
		
		TownPersister tp = new TownPersisterImpl();
		Town plz1 = tp.findbyTownzip(6000);
		Town plz2 = tp.findbyTownzip(6005);
		
		FuelPersister fp = new FuelPersisterImpl();
		Fuel fuelid1 = fp.findFuelByFuelid(0);
		Fuel fuelid2 = fp.findFuelByFuelid(1);
		
		BlowertypePersister bp = new BlowertypePersisterImpl();
		Blowertype blowertype1 = bp.findBlowertypeByBlowertypeid(0);
		Blowertype blowertype2 = bp.findBlowertypeByBlowertypeid(1);
		
		Blower b1 = new Blower(blowertype1, fuelid1,"Name");
		Blower b2 = new Blower(blowertype2,fuelid2,"Name2");

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