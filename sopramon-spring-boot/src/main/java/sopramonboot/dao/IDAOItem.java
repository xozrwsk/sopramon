package sopramonboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import sopramonbis.model.Item;

@CrossOrigin("*")
public interface IDAOItem extends JpaRepository<Item, Integer> {
}