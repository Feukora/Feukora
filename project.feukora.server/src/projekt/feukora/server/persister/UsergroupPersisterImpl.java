package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Usergroup;

/**
 * 
 * @author Tamara
 * @version 1.0
 */
public class UsergroupPersisterImpl implements UsergroupPersister {

	@Override
	public void saveUsergroup(Usergroup entity) throws Exception {
		new GenericPersisterImpl<Usergroup>(Usergroup.class).save(entity);
		
	}

	@Override
	public Usergroup updateUsergroup(Usergroup entity) throws Exception {
		return new GenericPersisterImpl<Usergroup>(Usergroup.class).update(entity);
	}

	@Override
	public void deleteUsergroup(Usergroup entity) throws Exception {
		new GenericPersisterImpl<Usergroup>(Usergroup.class).delete(entity);
		
	}

	@Override
	public void deleteUsergroupByUsergroupid(Integer usergroupid) throws Exception {
		new GenericPersisterImpl<Usergroup>(Usergroup.class).deleteById(usergroupid);
		
	}

	@Override
	public Usergroup findUsergroupByUsergroupid(Integer usergroupid) {
		return new GenericPersisterImpl<Usergroup>(Usergroup.class).findById(usergroupid);
	}

	@Override
	public List<Usergroup> findAllUsergroup() {
		return new GenericPersisterImpl<Usergroup>(Usergroup.class).findAll();
		
	}

	
}
