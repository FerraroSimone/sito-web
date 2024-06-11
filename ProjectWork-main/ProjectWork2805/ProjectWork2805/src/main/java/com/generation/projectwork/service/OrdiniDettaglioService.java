package com.generation.projectwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.generation.projectwork.Entity.OrdiniDettaglio;
import com.generation.projectwork.Repository.OrdiniDettaglioRepo;


	@Service
	public class OrdiniDettaglioService {

	@Autowired
	OrdiniDettaglioRepo ordinidettaglioRepo;
	
	public List<OrdiniDettaglio> getAll() {
		   List<OrdiniDettaglio> ordini_dett = ordinidettaglioRepo.findAll();
		    return ordini_dett;
		}
	
	public Optional<OrdiniDettaglio> getById(int idOrdine_Dettaglio) {
		Optional<OrdiniDettaglio> ordini_dettOptional = ordinidettaglioRepo.findById(idOrdine_Dettaglio);
		return ordini_dettOptional;
	}

//	@Autowired
//	UtenteRepository utenteRepo;
//	
//	
//	public void aggiungiOrdine( OrdiniDettaglio ordine) {
//		
//		ordinidettaglioRepo.save(ordine);
//		
//	}
	
	public void deleteById(int idOrdineDett) {
		ordinidettaglioRepo.deleteById(idOrdineDett);
	}
	
public void aggiungiOrdini( List<OrdiniDettaglio> ordini) {
		
		
		for(OrdiniDettaglio ordine : ordini) {
			
			ordinidettaglioRepo.save(ordine);
		}
		
	}
	
}
