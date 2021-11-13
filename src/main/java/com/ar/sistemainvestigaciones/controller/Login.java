/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.sistemainvestigaciones.controller;
import com.ar.sistemainvestigaciones.dao.UsuarioAuth;
import com.ar.sistemainvestigaciones.dao.UsuarioDao;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    private UsuarioDao dao;

    public Login() {
        dao=new UsuarioDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave=(String)request.getParameter("pass");
        String correo=(String)request.getParameter("user");
        Usuario found=null;
        try {
            
            int i=0;
            while (found==null && i<5){
                found=dao.authenticate(correo,clave);
                i++;
            }
            if (found == null) {
                UsuarioAuth auth=new UsuarioAuth();
                int id=auth.authenticate(correo, clave);
                found=dao.readById(id);
            }
            if(found!=null){
                request.getSession().setAttribute("nombres", found.getNombres());
                request.getSession().setAttribute("apellidos", found.getApellidos());
                request.getSession().setAttribute("role", found.getRole().getUserRole());
                request.getSession().setAttribute("usuario", found);
                response.sendRedirect("Dashboard.jsp");
            }else{
                request.setAttribute("message", "Compruebe sus credenciales");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
