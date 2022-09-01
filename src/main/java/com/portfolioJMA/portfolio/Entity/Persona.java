/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioJMA.portfolio.Entity;
/**
 *
 * @author Joaqu
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String apellido;

    @Size(min = 1, max = 300, message = "No cumple con la longitud.")
    private String resumen;

    @Size(min = 1, max = 100, message = "No cumple con la longitud.")
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String resumen, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.resumen = resumen;
        this.img = img;
    }


   
    
    
}
