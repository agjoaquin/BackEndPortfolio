/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Controller;

import com.portfolioJMA.portfolio.Dto.DtoPersona;
import com.portfolioJMA.portfolio.Entity.Persona;
import com.portfolioJMA.portfolio.Security.Controller.Mensaje;
import com.portfolioJMA.portfolio.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joaqu
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {

    @Autowired
    SPersona sPersona;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return sPersona.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        sPersona.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Integer id) {
        sPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @GetMapping("personas/traer/perfil")
    public Persona findPersona() {
        return sPersona.findPersona((int) 1);
    }

    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        //Validamos si existe el ID
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = sPersona.findPersona(id);
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setResumen(dtoPersona.getResumen());
        persona.setImg(dtoPersona.getImg());

        sPersona.savePersona(persona);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

}
