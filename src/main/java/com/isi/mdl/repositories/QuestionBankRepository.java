package com.isi.mdl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.mdl.entities.QuestionBank;
import com.isi.mdl.entities.Section;

public interface QuestionBankRepository extends JpaRepository <QuestionBank,Long> {
	List<QuestionBank> findBySection(Section section);
}

