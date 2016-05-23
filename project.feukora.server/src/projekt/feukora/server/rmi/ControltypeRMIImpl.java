package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.ControltypeManager;
import projekt.feukora.server.business.ControltypeManagerImpl;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Fuel;

/**
 * This Class implements the methodes of the Interface ControltypeRMI
 * 
 * @author Tamara
 *
 */
public class ControltypeRMIImpl extends UnicastRemoteObject implements ControltypeRMI{
	
	private static final long serialVersionUID = 1813253292411198528L;
	
	private ControltypeManager controltypeManager;
	
	public ControltypeRMIImpl() throws RemoteException {
		controltypeManager = new ControltypeManagerImpl();
	}

	@Override
	public void saveControltype(Controltype entity) throws RemoteException, Exception {
		controltypeManager.saveControltype(entity);
		
	}

	@Override
	public Controltype updateControltype(Controltype entity) throws RemoteException, Exception {
		return controltypeManager.updateControltype(entity);
	}

	@Override
	public void deleteControltype(Controltype entity) throws RemoteException, Exception {
		controltypeManager.deleteControltype(entity);
		
	}

	@Override
	public void deleteControltypeByControltypeid(Integer controltypeid) throws RemoteException, Exception {
		controltypeManager.deleteControltypeByControltypeid(controltypeid);
		
	}

	@Override
	public Controltype findControltypeByControltypeid(Integer controltypeid) throws RemoteException {
		return controltypeManager.findControltypeByControltypeid(controltypeid);
	}

	@Override
	public List<Controltype> findAllControltype() throws RemoteException {
		return controltypeManager.findAllControltype();
	}

	@Override
	public Controltype findControltypeByName(String name) throws RemoteException, Exception {
		return controltypeManager.findControltypeByName(name);
	}

	

}
