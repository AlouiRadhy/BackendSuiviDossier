package com.isi.mdl.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.mdl.entities.Section;



public interface SectionRepository  extends JpaRepository <Section,Long>{
	Optional<Section> getSectionByCodeSection(String codeSection);

}
