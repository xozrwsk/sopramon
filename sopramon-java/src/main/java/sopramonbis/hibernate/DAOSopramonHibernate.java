package sopramonbis.hibernate;

import java.util.List;


import sopramonbis.dao.IDAOSopramon;
import sopramonbis.model.Combat;
import sopramonbis.model.Sopramon;

public class DAOSopramonHibernate extends DAOHibernate implements IDAOSopramon {

	@Override
	public List<Sopramon> findAll() {
		return em.createQuery("select s from Sopramon s", Sopramon.class).getResultList();
	
	}

	@Override
	public Sopramon findById(int id) {
		return em.find(Sopramon.class, id);
		}

	@Override
	public Sopramon save(Sopramon entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	
	}

	@Override
	public void delete(Sopramon entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteById(int id) {
		Sopramon mySopramon = new Sopramon();
		mySopramon.setId(id);
		delete(mySopramon);
		
	}
	
	public Sopramon findBySopramon(String username, String password) {
		return em
				.createQuery("select distinct s from Sopramon s where s.Utilisateur.username = :username and s.Utilisateur.password = :password", Sopramon.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
	}

}


