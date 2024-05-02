package com.isi.mdl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.isi.mdl.enums.Profiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Utilisateur")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private Long idUser;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation")
	private Date creationDate;
	@Column(name = "active")
	private boolean active;
	@Enumerated(EnumType.STRING)
	@Column(name = "profile")
	private Profiles profile;
}
