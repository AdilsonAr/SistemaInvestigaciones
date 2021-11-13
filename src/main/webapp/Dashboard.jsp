<%-- 
    Document   : Dashboard
    Created on : 9 nov. 2021, 22:11:29
    Author     : KGB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <title>Dashboard</title>
  </head>
  <body>
      
      <%@include file="Nav.jsp" %>
      
    <div class="container">
      <h1>Dashboard</h1>
      <%String role=(String)session.getAttribute("role");
      switch(role){
          case "SUPER_ADMINISTRADOR":
              out.print("<h3>Estas son las opciones para un super administrador</h3>");
          break;
          case "ADMINISTRADOR":
              out.print("<h3>Estas son las opciones para un administrador</h3>");
          break;
          case "INVESTIGADOR":
              out.print("<h3>Estas son las opciones para un investigador</h3>");
          break;
      }%>
      <%if(role.equals("SUPER_ADMINISTRADOR")){%>
      <a class="btn btn-primary" href="Administrador">Administradores</a>
      <a class="btn btn-primary" href="Investigador">Investigadores</a>
      <%}%>
      
      <%if(role.equals("ADMINISTRADOR")){%>
      <a class="btn btn-primary" href="Investigador">Investigadores</a>
      <%}%>
      
      <%if(role.equals("INVESTIGADOR")){%>
      <a class="btn btn-primary" href="Investigacion">Neva investigación</a>
      <a class="btn btn-primary" href="Investigacion?action=investigaciones">Mis investigaciones</a>
      <%}%>
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

  </body>
</html>

