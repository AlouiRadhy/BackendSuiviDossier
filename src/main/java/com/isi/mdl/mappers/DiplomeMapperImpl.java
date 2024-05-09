package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.DiplomeDto;
import com.isi.mdl.entities.Diplome;



@Service
public class DiplomeMapperImpl {

	
	public DiplomeDto fromDiplome (Diplome diplome) {
		DiplomeDto diplomeDto = new DiplomeDto();
	    BeanUtils.copyProperties(diplome, diplomeDto);
	    return diplomeDto;
	}
	
	public Diplome fromDiplomeDto (DiplomeDto diplomeDto) {
		Diplome diplome = new Diplome();
		BeanUtils.copyProperties(diplomeDto,diplome);
		return diplome;
	}
}
