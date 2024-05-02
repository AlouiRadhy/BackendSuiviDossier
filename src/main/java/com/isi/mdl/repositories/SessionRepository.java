package com.isi.mdl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.mdl.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
