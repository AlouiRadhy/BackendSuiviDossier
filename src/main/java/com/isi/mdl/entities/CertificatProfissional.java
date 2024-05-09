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
@Table(name = "Certicat_Profissional")
public class CertificatProfissional {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Certicat_Profissional")
	private Long idCertificatProfissional;
	
	@Column(name = "code_Certicat_Profissional")
	private String codeCertificatProfissional;
	
	@Column(name = "libelle_Certicat_Profissional")
	private String libelleCertificatProfissional;

}
