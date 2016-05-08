package projekt.feukora.server.persister;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *This is a help-class, which creates the Entity-Manager.
 *
 *@version 1.0
 * @author Pascal
 *
 */

public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory = null;

	static {
		try {
			/* Create EntityManagerFactory */
			entityManagerFactory = Persistence
					.createEntityManagerFactory("Feukora");
											
		} catch (Throwable e) {
			/* TODO - Ecxeption Handling … */
			e.printStackTrace();
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}