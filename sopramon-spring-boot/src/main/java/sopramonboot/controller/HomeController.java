package sopramonboot.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sopramonbis.model.Capacite;
import sopramonbis.model.Signe;
import sopramonbis.model.Sopramon;
import sopramonbis.model.Type;
import sopramonbis.model.Utilisateur;
import sopramonboot.dao.IDAOSigne;
import sopramonboot.dao.IDAOSopramon;

@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
@Controller
public class HomeController {

	@Autowired
	private IDAOSigne daoSigne;

	@Autowired
	private IDAOSopramon daoSopramon;

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/icombat")
	public String  icombat() {
		return "icombat";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/connexion")
	public String login() {
		return "connexion";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/sopramon")
	public String sopramon() {
		return "sopramon";
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/inscription")
	public String inscription(Model model) {
		model.addAttribute("signes", daoSigne.findAll());
		return "inscription";
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/acces")
	public String acces() {
		return "acces";
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	
	
	@PreAuthorize("permitAll()")
	@PostMapping("/inscription")
	public String Inscription(@DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam Date dateNaissance, @RequestParam String username, @RequestParam String password, @RequestParam String nom, @RequestParam int signe, @RequestParam String prenom,@RequestParam String nomsopramon,Model model) {

		Sopramon monSopramon = new Sopramon();
		Utilisateur monUtilisateur = new Utilisateur();
		Type monType = new Type();
		Capacite maCapacite = new Capacite();
		Signe monSigne = daoSigne.findById(signe).get();
		
			
		
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
		monSopramon.setNom(nomsopramon);
		monSopramon.setArgent(100.0);
		monSopramon.setDateNaissance(dateNaissance);
		monSopramon.setUtilisateur(monUtilisateur);
		monSopramon.setSigne(monSigne);
		monSopramon.setType(monSigne.getType());
		
		daoSopramon.save(monSopramon);


		 return "redirect:/connexion";
		
	}


}


