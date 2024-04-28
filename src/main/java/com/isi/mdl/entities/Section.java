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
@Table(name = "Section")
public class Section {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_section")
	private Long idSection;
	@Column(name = "code_section")
	private String codeSection;
	@Column(name = "libelle_section")
	private String libelleSection;

}
