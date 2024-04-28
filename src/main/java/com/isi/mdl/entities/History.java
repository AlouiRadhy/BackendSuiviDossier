package com.isi.mdl.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor  @AllArgsConstructor
public class History {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHistorique;
	private Date dateOperation;
	private String typeOperation;
	private String Operation;
	
	@ManyToOne
	private User user;
	
}
