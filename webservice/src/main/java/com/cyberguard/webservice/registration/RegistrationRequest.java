package com.cyberguard.webservice.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
	private final String username;
	private final String password;
	
	public RegistrationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

}
