package com.alextang.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alextang.investments.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{
	
	
}
