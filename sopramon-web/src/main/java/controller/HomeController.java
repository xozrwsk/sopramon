package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sopramon.dao.IDAOSopramon;

@Controller
public class HomeController {
	
	@Autowired
	private IDAOSopramon daoSopramon;
	
	@PostMapping("/connexion")
	public String menu(@RequestParam String usernameCo, @RequestParam String passwordCo, Model model) {
		
	return "connexion";
	
	}
	
	

}
