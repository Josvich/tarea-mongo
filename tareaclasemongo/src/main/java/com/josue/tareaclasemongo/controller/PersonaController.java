package com.josue.tareaclasemongo.controller;

import com.josue.tareaclasemongo.model.Persona;
import com.josue.tareaclasemongo.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarProductos() {
        return new ResponseEntity<>(personaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crearProducto(
            @RequestBody Persona p) {
        return new ResponseEntity<>(personaService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarProducto(@PathVariable Long id, @RequestBody Persona p) {
        Persona personaENcontrada = personaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setApellido(p.getApellido());
                personaENcontrada.setDireccion(p.getDireccion());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarProducto(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
