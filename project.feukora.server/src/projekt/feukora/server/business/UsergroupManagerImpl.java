package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

/**
 * This Class implements the methodes of the interface UsergroupManager.
 * 
 * @author Tamara
 * @version 1.0
 *
 */
public class UsergroupManagerImpl implements UsergroupManager {

	UsergroupPersister usergroupPersister  = new UsergroupPersisterImpl();

	@Override
	public void saveUsergroup(Usergroup entity) throws Exception {
		usergroupPersister.saveUsergroup(entity);
	}

	@Override
	public Usergroup updateFuel(Usergroup entity) throws Exception {
		return usergroupPersister.updateUsergroup(entity);
	}

	@Override
	public void deleteUsergroup(Usergroup entity) throws Exception {
		usergroupPersister.deleteUsergroup(entity);
	}

	@Override
	public void deleteUsergroupByUsergroupid(Integer usergroupid) throws Exception {
		usergroupPersister.deleteUsergroupByUsergroupid(usergroupid);
	}

	@Override
	public Usergroup findUsergroupByUsergroupid(Integer usergroupid) {
		return usergroupPersister.findUsergroupByUsergroupid(usergroupid);
	}

	@Override
	public List<Usergroup> findAllUsergroup() {
		return usergroupPersister.findAllUsergroup();
	}

	@Override
	public Usergroup findFuelByName(String name) {
		return usergroupPersister.findUsergroupByName(name);
	}
}