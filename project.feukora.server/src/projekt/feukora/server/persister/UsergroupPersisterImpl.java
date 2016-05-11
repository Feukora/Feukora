package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Usergroup;

/**
 * This class implements the interface UsergroupPersister
 * 
 * @version 1.1
 * @author Tamara
 *
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

	@Override
	public Usergroup findUsergroupByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Usergroup> tQuery = em.createNamedQuery("Usergroup.findByName",
				Usergroup.class);

		tQuery.setParameter("name", name);

		Usergroup usergroup = new Usergroup();

		em.close();

		return usergroup;
	}	
}
