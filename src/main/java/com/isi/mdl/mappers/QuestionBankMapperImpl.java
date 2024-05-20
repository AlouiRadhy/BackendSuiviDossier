package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.QuestionBank;
import com.isi.mdl.entities.Section;


@Service
public class QuestionBankMapperImpl {

   @Autowired
   private  SectionMapperImpl sectionMapper;
   
	public QuestionBankDto fromQuestionBank(QuestionBank questionBank) {
	    QuestionBankDto questionBankDto = new QuestionBankDto();
	    SectionDto sectionDto=sectionMapper.fromSection(questionBank.getSection());
	    questionBankDto.setSection(sectionDto);
	    BeanUtils.copyProperties(questionBank, questionBankDto);
	    return questionBankDto;
	}
	
	public QuestionBank fromQuestionBankDto(QuestionBankDto questionBankDto) {
		QuestionBank questionBank = new QuestionBank();
		Section section=sectionMapper.fromSectionDto(questionBankDto.getSection());
		questionBank.setSection(section);
		BeanUtils.copyProperties(questionBankDto,questionBank);
		return questionBank;
	}
	
}
