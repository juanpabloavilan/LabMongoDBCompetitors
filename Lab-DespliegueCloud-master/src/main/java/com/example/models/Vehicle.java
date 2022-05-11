/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
public class Vehicle {
    
    private String plate;
    private String brand;
    private int modelYear;
    
    @NotNull
    @Column(name="created_at", updatable=false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;
    
    @NotNull
    @Column(name="updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;
    
    public Vehicle(){
    
    }
    
    @PreUpdate
    private void actualizarEstampaDeTiempo(){
        this.updatedAt=Calendar.getInstance();
    }
    
    @PrePersist
    private void crearEstampaDeTiempo(){
        this.createdAt=this.updatedAt=Calendar.getInstance();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    
    
}
