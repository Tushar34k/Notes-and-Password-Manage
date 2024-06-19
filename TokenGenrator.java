package com.password.demo.tokengenrator;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenrator {
	
	private static final SecureRandom securerandome=new SecureRandom();
	
	
	public static String generateToken() {
        byte[] token = new byte[16];
        securerandome.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

}
