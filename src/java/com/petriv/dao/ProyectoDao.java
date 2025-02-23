/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.dao;

import com.petriv.model.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RayAj
 */
@Stateless
public class ProyectoDao implements ProyectoDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addProyecto(Proyecto proyecto) {
        em.persist(proyecto);
    }

    @Override
    public void editProyecto(Proyecto proyecto) {
        em.merge(proyecto);
    }

    @Override
    public void deleteProyecto(int proyectoId) {
        em.remove(getProyecto(proyectoId));
    }

    @Override
    public Proyecto getProyecto(int proyectoId) {
        return em.find(Proyecto.class, proyectoId);
    }

    @Override
    public List<Proyecto> getAllProyecto() {
        return em.createNamedQuery("Proyecto.getAll").getResultList();
    }
}
