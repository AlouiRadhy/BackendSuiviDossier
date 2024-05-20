package com.isi.mdl.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.dto.SessionDto;
import com.isi.mdl.entities.QuestionBank;
import com.isi.mdl.entities.Session;
import com.isi.mdl.services.impl.SessionServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SessionMapperImpl {

	@Autowired
	private QuestionBankMapperImpl questionMapper;

	public SessionDto fromSession(Session session) {
		SessionDto sessionDto = new SessionDto();
		log.info("Test 1");
		List<QuestionBankDto> questionBankDtp = session.getQuestions().stream().map(questionMapper::fromQuestionBank)
				.collect(Collectors.toList());
		log.info("Test 2s");
		sessionDto.setQuestions(questionBankDtp);
		BeanUtils.copyProperties(session, sessionDto);
		return sessionDto;
	}

	public Session fromSessionDto(SessionDto sessionDto) {
		Session session = new Session();
		List<QuestionBank> questionBank = sessionDto.getQuestions().stream().map(questionMapper::fromQuestionBankDto)
				.collect(Collectors.toList());
		session.setQuestions(questionBank);
		BeanUtils.copyProperties(sessionDto, session);
		return session;
	}
}
