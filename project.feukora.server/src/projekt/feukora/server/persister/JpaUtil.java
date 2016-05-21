package projekt.feukora.server.persister;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;


/**
 *This is a help-class, which creates the Entity-Manager.
 *
 * @version 1.1
 * @author Pascal
 *
 */

public class JpaUtil {
	
	private static final Logger logger = Logger
			.getLogger(JpaUtil.class);

	private static EntityManagerFactory entityManagerFactory = null;

	static {
		try {
			/* Create EntityManagerFactory */
			entityManagerFactory = Persistence
					.createEntityManagerFactory("Feukora");
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}