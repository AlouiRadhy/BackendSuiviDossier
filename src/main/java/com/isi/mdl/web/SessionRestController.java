package com.isi.mdl.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isi.mdl.dto.SessionDto;
import com.isi.mdl.entities.Session;
import com.isi.mdl.services.SessionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class SessionRestController {
	
	private SessionService sessionService;
	
	
	@RequestMapping(value = "/SaveSession", method = RequestMethod.POST)
	public ResponseEntity<?> saveSession(@RequestBody SessionDto sessionDto) {
	    try {
	    	SessionDto savedSessionDto = sessionService.saveSession(sessionDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedSessionDto);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de l'enregistrement de la Session.");
	    }
		
	}
	
	@RequestMapping(value = "/getAllSession", method = RequestMethod.GET)
	public List<SessionDto> getAllSession() {
		return sessionService.getAllSession();
	}
	
    @DeleteMapping("/Session/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
    	 try {
    		 sessionService.deleteSession(id);
    	return ResponseEntity.ok("Session deleted successfully.");
    	 }
    	 catch (Exception e) {
 	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de  supression de la session.");
 	    }
    }
    

}
