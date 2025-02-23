/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petriv.controller;

import com.petriv.dao.ProyectoDaoLocal;
import com.petriv.model.Proyecto;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RayAj
 */
@WebServlet(name = "ProyectoServlet", urlPatterns = {"/ProyectoServlet"})
public class ProyectoServlet extends HttpServlet {
    
    @EJB
    private ProyectoDaoLocal proyectoDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String proyectoIdStr = request.getParameter("proyectoId");
        int proyectoId=0;
        if(proyectoIdStr != null && !proyectoIdStr.equals(""))
            proyectoId = Integer.parseInt(proyectoIdStr);
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String presupuestoStr = request.getParameter("presupuesto");
        int presupuesto = 0;
        if(presupuestoStr != null && !presupuestoStr.equals(""))
            presupuesto = Integer.parseInt(presupuestoStr);
        String numHabitantesStr = request.getParameter("numHabitantes");
        int numHabitantes = 0;
        if(numHabitantesStr != null && !numHabitantesStr.equals(""))
            numHabitantes = Integer.parseInt(numHabitantesStr);
        
        Proyecto proyecto = new Proyecto(proyectoId, nombre, descripcion, presupuesto, numHabitantes);
        
        if("Add".equalsIgnoreCase(action)){
            proyectoDao.addProyecto(proyecto);
        }else if("Edit".equalsIgnoreCase(action)){
            proyectoDao.editProyecto(proyecto);
        }else if("Delete".equalsIgnoreCase(action)){
            proyectoDao.deleteProyecto(proyectoId);
        }else if("Search".equalsIgnoreCase(action)){
            proyecto = proyectoDao.getProyecto(proyectoId);
        }
        request.setAttribute("proyecto", proyecto);
        request.setAttribute("allProyectos", proyectoDao.getAllProyecto());
        request.getRequestDispatcher("proyectinfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
