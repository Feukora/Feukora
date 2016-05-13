package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.business.CustomerManager;
import projekt.feukora.server.business.CustomerManagerImpl;
import projekt.feukora.server.business.HeaterManager;
import projekt.feukora.server.business.HeaterManagerImpl;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.persister.GenericPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

/**
 *  This Class implements the methods of the interface HeaterRMI
 * @author Patrick Pereira
 * @version 1.0
 */

public class HeaterRMIImpl extends UnicastRemoteObject implements HeaterRMI {

	private static final long serialVersionUID = -2323293563629986879L;
	
	private HeaterManager heaterManager;

	public HeaterRMIImpl() throws RemoteException {
		heaterManager = new HeaterManagerImpl();
	}

	
	@Override
	public void saveHeater(Heater entity) throws RemoteException, Exception {
		heaterManager.saveHeater(entity);
		
	}

	@Override
	public Heater updateHeater(Heater entity) throws RemoteException, Exception {
		return heaterManager.updateHeater(entity);
	}

	@Override
	public void deleteHeater(Heater entity) throws RemoteException, Exception {
		heaterManager.deleteHeater(entity);
		
	}

	@Override
	public void deleteHeaterByHeaterid(Integer heaterid) throws RemoteException, Exception {
		heaterManager.deleteHeaterByHeaterid(heaterid);	
		
	}

	@Override
	public Heater findHeaterByheaterid(Integer heaterid) throws RemoteException {
		return heaterManager.findHeaterByHeaterid(heaterid);
	}

	@Override
	public List<Heater> findAllHeaters() throws RemoteException {
		return heaterManager.findAllHeaters();
	}

	@Override
	public List<Heater> findHeaterByName(String name) throws RemoteException {
		return heaterManager.findHeaterByName(name);
	} 


}
