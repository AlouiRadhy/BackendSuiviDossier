package com.isi.mdl.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DossierCondidatDto {

	//private Long idDossier;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Naissance")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateNaissance;
	private String numCin;
	private String numTel;
	private Date dateCreation;
	private Date dateModification;
	private int nbrAnnesExp;
	private int scoreDossier;
	private boolean active;
	
	private List<LoisirDto> loisirs;
	
}
