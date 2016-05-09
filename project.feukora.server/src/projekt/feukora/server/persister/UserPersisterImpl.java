package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Users;

/**
 * 
 * @author Tamara
 * version 1.0
 */
public class UserPersisterImpl implements UserPersister{

	@Override
	public void saveUser(Users entity) throws Exception {
		new GenericPersisterImpl<Users>(Users.class).save(entity);
		
	}

	@Override
	public Users updateUser(Users entity) throws Exception {
		new GenericPersisterImpl<Users>(Users.class).update(entity);
		return null;
	}

	@Override
	public void deleteUser(Users entity) throws Exception {
		new GenericPersisterImpl<Users>(Users.class).delete(entity);
		
	}

	@Override
	public void deleteUserByUserid(Integer userid) throws Exception {
		new GenericPersisterImpl<Users>(Users.class).deleteById(userid);
		
	}

	@Override
	public Users findUserByUserid(Integer userid) {
		new GenericPersisterImpl<Users>(Users.class).findById(userid);
		return null;
	}

	@Override
	public List<Users> findAllUsers() {
		new GenericPersisterImpl<Users>(Users.class).findAll();
		return null;
	}

	@Override
	public List<Users> findUserByLastname(String lastname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Users> tQuery = em.createNamedQuery("Users.findByLastname",
				Users.class);

		tQuery.setParameter("lastname", lastname);

		List<Users> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<Users>();
	}

	@Override
	public List<Users> findUserByFirstname(String firstname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Users> tQuery = em.createNamedQuery("Users.findByFirstname",
				Users.class);

		tQuery.setParameter("firstname", firstname);

		List<Users> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<Users>();
	}

	@Override
	public List<Users> findUserByLastnameAndFirstname(String lastname, String firstname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Users> tQuery = em.createNamedQuery(
				"Users.findByLastnameAndFirstname", Users.class);

		tQuery.setParameter("lastname", lastname);
		tQuery.setParameter("firstname", firstname);

		List<Users> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<Users>();
	}

	@Override
	public List<Users> findUserByUsername(String username) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Users> tQuery = em.createNamedQuery(
				"Users.findByUsername", Users.class);

		tQuery.setParameter("username", username);

		List<Users> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<Users>();
	}

	

	
	

}
