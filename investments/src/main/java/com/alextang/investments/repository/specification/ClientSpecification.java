package com.alextang.investments.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import com.alextang.investments.entity.ClientEntity;

public class ClientSpecification {

	public static Specification<ClientEntity> lastNameContainsIgnoreCase(String name) {
		return (root, query, builder) -> {
			return builder.like(root.get("lastName"), "%"+ name + "%");
		};
	}
	
	public static Specification<ClientEntity> firstNameContainsIgnoreCase(String name) {
		return (root, query, builder) -> {
			return builder.like(root.get("firstName"), "%" + name + "%");
		};
	}
}
