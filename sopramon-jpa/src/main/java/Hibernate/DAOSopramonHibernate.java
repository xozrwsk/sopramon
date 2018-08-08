package Hibernate;

import java.util.List;

import sopramon.dao.IDAOSopramon;
import sopramonbis.model.Sopramon;

public class DAOSopramonHibernate extends DAOHibernate implements IDAOSopramon {

	public List<Sopramon> findAll() {
		return em.createQuery("select s from Sopramon s", Sopramon.class).getResultList();

	}

	public Sopramon findById(int id) {
		return em.find(Sopramon.class, id);
	}

	public Sopramon save(Sopramon entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;

	}

	public void delete(Sopramon entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();

	}

	public void deleteById(int id) {
		Sopramon mySopramon = new Sopramon();
		mySopramon.setId(id);
		delete(mySopramon);

	}

	public Sopramon findBySopramon(String username, String password) {
		return em.createQuery(
				"select distinct s from Sopramon s where s.Utilisateur.username = :username and s.Utilisateur.password = :password",
				Sopramon.class).setParameter("username", username).setParameter("password", password).getSingleResult();
	}

}
