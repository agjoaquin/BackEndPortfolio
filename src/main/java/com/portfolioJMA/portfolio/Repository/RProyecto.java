/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Repository;

import com.portfolioJMA.portfolio.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joaqu
 */

@Repository
public interface RProyecto extends JpaRepository<Proyecto,Integer>{
    public Optional<Proyecto> findByTituloP(String tituloP);
    public boolean existsByTituloP(String tituloP);
}
