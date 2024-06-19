package com.password.demo.resetpasscontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.password.demo.userservice.UserService;

@RestController
@RequestMapping("/password")
public class ResetPassController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("password") String password) {
        userService.regsterUser(email, password);
        return "User registered successfully";
    }
	
	@PostMapping("/forgotpass")
	public void forgotPassword(@RequestParam("email") String email)
	{
		userService.initiatePasswordReset(email);
	}
	
	@GetMapping("/verify")
	public boolean verifyEmail(@RequestParam("email") String email,@RequestParam("token") String token)
	{
		return userService.verifyRestToken(email, token);
	}
	
	@PostMapping("/reset")
	public String resetpassword(@RequestParam("email") String email,@RequestParam("newPass") String newPass)
	{
		userService.resetPassword(email, newPass);
		
		return "password reset success";
		
	}
}
