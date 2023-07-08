package com.josue.tareaclasemongo.service;

import com.josue.tareaclasemongo.model.Persona;
import com.josue.tareaclasemongo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements GenericService<Persona,Long>{


    @Autowired
    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao(){return personaRepository;}
}
