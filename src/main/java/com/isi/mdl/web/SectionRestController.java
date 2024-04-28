package com.isi.mdl.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.Section;
import com.isi.mdl.entities.User;
import com.isi.mdl.services.SectionService;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class SectionRestController {
	
	private SectionService sectionService;
	
	@RequestMapping(value = "/SaveSection", method = RequestMethod.POST)
	public ResponseEntity<?> saveSection(@RequestBody SectionDto sectionDto) {
	    try {
	    	SectionDto savedSectionDto = sectionService.saveSection(sectionDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(sectionDto);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de l'enregistrement de la Section.");
	    }
		
	}
	
	
	@RequestMapping(value = "/getAllSection", method = RequestMethod.GET)
	public List<Section> getAllSection() {
		return sectionService.getAllSection();
	}
	
	
	//@RequestMapping(value="/UpdateSection", method= RequestMethod.PUT)
	@PutMapping("/UpdateSection/{codeSection}")
    public ResponseEntity<?> updateSection(@PathVariable (name = "codeSection") String codeSection, @RequestBody SectionDto sectionDto ) {
        java.util.Optional<Section> userOptional = sectionService.updateSection(sectionDto, codeSection);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok("Section updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
