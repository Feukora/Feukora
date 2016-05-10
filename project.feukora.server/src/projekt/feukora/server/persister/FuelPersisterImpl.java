package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Fuel;

/**
 *  
 * @author Tamara
 * @version
 */
public class FuelPersisterImpl implements FuelPersister{

	@Override
	public void saveFuel(Fuel entity) throws Exception {
		new GenericPersisterImpl<Fuel>(Fuel.class).save(entity);
		
	}

	@Override
	public Fuel updateFuel(Fuel entity) throws Exception {
		return new GenericPersisterImpl<Fuel>(Fuel.class).update(entity);
	}

	@Override
	public void deleteFuel(Fuel entity) throws Exception {
		new GenericPersisterImpl<Fuel>(Fuel.class).delete(entity);
		
	}

	@Override
	public void deleteFuelByFuelid(Integer fuelid) throws Exception {
		new GenericPersisterImpl<Fuel>(Fuel.class).deleteById(fuelid);
		
	}

	@Override
	public Fuel findFuelByFuelid(Integer fuelid) {
		return new GenericPersisterImpl<Fuel>(Fuel.class).findById(fuelid);
	}

	@Override
	public List<Fuel> findAllFuel() {
		return new GenericPersisterImpl<Fuel>(Fuel.class).findAll();
	}

}
