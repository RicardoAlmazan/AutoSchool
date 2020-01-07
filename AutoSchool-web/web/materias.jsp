<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*;" session="true"%>
<%
    HttpSession sesion = request.getSession();
    String usuario = "";
    String liga = "";

    if (sesion.getAttribute("usr") != null && sesion.getAttribute("xTipo").toString().equalsIgnoreCase("2")) {
        usuario = sesion.getAttribute("usr").toString();
        liga = "<li><a href='validaLogin?cerrar=true' class=external>Cerrar sesión " + usuario + " </a></li>";
    } else {
        out.print("<script>"
                + "var pagina = 'javascript:history.go(-1)'; "
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

        <title>Materias</title>   
        <meta name="description" content="Techno - Dev" /> 

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
                        <li ><a href="equipos.jsp" class="external">Equipos</a></li>
                        <li ><a href="main.jsp" class="external">Usuarios</a></li>
                        <li  class="current"><a href="materias.jsp">Materias</a></li>
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
                            <h3 class="title-description">@<%=usuario%> </h3>

                        </div>
                    </div>
                </div>
                <!--Cierre de Titulo -->
                <!-- Start Accordion/Toggle Section -->
                <div class="row">



                    <div class="span6">
                        <h3 class="spec">Agregar Materias</h3>
                        
                    </div>
                    <!-- End Accordion/Toggle Section -->
                </div>
            </div>
        </div>
        <footer>
            <p class="credits">&copy;2016  <a title="Techno - Dev">Techno - Dev</a> 
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
