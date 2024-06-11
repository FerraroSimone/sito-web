package com.generation.projectwork.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projectwork.Entity.OrdiniDettaglio;

@Repository
public interface OrdiniDettaglioRepo extends JpaRepository<OrdiniDettaglio,Integer> {

}
