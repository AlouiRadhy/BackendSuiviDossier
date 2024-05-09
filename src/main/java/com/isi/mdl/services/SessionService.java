package com.isi.mdl.services;

import java.util.List;
import java.util.Optional;

import com.isi.mdl.dto.SessionDto;
import com.isi.mdl.entities.Session;



public interface SessionService {

	SessionDto  saveSession (SessionDto sessionDto);
	
	List<SessionDto> getAllSession();
	
	Optional<Session> updateSession (SessionDto sessionDto);
	
	Optional<SessionDto> getSession(Long id);
	
	void deleteSession(Long id);
	
}
