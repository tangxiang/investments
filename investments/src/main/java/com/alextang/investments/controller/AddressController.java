package com.alextang.investments.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alextang.investments.model.AddressRequest;
import com.alextang.investments.model.AddressResponse;
import com.alextang.investments.service.AddressService;

@RestController
public class AddressController {
	
	
	@Autowired
	AddressService addressService;
	
	@PostMapping(path="client/{clientId}/address",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressResponse> createAddress(@PathVariable UUID clientId, @RequestBody AddressRequest addressRequest) {
		return new ResponseEntity<AddressResponse>(addressService.createAddress(clientId, addressRequest), HttpStatus.OK);
	}
	
}
