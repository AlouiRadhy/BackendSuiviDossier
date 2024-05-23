package com.isi.mdl.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.AdressDto;
import com.isi.mdl.dto.CertificatProfissionalDto;
import com.isi.mdl.dto.CompetenceDto;
import com.isi.mdl.dto.DiplomeDto;
import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.dto.LoisirDto;
import com.isi.mdl.dto.UserDto;
import com.isi.mdl.entities.Adress;
import com.isi.mdl.entities.CertificatProfissional;
import com.isi.mdl.entities.Competence;
import com.isi.mdl.entities.Diplome;
import com.isi.mdl.entities.DossierCondidat;
import com.isi.mdl.entities.Loisir;
import com.isi.mdl.entities.User;
import com.isi.mdl.web.DossierCondidatRestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DossierCondidatMapperImpl {
	
	@Autowired
	private CompetenceMapperImpl  competenceMapper; 
	@Autowired
	private DiplomeMapperImpl  diplomeMapper;
	@Autowired
	private CertificatProfissionalMapperImpl certificatProfissionalMapper;
	@Autowired
	private LoisirDtoMapperImpl loisirDtoMapper;
	
	@Autowired
	private AdressMapperImpl adressMapper;
	
	@Autowired
	private  UserMapperImpl userMapper;
	
	
	
	public DossierCondidatDto fromDossierCondidat (DossierCondidat dossierCondidat) {
		DossierCondidatDto dossierCondidatDto = new DossierCondidatDto();
		log.info("1");
	    List<CompetenceDto> competenceDtp=dossierCondidat.getCompetences()
	    		.stream()
			    .map(competenceMapper::fromCompetence)
			    .collect(Collectors.toList());
	    List<DiplomeDto> DiplomeDtp=dossierCondidat.getDiplomes()
	    		.stream()
			    .map(diplomeMapper::fromDiplome)
			    .collect(Collectors.toList());
	    		
	    List<CertificatProfissionalDto> certificatDtp=dossierCondidat.getCertificatProfissional()
	    		.stream()
			    .map(certificatProfissionalMapper::fromCertificatProfissional)
			    .collect(Collectors.toList());
	    List<LoisirDto>loisDtp=dossierCondidat.getLoisirs()
	    		.stream()
			    .map(loisirDtoMapper::fromLoisir)
			    .collect(Collectors.toList());
	    log.info("5");
	    AdressDto adressDtp=adressMapper.fromAdress(dossierCondidat.getAdress());
	    
	   // UserDto userDtp=userMapper.fromUser(dossierCondidat.getUser());
	    
			    dossierCondidatDto.setCompetences(competenceDtp); 
			    dossierCondidatDto.setDiplomes(DiplomeDtp);
			    dossierCondidatDto.setCertificatProfissionals(certificatDtp);
			    dossierCondidatDto.setLoisirs(loisDtp);
			    dossierCondidatDto.setAdress(adressDtp);
			    log.info("tesssssssssssss");
			   // dossierCondidatDto.setUser(userDtp);
			    BeanUtils.copyProperties(dossierCondidat, dossierCondidatDto);
	    return dossierCondidatDto;
	}
	
	public DossierCondidat fromDossierCondidatDto (DossierCondidatDto dossierCondidatDto) {
		DossierCondidat dossierCondidat = new DossierCondidat();
		List<LoisirDto> loirsDtos=dossierCondidatDto.getLoisirs();
		List<Loisir> loisrs = loirsDtos.stream()
			    .map(loisirDtoMapper::fromLoisirDto)
			    .collect(Collectors.toList());
		
		List<DiplomeDto>diplomeDtos = dossierCondidatDto.getDiplomes();
		List<CompetenceDto>competenceDtos=dossierCondidatDto.getCompetences();
		List<CertificatProfissionalDto>certificatProfissionalDtos=dossierCondidatDto.getCertificatProfissionals();
		List<Diplome>diplomes=diplomeDtos.stream()
			    .map(diplomeMapper::fromDiplomeDto)
			    .collect(Collectors.toList());
		List<Competence>competences=competenceDtos.stream()
			    .map(competenceMapper::fromCompetenceDto)
			    .collect(Collectors.toList());
		List<CertificatProfissional> CertificatProfissionals=certificatProfissionalDtos.stream()
			    .map(certificatProfissionalMapper::fromCertificatProfissionalDto)
			    .collect(Collectors.toList());
		Adress address =adressMapper.fromAdressDto(dossierCondidatDto.getAdress());
		//User user = userMapper.fromUserDto(dossierCondidatDto.getUser());
		dossierCondidat.setLoisirs(loisrs);
		dossierCondidat.setCertificatProfissional(CertificatProfissionals);
		dossierCondidat.setCompetences(competences);
		dossierCondidat.setDiplomes(diplomes);
		dossierCondidat.setAdress(address);
		//dossierCondidat.setUser(user);
		BeanUtils.copyProperties(dossierCondidatDto,dossierCondidat);
		return dossierCondidat;
	}
	
}
