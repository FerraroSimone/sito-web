package com.generation.projectwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.generation.projectwork.Entity.Utente;
import com.generation.projectwork.Repository.UtenteRepository;

@Service
public class UtenteService {
@Autowired
UtenteRepository utenteRepo;

public List<Utente> getAll() {
   List<Utente> utente = utenteRepo.findAll();
    return utente;
}

public void aggiungiUtente(Utente utente) {
	utenteRepo.save(utente);
}

public void deleteById(int idOrdine) {
    utenteRepo.deleteById(idOrdine);
}

public Optional<Utente> getById(int idOrdine) {
	Optional<Utente> ordini_dettOptional = utenteRepo.findById(idOrdine);
	return ordini_dettOptional;
}
}
