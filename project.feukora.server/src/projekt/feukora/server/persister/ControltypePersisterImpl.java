package projekt.feukora.server.persister;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Controltype;

/**
 * This class implements the interface ControltypePersister
 * 
 * @version 1.1
 * @author Allan
 *
 */

public class ControltypePersisterImpl implements ControltypePersister {

	@Override
	public void saveControltype(Controltype entity) throws Exception {
		new GenericPersisterImpl<Controltype>(Controltype.class).save(entity);
	}

	@Override
	public Controltype updateControltype(Controltype entity) throws Exception {
		return new GenericPersisterImpl<Controltype>(Controltype.class).update(entity);
	}

	@Override
	public void deleteControltype(Controltype entity) throws Exception {
		new GenericPersisterImpl<Controltype>(Controltype.class).delete(entity);
	}

	@Override
	public void deleteControltypeByControltypeid(Integer controltypeid) throws Exception {
		new GenericPersisterImpl<Controltype>(Controltype.class).deleteById(controltypeid);
	}

	@Override
	public Controltype findControltypeByControltypeid(Integer controltypeid) {
		return new GenericPersisterImpl<Controltype>(Controltype.class).findById(controltypeid);
	}

	@Override
	public List<Controltype> findAllControltypes() {
		return new GenericPersisterImpl<Controltype>(Controltype.class).findAll();
	}

	@Override
	public String findControltypeByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Controltype> tQuery = em.createNamedQuery("Controltype.findByName",
				Controltype.class);

		tQuery.setParameter("name", name);

		em.close();

		return name;
	}
}
