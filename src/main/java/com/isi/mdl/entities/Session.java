package com.isi.mdl.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.JoinColumn;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Session")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_session")
	private Long idSession;
	
	@Column(name = "libelle_session")
	private String libelleSession;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Debut")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Fin")
	private Date endDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Annulation")
	private Date cancelationDate;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "Nombre_Question")
	private int nbrQuestions;
	
    @Column(name = "Nombre_Condiats")
	private int nbrCandidats;	
    
    @Column(name = "Score_Reussite")
	private int successScore;
    
    @ManyToMany
    @JoinTable(
        name = "Session_Question",
        		joinColumns = @JoinColumn(name = "id_session"),
                inverseJoinColumns = @JoinColumn(name = "id_Langue")
    )
    @JsonIgnore
    private List<QuestionBank> questions;
}
