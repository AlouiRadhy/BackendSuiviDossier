package com.isi.mdl.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.LangueDto;
import com.isi.mdl.entities.Langue;
import com.isi.mdl.entities.Langue;
import com.isi.mdl.exceptions.EntiteNotFoundException;
import com.isi.mdl.mappers.LangueMapperImpl;
import com.isi.mdl.mappers.LangueMapperImpl;
import com.isi.mdl.repositories.LangueRepository;
import com.isi.mdl.repositories.LangueRepository;
import com.isi.mdl.services.LangueService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class LangueServiceImpl implements LangueService {
	
	private LangueRepository langueRepository ;
	private LangueMapperImpl langueMapper;
	
	@Override
	public LangueDto saveLangue(LangueDto langueDto) {
		log.info("Save Langue");
		Langue langue = langueMapper.fromLangueDto(langueDto);
		Langue saveLangue = langueRepository.save(langue);
		return langueMapper.fromLangue(saveLangue);
	}

	@Override
	public List<Langue> getAllLangue() {
		// TODO Auto-generated method stub
		return langueRepository.findAll();
	}

	@Override
	public Langue findLangueByCode(String codeLangue) {
		return langueRepository.getLangueByCodeLangue(codeLangue)
				.orElseThrow(() -> new EntiteNotFoundException("Langue not found with code: " + codeLangue));
	}
	

	@Override
	public Optional<Langue> updateLangue(LangueDto langueDto, String codeLangue) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
