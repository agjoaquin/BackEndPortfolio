/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Controller;

import com.portfolioJMA.portfolio.Dto.DtoSkill;
import com.portfolioJMA.portfolio.Entity.Skill;
import com.portfolioJMA.portfolio.Security.Controller.Mensaje;
import com.portfolioJMA.portfolio.Service.SSkill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joaqu
 */
@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkills {

    @Autowired
    SSkill sSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("Mo existe"), HttpStatus.NOT_FOUND);
        }
        sSkill.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoSkill) {
        if (StringUtils.isBlank(dtoSkill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sSkill.existsByNombreSkill(dtoSkill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(dtoSkill.getNombreSkill(), dtoSkill.getPorcentajeSkill(),
                dtoSkill.getLinkImagenSkill());
        sSkill.save(skill);

        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill) {
        //Validamos si existe el ID
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombres de skills
        if (sSkill.existsByNombreSkill(dtoSkill.getNombreSkill()) && sSkill.getByNombreSkill(dtoSkill.getNombreSkill()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoSkill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = sSkill.getOne(id).get();
        skill.setNombreSkill(dtoSkill.getNombreSkill());
        skill.setPorcentajeSkill(dtoSkill.getPorcentajeSkill());
        skill.setLinkImagenSkill(dtoSkill.getLinkImagenSkill());

        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Proyecto actualizado."), HttpStatus.OK);

    }
}
