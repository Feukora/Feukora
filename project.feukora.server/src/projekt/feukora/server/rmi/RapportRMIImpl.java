package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.model.Rapport;

/**
 * This Class implements the methods of the interface RapportRMI
 * @author Sandro Fasser
 * @version 1.0
 */
public class RapportRMIImpl extends UnicastRemoteObject implements RapportRMI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8825604569434762933L;
	
	private RapportManager rapportManager;
	
	public RapportRMIImpl() throws RemoteException{
		rapportManager = new RapportManagerImpl();
	}

	@Override
	public void saveRapport(Rapport entity) throws RemoteException, Exception {
		rapportManager.saveRapport(entity);
		
	}

	@Override
	public Rapport updateRapport(Rapport entity) throws RemoteException, Exception {
		rapportManager.updateRapport(entity);
	}

	@Override
	public void deleteRapport(Rapport entity) throws RemoteException, Exception {
		rapportManager.deleteRapport(entity);
		
	}

	@Override
	public void deleteRapportByRapportid(Integer rapportid) throws RemoteException, Exception {
		rapportManager.deleteRapportByRapportid(rapportid);
		
	}

	@Override
	public Rapport findRapportByRapportid(Integer rapportid) throws RemoteException {
		rapportManager.findRapportByRapportid(rapportid);
	}

	@Override
	public List<Rapport> findAllRapports() throws RemoteException {
		rapportManager.findAllRapports();
	}

	@Override
	public List<Rapport> findRapportByResults(Boolean results) throws RemoteException {
		rapportManager.findRapportByResults(results);
	}

	@Override
	public List<Rapport> findRapportByMeasuringdate(GregorianCalendar measuringdate) throws RemoteException {
		rapportManager.findRapportByMeasuringdate(measuringdate);
	}
	
	

}

