/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.controller;

import com.ar.sistemainvestigaciones.dao.AdministradorDao;
import com.ar.sistemainvestigaciones.dao.InvestigadorDao;
import com.ar.sistemainvestigaciones.dao.PaisDao;
import com.ar.sistemainvestigaciones.dao.RoleDao;
import com.ar.sistemainvestigaciones.dao.UsuarioDao;
import com.ar.sistemainvestigaciones.model.Administrador;
import com.ar.sistemainvestigaciones.model.Investigador;
import com.ar.sistemainvestigaciones.model.Role;
import com.ar.sistemainvestigaciones.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KGB
 */
@WebServlet(name = "Investigador", urlPatterns = {"/Investigador"})
public class InvestigadorController extends HttpServlet {
  
    private InvestigadorDao investigadorDao;
    private AdministradorDao administradorDao;
    private PaisDao paisDao;

    public InvestigadorController() {
        investigadorDao=new InvestigadorDao();
        administradorDao=new AdministradorDao();
        paisDao=new PaisDao();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("paices", paisDao.readAll());
        request.setAttribute("title", "Investigadores");
        request.setAttribute("action", "Investigador");
            request.setAttribute("usuarios", investigadorDao.readAll());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("role")==null){
            response.sendRedirect("Login.jsp");
        }else{
            processRequest(request, response);
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
            //response.sendRedirect("Administrador.jsp");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role=(String)request.getSession().getAttribute("role");
        
        if(request.getSession().getAttribute("role")==null){
            response.sendRedirect("Login.jsp");
        }else{
            Usuario u=new Usuario();
            Investigador a= new Investigador();
            try{
                u.setNombres((String)request.getParameter("nombre"));
                 u.setApellidos((String)request.getParameter("apellido"));
                  u.setTelefono((String)request.getParameter("telefono"));
                  u.setClave((String)request.getParameter("clave"));
                  u.setCorreo((String)request.getParameter("correo"));
                  Role r=new Role();
                  r.setId(3);
                  u.setRole(r);
                  Usuario usuarioCreador=(Usuario)request.getSession().getAttribute("usuario");
                  Administrador adminCreador=administradorDao.findByUsuario(usuarioCreador);
                  u.setPais(adminCreador.getUsuario().getPais());
                  a.setUsuario(u);
                  a.setAdministrador(adminCreador);
                  investigadorDao.create(a);
                  
                  processRequest(request, response);
                  request.setAttribute("message", "El Investigador se creo correctamente");
                request.getRequestDispatcher("Usuario.jsp").forward(request, response);
            }catch(Exception e){
                e.printStackTrace();
                request.setAttribute("message", "Se encontraron errores en los datos");
                request.getRequestDispatcher("Usuario.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
