package Hibernate;

import java.util.List;

import sopramon.dao.IDAOCombat;
import sopramonbis.model.Combat;

public class DAOCombatHibernate extends DAOHibernate implements IDAOCombat {

	public List<Combat> findAll() {
		return em.createQuery("select c from Combat c", Combat.class).getResultList();

	}

	public Combat findById(int id) {
		return em.find(Combat.class, id);

	}

	public Combat save(Combat entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	public void delete(Combat entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();

	}

	public void deleteById(int id) {
		Combat myCombat = new Combat();
		myCombat.setId(id);
		delete(myCombat);

	}

}
