package com.generation.projectwork.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projectwork.Entity.Ordini;

@Repository
public interface OrdiniRepository extends JpaRepository<Ordini,Integer>{

}
