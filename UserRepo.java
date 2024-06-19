package com.password.demo.userrepo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.password.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	

}
