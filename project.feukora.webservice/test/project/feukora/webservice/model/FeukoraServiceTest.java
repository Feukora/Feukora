package project.feukora.webservice.model;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Rapport;

public class FeukoraServiceTest {

	private FeukoraService feukoraService = new FeukoraService();

	@BeforeClass
	public static void setUp()
	{

	}

	@Test
	public void testLogin() {
		try {
			assertTrue(feukoraService.login("admin", "admin"));
		} catch (RemoteException e) {
			fail( "Fehler beim Login: " + e );
		}
	}

	@Test
	public void testCreateRapport()
	{
		try {
			Rapport rapport = feukoraService.createRapport();
			assertTrue( rapport.getMeasuringdate() != null );
		} catch (RemoteException e) {
			fail( "Fehler beim Rapport: " + e );
		}
	}

	@Test
	public void testGetCustomers()
	{
		try {
			List<Customer> customers = feukoraService.getCustomers();
			assertTrue( customers != null );
			assertTrue( customers.size() == 2 );
		} catch (RemoteException e) {
			fail( "Fehler beim den Kunden: " + e );
		}
	}

}
