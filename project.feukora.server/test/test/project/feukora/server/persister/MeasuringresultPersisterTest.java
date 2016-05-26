package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;
import projekt.feukora.server.persister.MeasuringresultPersister;
import projekt.feukora.server.persister.MeasuringresultPersisterImpl;
import projekt.feukora.server.persister.RapportPersister;
import projekt.feukora.server.persister.RapportPersisterImpl;
import projekt.feukora.server.persister.TownData;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

/**
 * Class to test the methods of the class MeasuringresultPersister.
 * 
 * @author Patrick
 * @version 1.0
 *
 */
public class MeasuringresultPersisterTest {


	private static MeasuringresultPersisterImpl measuringresultTest = new MeasuringresultPersisterImpl();

	@BeforeClass
	public static void start() throws Exception {
		TownData.loadTownData();
		TestdataMeasuringresult.loadTestdata();
	}

	@Before
	public void setUp() throws Exception {
		MeasuringresultPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * tests if the Measuringresult is saved
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {

		List<Measuringresult> measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 2);

		RapportPersister rp = new RapportPersisterImpl();
		Rapport rapport1 = rp.findRapportByResults(false).get(0);

		Measuringresult mr = new Measuringresult(rapport1, 2, 2, 45, 10, true, 5, 34, 44, 6, 5.6, 34.9);
		measuringresultTest.saveMeasuringresult(mr);

		measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 3);
	}

	/**
	 * tests if the Measuringresult is deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Measuringresult> measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 2);

		measuringresultTest.deleteMeasuringresult(measuringresultlist.get(0));

		measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 1);
	}

	public static List<Measuringresult> init() throws Exception {

		MeasuringresultPersisterTest.deleteAll();

		RapportPersister rp = new RapportPersisterImpl();
		Rapport rapport1 = rp.findRapportByResults(false).get(0);
		Rapport rapport2 = rp.findRapportByResults(true).get(0);

		Measuringresult mr1 = new Measuringresult(rapport1, 1, 2, 45, 10, true, 5, 34, 44, 6, 5.6, 12.8);
		Measuringresult mr2 = new Measuringresult(rapport2, 2, 1, 23, 18, false, 7, 23, 55, 9, 7.1, 15.7);

		measuringresultTest.saveMeasuringresult(mr1);
		measuringresultTest.saveMeasuringresult(mr2);

		List<Measuringresult> measuringresultlist = new ArrayList<>();
		measuringresultlist.add(mr1);
		measuringresultlist.add(mr2);

		return measuringresultlist;
	}

	private static void deleteAll() throws Exception {

		for (Measuringresult mr : measuringresultTest.findAllMeasuringresult()) {
			measuringresultTest.deleteMeasuringresult(mr);
		}
	}
}