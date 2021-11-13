<%-- 
    Document   : Administrador
    Created on : 10 nov. 2021, 21:03:55
    Author     : KGB
--%>

<%@page import="com.ar.sistemainvestigaciones.model.Investigador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ar.sistemainvestigaciones.model.Usuario"%>
<%@page import="com.ar.sistemainvestigaciones.model.Administrador"%>
<%@page import="com.ar.sistemainvestigaciones.model.Role"%>
<%@page import="com.ar.sistemainvestigaciones.model.Pais"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String title =(String)request.getAttribute("title");
    String role=(String)session.getAttribute("role");
    String action=(String)request.getAttribute("action");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    
    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="valid/validetta.min.css" />
    <title><%=title%></title>
  </head>
  <body>
      <%@include file="Nav.jsp" %>
    <div class="container">
      <h1><%=title%></h1>
      
      <%if( (role.equals("SUPER_ADMINISTRADOR") && action.equals("Administrador")) || role.equals("ADMINISTRADOR")){%>
      
      <form method="POST" action="<%=action%>" id="AdministradoresForm">
          <div class="form-group">
                    <label for="nombre">nombres</label>
                    <input type="text" class="form-control" name="nombre" id="nombre" data-validetta="required">
                </div>
          
          <div class="form-group">
                    <label for="apellido">apellidos</label>
                    <input type="text" class="form-control" name="apellido" id="apellido" data-validetta="required">
                </div>
          
          <div class="form-group">
                    <label for="correo">correo</label>
                    <input type="text" class="form-control" name="correo" id="correo" data-validetta="required">
                </div>
          
          <div class="form-group">
                    <label for="telefono">telefono</label>
                    <input type="text" class="form-control" name="telefono" id="telefono" data-validetta="required">
                </div>
          
          <%if(role.equals("SUPER_ADMINISTRADOR")){%>
          <div class="form-group">
    <label for="pais">pais</label>
    <select class="form-control" id="pais" name="pais" data-validetta="required">
        <%
            if(request.getAttribute("paices")!=null){
                List<Pais> paices=(List<Pais>)request.getAttribute("paices");
                for(Pais c: paices){
                    out.print("<option " +"value =\""+c.getId()+"\"" + ">");
                    out.print(c.getNombre());
                    out.print("</option>");
                }
            }
            
        %>
    </select>
  </div>
    <%}%>
    <div class="form-group">
                    <label for="clave">Contraseña</label>
                    <input type="password" class="form-control" name="clave" id="clave" data-validetta="required,callback[clave]">
                </div>
    
    <div class="form-group">
                    <label for="clave2">Verifique la contraseña</label>
                    <input type="password" class="form-control" name="clave2" id="clave2" data-validetta="required,callback[clave2]">
                </div>
  
          <button type="submit" class="btn btn-primary" id="guardar">
                    Guardar registros
                </button>
      </form>
    <%}%>
    <table class="table" >
        <tr>
            <th>nombres</th>
            <th>apellidos</th>
            <th>correo</th>
            <th>telefono</th>
            <th>pais</th>
        </tr>
        <%
            List<Usuario>usuarios=new ArrayList<>();
            if(title.equals("Administradores")){
                List<Administrador> admins=(List<Administrador>)request.getAttribute("usuarios");
                for(Administrador x: admins){
                    usuarios.add(x.getUsuario());
                }
            }else{
                //Investigadores
                List<Investigador> inves=(List<Investigador>)request.getAttribute("usuarios");
                for(Investigador x:inves){
                    usuarios.add(x.getUsuario());
                }
            }
            
        
        for(Usuario c: usuarios){
            out.print("<tr>");
            
            out.print("<td>");
            out.print(c.getNombres());
            out.print("</td>");
            
            out.print("<td>");
            out.print(c.getApellidos());
            out.print("</td>");
            
            out.print("<td>");
            out.print(c.getCorreo());
            out.print("</td>");
            
            out.print("<td>");
            out.print(c.getTelefono());
            out.print("</td>");
            
            out.print("<td>");
            out.print(c.getPais().getNombre());
            out.print("</td>");
            
            out.print("</tr>");
}%>
    </table>
      
    </div>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <%if(request.getAttribute("message")!=null){
          String message =(String)request.getAttribute("message");
      %>
        <script>
        swal({
          title: "Mensage",
          text: "<%=message%>",
          icon: "info",
          button: "Ok",
        });
    </script>
      <%}%>
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
      integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
      crossorigin="anonymous"
    ></script>
    
    <script src="valid/validetta.min.js"></script>
        <script src="valid/validettaLang-es-ES.js"></script>

        <script src="valid/AdministradoresValidation.js"></script>
    <script src="js/Administradores.js"></script>
  </body>
</html>

