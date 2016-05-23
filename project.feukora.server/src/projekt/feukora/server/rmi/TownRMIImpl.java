package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import projekt.feukora.server.business.TownManager;
import projekt.feukora.server.business.TownManagerImpl;
import projekt.feukora.server.model.Town;

/**
 * This Class implements the methods of the interface TownRMI
 *  
 * @author Pascal
 * @version 1.0
 */
public class TownRMIImpl extends UnicastRemoteObject implements TownRMI {
	
	private static final long serialVersionUID = 1L;
	
	private TownManager townManager;

	public TownRMIImpl() throws RemoteException {
		townManager = new TownManagerImpl();
	}

	@Override
	public void saveTown(Town entity) throws RemoteException, Exception {
		townManager.saveTown(entity);	
	}

	@Override
	public Town updateTown(Town entity) throws RemoteException, Exception {
		return townManager.updateTown(entity);
	}

	@Override
	public void deleteTown(Town entity) throws RemoteException, Exception {
		townManager.deleteTown(entity);
	}

	@Override
	public List<Town> findAllTowns() throws RemoteException {
		return townManager.findAllTowns();
	}

	@Override
	public Town findTownByZip(Integer zip) throws RemoteException  {
		return townManager.findTownByZip(zip);
	}
}
