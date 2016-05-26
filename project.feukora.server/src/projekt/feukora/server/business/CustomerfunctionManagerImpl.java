package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.persister.CustomerfunctionPersister;
import projekt.feukora.server.persister.CustomerfunctionPersisterImpl;

/**
 * This Class implements the methods of the interface CustomerfunctionManager.
 * 
 * @author Patrick
 * @version 1.4
 * 
 */
public class CustomerfunctionManagerImpl implements CustomerfunctionManager {

	private CustomerfunctionPersister customerfunctionPersister = new CustomerfunctionPersisterImpl();

	@Override
	public void saveCustomerfunction(Customerfunction entity) throws Exception {
		customerfunctionPersister.saveCustomerfunction(entity);
	}

	@Override
	public Customerfunction updateCustomerfunction(Customerfunction entity) throws Exception {
		return customerfunctionPersister.updateCustomerfunction(entity);
	}

	@Override
	public void deleteCustomerfunction(Customerfunction entity) throws Exception {
		customerfunctionPersister.deleteCustomerfunction(entity);
	}

	@Override
	public void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws Exception {
		customerfunctionPersister.deleteCustomerfunctionByCustomerfunctionid(customerfunctionid);
	}

	@Override
	public Customerfunction findCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) {
		return customerfunctionPersister.findCustomerfunctionByCustomerfunctionid(customerfunctionid);
	}

	@Override
	public List<Customerfunction> findAllCustomerfunction() {
		return customerfunctionPersister.findAllCustomerfunction();
	}

	@Override
	public Customerfunction findCustomerfunctionByName(String name) {
		return customerfunctionPersister.findCustomerfunctionByName(name);
	}
}