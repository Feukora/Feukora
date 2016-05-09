package projekt.feukora.server.rmi;

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
		props.load(is);
		int port = Integer.parseInt(props.getProperty("server_port"));
		String hostIP = props.getProperty("server_ip");
		

		String studentROName = "studentRO";
		String dozentROName = "dozentRO";
		String modulROName = "modulRO";

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
				StudentRO studentRO = new StudentROImpl();
				DozentRO dozentRO = new DozentROImpl();
				ModulRO modulRO = new ModulROImpl();

				registry.rebind(studentROName, studentRO);
				registry.rebind(dozentROName, dozentRO);
				registry.rebind(modulROName, modulRO);

				String msg = "RMI-Server ist bereit fuer Client-Anfragen.\n\n"
						+ "Server herunterfahren?";
				JOptionPane.showMessageDialog(null, msg, "ServerName ["
						+ hostIP + ":" + port + "]",
						JOptionPane.QUESTION_MESSAGE);

				registry.unbind(studentROName);
				registry.unbind(dozentROName);
				registry.unbind(modulROName);

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
