package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sopramon.dao.IDAOItem;

@Controller
public class ItemContoller {
	
	@Autowired
	private IDAOItem daoItem;

}
