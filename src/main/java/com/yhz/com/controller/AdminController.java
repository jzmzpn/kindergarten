package com.yhz.com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yhz.com.model.KAdmin;
import com.yhz.com.service.KAdminService;

@Controller
public class AdminController {
	
	@Resource(name = "kAdminService")
	private KAdminService kAdminService;
	
	@RequestMapping("index")
	public String test(HttpServletRequest request) {
		Object attribute = request.getSession().getAttribute("user");
		if(attribute == null) {
			return "/page-login";
		}
		return "/index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, String userName, String password) {
		KAdmin user = kAdminService.getUserByName(userName);
		if(user != null && "123456".equals(password)) {
			request.getSession().setAttribute("user", userName);
			return "redirect:/index";
		}
		return "/page-login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String index(String username, String password) {
		KAdmin user = kAdminService.getUserByName(username);
		if(user != null && "123456".equals(password)) {
			return "/index";
		}
		return "/page-login";
	}
	

}
