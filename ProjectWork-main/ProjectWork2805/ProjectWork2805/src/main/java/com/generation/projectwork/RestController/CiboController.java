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

import com.generation.projectwork.Entity.Cibo;
import com.generation.projectwork.Entity.Utente;
import com.generation.projectwork.service.CiboService;


@CrossOrigin("*")
@RestController
@RequestMapping("api/cibo")
public class CiboController {

	@Autowired
	CiboService ciboService;
	
	@GetMapping //locahost:8080/api/persona 
    public ResponseEntity<List<Cibo>> getAllCibo(){
           try {
                List<Cibo> utenti = ciboService.getAll();

                return new ResponseEntity<>(utenti, HttpStatus.OK);

            } catch (DataAccessException e) {

                System.err.println("errore su getAllEditore editoreController r26");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
	
	
	@GetMapping("/{id-cibo}")
    public ResponseEntity<Cibo> dammiciboConId(@PathVariable("id-cibo") int idCibo) {

        try {

        Optional<Cibo> optional = ciboService.getById(idCibo);
        if(optional.isEmpty())
        {
            return new ResponseEntity<Cibo>(new Cibo(), HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<Cibo>(optional.get(), HttpStatus.OK);
        }

    }catch (Exception e) {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
	
	@PostMapping("/inserisci")
	public Cibo aggiungiCibo(@RequestBody Cibo cibo){
		ciboService.aggiungiCibo(cibo);
		return cibo;
	}
	
	
	
	@DeleteMapping("delete/{id-cibo}")
	public ResponseEntity<Void> cancellaCibo(@PathVariable("id-cibo") int idCibo) {
	    try {
	        Optional<Cibo> optional = ciboService.getById(idCibo);
	        if (optional.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	        	ciboService.deleteById(idCibo); // Passa solo l'ID
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	
}
