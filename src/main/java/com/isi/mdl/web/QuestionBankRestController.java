package com.isi.mdl.web;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isi.mdl.dto.QuestionBankDto;
import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.QuestionBank;
import com.isi.mdl.services.QuestionBankService;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class QuestionBankRestController {
	private QuestionBankService  questionBankService;

	
	@RequestMapping(value = "/SaveQuestion", method = RequestMethod.POST)
	public ResponseEntity<?> saveSection(@RequestBody QuestionBankDto questionBankDto ,@RequestParam(name = "idSection") Long idSection) {
	    try {
	    	QuestionBankDto questionBankDtoResult = questionBankService.createQuestionBank(questionBankDto,idSection);
	        return ResponseEntity.status(HttpStatus.CREATED).body(questionBankDtoResult);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de l'enregistrement de la Question.");
	    }
		
	}
	
	
	@RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
	public List<QuestionBankDto> getAllQuestions() {
		return questionBankService.getAllQuestions();
	}
	
	@PutMapping("/UpdateQuestion/{idQuestionBank}")
	 public ResponseEntity<?> updateQuestionBank(@PathVariable (name = "idQuestionBank") Long idQuestionBank, @RequestBody QuestionBankDto questionBankDto ) {
		java.util.Optional<QuestionBank> questionBankOptional= questionBankService.updateQuestionBank(idQuestionBank, questionBankDto);
	     if (questionBankOptional.isPresent()) {
	            return ResponseEntity.ok("Question updated successfully.");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
    @DeleteMapping("/Questionank/{id}")
    public ResponseEntity<?> deleteQuestionBank(@PathVariable Long id){
    	 try {
    	questionBankService.deleteQuestionBank(id);
    	return ResponseEntity.ok("Question deleted successfully.");
    	 }
    	 catch (Exception e) {
 	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de  supression de la Question.");
 	    }
    }
    
    
    @RequestMapping(value = "/GetQuestionBySection", method = RequestMethod.GET)
	public List<QuestionBankDto> getQuestionBySection(@RequestBody SectionDto sectionDto) {
		return questionBankService.getQuestionBySection(sectionDto);
	}
	
}
