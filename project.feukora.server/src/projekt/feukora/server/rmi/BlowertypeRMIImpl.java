package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.BlowertypeManager;
import projekt.feukora.server.business.BlowertypeManagerImpl;
import projekt.feukora.server.model.Blowertype;

/**
 * This Class implements the methods of the interface BlowertypeRMI
 *  
 * @author Patrick
 * @version 1.0
 */
public class BlowertypeRMIImpl extends UnicastRemoteObject implements BlowertypeRMI {

	private static final long serialVersionUID = -145670658486889430L;

	private BlowertypeManager blowertypeManager;

	public BlowertypeRMIImpl() throws RemoteException {
		blowertypeManager = new BlowertypeManagerImpl();
	}

	@Override
	public void saveBlowertype(Blowertype entity) throws RemoteException, Exception {
		blowertypeManager.saveBlowertype(entity);	
	}

	@Override
	public Blowertype updateBlowertype(Blowertype entity) throws RemoteException, Exception {
		return blowertypeManager.updateBlowertype(entity);
	}

	@Override
	public void deleteBlowertype(Blowertype entity) throws RemoteException, Exception {
		blowertypeManager.deleteBlowertype(entity);
	}

	@Override
	public void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws RemoteException, Exception {
		blowertypeManager.deleteBlowertypeByBlowertypeid(blowertypeid);	
	}

	@Override
	public Blowertype findBlowertypeByBlowertypeid(Integer blowertypeid) throws RemoteException {
		return blowertypeManager.findBlowertypeByBlowertypeid(blowertypeid);
	}

	@Override
	public List<Blowertype> findAllBlowertypes() throws RemoteException {
		return blowertypeManager.findAllBlowertypes();
	}

	@Override
	public Blowertype findBlowertypeByName(String name) throws RemoteException, Exception {
		return blowertypeManager.findBlowertypeByName(name);
	}
}
