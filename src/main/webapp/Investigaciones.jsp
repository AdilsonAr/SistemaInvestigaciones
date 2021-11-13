<%-- 
    Document   : Investigaciones
    Created on : 12 nov. 2021, 18:01:11
    Author     : KGB
--%>

<%@page import="com.ar.sistemainvestigaciones.model.Investigacion"%>
<%@page import="java.util.List"%>
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

    <title>Mis investigaciones</title>
  </head>
  <body>
      <%@include file="Nav.jsp" %>
    <div class="container">
      <h1>Mis investigaciones</h1>
      <table class="table">
          <tr>
              <th>nombre</th>
              <th>creada</th>
              <th>estado</th>
              <th>...</th>
          </tr>
          
          <%if(request.getAttribute("investigaciones")!=null){
          List<Investigacion> lista=(List<Investigacion> )request.getAttribute("investigaciones");
          for(Investigacion x:lista){
              out.print("<tr>");
              
              out.print("<td>");
              out.print(x.getNombre());
              out.print("</td>");
              
              out.print("<td>");
              out.print(x.getFechaCreacion().toString());
              out.print("</td>");
              
              out.print("<td>");
              out.print(x.getStatus().getStatus());
              out.print("</td>");
              
              out.print("<td>");
              out.print("<a class=\"btn btn-primary\" href=\"Investigacion?uuid="+x.getDocumentUuid()+"\">Ver</a>");
              out.print("</td>");

              out.print("</tr>");
          }
      }%>
      
      </table>
      
    </div>

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

