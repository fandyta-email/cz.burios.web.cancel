package cz.burios.ux.cancel.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("index");
		retVal.addObject("userRole", "anonymous");
		retVal.addObject("pageName", "index");

		return retVal;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("index");
		retVal.addObject("userRole", "anonymous");
		retVal.addObject("pageName", "index");
		return retVal;
	}

	@PreAuthorize("hasRole('ROLE_SITE_ADMIN')")
	@RequestMapping(value = "/secure/testPage1", method = RequestMethod.GET)
	public ModelAndView testPage1() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("testPage1");
		retVal.addObject("userRole", "site admin");
		retVal.addObject("pageName", "testPage1");
		return retVal;
	}

	@PreAuthorize("hasRole('ROLE_SITE_STAFF')")
	@RequestMapping(value = "/secure/testPage2", method = RequestMethod.GET)
	public ModelAndView testPage2() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("testPage2");
		retVal.addObject("userRole", "site staff");
		retVal.addObject("pageName", "testPage2");
		return retVal;
	}

	@PreAuthorize("hasRole('ROLE_SITE_USER')")
	@RequestMapping(value = "/secure/testPage3", method = RequestMethod.GET)
	public ModelAndView testPage3() {
		ModelAndView retVal = new ModelAndView();
		retVal.setViewName("testPage3");
		retVal.addObject("userRole", "site user");
		retVal.addObject("pageName", "testPage3");
		return retVal;
	}
}
