package com.cyberguard.webservice.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
	private  String username;
	private  String password;
	private int major;
	
	public RegistrationRequest(String username, String password, int major) {
		this.username = username;
		this.password = password;
		this.major = major;
	}
	public RegistrationRequest() {

	}

}
