package cz.burios.ux.cancel.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("login");
		retVal.addObject("viewName", "Please Log In");

		return retVal;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView loginError() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("noAccess");
		retVal.addObject("viewName", "Access Denied");
		retVal.addObject("noAccessTitle", "Access Denied");
		retVal.addObject("noAccessMsg", "You don't have permission to access this page");

		return retVal;
	}

	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public ModelAndView logoutPage() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("login");
		retVal.addObject("viewName", "Logout Successfully");
		retVal.addObject("noAccessTitle", "Logout Successfully");
		retVal.addObject("noAccessMsg", "You have logged out successfully");

		return retVal;
	}
}
