package projekt.feukora.server.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.persister.FacilitymanagerPersister;
import projekt.feukora.server.persister.FacilitymanagerPersisterImpl;
import projekt.feukora.server.persister.GenericPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

/**
 * This class implements the interface FacilitymanagerManagerImpl
 * 
 * @version 1.0
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

	@Override
	public List<Facilitymanager> findFacilitymanagerByFirstname(String firstname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Facilitymanager> tQuery = em.createNamedQuery("Facilitymanager.findByFirstname",
				Facilitymanager.class);

		tQuery.setParameter("firstname", firstname);

		List<Facilitymanager> facilitymanagerlist = tQuery.getResultList();

		em.close();

		return facilitymanagerlist != null ? facilitymanagerlist : new ArrayList<Facilitymanager>();
	}

	
	
}

