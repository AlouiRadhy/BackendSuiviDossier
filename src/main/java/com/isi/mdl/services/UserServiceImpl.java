package com.isi.mdl.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.User;
import com.isi.mdl.mappers.UserMapperImpl;
import com.isi.mdl.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	private UserMapperImpl dtoMapper;
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		log.info("Saving User");
		User user=dtoMapper.fromUserDto(userDto);
		User saveUser=userRepository.save(user);		
		return dtoMapper.fromUser(saveUser);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		log.info("Find User with " + " Login : "+ email +"  " + "Password : "+ password);
		User user=userRepository.findByEmailAndPassword(email, password);
		return user;
	}

}
