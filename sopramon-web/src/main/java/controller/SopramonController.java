package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sopramon.dao.IDAOSopramon;

@Controller
public class SopramonController {
	
	@Autowired
	private IDAOSopramon daoSopramon;
	
	@GetMapping("/listeSopramon")
	public String listerProd(Model model) {
		model.addAttribute("sopramons", daoSopramon.findAll());
	return "listeSopramon";
	}

}
