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
@Table(name = "Competence")
public class Competence {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Competence")
	private Long idCompetence;
	
	@Column(name = "libelle_Competence")
	private String libelleCompetence;
	

}
