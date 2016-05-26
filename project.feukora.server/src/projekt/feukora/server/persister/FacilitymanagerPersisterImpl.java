package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Facilitymanager;

/**
 * This class implements the interface FacilitymanagerPersister
 * 
 * @version 1.5
 * @author Pascal
 *
 */
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

	@Override
	public List<Facilitymanager> findFacilitymanagerByLastname(String lastname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Facilitymanager> tQuery = em.createNamedQuery("Facilitymanager.findByLastname",
				Facilitymanager.class);

		tQuery.setParameter("lastname", lastname);

		List<Facilitymanager> facilitymanagerlist = tQuery.getResultList();

		em.close();

		return facilitymanagerlist != null ? facilitymanagerlist : new ArrayList<Facilitymanager>();
	}
}