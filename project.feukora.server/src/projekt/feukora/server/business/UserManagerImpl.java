package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Users;
import projekt.feukora.server.persister.UserPersister;
import projekt.feukora.server.persister.UserPersisterImpl;

public class UserManagerImpl implements UserManager {

	private UserPersister userPersister = new UserPersisterImpl();
	
	@Override
	public void saveUsers(Users entity) throws Exception {
		if((Integer)entity.getUserid()== null){
			userPersister.saveUser(entity);
		}else{
			throw new Exception ("Der User (id ="+ entity.getUserid()+ ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Users updateUsers(Users entity) throws Exception {
		return userPersister.updateUser(entity);
	}

	@Override
	public void deleteUsers(Users entity) throws Exception {
		userPersister.deleteUser(entity);
		
	}

	@Override
	public void deleteUsersByUsersid(Integer userid) throws Exception {
		userPersister.deleteUserByUserid(userid);
		
	}

	@Override
	public Users findUsersByUsersid(Integer userid) {
		return  userPersister.findUserByUserid(userid);
	}

	@Override
	public List<Users> findAllUsers() {
		return userPersister.findAllUsers();
	}

	@Override
	public List<Users> findUsersByLastname(String lastname) {
		return userPersister.findUserByLastname(lastname);
	}

	@Override
	public List<Users> findUsersByFirstname(String firstname) {
		return userPersister.findUserByFirstname(firstname);
	}

	@Override
	public List<Users> findUsersByLastnameAndFirstname(String lastname, String firstname) {
		return userPersister.findUserByLastnameAndFirstname(lastname, firstname);
	}

	@Override
	public List<Users> findUserByUsername(String username) {
		return userPersister.findUserByUsername(username);
	}
	
	

}
