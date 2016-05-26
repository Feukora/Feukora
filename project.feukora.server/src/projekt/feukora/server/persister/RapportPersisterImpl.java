package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Rapport;

/**
 * This class implements the interface RapportPersister
 * 
 * @version 1.5
 * @author Sandro
 *
 */
public class RapportPersisterImpl implements RapportPersister {

	@Override
	public void saveRapport(Rapport entity) throws Exception {
		new GenericPersisterImpl<Rapport>(Rapport.class).save(entity);	
	}

	@Override
	public Rapport updateRapport(Rapport entity) throws Exception {
		return new GenericPersisterImpl<Rapport>(Rapport.class).update(entity);
	}

	@Override
	public void deleteRapport(Rapport entity) throws Exception {
		new GenericPersisterImpl<Rapport>(Rapport.class).delete(entity);	
	}

	@Override
	public void deleteRapportByRapportid(Integer rapportid) throws Exception {
		new GenericPersisterImpl<Rapport>(Rapport.class).deleteById(rapportid);			
	}

	@Override
	public Rapport findRapportByRapportid(Integer rapportid) {
		return new GenericPersisterImpl<Rapport>(Rapport.class).findById(rapportid);
	}

	@Override
	public List<Rapport> findAllRapports() {
		return new GenericPersisterImpl<Rapport>(Rapport.class).findAll();
	}

	@Override
	public List<Rapport> findRapportByResults(Boolean results) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Rapport> tQuery = em.createNamedQuery("Rapport.findByResults",
				Rapport.class);

		tQuery.setParameter("results", results);

		List<Rapport> rapportlist = tQuery.getResultList();

		em.close();

		return rapportlist != null ? rapportlist : new ArrayList<Rapport>();
	
	}

	@Override
	public List<Rapport> findRapportByMeasuringdate(GregorianCalendar measuringdate) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Rapport> tQuery = em.createNamedQuery("Rapport.findByMeasuringdate",
				Rapport.class);

		tQuery.setParameter("measuringdate", measuringdate);

		List<Rapport> rapportlist = tQuery.getResultList();

		em.close();

		return rapportlist != null ? rapportlist : new ArrayList<Rapport>();
	}
}
