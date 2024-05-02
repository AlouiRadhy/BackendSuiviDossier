package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.SectionDto;
import com.isi.mdl.entities.Section;
import com.isi.mdl.services.impl.SectionServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SectionMapperImpl {

	public SectionDto fromSection(Section section) {
		SectionDto sectionDto = new SectionDto();
		BeanUtils.copyProperties(section,sectionDto);
		return sectionDto;
	}
	
	public Section fromSectionDto(SectionDto sectionDto) {
		Section section = new Section();
		BeanUtils.copyProperties(sectionDto,section);
		return section;
	}
}
