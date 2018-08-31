package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramon.dao.IDAOItem;
import sopramonbis.model.Item;

@Controller
public class ItemContoller {

	@Autowired
	private IDAOItem daoItem;

	@GetMapping("/gestionItems")
	public String listerItem(Model model) {
		model.addAttribute("items", daoItem.findAll());
		return "gestionItems";
	}

	@GetMapping("/modifierItem")
	public String modifierItem(@RequestParam int id, Model model) {
		model.addAttribute("item", daoItem.findById(id).get());
		return "modifierItem";
	}

	@PostMapping("/modifierItem")
	public String modifierItem(@RequestParam String nom, @RequestParam double prix, @RequestParam int attaque,
			@RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse, @RequestParam int id,
			Model model) {
		Item myItem = new Item();

		myItem.setId(id);
		myItem.setNom(nom);
		myItem.setAttaque(attaque);
		myItem.setDefense(defense);
		myItem.setEsquive(esquive);
		myItem.setVitesse(vitesse);

		daoItem.save(myItem);
		return "redirect:/gestionItems";
	}

	@GetMapping("/supprimerItem")
	public String supprimerItem(@RequestParam int id, Model model) {
		Item myItem = new Item();
		myItem.setId(id);

		daoItem.deleteById(id);
		return "redirect:/gestionItems";
	}

	@GetMapping("/creerItem")
	public String creerItem(Model model) {
		model.addAttribute("items", daoItem.findAll());
	return "creerItem";
	}

	@PostMapping("/creerItem")
	public String creerItem(@RequestParam String nom, @RequestParam double prix, @RequestParam int attaque, @RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse,
			Model model) {
		Item myItem = new Item();
		
		myItem.setNom(nom);
		myItem.setAttaque(attaque);
		myItem.setDefense(defense);
		myItem.setEsquive(esquive);
		myItem.setVitesse(vitesse);
		
		daoItem.save(myItem);
		return "redirect:/gestionItems";
	}

}
