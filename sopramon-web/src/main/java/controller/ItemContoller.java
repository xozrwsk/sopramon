package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sopramon.dao.IDAOItem;

@Controller
public class ItemContoller {
	
	@Autowired
	private IDAOItem daoItem;
	
	@GetMapping("/gestionItems")
	public String listerProd(Model model) {
		model.addAttribute("items", daoItem.findAll());
	return "gestionItems";
	}

}
