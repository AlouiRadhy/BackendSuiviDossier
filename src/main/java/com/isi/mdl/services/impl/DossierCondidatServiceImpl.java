package com.isi.mdl.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.entities.DossierCondidat;
import com.isi.mdl.mappers.DossierCondidatMapperImpl;
import com.isi.mdl.mappers.SectionMapperImpl;
import com.isi.mdl.repositories.DossierCondidatRepository;
import com.isi.mdl.repositories.SectionRepository;
import com.isi.mdl.services.DossierCondidatService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DossierCondidatServiceImpl implements DossierCondidatService {

	private  DossierCondidatRepository  dossierCondidatRepository;
	private  DossierCondidatMapperImpl      dtoMapperDossier;
	
	
	@Override
	public DossierCondidatDto saveDossierCondidat(DossierCondidatDto dossierCondidatDto) {
		log.info("Save DossierCondidat");
		DossierCondidat dossierCondidat =dtoMapperDossier.fromDossierCondidatDto(dossierCondidatDto);
		DossierCondidat  dossierCondidatSave=dossierCondidatRepository.save(dossierCondidat);
		return dtoMapperDossier.fromDossierCondidat(dossierCondidat);
	}

	@Override
	public Optional<DossierCondidatDto> update(DossierCondidatDto dossierCondidatDto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<DossierCondidat> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
