package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.CustomerfunctionManager;
import projekt.feukora.server.business.CustomerfunctionManagerImpl;
import projekt.feukora.server.model.Customerfunction;

/**
 *  This Class implements the methods of the interface CustomerfunctionRMI
 *  
 * @author Patrick
 * @version 1.0
 */
public class CustomerfunctionRMIImpl extends UnicastRemoteObject implements CustomerfunctionRMI {

	private static final long serialVersionUID = 1266986892096541978L;

	private CustomerfunctionManager customerfunctionManager;

	public CustomerfunctionRMIImpl() throws RemoteException {
		customerfunctionManager = new CustomerfunctionManagerImpl();
	}

	@Override
	public void saveCustomerfunction(Customerfunction entity) throws RemoteException, Exception {
		customerfunctionManager.saveCustomerfunction(entity);	
	}

	@Override
	public Customerfunction updateCustomerfunction(Customerfunction entity) throws RemoteException, Exception {
		return customerfunctionManager.updateCustomerfunction(entity);
	}

	@Override
	public void deleteCustomerfunction(Customerfunction entity) throws RemoteException, Exception {
		customerfunctionManager.deleteCustomerfunction(entity);
	}

	@Override
	public void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws RemoteException, Exception {
		customerfunctionManager.deleteCustomerfunctionByCustomerfunctionid(customerfunctionid);	
	}

	@Override
	public Customerfunction findCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws RemoteException {
		return customerfunctionManager.findCustomerfunctionByCustomerfunctionid(customerfunctionid);
	}

	@Override
	public List<Customerfunction> findAllCustomerfunction() throws RemoteException {
		return customerfunctionManager.findAllCustomerfunction();
	}

	@Override
	public Customerfunction findCustomerfunctionByName(String name) throws RemoteException {
		return customerfunctionManager.findCustomerfunctionByName(name);
	}
}
