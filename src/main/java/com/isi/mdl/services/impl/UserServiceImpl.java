package com.isi.mdl.services.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.User;
import com.isi.mdl.mappers.UserMapperImpl;
import com.isi.mdl.repositories.UserRepository;
import com.isi.mdl.services.UserService;

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
		User user=userRepository.findByEmailAndPasswordAndActiveTrue(email, password);
		return user;
	}

    public Optional<User> updateUserActiveStatus(Long userId, boolean status) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setActive(status);
            userRepository.save(user);
        }
        return userOptional;
    }

	@Override
	public boolean existsUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsUserByEmail(email);
	}

}
