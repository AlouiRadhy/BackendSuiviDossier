package com.isi.mdl.services.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import com.isi.mdl.dto.CertificatProfissionalDto;
import com.isi.mdl.dto.CompetenceDto;
import com.isi.mdl.dto.DiplomeDto;
import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.dto.LoisirDto;
import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.CertificatProfissional;
import com.isi.mdl.entities.Competence;
import com.isi.mdl.entities.Diplome;
import com.isi.mdl.entities.DossierCondidat;
import com.isi.mdl.entities.Loisir;
import com.isi.mdl.entities.User;
import com.isi.mdl.mappers.CertificatProfissionalMapperImpl;
import com.isi.mdl.mappers.CompetenceMapperImpl;
import com.isi.mdl.mappers.DiplomeMapperImpl;
import com.isi.mdl.mappers.DossierCondidatMapperImpl;
import com.isi.mdl.mappers.LoisirDtoMapperImpl;
import com.isi.mdl.mappers.SectionMapperImpl;
import com.isi.mdl.mappers.UserMapperImpl;
import com.isi.mdl.repositories.DossierCondidatRepository;
import com.isi.mdl.repositories.SectionRepository;
import com.isi.mdl.repositories.UserRepository;
import com.isi.mdl.services.DossierCondidatService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DossierCondidatServiceImpl implements DossierCondidatService {

	private DossierCondidatRepository dossierCondidatRepository;
	private DossierCondidatMapperImpl dtoMapperDossier;
	private LoisirDtoMapperImpl loisirDtoMapper;
	private DiplomeMapperImpl diplomeMapper;
	private CertificatProfissionalMapperImpl certificatProfissionalMapper;
	private CompetenceMapperImpl competenceMapper;
	private UserRepository userRepository;
	private UserMapperImpl userMapper;

	@Override
	public DossierCondidatDto saveDossierCondidat(DossierCondidatDto dossierCondidatDto, String emailUser) {
		log.info("Save DossierCondidat");
		// User user=userRepository.findByEmail(emailUser);
		// if (user!=null) {
		// UserDto userSave=userMapper.fromUser(user);
		// dossierCondidatDto.setUser(userSave);
		// }
		DossierCondidat dossierCondidat = dtoMapperDossier.fromDossierCondidatDto(dossierCondidatDto);
		log.info("Save DossierCondidat Test " + dossierCondidat);
	
			DossierCondidat dossierCondidatSave = dossierCondidatRepository.save(dossierCondidat);
	
	
		log.info("Test 2");
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
