package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sopramon.dao.IDAOSopramon;
import sopramonbis.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class connectionTest {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private IDAOSopramon daoSopramon;

	@Test
	public void testConnection() {
		
		assertNotNull(daoSopramon.finBySopramon("XO", "4"));
		assertNull(daoSopramon.finBySopramon("XO", "9"));
		assertNull(daoSopramon.finBySopramon("JP", "4"));
		
	}
	
}
