package cz.burios.ux.cancel.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cz.burios.ux.cancel.jdbc.UsersRowMapper;
import cz.burios.ux.cancel.model.UserCredentials;

@Controller
public class LoginController {

	@Autowired DataSource ds;
	
	@GetMapping(value = {"/", "/login"})
	public ModelAndView getLoginPage(Model model) {
		System.out.println("LoginController.getLoginPage()");
		ModelAndView view = new ModelAndView("login");		
		try {
			view.addObject("error", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	@GetMapping(value = {"/login?err={error}"})
	public ModelAndView getLoginErrorPage(@RequestParam("error") String error, Model model) {
		System.out.println("LoginController.getLoginErrorPage()");
		ModelAndView view = new ModelAndView("/login");		
		try {
			view.addObject("errcode", error);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	@PostMapping("/login")
	public ModelAndView doLoginAuth(@RequestParam Map<String,String> qp, Model model) throws Exception {
		System.out.println("LoginController.doLoginAuth()");
		ModelAndView view = new ModelAndView("login");
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
			String userName = qp.getOrDefault("username", "");
			String password = qp.getOrDefault("password", "");
			final String query = "SELECT * FROM user_credentials WHERE USER_NAME = ? AND USER_PASSWORD = ?";
			List<UserCredentials> data = jdbcTemplate.queryForStream(query, new UsersRowMapper(), userName, password).collect(Collectors.toList());
			System.out.println("data: " + data);
			if (data == null || data.isEmpty()) {
				view.addObject("errcode", "ERR_403");
				view.setViewName("login") ;
			} else {
				view.setViewName("p/desktop");
			}
		} catch (Exception e) {
			e.printStackTrace();
			view.addObject("errcode", "ERR_403");
			view.setViewName("login") ;
		}
		return view;
	}
	
	@GetMapping(value = {"/logout"})
	public ModelAndView getLogoutPage(Model model) {
		System.out.println("LoginController.getLogoutPage()");
		ModelAndView view = new ModelAndView("login");		
		try {
			view.addObject("errcode", "ERR_LOGOUT");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}
}