package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.business.CustomerManager;
import projekt.feukora.server.business.CustomerManagerImpl;
import projekt.feukora.server.business.MeasuringresultManager;
import projekt.feukora.server.business.MeasuringresultManagerImpl;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.persister.GenericPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

/**
 * This Class implements the methods of the interface MeasuringresultRMI
 *  
 * @author Patrick 
 * @version 1.1
 */
public class MeasuringresultRMIImpl extends UnicastRemoteObject implements MeasuringresultRMI {
	
	private static final long serialVersionUID = -8183938237869692194L;
	
	private MeasuringresultManager measuringresultManager;

	public MeasuringresultRMIImpl() throws RemoteException {
		measuringresultManager = new MeasuringresultManagerImpl();
	}

	@Override
	public void saveMeasuringresult(Measuringresult entity) throws RemoteException, Exception {
		measuringresultManager.saveMeasuringresult(entity);	
	}

	@Override
	public Measuringresult updateMeasuringresult(Measuringresult entity) throws RemoteException, Exception {
		return measuringresultManager.updateMeasuringresult(entity);
	}

	@Override
	public void deleteMeasuringresult(Measuringresult entity) throws RemoteException, Exception {
		measuringresultManager.deleteMeasuringresult(entity);
		
	}

	@Override
	public void deleteMeasuringresultByMeasuringresultid(Integer measuringresultid) throws RemoteException, Exception {
		measuringresultManager.deleteMeasuringresultByMeasuringresultid(measuringresultid);	
		
	}

	@Override
	public Measuringresult findMeasuringresultByMeasuringresultid(Integer measuringresultid) throws RemoteException {
		return measuringresultManager.findMeasuringresultByMeasuringresultid(measuringresultid);
	}

	@Override
	public List<Measuringresult> findAllMeasuringresult() throws RemoteException {
		return measuringresultManager.findAllMeasuringresults();
	}

}
