package com.acme.cdc.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.cdc.domain.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
