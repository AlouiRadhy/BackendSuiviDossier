package com.isi.mdl.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.User;

public interface UserService {

	UserDto saveUser(UserDto userDto);

	User findByEmailAndPassword(String email, String password);

	Optional<User> updateUserActiveStatus(Long userId, boolean status);
	
	boolean existsUserByEmail(String email);
}
