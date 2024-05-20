package com.isi.mdl.entities;

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
@Table(name = "Diplome")
public class Diplome {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Diplome")
	private Long idDiplome;
	
	@Column(name = "libelle_Diplome")
	private String libelleDiplome;
	
	@Column(name = "mention")
	private String mention;
	
	@Column(name = "anne_Diplome")
	private String anneDiplome;
}
