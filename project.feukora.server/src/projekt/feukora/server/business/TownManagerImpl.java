package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;

/**
 * This Class implements the methods of the interface TownManager.
 * 
 * @author Pascal
 * @version 1.4
 */
public class TownManagerImpl implements TownManager {
	
	private TownPersister townPersister = new TownPersisterImpl();

	@Override
	public void saveTown(Town entity) throws Exception {
			townPersister.saveTown(entity);
	}

	@Override
	public Town updateTown(Town entity) throws Exception {
			return townPersister.updateTown(entity);	
	}
	
	@Override
	public void deleteTown(Town entity) throws Exception {
		townPersister.deleteTown(entity);
	}

	@Override
	public List<Town> findAllTowns() {
		return townPersister.findAllTowns();
	}

	@Override
	public Town findTownByZip(Integer zip) {
		return townPersister.findbyZip(zip);
	}
}