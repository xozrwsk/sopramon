package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sopramon.dao.IDAOSopramon;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Utilisateur;

@Controller
public class HomeController {

	@Autowired
	private IDAOSopramon daoSopramon;

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/sopramon")
	public String sopramon() {
		return "sopramon";
	}
	
	@GetMapping("/acces")
	public String acces() {
		return "acces";
	}
	@GetMapping("/connexion")
	public String saveUtilisateur() {
		return "connexion";
	}

	@PostMapping("/connexion")
	public String verifUtilisateur(@RequestParam String username, @RequestParam String password, Model model) {

		if (daoSopramon.finBySopramon(username, password) == null)
		{
	    model.addAttribute("msgerr", "Username ou Password erroné(s)");
	    return "connexion";
		}
	
        return "redirect:/acces";
		
	}


}



//Sopramon monSopramon = new Sopramon();
//Utilisateur monUtilisateur = new Utilisateur();
//
//monUtilisateur.setUsername(username);
//monUtilisateur.setPassword(password);
//monSopramon.setUtilisateur(monUtilisateur);
//daoSopramon.save(monSopramon);
