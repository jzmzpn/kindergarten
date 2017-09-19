package com.example.springcloudstudy.model.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.springcloudstudy.model.User;
import com.example.springcloudstudy.model.mapper.UserMapper;
import com.example.springcloudstudy.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
