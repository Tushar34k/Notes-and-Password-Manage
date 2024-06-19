package com.password.demo.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.password.demo.entity.User;
import com.password.demo.tokengenrator.TokenGenrator;
import com.password.demo.userrepo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    
    
    public void regsterUser(String email,String password)
    {
    	if(userRepo.existsByEmail(email))
    	{
    		throw new IllegalArgumentException("this is email is alredy register!!!!");
    	}
    	
    	
    		User user=new User(email,password);
    	userRepo.save(user);
    }

    public void initiatePasswordReset(String email) {
        User user = userRepo.findByEmail(email);

        if (user != null) {
            String token = TokenGenrator.generateToken(); // Generate a new token
            user.setResetToken(token); // Set the reset token to the user
            userRepo.save(user); // Save the user with the updated token
        }
    }

    public boolean verifyRestToken(String email, String token) {
        User user = userRepo.findByEmail(email);
        return user != null && token.equals(user.getResetToken());
    }

    public void resetPassword(String email, String newPassword) {
        User user = userRepo.findByEmail(email);
        user.setPassword(newPassword);
        userRepo.save(user);
    }
}

	


