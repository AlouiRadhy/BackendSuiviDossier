package com.isi.mdl.dto;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionBankDto {
	private Long idQuestion;
	private String question;
	private String response;
	private String choix;
	private Date creationDate = new Date();
	private boolean active;
	private int point;
	private Long idSection;
}
