package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.CompetenceDto;
import com.isi.mdl.entities.Competence;


@Service
public class CompetenceMapperImpl {

	public CompetenceDto fromCompetence (Competence competence) {
		CompetenceDto competenceDto = new CompetenceDto();
	    BeanUtils.copyProperties(competence, competenceDto);
	    return competenceDto;
	}
	
	public Competence fromCompetenceDto (CompetenceDto competenceDto) {
		Competence competence = new Competence();
		BeanUtils.copyProperties(competenceDto,competence);
		return competence;
	}
}
