package com.cyberguard.webservice.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/registration")
public class RegistrationController {
	
	
	private RegistrationService registrationService;
	
	

	
	
	@PostMapping
<<<<<<< HEAD
	@GetMapping
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
=======
	public @ResponseBody void register(@RequestParam("username") String username, @RequestParam("password") String password) {
>>>>>>> parent of 822a7d8 (allow major on registration)
		RegistrationRequest request = new RegistrationRequest(username, password);
		registrationService.register(request);
		
		
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
