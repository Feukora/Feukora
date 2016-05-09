package projekt.feukora.server.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIServer {

	public static void main(String[] args) {
		
		int port = 60140;
		String hostIP = "1"
		
		try {
			// Entferntes Objekt erzeugen
			Adder adder = new AdderImpl();
			// Entferntes Objekt beim Namensdienst registrieren
			Naming.rebind("AdderObjekt", adder);
			// Ausgabe – Server bereit
			System.out.println("Server ready");
			} catch (RemoteException re){
			re.printStackTrace();
			} catch (MalformedURLException me){
			me.printStackTrace();
			}

	}

}
