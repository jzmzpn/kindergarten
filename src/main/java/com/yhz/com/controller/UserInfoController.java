package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.dao.UserInfoMapper;
import com.yhz.com.model.UserInfo;
import com.yhz.com.service.UserInfoService;

/**
* Created by CodeGenerator on 2018/08/05.
*/
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    
    @Resource
    private UserInfoMapper userInfoMapper;
    
    @RequestMapping(value="/userjson", method=RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> query() {
        
        List<UserInfo> list = userInfoService.getUsers();
        
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", 100);
        return map;
    }
}
