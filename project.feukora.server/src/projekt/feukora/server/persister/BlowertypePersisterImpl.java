package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Blowertype;


/**
 * This class implements the interface BlowertypePersister
 * 
 * @version 1.1
 * @author Patrick
 * 
 */
public class BlowertypePersisterImpl implements BlowertypePersister{

	@Override
	public void saveBlowertype(Blowertype entity) throws Exception {
		new GenericPersisterImpl<Blowertype>(Blowertype.class).save(entity);
	}

	@Override
	public Blowertype updateBlowertype(Blowertype entity) throws Exception {
		return new GenericPersisterImpl<Blowertype>(Blowertype.class).update(entity);
	}

	@Override
	public void deleteBlowertype(Blowertype entity) throws Exception {
		new GenericPersisterImpl<Blowertype>(Blowertype.class).delete(entity);	
	}

	@Override
	public void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws Exception {
		new GenericPersisterImpl<Blowertype>(Blowertype.class).deleteById(blowertypeid);	
	}

	@Override
	public Blowertype findBlowertypeByBlowertypeid(Integer blowertypeid) {
		return new GenericPersisterImpl<Blowertype>(Blowertype.class).findById(blowertypeid);
	}

	@Override
	public List<Blowertype> findAllBlowertypes() {
		return new GenericPersisterImpl<Blowertype>(Blowertype.class).findAll();
	}

	@Override
	public List<Blowertype> findBlowertypeByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Blowertype> tQuery = em.createNamedQuery("Blowertype.findByName",
				Blowertype.class);

		tQuery.setParameter("name", name);

		List<Blowertype> blowertypelist = tQuery.getResultList();

		em.close();

		return blowertypelist != null ? blowertypelist : new ArrayList<Blowertype>();
	}

}
