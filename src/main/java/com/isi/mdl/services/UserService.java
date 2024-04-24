package com.isi.mdl.services;

import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.User;

public interface UserService {

	UserDto saveUser(UserDto userDto);
	User findByEmailAndPassword(String email, String password);
}
