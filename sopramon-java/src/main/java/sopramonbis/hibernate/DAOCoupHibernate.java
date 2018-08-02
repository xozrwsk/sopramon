package sopramonbis.hibernate;

import java.util.List;

import sopramonbis.dao.IDAOCoup;
import sopramonbis.model.Combat;
import sopramonbis.model.Coup;

public class DAOCoupHibernate extends DAOHibernate implements IDAOCoup {

	@Override
	public List<Coup> findAll() {
		return em.createQuery("select c from Coup c", Coup.class).getResultList();
		}

	@Override
	public Coup findById(int id) {
		return em.find(Coup.class, id);
	
	}

	@Override
	public Coup save(Coup entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
		
	}

	@Override
	public void delete(Coup entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();

		
	}

	@Override
	public void deleteById(int id) {
		Coup myCoup = new Coup();
		myCoup.setId(id);
		delete(myCoup);
		
	}

}
