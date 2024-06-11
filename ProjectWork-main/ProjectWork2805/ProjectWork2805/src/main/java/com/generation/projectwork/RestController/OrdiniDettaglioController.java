package com.generation.projectwork.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.generation.projectwork.Entity.OrdiniDettaglio;

import com.generation.projectwork.service.OrdiniDettaglioService;


@CrossOrigin("*")
@RestController
@RequestMapping("api/ordinidettaglio")
public class OrdiniDettaglioController {

	@Autowired
	OrdiniDettaglioService ordini_dettaglioService;
	
	@GetMapping
	public ResponseEntity<List<OrdiniDettaglio>> getAllOrdiniDettaglio(){
        try {
             List<OrdiniDettaglio> utenti = ordini_dettaglioService.getAll();

             return new ResponseEntity<>(utenti, HttpStatus.OK);

         } catch (DataAccessException e) {

             System.err.println("errore su getAllEditore editoreController r26");
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
	
	@GetMapping("/{id-ordini_dettaglio}")
    public ResponseEntity<OrdiniDettaglio> dammiordineConId(@PathVariable("id-ordini_dettaglio") int idOrdini_Dettaglio) {

        try {

        Optional<OrdiniDettaglio> optional = ordini_dettaglioService.getById(idOrdini_Dettaglio);
        if(optional.isEmpty())
        {
            return new ResponseEntity<OrdiniDettaglio>(new OrdiniDettaglio(), HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<OrdiniDettaglio>(optional.get(), HttpStatus.OK);
        }

    }catch (Exception e) {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
	
//	@PostMapping
//	//response questa a sisnistra                     qui ho la richiesta post salva
//	public OrdiniDettaglio aggiungiOrdini(@RequestBody OrdiniDettaglio ordine){
//		ordini_dettaglioService.aggiungiOrdine(ordine);
//		return ordine;
//	}
	
	@PostMapping("/array")
	//response questa a sisnistra                     qui ho la richiesta post salva
	public ArrayList<OrdiniDettaglio> aggiungiOrdini(@RequestBody ArrayList<OrdiniDettaglio> ordini){
		ordini_dettaglioService.aggiungiOrdini(ordini);
		return ordini;
	}
	
	@DeleteMapping("delete/{id-ordini_dettaglio}")
	public ResponseEntity<Void> cancellaOrdineDett(@PathVariable("id-ordini_dettaglio") int idOrdineDett) {
	    try {
	        Optional<OrdiniDettaglio> optional = ordini_dettaglioService.getById(idOrdineDett);
	        if (optional.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	        	ordini_dettaglioService.deleteById(idOrdineDett); // Passa solo l'ID
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
