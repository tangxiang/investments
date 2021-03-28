package com.alextang.investments.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class ClientRequest {
	
	private String lastName;
	
	private String firstName;
	
	private String telNum;
	
	private Set<AddressRequest> addresses;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public Set<AddressRequest> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<AddressRequest> addresses) {
		this.addresses = addresses;
	}
}
