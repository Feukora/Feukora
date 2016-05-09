package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Facilitymanager;

public class FacilitymanagerPersisterImpl implements FacilitymanagerPersister{

	@Override
	public void saveFacilitymanager(Facilitymanager entity) throws Exception {
		new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).save(entity);
		
	}

	@Override
	public Facilitymanager updateFacilitymanager(Facilitymanager entity) throws Exception {
		return new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).update(entity);
	}

	@Override
	public void deleteFacilitymanager(Facilitymanager entity) throws Exception {
		new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).delete(entity);
		
	}

	@Override
	public void deleteFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) throws Exception {
		new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).deleteById(Facilitymanagerid);			
	}

	@Override
	public Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) {
		return new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).findById(Facilitymanagerid);
	}

	@Override
	public List<Facilitymanager> findAllFacilitymanagers() {
		return new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).findAll();
	}

}
