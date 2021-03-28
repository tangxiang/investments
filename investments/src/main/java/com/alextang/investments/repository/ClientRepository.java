package com.alextang.investments.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alextang.investments.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>, JpaSpecificationExecutor<ClientEntity>{
	List<ClientEntity> findByLastName(String lastName);
	ClientEntity findByClientId(UUID clientId);
}
