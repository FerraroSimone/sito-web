package com.generation.projectwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.projectwork.Entity.Cibo;

import com.generation.projectwork.Repository.CiboRepository;


@Service
public class CiboService {
	@Autowired
	CiboRepository ciboRepo;

	public List<Cibo> getAll() {
	   List<Cibo> cibo = ciboRepo.findAll();
	    return cibo;
	}
	
	public Optional<Cibo> getById(int idCibo) {
		Optional<Cibo> ciboOptional = ciboRepo.findById(idCibo);
		return ciboOptional;
	}
	
	
	public void aggiungiCibo(Cibo cibo) {
		ciboRepo.save(cibo);
	}
	
	public void deleteById(int idCibo) {
		ciboRepo.deleteById(idCibo);
	}
	
}
