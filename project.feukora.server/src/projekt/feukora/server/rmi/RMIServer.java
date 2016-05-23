package projekt.feukora.server.rmi;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.eclipse.persistence.sessions.server.Server;
import projekt.feukora.server.persister.TownData;
import test.project.feukora.server.persister.TestdataDB;
import test.project.feukora.server.persister.TestdataMeasuringresult;


/**
 * This Class starts the RMI-Server on this machine, also it instances Remote Objects, binds and also unbinds them.
 * 
 * @author Sandro 
 * @version 1.2
 */
public class RMIServer {

	private static final Logger logger = Logger
			.getLogger(RMIServer.class);
	
	public static void main(String[] args) {
		
		
		/* Konfigurationsdaten einlesen */
		Properties props = new Properties();
		InputStream is = Server.class.getClassLoader().getResourceAsStream("rmiserver.properties");
		try {
			props.load(is);
		} catch (Exception e) {
			logger.error("Konfigurationsdaten konnten nicht eingelesen werden\'",
					e);
		}
		int port = Integer.parseInt(props.getProperty("server_port"));
		String hostIP = props.getProperty("server_ip");
		

		String customerRMIName = "customerRMI";
		String companyRMIName = "companyRMI";
		String appointmentRMIName = "appointmentRMI";
		String blowerRMIName = "blowerRMI";
		String heaterRMIName = "heaterRMI";
		String measuringresultRMIName = "measuringresultRMI";
		String rapportRMIName = "rapportRMI";
		String userRMIName = "userRMI";
		String townRMIName = "townRMI";
		String blowertypeRMIName = "blowertypeRMI";
		String controltypeRMIName = "controltypeRMI";
		String customerfunctionRMIName = "customerfunctionRMI";
		String customerheaterRMIName = "customerheaterRMI";
		String facilitymanagerRMIName = "facilitymanagerRMI";
		String fuelRMIName = "fuelRMI";
		String usergroupRMIName = "usergroupRMI";
		
		Registry registry = null;
		
		try{


			InetAddress.getLocalHost();

			
			System.setProperty("java.rmi.server.hostname", hostIP);

			registry = LocateRegistry.createRegistry(port, null, null);

			if (registry != null) {
				
				TownData.loadTownData("resources/ZIP.txt");
				TestdataDB.loadTestdata();
				// Entfernte Objekte erstellen
				CustomerRMI customerRMI = new CustomerRMIImpl();
				CompanyRMI companyRMI = new CompanyRMIImpl();
				AppointmentRMI appointmentRMI = new AppointmentRMIImpl();
				BlowerRMI blowerRMI = new BlowerRMIImpl();
				HeaterRMI heaterRMI = new HeaterRMIImpl();
				MeasuringresultRMI measuringresultRMI = new MeasuringresultRMIImpl();
				RapportRMI rapportRMI = new RapportRMIImpl();
				UserRMI userRMI = new UserRMIImpl();
				TownRMI townRMI = new TownRMIImpl();
				BlowertypeRMI blowertypeRMI = new BlowertypeRMIImpl();
				ControltypeRMI controltypeRMI = new ControltypeRMIImpl();
				CustomerfunctionRMI customerfunctionRMI = new CustomerfunctionRMIImpl();
				CustomerheaterRMI customerheaterRMI = new CustomerheaterRMIImpl();
				FacilitymanagerRMI facilitymanagerRMI = new FacilitymanagerRMIImpl();
				FuelRMI fuelRMI = new FuelRMIImpl();
				UsergroupRMI usergroupRMI = new UsergroupRMIImpl();
				

				registry.rebind(customerRMIName, customerRMI);
				registry.rebind(companyRMIName, companyRMI);
				registry.rebind(appointmentRMIName, appointmentRMI);
				registry.rebind(blowerRMIName, blowerRMI);
				registry.rebind(heaterRMIName, heaterRMI);
				registry.rebind(measuringresultRMIName, measuringresultRMI);
				registry.rebind(rapportRMIName, rapportRMI);
				registry.rebind(userRMIName, userRMI);
				registry.rebind(townRMIName, townRMI);
				registry.rebind(blowertypeRMIName, blowertypeRMI);
				registry.rebind(controltypeRMIName, controltypeRMI);
				registry.rebind(customerfunctionRMIName, customerfunctionRMI);
				registry.rebind(customerheaterRMIName, customerheaterRMI);
				registry.rebind(facilitymanagerRMIName, facilitymanagerRMI);
				registry.rebind(fuelRMIName, fuelRMI);
				registry.rebind(usergroupRMIName, usergroupRMI);
				
			
				String msg = "RMI-Server ist bereit fuer Client-Anfragen.\n\n"
						+ "Server herunterfahren?";
				JOptionPane.showMessageDialog(null, msg, "ServerName ["
						+ hostIP + ":" + port + "]",
						JOptionPane.QUESTION_MESSAGE);

				registry.unbind(customerRMIName);
				registry.unbind(companyRMIName);
				registry.unbind(appointmentRMIName);
				registry.unbind(blowerRMIName);
				registry.unbind(heaterRMIName);
				registry.unbind(measuringresultRMIName);
				registry.unbind(rapportRMIName);
				registry.unbind(userRMIName);
				registry.unbind(townRMIName);
				registry.unbind(blowertypeRMIName);
				registry.unbind(controltypeRMIName);
				registry.unbind(customerfunctionRMIName);
				registry.unbind(customerheaterRMIName);
				registry.unbind(facilitymanagerRMIName);
				registry.unbind(fuelRMIName);
				registry.unbind(usergroupRMIName);
				
				

				System.out.println("RMI Server wird heruntergefahren!\n");

				System.exit(0);
			} else {
				System.out
						.println("Entferntes Objekt konnte nicht exportiert werden!");
			}
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}
}
