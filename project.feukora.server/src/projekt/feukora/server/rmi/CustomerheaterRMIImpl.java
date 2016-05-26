package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.CustomerheaterManager;
import projekt.feukora.server.business.CustomerheaterManagerImpl;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;

/**
 * This Class implements the methods of the interface CustomerheaterRMI
 * 
 * @author Pascal
 * @version 1.1
 */
public class CustomerheaterRMIImpl extends UnicastRemoteObject implements CustomerheaterRMI {

	private static final long serialVersionUID = 7732803052258894910L;

	private CustomerheaterManager customerheaterManager;

	public CustomerheaterRMIImpl() throws RemoteException {
		customerheaterManager = new CustomerheaterManagerImpl();
	}

	@Override
	public void saveCustomerheater(Customerheater entity) throws RemoteException, Exception {
		customerheaterManager.saveCustomerheater(entity);	
	}

	@Override
	public Customerheater updateCustomerheater(Customerheater entity) throws RemoteException, Exception {
		return customerheaterManager.updateCustomerheater(entity);
	}

	@Override
	public void deleteCustomerheater(Customerheater entity) throws RemoteException, Exception {
		customerheaterManager.deleteCustomerheater(entity);
	}

	@Override
	public void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws RemoteException, Exception {
		customerheaterManager.deleteCustomerheaterByCustomerheaterid(customerheaterid);	
	}

	@Override
	public Customerheater findCustomerheaterByCustomerheaterid(Integer customerheaterid) throws RemoteException {
		return customerheaterManager.findCustomerheaterByCustomerheaterid(customerheaterid);
	}

	@Override
	public List<Customerheater> findAllCustomerheaters() throws RemoteException {
		return customerheaterManager.findAllCustomerheaters();
	}

	@Override
	public List<Customerheater> findCustomerheaterByPerformance(Integer performance) throws RemoteException {
		return customerheaterManager.findCustomerheaterByPerformance(performance);
	}

	@Override
	public List<Customerheater> findCustomerHeaterForCustomer(Customer customer) throws RemoteException {
		return customerheaterManager.findCustomerHeaterForCustomer(customer);
	} 
}
