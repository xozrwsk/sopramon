package sopramon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopramonbis.model.Sopramon;

public interface IDAOSopramon extends JpaRepository<Sopramon, Integer> {

	@Query("select distinct s from Sopramon s where s.Utilisateur.username = :username and s.Utilisateur.password = :password")
	public Sopramon finBySopramon(@Param("username") String username, @Param("password") String password);

}
