package com.alextang.investments.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alextang.investments.model.ClientRequest;
import com.alextang.investments.model.ClientResponse;
import com.alextang.investments.model.UserRequest;
import com.alextang.investments.model.UserResponse;
import com.alextang.investments.service.ClientService;
import com.alextang.investments.service.UserService;


@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ClientService clientService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@RequestBody UserRequest user){
		
		return userService.createUser(user);
	}
	
	@GetMapping(path="/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable UUID userId) {
		
		UserResponse user = userService.getUserByUserId(userId);
		return new ResponseEntity<UserResponse>(user,HttpStatus.OK);
	}
	
	@GetMapping(path="/email/{email}")
	public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
		
		UserResponse user = userService.getUserByEmail(email);
		
		return new ResponseEntity<UserResponse>(user,HttpStatus.OK);
	}
	
	@PostMapping(path="/{userId}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse createClient(@PathVariable UUID userId, @RequestBody ClientRequest clientRequest){
		
		return clientService.createClient(userId, clientRequest);
	}
	
}
