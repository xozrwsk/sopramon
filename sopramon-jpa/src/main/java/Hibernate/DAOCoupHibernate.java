package Hibernate;

import java.util.List;

import sopramon.dao.IDAOCoup;
import sopramonbis.model.Coup;

public class DAOCoupHibernate extends DAOHibernate implements IDAOCoup {

	public List<Coup> findAll() {
		return em.createQuery("select c from Coup c", Coup.class).getResultList();
	}

	public Coup findById(int id) {
		return em.find(Coup.class, id);

	}

	public Coup save(Coup entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;

	}

	public void delete(Coup entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();

	}

	public void deleteById(int id) {
		Coup myCoup = new Coup();
		myCoup.setId(id);
		delete(myCoup);

	}

}
