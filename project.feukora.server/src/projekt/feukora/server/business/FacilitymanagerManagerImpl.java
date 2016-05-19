package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.persister.FacilitymanagerPersister;
import projekt.feukora.server.persister.FacilitymanagerPersisterImpl;


/**
 * This class implements the interface FacilitymanagerManagerImpl
 * 
 * @version 1.1
 * @author Pascal
 *
 */

public class FacilitymanagerManagerImpl implements FacilitymanagerManager {

	FacilitymanagerPersister facilitymanagerPersister = new FacilitymanagerPersisterImpl();
	
	@Override
	public void saveFacilitymanager(Facilitymanager entity) throws Exception {
		if((Integer) entity.getFacilitymanagerid() == null){
			facilitymanagerPersister.saveFacilitymanager(entity);
		}else{
			throw new Exception("Der Facilitymanager (id = "+ entity.getFacilitymanagerid() + ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Facilitymanager updateFacilitymanager(Facilitymanager entity) throws Exception {
		return facilitymanagerPersister.updateFacilitymanager(entity);
	}

	@Override
	public void deleteFacilitymanager(Facilitymanager entity) throws Exception {
		facilitymanagerPersister.deleteFacilitymanager(entity);
		
	}

	@Override
	public void deleteFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) throws Exception {
		facilitymanagerPersister.deleteFacilitymanagerByFacilitymanagerid(Facilitymanagerid);
		
	}

	@Override
	public Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) {
		return facilitymanagerPersister.findFacilitymanagerByFacilitymanagerid(Facilitymanagerid);
	}

	@Override
	public List<Facilitymanager> findAllFacilitymanagers() {
		return facilitymanagerPersister.findAllFacilitymanagers();
	}

	@Override
	public List<Facilitymanager> findFacilitymanagerByLastname(String lastname) {
		return facilitymanagerPersister.findFacilitymanagerByFirstname(lastname);
	}

	@Override
	public List<Facilitymanager> findFacilitymanagerByFirstname(String firstname) {
		return facilitymanagerPersister.findFacilitymanagerByFirstname(firstname);
	}

	
	
}

