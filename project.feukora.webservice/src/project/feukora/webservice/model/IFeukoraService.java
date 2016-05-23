package project.feukora.webservice.model;

import java.rmi.RemoteException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Rapport;

@WebService
public interface IFeukoraService {
	
	@WebMethod
	boolean login(@WebParam(name = "username") String username, @WebParam(name="password")String password ) throws RemoteException;
	
	@WebMethod
	List<Customer> getCustomers() throws RemoteException;
	
	@WebMethod
	Rapport createRapport() throws RemoteException;
	
	@WebMethod
	void saveRapport ( @WebParam(name="rapport")Rapport rapport ) throws RemoteException;
	
}
