package com.alextang.investments.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alextang.investments.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findUserByEmail(String email);
	
	UserEntity findUserByUserId(UUID userId);
}
