<%-- 
    Document   : Investigacion
    Created on : 12 nov. 2021, 11:16:33
    Author     : KGB
--%>

<%@page import="com.ar.sistemainvestigaciones.model.Investigacion"%>
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
        <%
            String name = (String) request.getAttribute("name");
            Investigacion in = null;
            if (request.getAttribute("investigacion") != null) {
                in = (Investigacion) request.getAttribute("investigacion");
                name = in.getNombre();
            }
        %>
        <link rel="stylesheet" href="valid/validetta.min.css" />
        <title><%=name%></title>
    </head>
    <body>
        <%@include file="Nav.jsp" %>
        <div class="container">
            <h1><%=name%></h1>
            <form method="POST" action="Investigacion" id="InvestigacionForm">
                <div class="form-group">
                    <label for="nombre">nombre</label>  
                    <input type="text" class="form-control" name="nombre" value="<%=name%>" id="nombre" data-validetta="required">
                </div>
                <%if (request.getAttribute("investigacion") == null) {%>
                <button type="submit" class="btn btn-primary" id="guardar">
                    Guardar Investigación
                </button>
                <%}%>

            </form> 
            <div id="editorjs"></div>
        </div>

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <%if (request.getAttribute("message") != null) {
                String message = (String) request.getAttribute("message");
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

        <script src="js/editor.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@editorjs/simple-image@latest"></script>
        <script src="https://cdn.jsdelivr.net/npm/@editorjs/header@latest"></script>
        <script src="https://cdn.jsdelivr.net/npm/@editorjs/list@latest"></script>
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

        <script>
            let documento = {};

            <%if (request.getAttribute("investigacion") != null) {%>

            axios.get('http://localhost:8080/SistemaInvestigaciones/File?uuid=<%=in.getDocumentUuid()%>')
                    .then(function (response) {
                        // handle success
                        console.log(response.data);

                        const editor = new EditorJS({
                            /**
                             * Id of Element that should contain Editor instance
                             */
                            holder: 'editorjs',
                            /** 
                             * Available Tools list. 
                             * Pass Tool's class or Settings object for each Tool you want to use 
                             */
                            tools: {
                                header: Header,
                                image: SimpleImage,
                                list: {
                                    class: List,
                                    inlineToolbar: true,
                                },
                            },
                            data: response.data,
                        });
                    })

            <%} else {%>

            const editor = new EditorJS({
                /**
                 * Id of Element that should contain Editor instance
                 */
                holder: 'editorjs',
                /** 
                 * Available Tools list. 
                 * Pass Tool's class or Settings object for each Tool you want to use 
                 */
                tools: {
                    header: Header,
                    image: SimpleImage,
                    list: {
                        class: List,
                        inlineToolbar: true,
                    },
                },
            });

            <%}%>

        </script>

        <script src="valid/validetta.min.js"></script>
        <script src="valid/validettaLang-es-ES.js"></script>
        <script src="js/Investigacion.js"></script>
        <script src="valid/InvestigacionValidation.js"></script>


    </body>
</html>