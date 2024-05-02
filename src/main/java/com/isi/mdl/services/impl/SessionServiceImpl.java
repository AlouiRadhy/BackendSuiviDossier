package com.isi.mdl.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.SessionDto;
import com.isi.mdl.entities.Session;
import com.isi.mdl.mappers.SessionMapperImpl;
import com.isi.mdl.repositories.SessionRepository;
import com.isi.mdl.services.SessionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class SessionServiceImpl  implements SessionService{
	
	private SessionRepository sessionRepository;
	private SessionMapperImpl sessiondtoMapper;
	@Override
	public SessionDto saveSession(SessionDto sessionDto) {
		log.info("Save Session : " + sessionDto);
		Session session =sessiondtoMapper.fromSessionDto(sessionDto);
		Session saveSession = sessionRepository.save(session);
		return sessiondtoMapper.fromSession(saveSession);
	
	}
	@Override
	public List<SessionDto> getAllSession() {
		log.info("getAllSession : ");
		List<Session>sessionSearch= sessionRepository.findAll();
		  return sessionSearch.stream()
                  .map(sessiondtoMapper::fromSession) 
                  .collect(Collectors.toList());
	}
	@Override
	public Optional<Session> updateSession(SessionDto sessionDto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public void deleteSession(Long id) {
		log.info("deleteSession : ");
		sessionRepository.deleteById(id);

	}

}