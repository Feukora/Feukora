package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.CustomerManager;
import projekt.feukora.server.business.CustomerManagerImpl;
import projekt.feukora.server.business.FacilitymanagerManager;
import projekt.feukora.server.business.FacilitymanagerManagerImpl;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Facilitymanager;

/**
 * This Class implements the methods of the interface FacilitymanagerRMI
 *  
 * @author Pascal
 * @version 1.0
 */

public class FacilitymanagerRMIImpl extends UnicastRemoteObject implements FacilitymanagerRMI {

	private static final long serialVersionUID = -8209421018993159995L;
	
	private FacilitymanagerManager facilitymanagerManager;

	public FacilitymanagerRMIImpl() throws RemoteException {
		facilitymanagerManager = new FacilitymanagerManagerImpl();
	}

	@Override
	public void saveFacilitymanager(Facilitymanager entity) throws RemoteException, Exception {
		facilitymanagerManager.saveFacilitymanager(entity);	
	}

	@Override
	public Facilitymanager updateFacilitymanager(Facilitymanager entity) throws RemoteException, Exception {
		return facilitymanagerManager.updateFacilitymanager(entity);
	}

	@Override
	public void deleteFacilitymanager(Facilitymanager entity) throws RemoteException, Exception {
		facilitymanagerManager.deleteFacilitymanager(entity);
	}

	@Override
	public void deleteFacilitymanagerByFacilitymanagerid(Integer facilitymanagerid) throws RemoteException, Exception {
		facilitymanagerManager.deleteFacilitymanagerByFacilitymanagerid(facilitymanagerid);	
	}

	@Override
	public Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer facilitymanagerid) throws RemoteException {
		return facilitymanagerManager.findFacilitymanagerByFacilitymanagerid(facilitymanagerid);
	}

	@Override
	public List<Facilitymanager> findAllFacilitymanagers() throws RemoteException {
		return facilitymanagerManager.findAllFacilitymanagers();
	}

	@Override
	public List<Facilitymanager> findFacilitymanagerByLastname(String lastname) throws RemoteException  {
		return facilitymanagerManager.findFacilitymanagerByLastname(lastname);
	}
	
	}