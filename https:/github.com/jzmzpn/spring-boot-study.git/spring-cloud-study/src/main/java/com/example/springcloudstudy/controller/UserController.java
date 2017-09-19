package com.example.springcloudstudy.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloudstudy.model.User;
import com.example.springcloudstudy.model.service.UserService;

@RestController("userController")
@RequestMapping("user")
public class UserController {

	@Resource
	private UserService userService;
	
	@GetMapping("{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.findById(id);
	}
}
