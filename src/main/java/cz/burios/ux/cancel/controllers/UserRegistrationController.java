package cz.burios.ux.cancel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class UserRegistrationController {

	@RequestMapping("/user_registration")
	public String defaultPage(Model model) {
		
		return "user_registration";
	}
}
