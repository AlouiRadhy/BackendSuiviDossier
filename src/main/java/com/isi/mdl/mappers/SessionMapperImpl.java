package com.isi.mdl.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.dto.SessionDto;
import com.isi.mdl.entities.DossierCondidat;
import com.isi.mdl.entities.QuestionBank;
import com.isi.mdl.entities.Session;
import com.isi.mdl.services.impl.SessionServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SessionMapperImpl {

	@Autowired
	private QuestionBankMapperImpl questionMapper;
	@Autowired
	private  DossierCondidatMapperImpl dossierCondidatMapper;

	public SessionDto fromSession(Session session) {
		SessionDto sessionDto = new SessionDto();
		
		List<QuestionBankDto> questionBankDtp = session.getQuestions().stream().map(questionMapper::fromQuestionBank)
				.collect(Collectors.toList());
	  
		List<DossierCondidatDto> dossierCondidatDtp = session.getDossierCondidats().stream().map(dossierCondidatMapper::fromDossierCondidat)
				.collect(Collectors.toList());
		
		sessionDto.setDossiersCandidats(dossierCondidatDtp);
		sessionDto.setQuestions(questionBankDtp);
		BeanUtils.copyProperties(session, sessionDto);
		return sessionDto;
	}

	public Session fromSessionDto(SessionDto sessionDto) {
		Session session = new Session();
		List<QuestionBank> questionBank = sessionDto.getQuestions().stream().map(questionMapper::fromQuestionBankDto)
				.collect(Collectors.toList());
		List<DossierCondidat> dossierCondidat = sessionDto.getDossiersCandidats().stream().map(dossierCondidatMapper::fromDossierCondidatDto)
				.collect(Collectors.toList());
		session.setDossierCondidats(dossierCondidat);
		session.setQuestions(questionBank);
		BeanUtils.copyProperties(sessionDto, session);
		return session;
	}
}
