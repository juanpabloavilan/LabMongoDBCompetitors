/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 *
 * @author javil
 */
@NoSql(dataFormat=DataFormatType.MAPPED)
@Embeddable
@XmlRootElement
public class Producto implements Serializable{
    private String nombre;
    private String marca;
    
    @NotNull
    @Column(name="fecha_compra")
    @Temporal(TemporalType.DATE)
    private Calendar fechaCompra;
    
    @PrePersist
    private void crearFechaDeCompra(){
        this.fechaCompra=Calendar.getInstance();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
    
    
}
