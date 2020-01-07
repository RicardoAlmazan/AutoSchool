<%-- 
    Document   : perfilM
    Created on : 09-nov-2016, 21:16:41
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "true" %>
<%
    HttpSession sesion = request.getSession();
    String usuario = "";
    String liga = "";
    String nombre = "";
    String apePat = "";
    String apeMat = "";
    String email = "";
    String grupo = "";
    String valor = "";
    boolean muestraFormu = false;
    int numForm = 0;
    if (sesion.getAttribute("usr") != null && sesion.getAttribute("xTipo").toString().equalsIgnoreCase("2")) {

        usuario = sesion.getAttribute("usr").toString();
        liga = "<li><a href='validaLogin?cerrar=true' class=external>Cerrar sesión " + usuario + " </a></li>";
        if (request.getParameter("buscar") == null) {
            muestraFormu = false;
        } else {

            muestraFormu = true;
            try {
                administrador.Administrador_Service service = new administrador.Administrador_Service();
                administrador.Administrador port = service.getAdministradorPort();

                java.lang.String result = port.buscarUsr(request.getParameter("busca"));
                if (result.equalsIgnoreCase("Usuario encontrado")) {
                    java.lang.String tipoUsr = port.getTipoUsr();
                    if(sesion.getAttribute("Usr2") != null){
                    sesion.removeAttribute("Usr2");
                    sesion.removeAttribute("email2"); sesion.removeAttribute("grupo2");
                    sesion.removeAttribute("xid2");
                    sesion.removeAttribute("nombre2");
                    sesion.removeAttribute("apePat2");
                    sesion.removeAttribute("apeMat2");
                    }
                    switch (Integer.parseInt(tipoUsr)) {
                        case 1:
                            out.print("Eres tú, weon");
                            break;
                        case 2:
                            try {
                                profesor.DatosProfesor_Service servicioProfe = new profesor.DatosProfesor_Service();
                                profesor.DatosProfesor puertoProfe = servicioProfe.getDatosProfesorPort();
                                java.lang.String resultProfe = puertoProfe.getTodosLosDatosProfe(request.getParameter("busca"));
                                if (resultProfe.equalsIgnoreCase("No hay error")) {
                                    nombre = puertoProfe.getNombre();
                                    apePat = puertoProfe.getApePaterno();
                                    apeMat = puertoProfe.getApeMaterno();
                                    email = puertoProfe.getEmail();
                                    sesion.setAttribute("email2", email);
                                    sesion.setAttribute("Usr2", puertoProfe.getUsr());
                                    sesion.setAttribute("xid2", puertoProfe.getId());
                                    numForm = 1;
                                } else {
                                    out.print(resultProfe);
                                }
                            } catch (Exception ex) {
                                out.print(ex.getMessage());
                            }
                            break;
                        case 3:
                            try {
                                service = new administrador.Administrador_Service();
                                administrador.Administrador pAlum = service.getAdministradorPort();
                                java.lang.String resAl = pAlum.getTodosLosDatosAlumno(request.getParameter("busca"));
                                if (resAl.equalsIgnoreCase("No hay error")) {
                                    nombre = pAlum.getNombre();
                                    apePat = pAlum.getApePaterno();
                                    apeMat = pAlum.getApeMaterno();
                                    grupo = pAlum.getGrupo();
                                    sesion.setAttribute("grupo2", grupo);
                                    sesion.setAttribute("Usr2", pAlum.getUsr());
                                    sesion.setAttribute("xid2", pAlum.getIdUsr());
                                    numForm = 2;
                                }
                            } catch (Exception ex) {
                                out.print(ex.getMessage());
                            }
                            break;

                    }
                    sesion.setAttribute("nombre2", nombre);
                    sesion.setAttribute("apePat2", apePat);
                    sesion.setAttribute("apeMat2", apeMat);

                } else {
                    out.print("<script>alert('Usuario no encontrado');</script>");
                    muestraFormu = false;
                }
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }

        }
    } else {
        out.print("<script>"
                + "var pagina = 'index.jsp'; "
                + "document.location.href=pagina;"
                + "</script>");
    }


%>



<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if (IE 9)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
    <head>
        <link rel="icon" type="image/png" href="_include/img/logoAutoSchool.png" />
        <!-- Meta Tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <title>Perfil de <%=usuario%></title>   

        <meta name="description" content="Techno-Dev" /> 

        <style>
            .progress-bar-azulito{
                background-color:  #00B0DD;
                color: #fff;
                margin: auto 0;
                text-align: center;
                align-content: center;
                top: 0%;
            }
        </style>
        <style>
            .modal-header, .close {
                background-color: #00A0DF;
                color:white !important;
                text-align: center;
                font-size: 30px;
            }
            .modal-header h2{
                background-color: #00A0DF;
                color:white !important;
                text-align: center;
                font-size: 30px;
            }
            .modal-footer {
                background-color: #f9f9f9;
            }
            .modal-body {
                color: black;

            }
        </style>

        <!-- Mobile Specifics -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="HandheldFriendly" content="true"/>
        <meta name="MobileOptimized" content="320"/>   

        <!-- Mobile Internet Explorer ClearType Technology -->
        <!--[if IEMobile]>  <meta http-equiv="cleartype" content="on">  <![endif]-->

        <!-- Bootstrap -->
        <link href="_include/css/bootstrap.min.css" rel="stylesheet">

        <!-- Main Style -->
        <link href="_include/css/main.css" rel="stylesheet">

        <!-- Supersized -->
        <link href="_include/css/supersized.css" rel="stylesheet">
        <link href="_include/css/supersized.shutter.css" rel="stylesheet">
        <!-- FancyBox -->
        <link href="_include/css/fancybox/jquery.fancybox.css" rel="stylesheet">

        <!-- Font Icons -->
        <link href="_include/css/fonts.css" rel="stylesheet">

        <!-- Shortcodes -->
        <link href="_include/css/shortcodes.css" rel="stylesheet">

        <!-- Responsive -->
        <link href="_include/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="_include/css/responsive.css" rel="stylesheet">

        <!-- Google Font -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,200italic,300,300italic,400italic,600,600italic,700,700italic,900' rel='stylesheet' type='text/css'>

        <!-- Fav Icon -->
        <link rel="shortcut icon" href="#">

        <link rel="apple-touch-icon" href="#">
        <link rel="apple-touch-icon" sizes="114x114" href="#">
        <link rel="apple-touch-icon" sizes="72x72" href="#">
        <link rel="apple-touch-icon" sizes="144x144" href="#">

        <!-- Modernizr -->
        <script src="_include/js/modernizr.js"></script>
        <link href="_include/css/fileinput.min.css" rel="stylesheet" type="text/css"/>

    </head>


    <body>

        <!-- Splash -->
        <section id="jSplash">
            <div id="circle"></div>
        </section>
        <!-- End of Splash Screen -->

        <!-- Header -->
        <header>
            <div class="sticky-nav">
                <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

                <div id="logo">
                    <a id="goUp" href="index.jsp" title="Techno-Dev">Techno-Dev</a>
                </div>

                <nav id="menu">
                    <ul id="menu-nav">
                        <li><a href="equipos.jsp" class="external">Equipos</a></li>
                        <li  class="current"><a href="main.jsp">Usuarios</a></li>
                        <li><a href="materias.jsp" class="external">Materias</a></li>
                        <li><a href="registro.jsp" class="external">Registro de Usuarios</a></li>
                            <%=liga%>

                    </ul>
                </nav>

            </div>
        </header>
        <!-- / Header -->
        <!-- Perfil -->
        <div id="shortcodes" class="page">
            <div class="container" style="height:100%">

                <!-- Title Page -->
                <div class="row">
                    <div class="span12">
                        <div class="title-page">
                            <img src="_include/img/logoAutoSchool.png" class="img-circle" width="180px" ><br>
                            <form action="main.jsp" method="post">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="input-group">
                                            <span class="input-group-btn">
                                                <button class="btn btn-info btn-primary" type="submit" name="buscar" id="buscar">Buscar</button>
                                            </span>
                                            <input type="text" class="form-control" name="busca" id="busca">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!--Cierre de Titulo -->
                <!-- Start Accordion/Toggle Section -->
                <%if (muestraFormu) {%>
                <div class="row center-block ">



                    <div class="span9">
                        <h3 class="spec">Información</h3>

                        <!-- Toggle -->
                        <div class="accordion" id="toggleArea">

                            <div class="accordion-group">
                                <div class="accordion-heading togglize">
                                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#" href="#collapseOne">
                                        Sobre <%=nombre%> 
                                        <span class="font-icon-plus"></span>
                                        <span class="font-icon-minus"></span>
                                    </a>
                                </div>
                                <div id="collapseOne" class="accordion-body collapse">
                                    <div class="accordion-inner" charset=UTF-8>
                                        <%if (numForm == 1) {%>
                                        <form  action="modificaAdmin?oxq=1" method="POST" name="formu">
                                            <%} else if (numForm == 2) {%>
                                            <form  action="modificaAdmin?oxq=2" method="POST" name="formu">
                                                <%}%>
                                                <span class="col-lg-2 control-label" style="padding-right: 75px;"> Nombre: </span>
                                                <input class="form-control-static" type="text" value="<%=nombre%>" disabled="true" name="nombre" id="nombre" required="true" maxlength="50" onkeypress="return presionaLetras(event);"/>
                                                <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('nombre', 'butNom');" value="Modificar" name="butNom" id="butNom"/><br>

                                                <span class="col-lg-2 control-label" style="padding-right: 68px;">  Paterno:</span>
                                                <input class="form-control-static" type="text" value="<%=apePat%>"  required="true" maxlength="20" disabled="true" name="paterno" id="paterno"onkeypress="return presionaLetras(event);"/>
                                                <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('paterno', 'butPat');" value="Modificar" name="butPat" id="butPat"/><br>
                                                <span class="col-lg-2 control-label" style="padding-right: 68px;">  Materno:</span>
                                                <input class="form-control-static" type="text" value="<%=apeMat%>"  required="true" maxlength="20" disabled="true" name="materno" id="materno"onkeypress="return presionaLetras(event);"/>
                                                <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('materno', 'butMat');" value="Modificar" name="butMat" id="butMat"/><br>
                                                <%if (numForm == 1) {%>

                                                <span class="col-lg-2 control-label" style="padding-right: 85px;"> E-mail: </span>
                                                <input class="form-control-static" type="email" value="<%=email%>" disabled="true" name="email" id="email"  required="true" maxlength="100" onchange="validarEmail(this.value)"/>
                                                <input type="button" class="btn btn-info form-control-static" id="butEmail" name="butEmail"
                                                       style="float: right;" onclick="modificar('email', 'butEmail');" value="Modificar"/><br>

                                                <span class="col-lg-2 control-label" style="padding-right: 53px;"> Contraseña:  </span>
                                                <input class="form-control-static" type="password" value="" disabled="true" name="contra" id="contra"  required="true" maxlength="30"/>
                                                <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('contra', 'butCon');
                                                        document.getElementById('lbncontra').style.display = 'inline';
                                                        document.getElementById('ncontra').style.display = 'inline';"
                                                       value="Modificar" name="butCon" id="butCon"/><br>


                                                <span class="col-lg-2 control-label" style="padding-right: 53px; display: none;" id="lbncontra"> Confirma contraseña:  </span>
                                                <input class="form-control-static" style="display:none;" type="password" name="ncontra" id="ncontra"/><br>

                                                <%} else if (numForm == 2) {%>
                                                <span class="col-lg-2 control-label" style="padding-right: 85px;"> Grupo: </span>
                                                <input class="form-control-static" type="text" value="<%=grupo%>" disabled="true" name="grupo" id="grupo"  required="true" maxlength="100"/>
                                                <input type="button" class="btn btn-info form-control-static" id="butGrupo" name="butGrupo"
                                                       style="float: right;" onclick="modificar('grupo', 'butGrupo');" value="Modificar"/><br>
                                                <%}%>
                                                <input type="hidden" name="confContra" id="confContra">
                                                <input type="button" data-toggle="modal" data-target="#validaRegistro" style="display:none;padding-left:45px; padding-right: 25px;" class="btn btn-info form-control-static" value="Actualizar"  id="guarda" name="guarda"/>
                                                <input type="button" id="cancela" name="cancela" style="display:none;" class="btn btn-info form-control-static" value="Cancelar" onclick="cancelaReg();" />
                                                <input type="hidden" id="acepta" name="acepta">
                                            </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Accordion/Toggle Section -->



                    </div>
                    <!-- End Accordion/Toggle Section -->
                </div>
                <%}%>
            </div>
        </div>
        <div class="modal fade hide" id="validaRegistro" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header" style="padding:35px 50px;">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h2>Confirmar los cambios.</h2>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">
                        Por favor, introduce tu contraseña.
                        <input type="password" name="confContr" id="confContr" onchange="document.getElementById('confContra').value = this.value;">

                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-danger btn-default pull-center" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>
                        <input type="button" onclick="document.formu.submit()"   class="btn btn-info form-control-static" value="Aceptar" name ="aceptar" onchange="document.getElementById('acepta').value = this.value;">
                    </div>
                </div>

            </div>
        </div>
        <footer>
            <p class="credits">&copy;2016  <a title="Techno-Dev">Techno-Dev</a> 
            </p>
        </footer>
        <!-- End Footer -->

        <!-- Js -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- jQuery Core -->
        <script src="_include/js/bootstrap.min.js"></script> <!-- Bootstrap -->
        <script src="_include/js/supersized.3.2.7.min.js"></script> <!-- Slider -->
        <script src="_include/js/waypoints.js"></script> <!-- WayPoints -->
        <script src="_include/js/waypoints-sticky.js"></script> <!-- Waypoints for Header -->
        <script src="_include/js/jquery.isotope.js"></script> <!-- Isotope Filter -->
        <script src="_include/js/jquery.fancybox.pack.js"></script> <!-- Fancybox -->
        <script src="_include/js/jquery.fancybox-media.js"></script> <!-- Fancybox for Media -->
        <script src="_include/js/jquery.tweet.js"></script> <!-- Tweet -->
        <script src="_include/js/plugins.js"></script> <!-- Contains: jPreloader, jQuery Easing, jQuery ScrollTo, jQuery One Page Navi -->
        <script src="_include/js/main.js"></script> <!-- Default JS -->
        <script src="_include/js/fileinput.min.js" type="text/javascript"></script>

        <script src="_include/js/perfil.js" type="text/javascript"></script>

        <!-- End Js -->

    </body>
</html>
