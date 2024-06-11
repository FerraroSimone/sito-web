package com.generation.projectwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.generation.projectwork.Entity.Ordini;
import com.generation.projectwork.Entity.OrdiniDettaglio;
import com.generation.projectwork.Repository.OrdiniRepository;

@Service
public class OrdiniService {

	@Autowired
	OrdiniRepository ordiniRepo;
	public List<Ordini> getAll() {
		   List<Ordini> utente = ordiniRepo.findAll();
		    return utente;
}
	
	public Optional<Ordini> getById(int idOrdine) {
		Optional<Ordini> ordini_dettOptional = ordiniRepo.findById(idOrdine);
		return ordini_dettOptional;
	}
//	public void deleteById(Ordini ordini) {
//        // Implementazione per eliminare l'ordine con l'ID specificato
//        // Utilizza il tuo meccanismo di persistenza (ad esempio JPA) per eliminare l'ordine dal database
//    }

//	public Optional<Ordini> deleteById(int idOrdine) {
//		Optional<Ordini> ordiniCanc=ordiniRepo.deleteById(idOrdine);
//		return ordiniCanc;
//		// TODO Auto-generated method stub
//		
//	}
	public void deleteById(int idOrdine) {
	    ordiniRepo.deleteById(idOrdine);
	}
	
	public void aggiungiOrdine(Ordini ordine) {
		ordiniRepo.save(ordine);
	}
	
//public void aggiungiOrdini( List<Ordini> ordini) {
//		
//		
//		for(Ordini ordine : ordini) {
//			
//			ordiniRepo.save(ordine);
//		}
//		
//	}
}
