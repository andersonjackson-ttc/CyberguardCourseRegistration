package com.cyberguard.webservice.registration;


import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class RegistrationController {
	
	
	private RegistrationService registrationService;
	
	
	@PostMapping
  public
  @ResponseBody
  String authenticate(@PathVariable("username") String username,
                              @RequestBody MultiValueMap paramMap)
          throws Exception {


      if(paramMap == null || paramMap.get("password") == null) {
          throw new IllegalArgumentException("Password not provided");
      }
      return registrationService.register(new RegistrationRequest (username, paramMap.get("password").toString()));
}
	
	
//	public String register(@RequestBody RegistrationRequest request) {
//		return registrationService.register(request);
//	}

//	public String register(@PathVariable("username") String username, @PathVariable("password") String password) {
//
//		   RegistrationRequest request = new RegistrationRequest(username, password);
//		    return registrationService.register(request);
//		}


}
