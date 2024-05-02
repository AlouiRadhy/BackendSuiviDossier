package com.isi.mdl.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.Section;

public interface SectionService {
	
	SectionDto  saveSection (SectionDto sectionDto);
	
	List<Section> getAllSection();
	
	Section findSectionByCode(String codeSection);
	
	Optional<Section> updateSection (SectionDto sectionDto, String codeSection);
	

	

}
