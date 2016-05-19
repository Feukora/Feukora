package projekt.feukora.server.business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Town;
import projekt.feukora.server.persister.TownPersister;
import projekt.feukora.server.persister.TownPersisterImpl;
import projekt.feukora.server.persister.GenericPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

/**
 * This Class implements the methods of the interface TownManager.
 * 
 * @author Pascal
 * @version 1.0
 */

public class TownManagerImpl implements TownManager {
	
	private TownPersister townPersister = new TownPersisterImpl();

	@Override
	public void saveTown(Town entity) throws Exception {
//		if( entity.getTownid() == 0){
			townPersister.saveTown(entity);
//		}else{
//			throw new Exception("Der Kunde (id = "+ entity.getTownid() + ") ist bereits vorhanden");
//		}
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
