package project.feukora.client.extern;


import org.apache.log4j.Logger;

import project.feukora.webservice.model.FeukoraServiceService;
import project.feukora.webservice.model.IFeukoraService;

public class ClientExternRMI {
	
	private static final Logger logger = Logger
			.getLogger(ClientExternRMI.class);

	public static void main(String[] args) {
		System.out
		.println("======================================================================");
		try {
			// Init Application over RMI
			FeukoraServiceService service = new FeukoraServiceService();
			IFeukoraService feukora = service.getFeukoraServicePort();
			
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}

	/**
	 * Instantiates a new modulverwaltung client rmi.
	 *
	 * @throws Exception
	 */
	public ClientExternRMI() throws Exception {



	}
	
	
}
