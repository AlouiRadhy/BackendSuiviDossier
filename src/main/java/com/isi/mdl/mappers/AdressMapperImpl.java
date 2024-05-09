package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.AdressDto;
import com.isi.mdl.entities.Adress;



@Service
public class AdressMapperImpl {

	public AdressDto fromAdress (Adress adress) {
		AdressDto adressDto = new AdressDto();
	    BeanUtils.copyProperties(adress, adressDto);
	    return adressDto;
	}
	
	public Adress fromAdressDto (AdressDto adressDto) {
		Adress adress = new Adress();
		BeanUtils.copyProperties(adressDto,adress);
		return adress;
	}
	
}
