package com.isi.mdl.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isi.mdl.enums.EtatCivile;
import com.isi.mdl.enums.GENRE;
import com.isi.mdl.enums.Niveau;

import lombok.Data;

@Data
public class DossierCondidatDto {

	// private Long idDossier;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Naissance")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateNaissance;
	private String numCin;
	private String numTel;
	private Date dateCreation= new Date();
	private Date dateModification;
	private int nbrAnnesExp;
	private int scoreDossier;
	private GENRE genre;
	private EtatCivile etatCivile;
	private Niveau niveau;
	private boolean active;
	private AdressDto adress;
	private UserDto user;
	private List<LoisirDto> loisirs;
	private List<DiplomeDto>diplomes;
	private List<CompetenceDto>competences;
	private List<CertificatProfissionalDto> certificatProfissionals;

}
