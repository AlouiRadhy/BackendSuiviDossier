package com.isi.mdl.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class SessionDto {

	private Long idSession;
	private String libelleSession;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Debut")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Debut")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date endDate;
	private boolean active;
	private int nbrQuestions;
	private int nbrCandidats;
	private int successScore;
	private List<QuestionBankDto> questions;
	private List<DossierCondidatDto> dossiersCandidats;
}
