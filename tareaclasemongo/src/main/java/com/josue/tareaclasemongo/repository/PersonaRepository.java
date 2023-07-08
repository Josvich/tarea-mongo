package com.josue.tareaclasemongo.repository;

import com.josue.tareaclasemongo.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


public interface PersonaRepository extends MongoRepository<Persona,Long> {





}
