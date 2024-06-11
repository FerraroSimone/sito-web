package com.generation.projectwork.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projectwork.Entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository <Utente,Integer> {

	Utente findByEmailAndPassword(String email, String password);
}


