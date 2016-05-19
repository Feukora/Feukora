package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.persister.UsergroupPersister;
import projekt.feukora.server.persister.UsergroupPersisterImpl;

public class UsergroupManagerImpl implements UsergroupManager{
	
	UsergroupPersister usergroupPersister  = new UsergroupPersisterImpl();
	
	@Override
	public void saveUsergroup(Usergroup entity) throws Exception {
		if((Integer)entity.getUsergroupid()== 0){
			usergroupPersister.saveUsergroup(entity);
		}else{
			throw new Exception ("Die Usergroup(id =" + entity.getUsergroupid() + ") ist bereits vorhanden");
		}
		
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
