package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Measuringresult;

/**
 * RMI interface for handling measuringresult entities
 * @author Patrick Pereira
 * @version 1.0
 */

public interface MeasuringresultRMI extends Remote{
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveMeasuringresult(Measuringresult entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Measuringresult updateMeasuringresult(Measuringresult entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteMeasuringresult(Measuringresult entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteMeasuringresultByMeasuringresultid(Integer measuringresultid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Measuringresult findMeasuringresultByMeasuringresultid(Integer measuringresultid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Measuringresult> findAllMeasuringresult() throws RemoteException;
}
