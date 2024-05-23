package com.isi.mdl.services;

import java.util.List;
import java.util.Optional;

import com.isi.mdl.dto.LangueDto;
import com.isi.mdl.entities.Langue;



public interface LangueService {

	
LangueDto  saveLangue (LangueDto langueDto);
	
	List<Langue> getAllLangue();
	
	Langue findLangueByCode(String codeLangue);
	
	Optional<Langue> updateLangue (LangueDto langueDto, String codeLangue);
}
