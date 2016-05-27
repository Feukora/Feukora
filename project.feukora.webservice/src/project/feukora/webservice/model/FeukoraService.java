package project.feukora.webservice.model;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.User;
import projekt.feukora.server.rmi.CustomerRMI;
import projekt.feukora.server.rmi.RapportRMI;
import projekt.feukora.server.rmi.UserRMI;

@WebService(endpointInterface = "project.feukora.webservice.model.IFeukoraService")
public class FeukoraService implements IFeukoraService {

	private static final Logger logger = Logger.getLogger(FeukoraService.class);

	private UserRMI userManager;
	private CustomerRMI customerManager;
	private RapportRMI rapportManager;
	public static User currLoggedInUser;

	private User loggedInUser;

	public FeukoraService()
	{
		String userRMIName = "userRMI";
		String customerRMIName = "customerRMI";
		String rapportRMIName = "rapportRMI";

		try {

			/* Properties laden */
			Properties props = new Properties();

			InputStream is = FeukoraService.class.getClassLoader().getResourceAsStream("ws.properties");

			props.load(is);

			String hostIp = props.getProperty("rmi.host_ip");
			int rmiPort = Integer.parseInt(props.getProperty("rmi.port"));

			// URL
			String urlUserRMI = "rmi://" + hostIp + ":" + rmiPort + "/" + userRMIName;
			String urlCustomerRMI = "rmi://" + hostIp + ":" + rmiPort + "/" + customerRMIName;
			String urlRapportRMI = "rmi://" + hostIp + ":" + rmiPort + "/" + rapportRMIName;

			/* Lookup */
			userManager = (UserRMI) Naming.lookup(urlUserRMI);
			customerManager = (CustomerRMI) Naming.lookup(urlCustomerRMI);
			rapportManager = (RapportRMI) Naming.lookup(urlRapportRMI);

		} catch (NotBoundException nbe) {
			logger.error("Es konnte auf die Ressource einer URL nicht zugegriffen werden", nbe);
		} catch (IOException ioe){
			logger.error("Fehler beim Einlesen einer Datei", ioe);
		}
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		loggedInUser = userManager.findUsersByUsername(username);
		currLoggedInUser = loggedInUser.login(password);
		return currLoggedInUser != null;
	}

	@Override
	public List<Customer> getCustomers() throws RemoteException {
		return customerManager.findAllCustomers();
	}


	@Override
	public Rapport createRapport() throws RemoteException {
		return new Rapport( loggedInUser );
	}

	@Override
	public void saveRapport(Rapport rapport) throws RemoteException {
		try {
			rapportManager.saveRapport(rapport);
		} catch (Exception e) {
			logger.error("Fehler beim speichern des Rapportes", e);
		}

	}

}
