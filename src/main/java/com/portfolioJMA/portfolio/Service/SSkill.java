/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Service;

import com.portfolioJMA.portfolio.Entity.Skill;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolioJMA.portfolio.Repository.RSkill;
import java.util.Optional;

/**
 *
 * @author Joaqu
 */

@Service
@Transactional
public class SSkill {
    @Autowired
    RSkill rSkills;
    
    public List<Skill> list() {
        return rSkills.findAll();
    }

    public Optional<Skill> getOne(int id) {
        return rSkills.findById(id);
    }

    public Optional<Skill> getByNombreSkill(String nombreSkill) {
        return rSkills.findByNombreSkill(nombreSkill);
    }

    public void save(Skill nombreSkill) {
        rSkills.save(nombreSkill);
    }

    public void delete(int id) {
        rSkills.deleteById(id);
    }

    public boolean existsById(int id) {
        return rSkills.existsById(id);
    }

    public boolean existsByNombreSkill(String nombreSkill) {
        return rSkills.existsByNombreSkill(nombreSkill);
    }
    
}
