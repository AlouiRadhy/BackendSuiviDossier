package com.isi.mdl.dto;

import java.util.Date;

import com.isi.mdl.enums.Profiles;

import lombok.Data;

@Data
public class UserDto {
	private Long idUser;
	private String email;
	private String password;
	private String name;
	private String firstName;
	private Date creationDate= new Date();
	private boolean active;
	private Profiles profile;

}
