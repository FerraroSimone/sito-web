package com.generation.projectwork.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projectwork.Entity.Cibo;

@Repository
public interface CiboRepository extends JpaRepository <Cibo,Integer> {

}
