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
public class DtoSkill {
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String porcentajeSkill;
    @NotBlank
    private String linkImagenSkill;

    public DtoSkill() {
    }

    public DtoSkill(String nombreSkill, String porcentajeSkill, String linkImagenSkill) {
        this.nombreSkill = nombreSkill;
        this.porcentajeSkill = porcentajeSkill;
        this.linkImagenSkill = linkImagenSkill;
    }
    
    
}
