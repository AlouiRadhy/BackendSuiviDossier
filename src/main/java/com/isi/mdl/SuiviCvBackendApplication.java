package com.isi.mdl;


import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.isi.mdl.entities.User;
import com.isi.mdl.enums.Profiles;
import com.isi.mdl.repositories.UserRepository;
import com.isi.mdl.services.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class SuiviCvBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuiviCvBackendApplication.class, args);
	}
	

	 /*@Bean
	    CommandLineRunner commandLineRunner(UserService userService
	                           ){
	        return args -> {
	            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
	                User user=new User();
	                user.setLogin(name);
	                user.setPassword(name);
	                user.setActive(true);
	                user.setDateCreation(new Date());
	                user.setProfile(Profiles.ADMIN);
	                userService.saveUser(user);
	            });
	        
	            User user1 =new User ();
	            
	            user1= userService.findByLoginAndPassword("Yassine", "Yassine");
	            log.info("Resultat Recherche Utilisateur 1 : "+user1.getLogin());
	        };
	        
	       
	        
	    }*/
	
	 @Bean
	    CommandLineRunner start(UserRepository userRepository
	                           ){
	        return args -> {
	            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
	                User user=new User();
	                user.setEmail(name);
	                user.setPassword(name);
	                user.setActive(true);
	                user.setDateCreation(new Date());
	                user.setProfile(Profiles.ADMIN);
	                userRepository.save(user);
	            });
	        
	            User user1 =new User ();
	            
	            user1= userRepository.findByEmailAndPassword("Yassine", "Yassine");
	            log.info("Resultat Recherche Utilisateur : "+user1.getEmail());
	        };
	        
	       
	        
	    }

}
