package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Blower;
 
/**
 * This class implements the interface BlowerPersister
 * 
 * @version 1.1
 * @author Robin
 * 
 */
public class BlowerPersisterImpl implements BlowerPersister {

	@Override
	public void saveBlower(Blower entity) throws Exception {
		new GenericPersisterImpl<Blower>(Blower.class).save(entity);	
	}

	@Override
	public Blower updateBlower(Blower entity) throws Exception {
		return new GenericPersisterImpl<Blower>(Blower.class).update(entity);
	}

	@Override
	public void deleteBlower(Blower entity) throws Exception {
		new GenericPersisterImpl<Blower>(Blower.class).delete(entity);	
	}

	@Override
	public void deleteBlowerByBlowerid(Integer blowerid) throws Exception {
		new GenericPersisterImpl<Blower>(Blower.class).deleteById(blowerid);	
	}

	@Override
	public Blower findByBlowerid(Integer blowerid) {
		return new GenericPersisterImpl<Blower>(Blower.class).findById(blowerid);
	}

	@Override
	public List<Blower> findAllBlowers() {
		return new GenericPersisterImpl<Blower>(Blower.class).findAll();
	}

	@Override
	public List<Blower> findBlowerByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Blower> tQuery = em.createNamedQuery("Blower.findByName",
				Blower.class);

		tQuery.setParameter("name", name);

		List<Blower> blowerlist = tQuery.getResultList();

		em.close();

		return blowerlist != null ? blowerlist : new ArrayList<Blower>();
		}
}
