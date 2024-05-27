package com.isi.mdl.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isi.mdl.enums.EtatCivile;
import com.isi.mdl.enums.GENRE;
import com.isi.mdl.enums.Niveau;
import com.isi.mdl.enums.Profiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Dossier_Condidat")
public class DossierCondidat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dossier")
	private Long idDossier;

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Naissance")
	private Date dateNaissance;

	@Column(name = "numero_cin")
	private String numCin;

	@Column(name = "numero_Telephone")
	private String numTel;

	@Column(name = "date_Creation")
	private Date dateCreation;

	@Column(name = "date_modification")
	private Date dateModification;

	@Column(name = "nombre_annes_experience")
	private int nbrAnnesExp;

	@Column(name = "score_dossier")
	private int scoreDossier;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private GENRE genre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "etatCivile")
	private EtatCivile etatCivile;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "niveau")
	private Niveau niveau;
	

	@Column(name = "active")
	private boolean active;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dossier_id")
	private List<Loisir> loisirs;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dossier_id")
	private List<Competence> competences;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dossier_id")
	private List<CertificatProfissional> certificatProfissional;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id", referencedColumnName = "id_Adress")
	private Adress adress;
	
	/*@OneToOne
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
	private User  user;*/
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dossier_id")
	private List<Diplome> Diplomes;

	@ManyToMany
	@JoinTable(name = "Dossier_Condidat_langue", joinColumns = @JoinColumn(name = "id_dossier"), inverseJoinColumns = @JoinColumn(name = "id_langue"))
	@JsonIgnore
	private List<Langue> langues;

}
