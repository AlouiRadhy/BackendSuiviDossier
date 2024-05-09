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
@Table(name = "Loisir")
public class Loisir {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Loisir")
	private Long idLoisir;
	
	@Column(name = "libelle_Loisir")
	private String libelleLoisir;
}
