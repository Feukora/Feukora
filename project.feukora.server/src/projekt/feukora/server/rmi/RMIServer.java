package projekt.feukora.server.rmi;



import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.eclipse.persistence.sessions.server.Server;

import projekt.feukora.server.persister.TownData;
import test.project.feukora.server.persister.Testdata;
import test.project.feukora.server.persister.TestdataAppointment;
import test.project.feukora.server.persister.TestdataMeasuringresult;
import test.project.feukora.server.persister.TestdataUsers;

/**
 * This Class starts the RMI-Server on this machine, also it instances Remote Objects, 
 * binds and also unbinds them
 * 
 * @version 1.1
 * @author Sandro Fasser
 *
 */


public class RMIServer {

	
	public static void main(String[] args) {
		
		
		/* Konfigurationsdaten einlesen */
		Properties props = new Properties();
		InputStream is = Server.class.getClassLoader().getResourceAsStream("rmiserver.properties");
		try {
			props.load(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		Registry registry = null;
		
		try{


			InetAddress.getLocalHost();

			
			System.setProperty("java.rmi.server.hostname", hostIP);

			registry = LocateRegistry.createRegistry(port, null, null);

			if (registry != null) {
				
				TownData.loadTownData("resources/ZIP.txt");
				TestdataMeasuringresult.loadTestdata();
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
				

				registry.rebind(customerRMIName, customerRMI);
				registry.rebind(companyRMIName, companyRMI);
				registry.rebind(appointmentRMIName, appointmentRMI);
				registry.rebind(blowerRMIName, blowerRMI);
				registry.rebind(heaterRMIName, heaterRMI);
				registry.rebind(measuringresultRMIName, measuringresultRMI);
				registry.rebind(rapportRMIName, rapportRMI);
				registry.rebind(userRMIName, userRMI);
				registry.rebind(townRMIName, townRMI);
				
			
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
				
				

				System.out.println("RMI Server wird heruntergefahren!\n");

				System.exit(0);
			} else {
				System.out
						.println("Entferntes Objekt konnte nicht exportiert werden!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
