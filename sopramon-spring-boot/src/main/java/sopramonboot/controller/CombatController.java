package sopramonboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sopramonboot.dao.IDAOCombat;

@Controller
public class CombatController {
	
	@Autowired
	private IDAOCombat daoCombat;
	
	@GetMapping("/listeCombats")
	public String listerProd(Model model) {
		model.addAttribute("combats", daoCombat.findAll());
	return "listeCombats";
	}

}
