package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import projekt.feukora.server.business.UserManager;
import projekt.feukora.server.business.UserManagerImpl;
import projekt.feukora.server.model.Users;
import projekt.feukora.server.persister.GenericPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

/**
 *  This Class implements the methods of the interface UserRMI
 * @author Sandro Fasser
 * @version 1.0
 */
public class UserRMIImpl extends UnicastRemoteObject implements UserRMI {

	private static final long serialVersionUID = 784171184659353831L;
	
	private UserManager userManager;

	public UserRMIImpl() throws RemoteException {
		userManager = new UserManagerImpl();
	}

	@Override
	public void saveUsers(Users entity) throws RemoteException, Exception {
		userManager.saveUsers(entity);	
	}

	@Override
	public Users updateUsers(Users entity) throws RemoteException, Exception {
		return userManager.updateUsers(entity);
	}

	@Override
	public void deleteUsers(Users entity) throws RemoteException, Exception {
		userManager.deleteUsers(entity);
	}

	@Override
	public void deleteUserByUserid(Integer usersid) throws RemoteException, Exception {
		userManager.deleteUsersByUsersid(usersid);
		
	}

	@Override
	public Users findUsersByUserid(Integer usersid) throws RemoteException {
		return userManager.findUsersByUsersid(usersid);
	}

	@Override
	public List<Users> findAllUsers() throws RemoteException {
		return userManager.findAllUsers();
	}

	@Override
	public List<Users> findUsersByLastname(String lastname) throws RemoteException {
		return userManager.findUsersByLastname(lastname);
	}

	@Override
	public List<Users> findUsersByFirstname(String firstname) throws RemoteException {
		return userManager.findUsersByFirstname(firstname);
	}

	@Override
	public List<Users> findUsersByLastnameAndFirstname(String lastname, String firstname) throws RemoteException {
		return userManager.findUsersByLastnameAndFirstname(lastname, firstname);
	}

	@Override
	public List<Users> findUsersByUsername(String username) throws RemoteException {
		return userManager.findUserByUsername(username);
	}



	





}
