package com.isi.mdl.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.Section;

import com.isi.mdl.exceptions.EntiteNotFoundException;
import com.isi.mdl.mappers.SectionMapperImpl;

import com.isi.mdl.repositories.SectionRepository;

import com.isi.mdl.services.SectionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class SectionServiceImpl implements SectionService {
	private SectionRepository sectionRepository;
	private SectionMapperImpl dtoMapper;

	@Override
	public SectionDto saveSection(SectionDto sectionDto) {
		log.info("Save Section");
		Section section = dtoMapper.fromSectionDto(sectionDto);
		Section saveSection = sectionRepository.save(section);
		log.info("dtoMapper.fromSection(saveSection) "+ dtoMapper.fromSection(saveSection));
		return dtoMapper.fromSection(saveSection);
	}

	@Override
	public List<Section> getAllSection() {
		log.info("get All Section");
		return sectionRepository.findAll();
	}

	@Override
	public Section findSectionByCode(String codeSection) {
		return sectionRepository.getSectionByCodeSection(codeSection)
				.orElseThrow(() -> new EntiteNotFoundException("Section not found with code: " + codeSection));
	}

	@Override
	public Optional<Section> updateSection(SectionDto sectionDto, String codeSection) {
		Optional<Section> sectionOptional = sectionRepository.getSectionByCodeSection(codeSection);
		if (sectionOptional.isPresent()) {
			Section section = sectionOptional.get();
			section.setCodeSection(sectionDto.getCodeSection());
			section.setLibelleSection(sectionDto.getLibelleSection());
			sectionRepository.save(section);
		}
		return sectionOptional;
	}

}
