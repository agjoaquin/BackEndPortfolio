/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Joaqu
 */

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloP;
    private String descripcionP;
    private String anioP;
    private String linkP;
    private String imgP;

    public Proyecto() {
    }

    public Proyecto(String tituloP, String descripcionP, String anioP, String linkP, String imgP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.anioP = anioP;
        this.linkP = linkP;
        this.imgP = imgP;
    }
    
    
}
