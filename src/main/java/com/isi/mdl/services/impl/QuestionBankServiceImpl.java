package com.isi.mdl.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.QuestionBank;
import com.isi.mdl.entities.Section;
import com.isi.mdl.exceptions.EntiteNotFoundException;
import com.isi.mdl.mappers.QuestionBankMapperImpl;
import com.isi.mdl.mappers.SectionMapperImpl;
import com.isi.mdl.repositories.QuestionBankRepository;
import com.isi.mdl.repositories.SectionRepository;
import com.isi.mdl.services.QuestionBankService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class QuestionBankServiceImpl implements QuestionBankService {

	private QuestionBankRepository questionBankRepository;
	private SectionRepository sectionRepository;
	private QuestionBankMapperImpl dtoMapper;
	private SectionMapperImpl dtoSectionMapper;

	@Override
	public List<QuestionBankDto> getAllQuestions() {
		log.info("get AllQuestion");
		List<QuestionBank> questionBank = questionBankRepository.findAll();
		return questionBank.stream().map(dtoMapper::fromQuestionBank).collect(Collectors.toList());
	}

	@Override
	public Optional<QuestionBankDto> getQuestionById(Long id) {
		log.info("getQuestionById : " + id);
		Optional<QuestionBank> questionOptional = questionBankRepository.findById(id);
		return questionOptional.map(dtoMapper::fromQuestionBank);
	}

	@Override
	public QuestionBankDto createQuestionBank(QuestionBankDto questionBankDto) {
		log.info("Save QuestionBank : " + questionBankDto);
		Long sectionId = questionBankDto.getIdSection();

		Section section = sectionRepository.findById(sectionId)
				.orElseThrow(() -> new IllegalArgumentException("Section non trouvée avec l'ID: " + sectionId));
		QuestionBank questionBank = dtoMapper.fromQuestionBankDto(questionBankDto);
		questionBank.setSection(section);
		QuestionBank saveQuestionBank = questionBankRepository.save(questionBank);
		return dtoMapper.fromQuestionBank(questionBank);
	}

	@Override
	public Optional<QuestionBank> updateQuestionBank(Long id, QuestionBankDto updatedQuestionBankDto) {
		log.info("Update QuestionBank : " + updatedQuestionBankDto);

		Optional<QuestionBank> questionBankOptional = questionBankRepository.findById(id);
		if (questionBankOptional.isPresent()) {
			QuestionBank questionBnak = questionBankOptional.get();

			questionBankRepository.save(questionBnak);
		}
		return questionBankOptional;
	}

	@Override
	public void deleteQuestionBank(Long id) {
		log.info("Update QuestionBank : " + id);
		questionBankRepository.deleteById(id);

	}

	@Override
	public List<QuestionBankDto> getQuestionBySection(SectionDto sectiondto) {

		Section sectionSearch = dtoSectionMapper.fromSectionDto(sectiondto);
		log.info("sectionSearch :" + sectionSearch);
		List<QuestionBank> questions = questionBankRepository.findBySection(sectionSearch);
		return questions.stream().map(dtoMapper::fromQuestionBank).collect(Collectors.toList());
	}

}
