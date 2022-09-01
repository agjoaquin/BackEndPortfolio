/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioJMA.portfolio.Security.Repository;

import com.portfolioJMA.portfolio.Security.Entity.Rol;
import com.portfolioJMA.portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Joaqu
 */
@Repository
public interface iRolRepository  extends JpaRepository<Rol,Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
            
    
}
