package sopramonbis.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOHibernate {
		protected static EntityManagerFactory emf;
		protected static EntityManager em;
		
		
		public DAOHibernate() {
			if (em == null) {
				emf = Persistence.createEntityManagerFactory("OrderManagement");
				em = emf.createEntityManager();
			}
		}
	
		public static void close() {
			em.close();
			emf.close();
		}
	}

