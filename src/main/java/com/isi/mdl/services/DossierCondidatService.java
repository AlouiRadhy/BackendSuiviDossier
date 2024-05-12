package com.isi.mdl.services;

import java.util.Optional;

import com.isi.mdl.dto.DossierCondidatDto;
import com.isi.mdl.entities.DossierCondidat;

public interface DossierCondidatService {
	DossierCondidatDto saveDossierCondidat(DossierCondidatDto dossierCondidatDto);
	Optional<DossierCondidatDto> update (DossierCondidatDto dossierCondidatDto );
	Optional<DossierCondidat> findById (Long id);
}
