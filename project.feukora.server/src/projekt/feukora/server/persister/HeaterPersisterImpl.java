package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Heater;

/**
 * This class implements the interface HeaterPersister
 * 
 * @version 1.5
 * @author Patrick
 *
 */
public class HeaterPersisterImpl implements HeaterPersister {

	@Override
	public void saveHeater(Heater entity) throws Exception {
		new GenericPersisterImpl<Heater>(Heater.class).save(entity);
	}

	@Override
	public Heater updateHeater(Heater entity) throws Exception {
		return new GenericPersisterImpl<Heater>(Heater.class).update(entity);
	}

	@Override
	public void deleteHeater(Heater entity) throws Exception {
		new GenericPersisterImpl<Heater>(Heater.class).delete(entity);
	}

	@Override
	public void deleteHeaterByHeaterid(Integer heaterid) throws Exception {
		new GenericPersisterImpl<Heater>(Heater.class).deleteById(heaterid);	
	}

	@Override
	public Heater findHeaterByHeaterid(Integer heaterid) {
		return new GenericPersisterImpl<Heater>(Heater.class).findById(heaterid);
	}

	@Override
	public List<Heater> findAllHeaters() {
		return new GenericPersisterImpl<Heater>(Heater.class).findAll();
	}

	@Override
	public List<Heater> findHeaterByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Heater> tQuery = em.createNamedQuery("Heater.findByName",
				Heater.class);

		tQuery.setParameter("name", name);

		List<Heater> heaterlist = tQuery.getResultList();

		em.close();

		return heaterlist != null ? heaterlist : new ArrayList<Heater>();
	}
}
