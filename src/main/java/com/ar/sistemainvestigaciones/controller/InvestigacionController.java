/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.controller;

import com.ar.sistemainvestigaciones.dao.InvestigacionDao;
import com.ar.sistemainvestigaciones.dao.InvestigadorDao;
import com.ar.sistemainvestigaciones.file.FileManager;
import com.ar.sistemainvestigaciones.model.Investigacion;
import com.ar.sistemainvestigaciones.model.Investigador;
import com.ar.sistemainvestigaciones.model.Status;
import com.ar.sistemainvestigaciones.model.Usuario;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KGB
 */
@WebServlet(name = "Investigacion", urlPatterns = {"/Investigacion"})
@MultipartConfig
public class InvestigacionController extends HttpServlet {

    private InvestigadorDao investigadorDao;
    private InvestigacionDao investigacionDao;

    public InvestigacionController() {
        investigadorDao=new InvestigadorDao();
        investigacionDao=new InvestigacionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            String action = (String) request.getParameter("action");
            if (action.equals("investigaciones")) {
                Usuario usuarioCreador = (Usuario) request.getSession().getAttribute("usuario");
                Investigador investigadorCreador = investigadorDao.findByUsuario(usuarioCreador);
                request.setAttribute("investigaciones", investigacionDao.findByInvestigador(investigadorCreador));
                request.getRequestDispatcher("Investigaciones.jsp").forward(request, response);
            }
        } else {
            if (request.getParameter("uuid") == null) {
                request.setAttribute("name", "Investigación sin título");
            } else {
                String uuid = (String) request.getParameter("uuid");
                request.setAttribute("investigacion", investigacionDao.findByUuid(uuid));
            }
            request.getRequestDispatcher("Investigacion.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = (String) request.getParameter("nombre");
        String documento = (String) request.getParameter("documento");
        Investigacion investigacion = new Investigacion();
        Usuario usuarioCreador = (Usuario) request.getSession().getAttribute("usuario");
        Investigador investigadorCreador = investigadorDao.findByUsuario(usuarioCreador);
        Status status = new Status();
        status.setId(1);
        investigacion.setStatus(status);
        UUID uuid = UUID.randomUUID();
        String investigacionUuid = uuid.toString();
        FileManager fileManager = new FileManager();
        fileManager.save(documento, investigacionUuid);
        investigacion.setNombre(nombre);
        investigacion.setFechaCreacion(LocalDateTime.now());
        investigacion.setInvestigador(investigadorCreador);
        investigacion.setDocumentUuid(investigacionUuid);
        investigacionDao.create(investigacion);
        String message="La investigación se guardo con éxito";
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String responseToClient="";
        responseToClient="{\"success\":\"1\",\"message\":\""
                + message + "\"}";
        
        response.getWriter().write(responseToClient);
        response.getWriter().flush();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
