package com.isi.mdl.services;

import java.util.List;
import java.util.Optional;

import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.QuestionBank;

public interface QuestionBankService {

	List<QuestionBankDto> getAllQuestions();

	Optional<QuestionBankDto> getQuestionById(Long id);

	QuestionBankDto createQuestionBank(QuestionBankDto questionBankDto);

	Optional<QuestionBank> updateQuestionBank(Long id, QuestionBankDto updatedQuestionBankDto);
	
	List<QuestionBankDto> getQuestionBySection(SectionDto sectiondto);

	void deleteQuestionBank(Long id);
}
