package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.User;

/**
 * This class implements the interface UserPersister
 * 
 * @version 1.1
 * @author Tamara
 *
 */
public class UserPersisterImpl implements UserPersister{
	
	@Override
	public void saveUser(User entity) throws Exception {
		new GenericPersisterImpl<User>(User.class).save(entity);
	}

	@Override
	public User updateUser(User entity) throws Exception {
		return new GenericPersisterImpl<User>(User.class).update(entity);	
	}

	@Override
	public void deleteUser(User entity) throws Exception {
		new GenericPersisterImpl<User>(User.class).delete(entity);	
	}

	@Override
	public void deleteUserByUserid(Integer userid) throws Exception {
		new GenericPersisterImpl<User>(User.class).deleteById(userid);	
	}

	@Override
	public User findUserByUserid(Integer userid) {
		return new GenericPersisterImpl<User>(User.class).findById(userid);	
	}

	@Override
	public List<User> findAllUsers() {
		return new GenericPersisterImpl<User>(User.class).findAll();	
	}

	@Override
	public List<User> findUserByLastname(String lastname) {
		
		EntityManager em = JpaUtil.createEntityManager();
		TypedQuery<User> tQuery = em.createNamedQuery("User.findByLastname",
				User.class);

		tQuery.setParameter("lastname", lastname);

		List<User> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<User>();
	}

	@Override
	public List<User> findUserByFirstname(String firstname) {
		
		EntityManager em = JpaUtil.createEntityManager();
		TypedQuery<User> tQuery = em.createNamedQuery("User.findByFirstname",
				User.class);

		tQuery.setParameter("firstname", firstname);

		List<User> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<User>();
	}

	@Override
	public List<User> findUserByLastnameAndFirstname(String lastname, String firstname) {
		
		EntityManager em = JpaUtil.createEntityManager();
		TypedQuery<User> tQuery = em.createNamedQuery(
				"User.findByLastnameAndFirstname", User.class);

		tQuery.setParameter("lastname", lastname);
		tQuery.setParameter("firstname", firstname);

		List<User> userlist = tQuery.getResultList();

		em.close();

		return userlist != null ? userlist : new ArrayList<User>();
	}

	@Override
	public User findUserByUsername(String username) {
		
		EntityManager em = JpaUtil.createEntityManager();
		TypedQuery<User> tQuery = em.createNamedQuery(
				"User.findByUsername", User.class);

		tQuery.setParameter("username", username);

		User user = tQuery.getSingleResult();

		em.close();

		return user;
	}
}
