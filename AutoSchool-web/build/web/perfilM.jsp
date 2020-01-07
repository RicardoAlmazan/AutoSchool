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
    String valor = "";
    if (sesion.getAttribute("usr") != null && !sesion.getAttribute("xTipo").toString().equalsIgnoreCase("2")) {
        try {
            usuario = sesion.getAttribute("usr").toString();
            liga = "<li><a href='validaLogin?cerrar=true' class=external>Cerrar sesión " + usuario + " </a></li>";
            profesor.DatosProfesor_Service service = new profesor.DatosProfesor_Service();
            profesor.DatosProfesor port = service.getDatosProfesorPort();
            java.lang.String result = port.getTodosLosDatosProfe(usuario);
            if (result.equalsIgnoreCase("No hay error")) {
                nombre = port.getNombre();
                apePat = port.getApePaterno();
                apeMat = port.getApeMaterno();
                email = port.getEmail();
                
            } else {
                out.print(result);
            }

        } catch (Exception ex) {
            out.print("Error: " + ex.getMessage());
        }

    } else {
        out.print("<script>"
                + "var pagina = 'javascript:history.go(-1)'; "
                + "document.location.href=pagina;"
                + "</script>");
    }


%>    <%-- start web service invocation --%>
<%
%>
<%-- end web service invocation --%>

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
        <meta name="description" content="The Real Technology" /> 

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
        <script>
            function cancelaReg()
            {
                parent.self.window.location = "perfilM.jsp";
            }
        </script>
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
                        <li><a href="ConsultaAl.jsp" class="external">Alumnos</a></li>
                        <!--<li><a href="registro.jsp" class="external">Registrar</a></li>-->
                        <li class="current"><a href="perfilM.jsp">Perfil de <%=usuario%></a></li>
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
                            <h3 class="title-description">@<%=usuario%> </h3>

                        </div>
                    </div>
                </div>
                <!--Cierre de Titulo -->
                <!-- Start Accordion/Toggle Section -->
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
                                        <form  action="validaModificar" method="POST" name="formu">
                                            <span class="col-lg-2 control-label" style="padding-right: 75px;"> Nombre: </span>
                                            <input class="form-control-static" type="text" value="<%=nombre%>" disabled="true" name="nombre" id="nombre" required="true" maxlength="50" onkeypress="return presionaLetras(event);"/>
                                            <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('nombre', 'butNom');" value="Modificar" name="butNom" id="butNom"/><br>

                                            <span class="col-lg-2 control-label" style="padding-right: 68px;">  Paterno:</span>
                                            <input class="form-control-static" type="text" value="<%=apePat%>"  required="true" maxlength="20" disabled="true" name="paterno" id="paterno"onkeypress="return presionaLetras(event);"/>
                                            <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('paterno', 'butPat');" value="Modificar" name="butPat" id="butPat"/><br>
                                            <span class="col-lg-2 control-label" style="padding-right: 68px;">  Materno:</span>
                                            <input class="form-control-static" type="text" value="<%=apeMat%>"  required="true" maxlength="20" disabled="true" name="materno" id="materno"onkeypress="return presionaLetras(event);"/>
                                            <input type="button" class="btn btn-info form-control-static" style="float: right;" onclick="modificar('materno', 'butMat');" value="Modificar" name="butMat" id="butPat"/><br>

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
            <p class="credits">&copy;2016  <a title="The Real Technology">The Real Technology</a> 
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
