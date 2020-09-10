package sudhi.thymeleaf.emplooyee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/LoginPage")
	public String loginpage() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String accessdenied() {
		return "access-denied";
	}
}
