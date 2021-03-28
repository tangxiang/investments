package com.alextang.investments.service;

import java.util.List;
import java.util.UUID;

import com.alextang.investments.model.ClientRequest;
import com.alextang.investments.model.ClientResponse;

public interface ClientService {
	ClientResponse createClient(UUID userId, ClientRequest clientRequest);
	List<ClientResponse> getAllClients();
	ClientResponse getClientByClientId(UUID clientId);
	List<ClientResponse> getPagedClients(int pageNo, int pageSize);
	List<ClientResponse> getSortedClients();
	List<ClientResponse> searchByLastName(String lastName);
	List<ClientResponse> searchByNames(String name);
	
}
