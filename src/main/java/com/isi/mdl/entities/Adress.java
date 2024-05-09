package com.isi.mdl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor  @AllArgsConstructor
@Table(name = "Adress")
public class Adress {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Adress")
	private Long idAdress;
	
	@Column(name = "code_Postal")
	private String codePostal;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "Gouvenorat")
	private String gouvernorat;
	
	

}
