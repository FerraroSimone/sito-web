package com.generation.projectwork.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projectwork.Entity.Furgoni;

@Repository
public interface FurgoniRepository extends JpaRepository<Furgoni,Integer> {

}
