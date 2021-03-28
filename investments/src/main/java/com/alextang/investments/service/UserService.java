package com.alextang.investments.service;

import java.util.UUID;

import com.alextang.investments.model.UserRequest;
import com.alextang.investments.model.UserResponse;

public interface UserService {
	
	public UserResponse createUser(UserRequest userRequest);
	
	public UserResponse getUserByUserId(UUID userId);
	
	public UserResponse getUserByEmail(String email);
}
