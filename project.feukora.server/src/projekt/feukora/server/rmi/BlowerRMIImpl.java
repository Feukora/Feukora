package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.business.BlowerManager;
import projekt.feukora.server.business.BlowerManagerImpl;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.persister.JpaUtil;


/**
 *  This Class implements the methods of the interface BlowerRMI
 * @author Robin Purtschert
 * @version 1.0
 */
public class BlowerRMIImpl extends UnicastRemoteObject implements BlowerRMI {

	private static final long serialVersionUID = 724994631535546964L;
	
	private BlowerManager blowerManager;

	public BlowerRMIImpl() throws RemoteException {
		blowerManager = new BlowerManagerImpl();
	}

	@Override
	public void saveBlower(Blower entity) throws RemoteException, Exception {
		blowerManager.saveBlower(entity);	
	}

	@Override
	public Blower updateBlower(Blower entity) throws RemoteException, Exception {
		return blowerManager.updateBlower(entity);
	}

	@Override
	public void deleteBlower(Blower entity) throws RemoteException, Exception {
		blowerManager.deleteBlower(entity);
	}

	@Override
	public void deleteBlowerByBlowerid(Integer blowerid) throws RemoteException, Exception {
		blowerManager.deleteBlowerByBlowerid(blowerid);	
	}

	@Override
	public Blower findBlowerByBlowerid(Integer blowerid) throws RemoteException {
		return blowerManager.findBlowerByBlowerid(blowerid);
	}

	@Override
	public List<Blower> findAllBlowers() throws RemoteException {
		return blowerManager.findAllBlowers();
	}

	@Override
	public List<Blower> findBlowerByName(String name) throws RemoteException {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Blower> tQuery = em.createNamedQuery("Blower.findByName",
				Blower.class);

		tQuery.setParameter("name", name);

		List<Blower> blowerlist = tQuery.getResultList();

		em.close();

		return blowerlist != null ? blowerlist : new ArrayList<Blower>();
		}

}
