package com.isi.mdl.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isi.mdl.dto.LangueDto;
import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.Langue;
import com.isi.mdl.entities.Section;
import com.isi.mdl.services.LangueService;
import com.isi.mdl.services.SectionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class LangueRestController {

	
	private LangueService langueService;
	
	@RequestMapping(value = "/SaveLangue", method = RequestMethod.POST)
	public ResponseEntity<?> saveSection(@RequestBody LangueDto langueDto) {
	    try {
	    	LangueDto savedLangueDto = langueService.saveLangue(langueDto);
	    	log.info("Save Api Section"+savedLangueDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedLangueDto);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de l'enregistrement de la Langue.");
	    }
		
	}
	
	
	@RequestMapping(value = "/getAllLangue", method = RequestMethod.GET)
	public List<Langue> getAllLangue() {
		return langueService.getAllLangue();
	}
	
	
	
	@PutMapping("/UpdateSection/{codeLangue}")
    public ResponseEntity<?> updateLangue(@PathVariable (name = "codeLangue") String codeLangue, @RequestBody LangueDto langueDto ) {
        java.util.Optional<Langue> langueOptional = langueService.updateLangue(langueDto, codeLangue);
        if (langueOptional.isPresent()) {
            return ResponseEntity.ok("Section updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
