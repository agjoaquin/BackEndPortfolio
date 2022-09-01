/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Repository;

import com.portfolioJMA.portfolio.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joaqu
 */
@Repository
public interface RSkill extends JpaRepository<Skill,Integer> {
        public Optional<Skill> findByNombreSkill(String nombreSkill);
    public boolean existsByNombreSkill(String nombreSkill);
    
}
