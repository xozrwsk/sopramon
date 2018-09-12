package sopramonboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import sopramonbis.model.Combat;
import sopramonbis.model.Sopramon;
@CrossOrigin("*") 
public interface IDAOCombat extends JpaRepository<Combat, Integer> {

	@Query("select distinct c from Combat c where c.Combat.sopramon = :id")
	public Combat finById(@Param("id") Integer sopramon);
	
}
