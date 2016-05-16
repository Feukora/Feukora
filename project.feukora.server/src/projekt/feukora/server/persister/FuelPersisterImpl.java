package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Fuel;

/**
 *  * This class implements the interface FuelPersister
 *  
 * @version 1.1
 * @author Tamara
 * 
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

	@Override
	public Fuel findFuelByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Fuel> tQuery = em.createNamedQuery("Fuel.findByName",
				Fuel.class);

		tQuery.setParameter("name", name);

		List<Fuel> fuellist = tQuery.getResultList();

		em.close();

		return fuellist.get(0);
	}

}
