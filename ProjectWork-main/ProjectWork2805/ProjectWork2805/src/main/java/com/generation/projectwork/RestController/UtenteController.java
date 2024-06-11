package com.generation.projectwork.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.generation.projectwork.Entity.Utente;
import com.generation.projectwork.Repository.UtenteRepository;
import com.generation.projectwork.service.UtenteService;

@CrossOrigin("*")
//@Validated
@RestController
@RequestMapping("api/utente")
public class UtenteController {

	@Autowired
	UtenteService utenteService;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@GetMapping //locahost:8080/api/persona 
    public ResponseEntity<List<Utente>> getAllUtente(){
           try {
                List<Utente> utenti = utenteService.getAll();

                return new ResponseEntity<>(utenti, HttpStatus.OK);

            } catch (DataAccessException e) {

                System.err.println("errore su getAllEditore editoreController r26");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
	
	@GetMapping("/form")
    public String mostraForm(Model model) {
        model.addAttribute("utente", new Utente());
        return "form";
    }
	
//	@PostMapping("/inserisci")
//    public String inserisciUtente(@ModelAttribute Utente utente) {
//        utenteRepository.save(utente);
//        return "ok";
//    }
//	
	
	@PostMapping("/inserisci") // funziona ma dava problemi con la password perche c'è json ignore sul campo password dell'entity che da la pass come null
  //response questa a sisnistra   qui ho la richiesta post salva
	public ResponseEntity <Utente> aggiungiUtente(@RequestBody Utente utente){
		if (utente.getPassword() == null || utente.getPassword().isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Restituisce 400 Bad Request se la password è null o vuota
	    }
		utenteService.aggiungiUtente(utente);
		return new ResponseEntity<>(utente, HttpStatus.CREATED);
	}
     
     


	@PostMapping("/verifica")
	public ResponseEntity<Map<String, Object>> verificaUtente(@RequestBody Map<String, String> payload) {
	    Map<String, Object> response = new HashMap<>();
	    String email = payload.get("email");
	    String password = payload.get("password");
	    Utente utente = utenteRepository.findByEmailAndPassword(email, password);
	    if (utente != null) {
	        response.put("exists", true);
	        response.put("utente", utente);
	    } else {
	        response.put("exists", false);
	    }
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

@DeleteMapping("delete/{id-utente}")
public ResponseEntity<Void> cancellaUtente(@PathVariable("id-utente") int idUtente) {
    try {
        Optional<Utente> optional = utenteService.getById(idUtente);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            utenteService.deleteById(idUtente); // Passa solo l'ID
            return new ResponseEntity<>(HttpStatus.OK);
        }
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
