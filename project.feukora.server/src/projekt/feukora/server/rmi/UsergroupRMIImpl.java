package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import projekt.feukora.server.business.UsergroupManager;
import projekt.feukora.server.business.UsergroupManagerImpl;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Usergroup;


/**
 * This Class implements the methodes of the interface UsergroupRMI
 * 
 * @author Tamara
 * @version 1.0
 */
public class UsergroupRMIImpl extends UnicastRemoteObject implements UsergroupRMI{

	private static final long serialVersionUID = -371551722376955090L;
private UsergroupManager usergroupManager;
	
	public UsergroupRMIImpl() throws RemoteException {
		usergroupManager = new UsergroupManagerImpl();
	}

	@Override
	public void saveUsergroup(Usergroup entity) throws RemoteException, Exception {
		usergroupManager.saveUsergroup(entity);
		
	}

	@Override
	public Usergroup updateUsergroup(Usergroup entity) throws RemoteException, Exception {
		return usergroupManager.updateFuel(entity);
	}

	@Override
	public void deleteUsergroup(Usergroup entity) throws RemoteException, Exception {
		usergroupManager.deleteUsergroup(entity);
		
	}

	@Override
	public void deleteUsergroupByUsergroupid(Integer usergroupid) throws RemoteException, Exception {
		usergroupManager.deleteUsergroupByUsergroupid(usergroupid);
		
	}

	@Override
	public Usergroup findUsergroupByUsergroupid(Integer usergroupid) throws RemoteException {
		return usergroupManager.findUsergroupByUsergroupid(usergroupid);
	}

	@Override
	public List<Usergroup> findAllUsergroup() throws RemoteException {
		return usergroupManager.findAllUsergroup();
	}

	@Override
	public Usergroup findUsergroupByName(String name) throws RemoteException, Exception {
		return usergroupManager.findFuelByName(name);
	}
}
