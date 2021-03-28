package com.alextang.investments.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alextang.investments.entity.AddressEntity;
import com.alextang.investments.entity.ClientEntity;
import com.alextang.investments.entity.UserEntity;
import com.alextang.investments.model.AddressRequest;
import com.alextang.investments.model.ClientRequest;
import com.alextang.investments.model.ClientResponse;
import com.alextang.investments.repository.ClientRepository;
import com.alextang.investments.repository.UserRepository;
import com.alextang.investments.repository.specification.ClientSpecification;
import com.alextang.investments.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ClientResponse createClient(UUID userId, ClientRequest clientRequest) {
		
		UserEntity userEntity = userRepository.findUserByUserId(userId);
		
		ClientEntity clientEntity = new ClientEntity();
		
		BeanUtils.copyProperties(clientRequest, clientEntity);
		
		Set<AddressRequest> addresses = clientRequest.getAddresses();
		
		Set<AddressEntity> addressSet = new HashSet<AddressEntity>();
		
		
		if (addresses != null) {
			for (AddressRequest addressRequest : addresses) {
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setAddressId(UUID.randomUUID());
				BeanUtils.copyProperties(addressRequest, addressEntity);
				addressEntity.setClient(clientEntity);
				addressSet.add(addressEntity);
			}
			
			clientEntity.setAddresses(addressSet);
		}

		clientEntity.setClientId(UUID.randomUUID());
		clientEntity.setUser(userEntity);
		
		ClientEntity returnClient = clientRepository.save(clientEntity);
		
		ClientResponse clientResponse = new ClientResponse();
		
		BeanUtils.copyProperties(returnClient, clientResponse);

		return clientResponse;
	}

	@Override
	public List<ClientResponse> getAllClients() {
		List<ClientEntity> clientList = clientRepository.findAll();
		
		List<ClientResponse> clientResponseList= new ArrayList<ClientResponse>();
		
		for(ClientEntity client : clientList) {
			ClientResponse clientResponse = new ClientResponse();
			BeanUtils.copyProperties(client, clientResponse);
			clientResponseList.add(clientResponse);
		}
		
		return clientResponseList;
	}

	@Override
	public List<ClientResponse> getPagedClients(int pageNo, int pageSize) {
		
		List<ClientEntity> clientList = clientRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();
		
		List<ClientResponse> clientResponseList= new ArrayList<ClientResponse>();
		
		for(ClientEntity client : clientList) {
			ClientResponse clientResponse = new ClientResponse();
			BeanUtils.copyProperties(client, clientResponse);
			clientResponseList.add(clientResponse);
		}
		
		return clientResponseList;
	}

	@Override
	public List<ClientResponse> getSortedClients() {
		List<ClientEntity> clientList = clientRepository.findAll(Sort.by(Sort.Direction.DESC, "lastName"));
		
		List<ClientResponse> clientResponseList= new ArrayList<ClientResponse>();
		
		for(ClientEntity client : clientList) {
			ClientResponse clientResponse = new ClientResponse();
			BeanUtils.copyProperties(client, clientResponse);
			clientResponseList.add(clientResponse);
		}
		
		return clientResponseList;
	}

	@Override
	public List<ClientResponse> searchByLastName(String lastName) {

		List<ClientEntity> clientList = clientRepository.findByLastName(lastName);
		
		List<ClientResponse> clientResponseList= new ArrayList<ClientResponse>();
		
		for(ClientEntity client : clientList) {
			ClientResponse clientResponse = new ClientResponse();
			BeanUtils.copyProperties(client, clientResponse);
			clientResponseList.add(clientResponse);
		}
		
		return clientResponseList;
	}

	@Override
	public List<ClientResponse> searchByNames(String name) {

		List<ClientEntity> clientList = clientRepository.findAll(ClientSpecification.firstNameContainsIgnoreCase(name).or(ClientSpecification.lastNameContainsIgnoreCase(name)));
		
		List<ClientResponse> clientResponseList= new ArrayList<ClientResponse>();
		
		for(ClientEntity client : clientList) {
			ClientResponse clientResponse = new ClientResponse();
			BeanUtils.copyProperties(client, clientResponse);
			clientResponseList.add(clientResponse);
		}
		
		return clientResponseList;
	}

	@Override
	public ClientResponse getClientByClientId(UUID clientId) {
		ClientEntity clientEntity = clientRepository.findByClientId(clientId);
		
		ClientResponse clientResponse = new ClientResponse();
		BeanUtils.copyProperties(clientEntity, clientResponse);
		
		return clientResponse;
	}
}
