package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import sopramonbis.model.Capacite;
import sopramonbis.model.Signe;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Type;
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
	
	@GetMapping("/inscription")
	public String inscription() {
		return "inscription";
	}
	
	@GetMapping("/acces")
	public String acces() {
		return "acces";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
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
	
	@PostMapping("/inscription")
	public String Inscription(@DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam Date dateNaissance, @RequestParam String username, @RequestParam String password, @RequestParam String nom, @RequestParam String prenom,Model model) {

		Sopramon monSopramon = new Sopramon();
		Utilisateur monUtilisateur = new Utilisateur();
		Signe monSigne = new Signe();
		Type monType = new Type();
		Capacite maCapacite = new Capacite();
		
		
		monSigne.setId(1);
		monType.setId(1);
		maCapacite.setAttaque(50);
		maCapacite.setDefense(50);
		maCapacite.setPointDeVie(500);
		maCapacite.setEsquive(50);
		maCapacite.setVitesse(50);
		
		monUtilisateur.setPrenom(prenom);
		monUtilisateur.setNom(nom);
		monUtilisateur.setUsername(username);
		monUtilisateur.setPassword(password);
			
		monSopramon.setExperience(0);
		monSopramon.setNiveau(1);
		monSopramon.setCapacite(maCapacite);
		monSopramon.setType(monType);;
		monSopramon.setNom(nom);
		monSopramon.setSigne(monSigne);
		monSopramon.setArgent(100.0);
		monSopramon.setDateNaissance(dateNaissance);
		monSopramon.setUtilisateur(monUtilisateur);
		daoSopramon.save(monSopramon);


		 return "redirect:/connexion";
		
	}


}



//Sopramon monSopramon = new Sopramon();
//Utilisateur monUtilisateur = new Utilisateur();
//
//monUtilisateur.setUsername(username);
//monUtilisateur.setPassword(password);
//monSopramon.setUtilisateur(monUtilisateur);
//daoSopramon.save(monSopramon);
