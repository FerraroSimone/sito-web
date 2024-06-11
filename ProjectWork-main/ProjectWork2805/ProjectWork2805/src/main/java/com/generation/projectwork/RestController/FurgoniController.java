package com.generation.projectwork.RestController;

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


import com.generation.projectwork.Entity.Furgoni;

import com.generation.projectwork.service.FurgoniService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/furgoni")
public class FurgoniController {

	@Autowired
	FurgoniService furgoniService;
	
	@GetMapping 
    public ResponseEntity<List<Furgoni>> getAllFurgoni(){
           try {
                List<Furgoni> utenti = furgoniService.getAll();

                return new ResponseEntity<>(utenti, HttpStatus.OK);

            } catch (DataAccessException e) {

                System.err.println("errore su getAllEditore editoreController r26");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
	
	
	@GetMapping("/{id-furgoni}")
    public ResponseEntity<Furgoni> dammiFurgoneConId(@PathVariable("id-furgoni") int idFurgone) {

        try {

        Optional<Furgoni> optional = furgoniService.getById(idFurgone);
        if(optional.isEmpty())
        {
            return new ResponseEntity<Furgoni>(new Furgoni(), HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<Furgoni>(optional.get(), HttpStatus.OK);
        }

    }catch (Exception e) {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
	
	
	@PostMapping("/inserisci") // funziona ma dava problemi con la password perche c'è json ignore sul campo password dell'entity che da la pass come null
	  //response questa a sisnistra   qui ho la richiesta post salva
		public Furgoni aggiungiFurgone(@RequestBody Furgoni furgoni){
			furgoniService.aggiungiFurgone(furgoni);
			return furgoni ;
		}
	
	
	@DeleteMapping("delete/{id-furgoni}")
	public ResponseEntity<Void> cancellaFurgone(@PathVariable("id-furgoni") int idFurgoni) {
	    try {
	        Optional<Furgoni> optional = furgoniService.getById(idFurgoni);
	        if (optional.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            furgoniService.deleteById(idFurgoni); // Passa solo l'ID
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
