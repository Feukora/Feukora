package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Customer;

/**
 * This class implements the interface CustomerPersister
 * 
 * @version 1.1
 * @author Pascal
 *
 */

public class CustomerPersisterImpl implements CustomerPersister {

	@Override
	public void saveCustomer(Customer entity) throws Exception {
		new GenericPersisterImpl<Customer>(Customer.class).save(entity);	
	}

	@Override
	public Customer updateCustomer(Customer entity) throws Exception {
		return new GenericPersisterImpl<Customer>(Customer.class).update(entity);
	}

	@Override
	public void deleteCustomer(Customer entity) throws Exception {
		new GenericPersisterImpl<Customer>(Customer.class).delete(entity);
	}

	@Override
	public void deleteCustomerByCustomerid(Integer customerid) throws Exception {
		new GenericPersisterImpl<Customer>(Customer.class).deleteById(customerid);	
	}

	@Override
	public Customer findCustomerByCustomerid(Integer customerid) {
		return new GenericPersisterImpl<Customer>(Customer.class).findById(customerid);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return new GenericPersisterImpl<Customer>(Customer.class).findAll();
	}

	@Override
	public List<Customer> findCustomerByLastname(String lastname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customer> tQuery = em.createNamedQuery("Customer.findByLastname",
				Customer.class);

		tQuery.setParameter("lastname", lastname);

		List<Customer> customerlist = tQuery.getResultList();

		em.close();

		return customerlist != null ? customerlist : new ArrayList<Customer>();
	}

	@Override
	public List<Customer> findCustomerByFirstname(String firstname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customer> tQuery = em.createNamedQuery("Customer.findByFirstname",
				Customer.class);

		tQuery.setParameter("firstname", firstname);

		List<Customer> customerlist = tQuery.getResultList();

		em.close();

		return customerlist != null ? customerlist : new ArrayList<Customer>();
	}

	@Override
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customer> tQuery = em.createNamedQuery(
				"Customer.findByLastnameAndFirstname", Customer.class);

		tQuery.setParameter("lastname", lastname);
		tQuery.setParameter("firstname", firstname);

		List<Customer> customerlist = tQuery.getResultList();

		em.close();

		return customerlist != null ? customerlist : new ArrayList<Customer>();
	}

	@Override
	public List<Customer> findCustomerByCompanyname(String companyname) {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customer> tQuery = em.createNamedQuery(
				"Customer.findByCompanyname", Customer.class);

		tQuery.setParameter("companyname", companyname);

		List<Customer> customerlist = tQuery.getResultList();

		em.close();

		return customerlist != null ? customerlist : new ArrayList<Customer>();
	} 
}
