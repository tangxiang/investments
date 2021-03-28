package com.alextang.investments.service;

import java.util.UUID;

import com.alextang.investments.model.AddressRequest;
import com.alextang.investments.model.AddressResponse;

public interface AddressService {
	AddressResponse createAddress(UUID clientId, AddressRequest addressRequest);
}
