package com.isi.mdl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.mdl.entities.User;

public interface UserRepository  extends JpaRepository<User,Long>{
	
	User findByEmailAndPasswordAndActiveTrue(String email, String password);
	boolean existsUserByEmail(String email);

}
