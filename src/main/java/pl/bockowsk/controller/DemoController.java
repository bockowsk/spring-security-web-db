package pl.bockowsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	// add request do managers
	@GetMapping("/managers")
	public String showManagers() {
		return "managers";
	}
	
	@GetMapping("/admins")
	public String showAdmins() {
		return "admins";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}
