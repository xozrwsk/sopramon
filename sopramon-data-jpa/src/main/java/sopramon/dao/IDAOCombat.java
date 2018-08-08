package sopramon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sopramonbis.model.Combat;

public interface IDAOCombat extends JpaRepository<Combat, Integer> {

}
