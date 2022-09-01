/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Service;

import com.portfolioJMA.portfolio.Entity.Persona;
import com.portfolioJMA.portfolio.Repository.RPersona;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joaqu
 */
@Service
@Transactional
public class SPersona  {

    @Autowired
    RPersona rPersona;


    public List<Persona> getPersona() {
        List<Persona> persona = rPersona.findAll();
        return persona;
    }


    public void savePersona(Persona persona) {
        rPersona.save(persona);
    }


    public void deletePersona(Integer id) {
        rPersona.deleteById(id);
    }


    public Persona findPersona(Integer id) {
        Persona persona = rPersona.findById(id).orElse(null);
        return persona;
    }

    public boolean existsById(int id) {
        return rPersona.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rPersona.existsByNombre(nombre);
    }

}
