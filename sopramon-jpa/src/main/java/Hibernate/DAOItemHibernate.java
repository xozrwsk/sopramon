package Hibernate;

import java.util.List;

import sopramon.dao.IDAOItem;
import sopramonbis.model.Item;

public class DAOItemHibernate extends DAOHibernate implements IDAOItem {

	public List<Item> findAll() {
		return em.createQuery("select i from Item i", Item.class).getResultList();

	}

	public Item findById(int id) {
		return em.find(Item.class, id);

	}

	public Item save(Item entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	public void delete(Item entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();

	}

	public void deleteById(int id) {
		Item myItem = new Item();
		myItem.setId(id);
		delete(myItem);

	}

}
