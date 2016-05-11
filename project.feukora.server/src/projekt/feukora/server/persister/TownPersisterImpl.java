package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Town;

/**
 * This class implements the interface TownPersister
 * 
 * @version 1.1
 * @author Robin
 *
 */
public class TownPersisterImpl implements TownPersister {

	@Override
	public void saveTown(Town entity) throws Exception {
		new GenericPersisterImpl<Town>(Town.class).save(entity);	
	}

	@Override
	public Town updateTown(Town entity) throws Exception {
		return new GenericPersisterImpl<Town>(Town.class).update(entity);
	}

	@Override
	public void deleteTown(Town entity) throws Exception {
		new GenericPersisterImpl<Town>(Town.class).delete(entity);	
	}

	@Override
	public void deleteTownByTownzip(Integer zip) throws Exception {
		new GenericPersisterImpl<Town>(Town.class).deleteById(zip);
	}

	@Override
	public List<Town> findbyTownzip(Integer zip) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Town> tQuery = em.createNamedQuery("Tonw.findByzip",
				Town.class);

		tQuery.setParameter("zip", zip);

		List<Town> townlist = tQuery.getResultList();

		em.close();

		return townlist != null ? townlist : new ArrayList<Town>();
	}

	@Override
	public List<Town> findAllTowns() {
		return new GenericPersisterImpl<Town>(Town.class).findAll();
	}

	@Override
	public List<Town> findTownByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Town> tQuery = em.createNamedQuery("Town.findByName",
				Town.class);

		tQuery.setParameter("name", name);

		List<Town> townlist = tQuery.getResultList();

		em.close();

		return townlist != null ? townlist : new ArrayList<Town>();
	}

	@Override
	public List<Town> findTownByCanton(String canton) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Town> tQuery = em.createNamedQuery("Town.findByCanton",
				Town.class);

		tQuery.setParameter("canton", canton);

		List<Town> cantonlist = tQuery.getResultList();

		em.close();

		return cantonlist != null ? cantonlist : new ArrayList<Town>();
	}
}
