package com.generation.projectwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;



import com.generation.projectwork.Entity.Furgoni;

import com.generation.projectwork.Repository.FurgoniRepository;


@Service
public class FurgoniService {

	
	@Autowired
	FurgoniRepository furgoniRepo;

	public List<Furgoni> getAll() {
	   List<Furgoni> utente = furgoniRepo.findAll();
	    return utente;
	}

	public Optional<Furgoni> getById(int idFurgone) {
		Optional<Furgoni> furgoniOptional = furgoniRepo.findById(idFurgone);
		return furgoniOptional;
	}
	
	
	public void aggiungiFurgone(Furgoni furgoni) {
		furgoniRepo.save(furgoni);
	}
	
	
	public void deleteById(int idFurgoni) {
	    furgoniRepo.deleteById(idFurgoni);
	}
	
}
