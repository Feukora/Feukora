package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
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
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

public class MeasuringresultPersisterTest {


	private static MeasuringresultPersisterImpl measuringresultTest = new MeasuringresultPersisterImpl();

	@Before
	public void setUp() throws Exception {
		MeasuringresultPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Measuringresult> measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		RapportPersister rp = new RapportPersisterImpl();
		Rapport id = rp.findRapportByRapportid(0);

		Measuringresult mr = new Measuringresult();

		measuringresultTest.saveMeasuringresult(mr);

		measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 3);

	}
	
	// Nach Absprache mit Team, lassen wir die testUpdate() Methode weg
	/*@Test
	public void testUpdate() throws Exception {

		List<Measuringresult> measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 2);
		
		// Die nächsten vier Zeilen braucht es nur, wenn ihr im Konstruktor Objekte von anderen Tabellen habt
		
		//TownPersister tp = new TownPersisterImpl();
		//Town plz = tp.findbyTownzip(6000);
		
		//CustomerfunctionPersister cf = new CustomerfunctionPersisterImpl();
		//Customerfunction function = cf.findCustomerfunctionByCustomerfunctionid(1);
		

		Measuringresult mr = new Measuringresult();

		measuringresultTest.saveMeasuringresult(mr);

		measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 3);

		mr.setCarbonmonoxide(3);

		measuringresultTest.updateMeasuringresult(mr);

		//Measuringresult measuringresultFromDB = measuringresultTest.findMeasuringresultByMeasuringresultid("Irrub",
		//		"Pascal").get(0);
		Measuringresult measuringresultFromDB = measuringresultTest.findMeasuringresultByMeasuringresultid(1).get(0);
		assertNotNull(measuringresultFromDB);

	}
	*/

	@Test
	public void testDelete() throws Exception {

		List<Measuringresult> measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 2);

		measuringresultTest.deleteMeasuringresult(measuringresultlist.get(0));

		measuringresultlist = measuringresultTest.findAllMeasuringresult();
		assertTrue(measuringresultlist.size() == 1);

	}
	//Ab hier müsst ihr das testen, was ihr in den NamedQueries hingeschrieben habt
	@Test
	public void testFindByMeasuringresultid() {

		//String lastname = "Fasser";
		int measuringresultid = 1;

		assertTrue(measuringresultTest.findMeasuringresultByMeasuringresultid(measuringresultid).equals(1));
	}

	//Das brauchen wieder alle
	public static List<Measuringresult> init() throws Exception {

		MeasuringresultPersisterTest.deleteAll();
		
		RapportPersister rp = new RapportPersisterImpl();
		Rapport rapport1 = rp.findRapportByRapportid(0);
		Rapport rapport2 = rp.findRapportByRapportid(1);

		Measuringresult mr1 = new Measuringresult();
		Measuringresult mr2 = new Measuringresult();

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