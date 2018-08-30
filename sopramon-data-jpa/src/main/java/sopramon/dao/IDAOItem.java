package sopramon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sopramonbis.model.Item;

public interface IDAOItem extends JpaRepository<Item, Integer> {
}