package sopramonboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Utilisateur;
import sopramonbis.model.Sopramon;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer> {
	public Utilisateur findByUsername(String username);

}