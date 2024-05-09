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
@Table(name = "Langue")
public class Langue {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Langue")
	private Long idLangue;
	
	@Column(name = "code_Langue")
	private String codeLangue;
	
	@Column(name = "libelle_Langue")
	private String libelleLangue;

}
