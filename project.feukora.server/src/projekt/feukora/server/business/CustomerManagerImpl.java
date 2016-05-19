package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.persister.CustomerPersister;
import projekt.feukora.server.persister.CustomerPersisterImpl;

/**
 * This Class implements the methods of the interface CustomerManager.
 * 
 * @author Sandro Fasser
 * @version 1.1
 */

public class CustomerManagerImpl implements CustomerManager {
	
	private CustomerPersister customerPersister = new CustomerPersisterImpl();

	@Override
	public void saveCustomer(Customer entity) throws Exception {
//		if( entity.getCustomerid() == 0){
			customerPersister.saveCustomer(entity);
//		}else{
//			throw new Exception("Der Kunde (id = "+ entity.getCustomerid() + ") ist bereits vorhanden");
//		}
	}

	@Override
	public Customer updateCustomer(Customer entity) throws Exception {
			return customerPersister.updateCustomer(entity);	
	}
	
	
	@Override
	public void deleteCustomer(Customer entity) throws Exception {
		customerPersister.deleteCustomer(entity);
	}

	@Override
	public void deleteCustomerByCustomerid(Integer customerid) throws Exception {
		customerPersister.deleteCustomerByCustomerid(customerid);	
	}

	@Override
	public Customer findCustomerByCustomerid(Integer customerid) {
		return customerPersister.findCustomerByCustomerid(customerid);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerPersister.findAllCustomers();
	}

	@Override
	public List<Customer> findCustomerByLastname(String lastname) {
		return customerPersister.findCustomerByLastname(lastname);
	}

	@Override
	public List<Customer> findCustomerByFirstname(String firstname) {
		return customerPersister.findCustomerByFirstname(firstname);
	}

	@Override
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname) {
		return customerPersister.findCustomerByLastnameAndFirstname(lastname, firstname);
	}

	@Override
	public List<Customer> findCustomerByCompanyname(String companyname) {
		return customerPersister.findCustomerByCompanyname(companyname);
	}


}
