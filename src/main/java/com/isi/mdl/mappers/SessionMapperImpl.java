package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.SessionDto;
import com.isi.mdl.entities.Session;



@Service
public class SessionMapperImpl {

	public SessionDto fromSession(Session session) {
	    SessionDto sessionDto = new SessionDto();
	    BeanUtils.copyProperties(session, sessionDto);
	    return sessionDto;
	}
	
	public Session fromSessionDto(SessionDto sessionDto) {
		Session session = new Session();
		BeanUtils.copyProperties(sessionDto,session);
		return session;
	}
}
