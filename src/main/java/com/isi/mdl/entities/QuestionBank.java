package com.isi.mdl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor  @AllArgsConstructor
@Table(name = "Bank_Question")
public class QuestionBank {
	@Column(name = "id_question")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestion;
	@Column(name = "question")
	private String questtion;
	@Column(name = "reponse")
	private String response;
	@Column(name = "date_creation")
	private Date creationDate;
	@Column(name = "date_annulation")
	private Date annulation_date;
	@Column(name = "active")
	private boolean active;
	@Column(name = "point")
	private int point;
 
}
