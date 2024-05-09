package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.LoisirDto;
import com.isi.mdl.entities.Loisir;


@Service
public class LoisirDtoMapperImpl {

		public LoisirDto fromLoisir (Loisir loisir) {
			LoisirDto loisirDto = new LoisirDto();
		    BeanUtils.copyProperties(loisir, loisirDto);
		    return loisirDto;
		}
		
		public Loisir fromLoisirDto (LoisirDto loisirDto) {
			Loisir loisir = new Loisir();
			BeanUtils.copyProperties(loisirDto,loisir);
			return loisir;
		}
		
}
