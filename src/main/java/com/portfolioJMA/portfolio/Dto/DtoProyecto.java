/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Joaqu
 */

@Getter @Setter
public class DtoProyecto {
    @NotBlank
    private String tituloP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String anioP;
    @NotBlank
    private String linkP;
    @NotBlank
    private String imgP;

    public DtoProyecto() {
    }
    
    public DtoProyecto(String tituloP, String descripcionP, String anioP, String linkP, String imgP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.anioP = anioP;
        this.linkP = linkP;
        this.imgP = imgP;
    }
    
    
}
