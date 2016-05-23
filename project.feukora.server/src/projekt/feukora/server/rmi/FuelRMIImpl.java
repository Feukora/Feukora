package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.FuelManager;
import projekt.feukora.server.business.FuelManagerImpl;
import projekt.feukora.server.model.Fuel;

/**
 * This Class implements the methodes of the interface FuelRMI.
 * 
 * @author Tamara
 * @version 1.0
 */
public class FuelRMIImpl extends UnicastRemoteObject implements FuelRMI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2534220880779514943L;
	private FuelManager fuelManager;
	
	public FuelRMIImpl() throws RemoteException{
		fuelManager = new FuelManagerImpl();
	}

	@Override
	public Fuel updateFuel(Fuel entity) throws RemoteException, Exception {
		return fuelManager.updateFuel(entity);
	}
	
	@Override
	public void saveFuel(Fuel entity) throws RemoteException, Exception {
		fuelManager.saveFuel(entity);
		
	}

	@Override
	public void deleteFuel(Fuel entity) throws RemoteException, Exception {
		fuelManager.deleteFuel(entity);
		
	}

	@Override
	public void deleteFuelByFuelid(Integer fuelid) throws RemoteException, Exception {
		fuelManager.deleteFuelByFuelid(fuelid);
		
	}

	@Override
	public Fuel findFuelByFuelid(Integer fuelid) throws RemoteException {
		return fuelManager.findFuelByfuelid(fuelid);
	}

	@Override
	public List<Fuel> findAllFuel() throws RemoteException {
		return fuelManager.findAllFuel();
	}

	@Override
	public Fuel findFuelByName(String name) throws RemoteException, Exception {
		return fuelManager.findFuelByName(name);
	}


	


}
