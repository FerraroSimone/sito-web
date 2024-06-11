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


import com.generation.projectwork.Entity.Ordini;
import com.generation.projectwork.Entity.OrdiniDettaglio;
import com.generation.projectwork.Repository.OrdiniRepository;
import com.generation.projectwork.service.OrdiniService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/ordini")
public class OrdiniController {

	@Autowired
	OrdiniService ordiniService;
	
	@Autowired
	OrdiniRepository ordiniRepo;
	
	@GetMapping
	public ResponseEntity<List<Ordini>> getAllOrdini(){
		try {
            List<Ordini> ordini = ordiniService.getAll();

            return new ResponseEntity<>(ordini, HttpStatus.OK);

        } catch (DataAccessException e) {

            System.err.println("errore su getAllEditore editoreController r26");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping
	public Ordini aggiungiOrdine(@RequestBody Ordini ordine){
		ordiniService.aggiungiOrdine(ordine);
		return ordine;
	}
	
	
//	@PostMapping
//	public Ordini salvaOrdine(@RequestBody Ordini ordine ) {
//		ordiniRepo.save(ordine);
//		return ordine;
//	};

	
//	@DeleteMapping("{id-ordine}")
//	public ResponseEntity<Ordini> cancellaOrdine(@PathVariable("id-ordine") int idOrdine)
//	{
//		try {
//			
//			Optional<Ordini> optional = ordiniService.getById(idOrdine);
//			if(optional.isEmpty())
//			{
//				return new ResponseEntity<Ordini>(new Ordini(), HttpStatus.NOT_FOUND);
//				
//			}else {
//				ordiniService.deleteById(optional.get());
//				return new ResponseEntity<Ordini>(optional.get(), HttpStatus.OK);
//			}
//			
//		} catch (Exception e) {
////			return (ResponseEntity<?>) ResponseEntity.internalServerError();
//			return new ResponseEntity<Ordini>(new Ordini(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//	}
	
	
	
	
	@DeleteMapping("delete/{id-ordine}")
	public ResponseEntity<Void> cancellaOrdine(@PathVariable("id-ordine") int idOrdine) {
	    try {
	        Optional<Ordini> optional = ordiniService.getById(idOrdine);
	        if (optional.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            ordiniService.deleteById(idOrdine); // Passa solo l'ID
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/{id-ordine}")
    public ResponseEntity<Ordini> dammiOrdineConId(@PathVariable("id-ordine") int idOrdine) {

        try {

        Optional<Ordini> optional = ordiniService.getById(idOrdine);
        if(optional.isEmpty())
        {
            return new ResponseEntity<Ordini>(new Ordini(), HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<Ordini>(optional.get(), HttpStatus.OK);
        }

    }catch (Exception e) {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
//    }
//	@PostMapping("/array")
//	public ArrayList<Ordini> aggiungiOrdini(@RequestBody ArrayList<Ordini> ordini){
//		ordiniService.aggiungiOrdini(ordini);
//		return ordini;
//		
//	}	
	}
	}
