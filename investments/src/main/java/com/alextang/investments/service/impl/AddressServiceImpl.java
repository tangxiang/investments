package com.alextang.investments.service.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alextang.investments.entity.AddressEntity;
import com.alextang.investments.entity.ClientEntity;
import com.alextang.investments.model.AddressRequest;
import com.alextang.investments.model.AddressResponse;
import com.alextang.investments.repository.AddressRepository;
import com.alextang.investments.repository.ClientRepository;
import com.alextang.investments.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public AddressResponse createAddress(UUID clientId, AddressRequest addressRequest) {

		ClientEntity clientEntity = clientRepository.findByClientId(clientId);
		
		AddressEntity addressEntity = new AddressEntity();
		BeanUtils.copyProperties(addressRequest, addressEntity);
		addressEntity.setAddressId(UUID.randomUUID());
		addressEntity.setClient(clientEntity);
		
		AddressEntity returnAddress = addressRepository.save(addressEntity);
		
		AddressResponse addressResponse = new AddressResponse();
		
		BeanUtils.copyProperties(returnAddress, addressResponse);
				
		return addressResponse;
	}

}
