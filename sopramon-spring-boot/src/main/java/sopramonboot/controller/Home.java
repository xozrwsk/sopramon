package sopramonboot.controller;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Home {
@RequestMapping("/home")
public String home(@RequestParam(value="username", required=false) String username, Model model) {
model.addAttribute("utilisateur", username);
return "home";
}

@GetMapping("/login")
public String login() {
return "login";
}



	
}



