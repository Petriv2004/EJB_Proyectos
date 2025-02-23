/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author RayAj
 */
@Entity(name="proyecto")
@NamedQueries(@NamedQuery(name = "Proyecto.getAll",query = "SELECT p FROM proyecto p"))
public class Proyecto implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int proyectoId;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private int presupuesto;
    @Column
    private int numHabitantes;

    public Proyecto(int proyectoId, String nombre, String descripcion, int presupuesto, int numHabitantes) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        this.numHabitantes = numHabitantes;
    }

    public Proyecto() {
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }
    
}
