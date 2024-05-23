package com.isi.mdl.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.mdl.entities.Langue;


public interface LangueRepository extends JpaRepository  <Langue,Long>{

	Optional<Langue> getLangueByCodeLangue(String codeLangue);
}
