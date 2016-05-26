package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.User;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;

/**
 * This Class implement the methods of the interface UserManager.
 * 
 * @author Tamara
 * @version 1.3
 *
 */
public class UserManagerImpl implements UserManager {

	private UserPersister userPersister = new UserPersisterImpl();
	
	@Override
	public void saveUsers(User entity) throws Exception {
			userPersister.saveUser(entity);
	}

	@Override
	public User updateUsers(User entity) throws Exception {
		return userPersister.updateUser(entity);
	}

	@Override
	public void deleteUsers(User entity) throws Exception {
		userPersister.deleteUser(entity);
	}

	@Override
	public void deleteUsersByUsersid(Integer userid) throws Exception {
		userPersister.deleteUserByUserid(userid);
	}

	@Override
	public User findUsersByUsersid(Integer userid) {
		return  userPersister.findUserByUserid(userid);
	}

	@Override
	public List<User> findAllUsers() {
		return userPersister.findAllUsers();
	}

	@Override
	public List<User> findUsersByLastname(String lastname) {
		return userPersister.findUserByLastname(lastname);
	}

	@Override
	public List<User> findUsersByFirstname(String firstname) {
		return userPersister.findUserByFirstname(firstname);
	}

	@Override
	public List<User> findUsersByLastnameAndFirstname(String lastname, String firstname) {
		return userPersister.findUserByLastnameAndFirstname(lastname, firstname);
	}

	@Override
	public User findUserByUsername(String username) {
		return userPersister.findUserByUsername(username);
	}
	
	@Override
	public List<User> findUserByUsergroup(Usergroup usergroup) {
		return userPersister.findUserByUsergroup(usergroup);
	}
}
