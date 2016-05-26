package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.model.Rapport;

/**
 * RMI interface for handling rapport entities
 * 
 * @author Sandro
 * @version 1.1
 *
 */
public interface RapportRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveRapport(Rapport entity) throws  RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Rapport
	 * @throws Exception
	 */
	Rapport updateRapport(Rapport entity) throws  RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteRapport(Rapport entity) throws  RemoteException, Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteRapportByRapportid(Integer rapportid) throws  RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Rapport
	 */
	Rapport findRapportByRapportid(Integer rapportid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Rapport> findAllRapports() throws RemoteException;

	/**
	 * Return a list with rapports with this results
	 * 
	 * @param name
	 * @return List with Rapports
	 */
	List<Rapport> findRapportByResults(Boolean results) throws RemoteException;

	/**
	 * Return a list with rapports with this measuringdate
	 * 
	 * @param name
	 * @return List with Rapports
	 */
	List<Rapport> findRapportByMeasuringdate(GregorianCalendar measuringdate) throws RemoteException;
}
