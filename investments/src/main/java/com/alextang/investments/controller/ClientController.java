package com.alextang.investments.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.alextang.investments.model.ClientResponse;
import com.alextang.investments.service.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<ClientResponse>> getAllClients() {
		return new ResponseEntity<List<ClientResponse>>(clientService.getAllClients(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{clientId}")
	public ResponseEntity<ClientResponse> getClientByClientId(@PathVariable UUID clientId) {
		return new ResponseEntity<ClientResponse>(clientService.getClientByClientId(clientId), HttpStatus.OK);
	}
	
	@GetMapping(value="/paged")
	public ResponseEntity<List<ClientResponse>> getPagedClients(@RequestParam int pageNo, @RequestParam int pageSize) {
		return new ResponseEntity<List<ClientResponse>>(clientService.getPagedClients(pageNo, pageSize), HttpStatus.OK);
	}
	
	@GetMapping(value="/sort")
	public ResponseEntity<List<ClientResponse>> getSortedClients() {
		return new ResponseEntity<List<ClientResponse>>(clientService.getSortedClients(), HttpStatus.OK);
	}
	
	@GetMapping(value="/lastName/{lastName}")
	public ResponseEntity<List<ClientResponse>> searchByLastName(@PathVariable String lastName) {
		return new ResponseEntity<List<ClientResponse>>(clientService.searchByLastName(lastName), HttpStatus.OK);
	}
	
	@GetMapping(value="/name/{name}")
	public ResponseEntity<List<ClientResponse>> searchByNames(@PathVariable String name) {
		return new ResponseEntity<List<ClientResponse>>(clientService.searchByNames(name), HttpStatus.OK);
	}
	
}
