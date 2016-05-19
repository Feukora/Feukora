package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.persister.FuelPersister;
import projekt.feukora.server.persister.FuelPersisterImpl;

public class FuelManagerImpl implements FuelManager{
	
	private FuelPersister fuelPersister = new FuelPersisterImpl();

	@Override
	public void saveFuel(Fuel entity) throws Exception {
		if((Integer)entity.getFuelid()== null){
			fuelPersister.saveFuel(entity);
		}else{
			throw new Exception ("Die Fuel(id =" + entity.getFuelid() + ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Fuel updateFuel(Fuel entity) throws Exception {
		return fuelPersister.updateFuel(entity);
	}

	@Override
	public void deleteFuel(Fuel entity) throws Exception {
		fuelPersister.deleteFuel(entity);
		
	}

	@Override
	public void deleteFuelByFuelid(Integer fuelid) throws Exception {
		fuelPersister.deleteFuelByFuelid(fuelid);
		
	}

	@Override
	public Fuel findFuelByfuelid(Integer fuelid) {
		return fuelPersister.findFuelByFuelid(fuelid);
	}

	@Override
	public List<Fuel> findAllFuel() {
		return fuelPersister.findAllFuel();
	}

	@Override
	public Fuel findFuelByName(String name) {
		return fuelPersister.findFuelByName(name);
	}

}