package com.ichat.code.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ichat.code.beans.User;
import com.ichat.code.mapper.UserMapper;
import com.ichat.code.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@Resource
	private UserMapper um;


	@Override
	public User Login(String username, String password) {
		return um.login(username, password);
	}

}
