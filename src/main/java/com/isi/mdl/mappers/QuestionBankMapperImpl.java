package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.entities.QuestionBank;


@Service
public class QuestionBankMapperImpl {

	public QuestionBankDto fromQuestionBank(QuestionBank questionBank) {
	    QuestionBankDto questionBankDto = new QuestionBankDto();
	    BeanUtils.copyProperties(questionBank, questionBankDto);
	    questionBankDto.setIdSection(questionBank.getSection().getIdSection());
	    return questionBankDto;
	}
	
	public QuestionBank fromQuestionBankDto(QuestionBankDto questionBankDto) {
		QuestionBank questionBank = new QuestionBank();
		BeanUtils.copyProperties(questionBankDto,questionBank);
		return questionBank;
	}
	
}
