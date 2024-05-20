package com.isi.mdl.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.services.DossierCondidatService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class DossierCondidatRestController { 
	
	private DossierCondidatService  dossierCondidatService;
	
	@RequestMapping(value = "/SaveDossierCondidat", method = RequestMethod.POST)
	public ResponseEntity<?> SaveDossierCondidat(@RequestBody DossierCondidatDto dossierCondidatDto,@RequestParam(name = "email") String email ) {
	    try {
	    	DossierCondidatDto savedDossierCondidatDto = dossierCondidatService.saveDossierCondidat(dossierCondidatDto, email);
	    	log.info("Save Api Section"+savedDossierCondidatDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedDossierCondidatDto);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de l'enregistrement du Dossier Condidat.");
	    }
		
	}

}
