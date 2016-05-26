package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.persister.FacilitymanagerPersister;
import projekt.feukora.server.persister.FacilitymanagerPersisterImpl;

/**
 * This class implements the methodes of the interface FacilitymanagerManager.
 * 
 * @author Pascal
 * @version 1.4
 *
 */
public class FacilitymanagerManagerImpl implements FacilitymanagerManager {

	FacilitymanagerPersister facilitymanagerPersister = new FacilitymanagerPersisterImpl();

	@Override
	public void saveFacilitymanager(Facilitymanager entity) throws Exception {
		facilitymanagerPersister.saveFacilitymanager(entity);
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
		return facilitymanagerPersister.findFacilitymanagerByLastname(lastname);
	}
}