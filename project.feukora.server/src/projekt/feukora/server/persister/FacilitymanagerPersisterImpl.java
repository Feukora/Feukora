package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Facilitymanager;

public class FacilitymanagerPersisterImpl implements FacilitymanagerPersister{

	@Override
	public void saveFacilitymanager(Facilitymanager entity) throws Exception {
		new GenericPersisterImpl<Facilitymanager>(Facilitymanager.class).save(entity);
		
	}

	@Override
	public Facilitymanager updateFacilitymanager(Facilitymanager entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFacilitymanager(Facilitymanager entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFacilitymanagerByFacilitymanagerid(Integer Facilitymanager) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facilitymanager> findAllFacilitymanagers() {
		// TODO Auto-generated method stub
		return null;
	}

}
