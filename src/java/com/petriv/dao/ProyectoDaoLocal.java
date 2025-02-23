/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.dao;

import com.petriv.model.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RayAj
 */
@Local
public interface ProyectoDaoLocal {
    
    void addProyecto(Proyecto proyecto);
    
    void editProyecto(Proyecto proyecto);
    
    void deleteProyecto(int proyectoId);
    
    Proyecto getProyecto(int proyectoId);
    
    List <Proyecto> getAllProyecto();
}
