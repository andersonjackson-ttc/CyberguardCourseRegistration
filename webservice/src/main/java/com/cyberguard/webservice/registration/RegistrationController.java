package com.cyberguard.webservice.registration;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/registration")
public class RegistrationController {
	
	
	private RegistrationService registrationService;
	
	

	
	
	@PostMapping
	public @ResponseBody void register(@RequestParam("username") String username, @RequestParam("password") String password) {
		RegistrationRequest request = new RegistrationRequest(username, password);
		registrationService.register(request);
		
		

}
	
	@GetMapping
	public String viewSuccessPage() {
		return "success";
	}
//	public String register(@RequestBody RegistrationRequest request) {
//        System.out.println("coming in controller    " +request.toString());  
//        return "success";
//	}
	
	
	
	

	
	
//	public String register(@RequestBody RegistrationRequest request) {
//		return registrationService.register(request);
//	}

//	public String register(@PathVariable("username") String username, @PathVariable("password") String password) {
//
//		   RegistrationRequest request = new RegistrationRequest(username, password);
//		    return registrationService.register(request);
//		}


}
