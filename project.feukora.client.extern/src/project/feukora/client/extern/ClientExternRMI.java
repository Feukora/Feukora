package project.feukora.client.extern;


import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

import project.feukora.webservice.model.FeukoraServiceService;
import project.feukora.webservice.model.IFeukoraService;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.User;

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
