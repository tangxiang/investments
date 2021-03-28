package com.alextang.investments.service.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alextang.investments.entity.UserEntity;
import com.alextang.investments.model.UserRequest;
import com.alextang.investments.model.UserResponse;
import com.alextang.investments.repository.UserRepository;
import com.alextang.investments.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponse createUser(UserRequest userRequest) {
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(userRequest, userEntity);
		
		userEntity.setUserId(UUID.randomUUID());
		
		UserEntity returnUser = userRepository.save(userEntity);
		
		UserResponse userResponse = new UserResponse();
		
		BeanUtils.copyProperties(returnUser, userResponse);
		
		return userResponse;
	}

	@Override
	public UserResponse getUserByUserId(UUID userId) {
		UserEntity returnUser = userRepository.findUserByUserId(userId);
		UserResponse userResponse = new UserResponse();
		
		BeanUtils.copyProperties(returnUser, userResponse);
		
		return userResponse;
	}

	@Override
	public UserResponse getUserByEmail(String email) {
		UserEntity returnUser = userRepository.findUserByEmail(email);
		UserResponse userResponse = new UserResponse();
		
		BeanUtils.copyProperties(returnUser, userResponse);
		
		return userResponse;
	}

}
