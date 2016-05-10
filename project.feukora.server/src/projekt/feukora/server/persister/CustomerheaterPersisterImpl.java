package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;

public class CustomerheaterPersisterImpl implements CustomerheaterPersister {

	@Override
	public void saveCustomer(Customerheater entity) throws Exception {
		new GenericPersisterImpl<Customerheater>(Customerheater.class).save(entity);	
	}

	@Override
	public Customerheater updateCustomer(Customerheater entity) throws Exception {
		return new GenericPersisterImpl<Customerheater>(Customerheater.class).update(entity);
	}

	@Override
	public void deleteCustomerheater(Customerheater entity) throws Exception {
		new GenericPersisterImpl<Customerheater>(Customerheater.class).delete(entity);
		
	}

	@Override
	public void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws Exception {
		new GenericPersisterImpl<Customerheater>(Customerheater.class).deleteById(customerheaterid);
		
	}

	@Override
	public Customerheater findCustomerheaterByCustomerheaterid(Integer customerheaterid) {
		return new GenericPersisterImpl<Customerheater>(Customerheater.class).findById(customerheaterid);
	}

	@Override
	public List<Customerheater> findAllCustomerheaters() {
		return new GenericPersisterImpl<Customerheater>(Customerheater.class).findAll();
	}

}