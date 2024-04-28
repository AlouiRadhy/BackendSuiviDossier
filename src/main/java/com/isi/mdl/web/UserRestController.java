package com.isi.mdl.web;

import java.util.ArrayList;

import org.apache.el.stream.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.User;
import com.isi.mdl.services.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class UserRestController {

	private UserService userService;
	
	@GetMapping("/loginUser")
	public ResponseEntity<?> user(@RequestParam(name = "email") String email,
	        @RequestParam(name = "password") String password) {
	    User user = userService.findByEmailAndPassword(email, password);
	    if (user != null) {
	        return ResponseEntity.ok(user);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email ou mot de passe incorrect.");
	    }
	}

	@RequestMapping(value = "/SaveUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
		 boolean existUser =userService.existsUserByEmail(userDto.getEmail());
		
		 log.info("userService.existsUserByEmail "+existUser);
		 if(!existUser) {
	    try {
	        UserDto savedUserDto = userService.saveUser(userDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDto);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de l'enregistrement de l'utilisateur.");
	    }
		 }
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("adresse mail existe deja");
	}
	
	@RequestMapping(value="/UpdateUser", method= RequestMethod.PUT)
	    public ResponseEntity<?> updateUserActiveStatus(@RequestParam (name = "userId") Long userId, @RequestParam  (name = "statut")boolean  active) {
	        java.util.Optional<User> userOptional = userService.updateUserActiveStatus(userId, active);
	        if (userOptional.isPresent()) {
	            return ResponseEntity.ok("User active status updated successfully.");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }


	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> handleSpecificException(Exception ex) {
	    return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
