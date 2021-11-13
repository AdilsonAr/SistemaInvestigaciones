/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.controller;

import com.ar.sistemainvestigaciones.file.FileManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KGB
 */
@WebServlet(name = "File", urlPatterns = {"/File"})
public class FileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uuid = (String) request.getParameter("uuid");
        FileManager fileManager = new FileManager();
        String documento = fileManager.read(uuid);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String responseToClient="";
        if(documento.length()>0){
            responseToClient=documento;
        }else{
            responseToClient="";
        }
        
        response.getWriter().write(responseToClient);
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
