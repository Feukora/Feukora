package projekt.feukora.server.rmi;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.eclipse.persistence.sessions.server.Server;

/**
 * This Class starts the RMI-Server on this machine, also it instances Remote Objects, 
 * binds and also unbinds them
 * 
 * @version 1.0
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

		Registry registry = null;

		try {

			if (args.length == 1) {
				// Port auslesen
				try {
					port = Integer.parseInt(args[0]);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					return;
				}
			} else if (args.length == 2) {

				// hostIp auslesen
				hostIP = args[0];

				// Port auslesen
				try {
					port = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					return;
				}
			}

			InetAddress.getLocalHost();

			/*
			 * Die NIC-IP nach 'aussen' kommunizieren (falls die Namensaufl�sung
			 * probleme bereiten sollte)
			 */
			System.setProperty("java.rmi.server.hostname", hostIP);

			// Registry starten
			registry = LocateRegistry.createRegistry(port, null, null);

			if (registry != null) {

				// Entfernte Objekte erstellen
				CustomerRMI customerRMI = new CustomerRMIImpl();


				registry.rebind(customerRMIName, customerRMI);
				

				String msg = "RMI-Server ist bereit fuer Client-Anfragen.\n\n"
						+ "Server herunterfahren?";
				JOptionPane.showMessageDialog(null, msg, "ServerName ["
						+ hostIP + ":" + port + "]",
						JOptionPane.QUESTION_MESSAGE);

				registry.unbind(customerRMIName);

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
