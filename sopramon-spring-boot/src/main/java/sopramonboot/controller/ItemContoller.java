package sopramonboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramonbis.model.Item;
import sopramonboot.dao.IDAOItem;

@Controller
public class ItemContoller {

	@Autowired
	private IDAOItem daoItem;

	
		
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/achatitem")
	public String listerachats(Model model) {
		model.addAttribute("items", daoItem.findAll());
		return "achatitem";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/gestionItems")
	public String listerItem(Model model) {
		model.addAttribute("items", daoItem.findAll());
		return "gestionItems";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/modifierItem")
	public String modifierItem(@RequestParam int id, Model model) {
		model.addAttribute("item", daoItem.findById(id).get());
		return "modifierItem";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/modifierItem")
	public String modifierItem(@RequestParam String nom, @RequestParam int prix, @RequestParam int attaque,
			@RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse, @RequestParam int id,
			@RequestParam String description, Model model) {
		Item myItem = new Item();

		myItem.setId(id);
		myItem.setNom(nom);
		myItem.setPrix(prix);
		myItem.setAttaque(attaque);
		myItem.setDefense(defense);
		myItem.setEsquive(esquive);
		myItem.setVitesse(vitesse);
		myItem.setDescription(description);

		daoItem.save(myItem);
		return "redirect:/gestionItems";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/supprimerItem")
	public String supprimerItem(@RequestParam int id, Model model) {
		Item myItem = new Item();
		myItem.setId(id);

		daoItem.deleteById(id);
		return "redirect:/gestionItems";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/creerItem")
	public String creerItem(Model model) {
		model.addAttribute("items", daoItem.findAll());
		return "creerItem";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/creerItem")
	public String creerItem(@RequestParam String nom, @RequestParam int prix, @RequestParam int attaque,
			@RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse,
			@RequestParam String description, Model model) {
		Item myItem = new Item();

		myItem.setNom(nom);
		myItem.setPrix(prix);
		myItem.setAttaque(attaque);
		myItem.setDefense(defense);
		myItem.setEsquive(esquive);
		myItem.setVitesse(vitesse);
		myItem.setDescription(description);

		daoItem.save(myItem);
		return "redirect:/gestionItems";
	}

}
