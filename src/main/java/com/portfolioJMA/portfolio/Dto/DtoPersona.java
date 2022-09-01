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
public class DtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String resumen;
    @NotBlank
    private String img;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String resumen, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.resumen = resumen;
        this.img = img;
    }
    
    
}
