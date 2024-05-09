package com.isi.mdl.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.isi.mdl.dto.CertificatProfissionalDto;
import com.isi.mdl.entities.CertificatProfissional;

@Service
public class CertificatProfissionalMapperImpl {

	
	public CertificatProfissionalDto fromCertificatProfissional (CertificatProfissional certificatProfissional) {
		CertificatProfissionalDto certificatProfissionalDto = new CertificatProfissionalDto();
	    BeanUtils.copyProperties(certificatProfissional, certificatProfissionalDto);
	    return certificatProfissionalDto;
	}
	
	public CertificatProfissional fromCertificatProfissionalDto (CertificatProfissionalDto certificatProfissionalDto) {
		CertificatProfissional certificatProfissional = new CertificatProfissional();
		BeanUtils.copyProperties(certificatProfissionalDto,certificatProfissional);
		return certificatProfissional;
	}
}
