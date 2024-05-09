package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import com.isi.mdl.dto.LangueDto;
import com.isi.mdl.entities.Langue;

@Service
public class LangueMapperImpl {

	public LangueDto fromLangue (Langue langue) {
		LangueDto langueDto = new LangueDto();
	    BeanUtils.copyProperties(langue, langueDto);
	    return langueDto;
	}
	
	public Langue fromLangueDto (LangueDto adressDto) {
		Langue langue = new Langue();
		BeanUtils.copyProperties(adressDto,langue);
		return langue;
	}
	
}
