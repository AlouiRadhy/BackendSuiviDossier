package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.entities.DossierCondidat;

@Service
public class DossierCondidatMapperImpl {

	public DossierCondidatDto fromDossierCondidat (DossierCondidat dossierCondidat) {
		DossierCondidatDto dossierCondidatDto = new DossierCondidatDto();
	    BeanUtils.copyProperties(dossierCondidat, dossierCondidatDto);
	    return dossierCondidatDto;
	}
	
	public DossierCondidat fromDossierCondidatDto (DossierCondidatDto dossierCondidatDto) {
		DossierCondidat dossierCondidat = new DossierCondidat();
		BeanUtils.copyProperties(dossierCondidatDto,dossierCondidat);
		return dossierCondidat;
	}
	
}
