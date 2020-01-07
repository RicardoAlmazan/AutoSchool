<%-- 
    Document   : index
    Created on : 3/11/2016, 02:40:32 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "true" %>
<%
    HttpSession sesion = request.getSession();
    String liga = "";
    String usuario = "";
    String tipoUsr = "";
    String menus = "<li><a href=\"#work\">Nuestro Trabajo</a></li>"
            + "<li><a href=\"#about\">Sobre Nosotros</a></li>"
            + "<li><a href=\"#contact\">Contáctanos</a></li>";
    if (sesion.getAttribute("usr") == null) {
        liga = "<a href='#login' data-toggle='modal'>Iniciar Sesión.</a>";
    } else {
        usuario = sesion.getAttribute("usr").toString();
        liga = "<a href='validaLogin?cerrar=true' class='external'>Cerrar sesión " + usuario + "</a>";
        tipoUsr = sesion.getAttribute("xTipo").toString();
        if (tipoUsr.equals("2")) {
            menus = "<li><a href=\"equipos.jsp\" class=\"external\">Equipos</a></li>"
                    + "<li><a href=\"main.jsp\" class=\"external\">Usuarios</a></li>"
                    + "<li><a href=\"registro.jsp\" class=\"external\">Registro de Usuarios</a></li>";
        } else if (tipoUsr.equals("1")) {
            menus = "<li><a href=\"ConsultaAl.jsp\" class=\"external\">Alumnos</a></li>"
                    + "<li><a href=\"perfilM.jsp\" class=\"external\">Perfil de " + usuario + "</a></li>";
        } else {
            response.sendRedirect("validaLogin?cerrar=true");
        }
    }%>
<!DOCTYPE html>

<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if (IE 9)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!--> <html lang=""> <!--<![endif]-->
    <html>
        <head>
            <link rel="icon" type="image/png" href="_include/img/logoAutoSchool.png" />
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Auto School</title>
            <meta name="description" content="Auto School" /> 
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

            <!-- Supersized -->
            <link href="_include/css/supersized.css" rel="stylesheet">
            <link href="_include/css/supersized.shutter.css" rel="stylesheet">

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
            <style>
                .modal-header, h2, .close {
                    background-color: rgb(51,153,67);
                    color:white !important;
                    text-align: center;
                    font-size: 30px;
                }
                .modal-footer {
                    background-color: #f9f9f9;
                }

                .colores{
                    color: #000;
                }
            </style>
        </head>
        <body>
            <div class="ole">
                <section id="jSplash">
                    <div id="circle"></div>
                </section>
            </div>
            <!-- Menu -->
            <!-- Carrusel -->
            <div id="home-slider">	
                <div class="overlay">
                </div>
                <div class="slider-text">
                    <div id="slidecaption">
                    </div>
                </div>   
                <div class="control-nav">
                    <ul id="slide-list"></ul>       
                    <a id="nextsection" href="#work"><i class="font-icon-arrow-simple-down"></i></a>
                </div>
            </div>
            <!-- Carrusel -->
            <header>
                <div class="sticky-nav">
                    <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

                    <div id="logo">
                        <a id="goUp" href="#home-slider" title="Techno - Dev">Techno - Dev</a>
                    </div>

                    <nav id="menu">
                        <ul id="menu-nav">

                            <li class="current"><a href="#home-slider">Inicio</a></li>
                                <%=menus%>
                            <li><%=liga%></li>

                        </ul>
                    </nav>

                </div>
            </header>
            <div class="modal fade hide" id="login" name= "login" role="dialog">
                <div class="modal-dialog">

                    <div class="modal-content colores">
                        <div class="modal-header" style="padding:35px 50px;">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h1><span class="glyphicon glyphicon-lock"></span>Iniciar sesión</h1>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">
                            <form name="flogin" id="flogin" action="validaLogin" method="POST" onsubmit="valida();" role="form">
                                <center><div class="form-group">
                                        <label for="username"><span class="glyphicon glyphicon-user"></span>Nombre de Usuario</label>
                                        <input type="text" name="txtUsuario" id="username" placeholder="Ingresa tu nombre de usuario" class="form-control btn-block" />
                                    </div>
                                    <div class="form-group">
                                        <label for="passsword"><span class="glyphicon glyphicon-eye-open"></span> Contraseña</label>
                                        <input type="password" name="txtContra" id="password" class="form-control  btn-block" onpaste="return false" placeholder="Ingresa tu contraseña" />
                                    </div>

                                </center><button type="submit" name="btnIngresar" id="ingresar" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Ingresar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <a class="btn btn-danger btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>

                        </div>
                    </div>

                </div>
            </div> 

            <!-- Menu -->

            <div id="work" class="page">
                <div class="container">
                    <!-- Titulo -->
                    <div class="row">
                        <div class="span12">
                            <div class="title-page">
                                <h2 class="title">Nuestro Trabajo</h2>
                            </div>
                        </div>
                    </div>
                    <!-- Titulo -->

                    <!-- Nuestra Empresa -->
                    <div class="row">
                        <div class="span2">
                            <!-- Empresa -->
                            <nav id="options" class="work-nav">
                                <ul id="filters" class="option-set" data-option-key="filter">
                                    <li class="type-work"></li>

                                </ul>
                            </nav>
                            <!-- Empresa -->
                        </div>

                        <div class="span9">
                            <div class="row">
                                <section id="projects">
                                    <ul id="thumbs">

                                        <!-- Mision -->
                                        <li class="item-thumbs span3 design">
                                            <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Misión" href="_include/img/work/full/business_2.jpg">
                                                <span class="overlay-img"></span>
                                                <span class="overlay-img-thumb font-icon-plus"></span>
                                            </a>
                                            <img src="_include/img/work/thumbs/mision.png" alt="Brindar a la sociedad un desarrollo integro, mediante el uso de nuestro software, el cual debera cumplir con los más grandes estandares de calidad para satisfacer las necesidades del cliente.">
                                        </li>
                                        <!-- Mision -->

                                        <!-- Vision -->
                                        <li class="item-thumbs span3 design">
                                            <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Visión" href="_include/img/work/full/business_8.jpg">
                                                <span class="overlay-img"></span>
                                                <span class="overlay-img-thumb font-icon-plus"></span>
                                            </a>
                                            <img src="_include/img/work/thumbs/vision.png" alt="Ser una empresa lider en el desarrollo de tecnologias computacionales para el año 2025.">
                                        </li>
                                        <!-- Vision -->

                                        <!-- Metas -->
                                        <li class="item-thumbs span3 design">
                                            <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Metas" href="_include/img/work/full/Business_1.jpg">
                                                <span class="overlay-img"></span>
                                                <span class="overlay-img-thumb font-icon-plus"></span>
                                            </a>
                                            <img src="_include/img/work/thumbs/metas.png" alt="Ser una empresa lider en el desarrollo de software.<br>
                                                 Lograr un mayor alcance de nuestros productos.<br>
                                                 Ser reconocidos a nivel mundial por nuestros productos amigables para el planeta.">
                                        </li>
                                        <!-- Metas -->





                                        <!-- Estrategias -->
                                        <li class="item-thumbs span3 photography">
                                            <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Estrategias" href="_include/img/work/full/business4.jpg">
                                                <span class="overlay-img"></span>
                                                <span class="overlay-img-thumb font-icon-plus"></span>
                                            </a>
                                            <img src="_include/img/work/thumbs/estrategias.png" alt="Nuestra forma de trabajo gira en torno a los valores con los que Techno-Dev está formado: compromiso, y austeridad, para ofrecer siempre un software de alta calidad.">
                                        </li>
                                        <!-- Estrategias -->

                                        <!-- Politicas -->
                                        <li class="item-thumbs span3 photography">
                                            <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Políticas" href="_include/img/work/full/business8.jpg">
                                                <span class="overlay-img"></span>
                                                <span class="overlay-img-thumb font-icon-plus"></span>
                                            </a>
                                            <img src="_include/img/work/thumbs/politicas.png" alt="En Techno-Dev damos un paso mas asumiendo nuestra responsabilidad global y local en congruencia con los principios de conducta. Como parte del Grupo, contribuimos con nuestros productos a que su desarrollo sea eficiente y practico. Nuestro objetivo es ser el número uno entre los desarrolladores mundiales de software.">
                                        </li>
                                        <!-- Politicas -->

                                        <!-- Valores -->
                                        <li class="item-thumbs span3 design">
                                            <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Valores" href="_include/img/work/full/business_9.jpg">
                                                <span class="overlay-img"></span>
                                                <span class="overlay-img-thumb font-icon-plus"></span>
                                            </a>
                                            <img src="_include/img/work/thumbs/valores.png" alt="Liderazgo.                      Pasión.<br>Responsabilidad.                      Trabajo en equipo.<br>Perseverancia.">
                                        </li>
                                        <!-- Valores -->
                                    </ul>
                                </section>

                            </div>
                        </div>
                    </div>
                    <!-- Nuestra Empresa -->
                </div>
                <!-- Sobre Nosotros -->
                <div id="about" class="page-alternate">
                    <div class="container">
                        <!-- Titulo -->
                        <div class="row">
                            <div class="span12">
                                <div class="title-page">
                                    <h2 class="title">Sobre Nosotros</h2>
                                    <h3 class="title-description">Conoce más sobre el equipo </h3>
                                </div>
                            </div>
                        </div>
                        <!-- Titulo -->

                        <!-- Personas -->
                        <div class="row">

                            <!-- Loth -->
                            <div class="span4 profile">
                                <div class="image-wrap">
                                    <div class="hover-wrap">
                                        <span class="overlay-img"></span>
                                        <span class="overlay-text-thumb">Directora General</span>
                                    </div>
                                    <img src="_include/img/profile/Sandy.png" alt="Céspedes Guerrero Sandy">
                                </div>
                                <h3 class="profile-name">Céspedes Guerrero Sandy</h3>
                                <p class="profile-description">Sandy Monserrat Céspedes Guerrero fue una de las fundadoreas de Techno-Dev. Desde el incio de la empresa ha desarrollado el papel de Directora General. Paritipó en el desarrollo de los proyectos Triimath y TechnoKron</p>

                                <div class="social">
                                    <ul class="social-icons">
                                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                                        <li><a href="#"><i class="font-icon-social-facebook"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- Loth -->
                            <!-- Torres -->
                            <div class="span4 profile">
                                <div class="image-wrap">
                                    <div class="hover-wrap">
                                        <span class="overlay-img"></span>
                                        <span class="overlay-text-thumb">Analista de Sistemas</span>
                                    </div>
                                    <img src="_include/img/profile/Enrique.png" alt="Sánchez Foyo Mauricio">
                                </div>
                                <h3 class="profile-name">Sánchez Foyo Mauricio</h3>
                                <p class="profile-description">Sánchez Foyo Mauricio Enrique partició en el desarrollo de los proyectos TriiMath y TechnoKron. Su papel es diseñar soluciones que presenta el equipo.</p>

                                <div class="social">
                                    <ul class="social-icons">
                                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                                        <li><a href="#"><i class="font-icon-social-facebook"></i></a></li>
                                        <li><a href="#"><i class="font-icon-social-google-plus"></i></a></li>

                                    </ul>
                                </div>
                            </div>

                            <!-- Almazan -->
                            <div class="span4 profile">
                                <div class="image-wrap">
                                    <div class="hover-wrap">
                                        <span class="overlay-img"></span>
                                        <span class="overlay-text-thumb">Programador</span>
                                    </div>
                                    <img src="_include/img/profile/Richie-j.png" alt="Ricardo Almazan" alt="Almazan Trejo Ricardo">
                                </div>
                                <h3 class="profile-name">Almazan Trejo Ricardo</h3>
                                <p class="profile-description">Ricardo Alejandro Almazán Trejo se unió a The Real Technology días después de su fundación. Ha colaborado en la realización de proyectos como "DibuTech" en donde fungió como programador y además de todo, diseñador.</p>

                                <div class="social">
                                    <ul class="social-icons">
                                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                                        <li><a href="#"><i class="font-icon-social-facebook"></i></a></li>
                                        <li><a href="#"><i class="font-icon-social-email"></i></a></li>
                                    </ul>
                                </div>
                            </div>

                            <br/><br/><br/>
                            <!-- Almazan -->
                            <!-- Zuñiga-->
                            <div class="span4 profile">
                                <div class="image-wrap">
                                    <div class="hover-wrap">
                                        <span class="overlay-img"></span>
                                        <span class="overlay-text-thumb">Diseñador Web</span>
                                    </div>
                                    <img src="_include/img/profile/Alvaro-j.jpg" alt="Alvaro Zuñiga" alt="Zuñiga Pineda Alvaro">
                                </div>
                                <h3 class="profile-name">Zuñiga Pineda Alvaro</h3>
                                <p class="profile-description">Alvaro Zúñiga Pineda se unió a The Real Technology desde sus inicios. Colaboró con el desarrollo de "DibuTech" en la parte de la programación. Empezó como programador y su esfuerzo lo ha llevado a posicionarse como director de la empresa. </p>

                                <div class="social">
                                    <ul class="social-icons">
                                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                                        <li><a href="#"><i class="font-icon-social-facebook"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- Zuñiga -->

                            <!-- Torres -->



                        </div>
                        <!-- Personas -->
                    </div>
                </div>
                <!-- Sobre Nosotros -->

                <!-- Contactanos -->
                <div id="contact" class="page">
                    <div class="container">
                        <!-- Titulo -->
                        <div class="row">
                            <div class="span12">
                                <div class="title-page">
                                    <h2 class="title">Contáctanos</h2>
                                    <h3 class="title-description">Tu opinión es importante.</h3>
                                </div>
                            </div>
                        </div>
                        <!-- Titulo -->

                        <!-- Contact Form -->
                        <div class="row">
                            <div class="span9">

                                <form id="contact-form" class="contact-form" name="formu" action="agregaMsj" method="post">
                                    <p class="contact-name">
                                        <input id="contact_name" type="text" placeholder="Nombre Completo" value="" name="nombre" />
                                    </p>
                                    <p class="contact-email">
                                        <input id="contact_email" type="text" placeholder="Dirección de Correo Electronico" value="" name="email" />
                                    </p>
                                    <p class="contact-message">
                                        <textarea id="contact_message" 
                                                  data-toggle="tooltip" title="Cada que saltes de línea presiona Enter, por favor." data-placement="top" placeholder="Mensaje" name="mensaje" rows="15" cols="40"></textarea>
                                    </p>
                                    <p class="contact-submit">
                                        <a id="contact-submit" class="submit" onclick="document.formu.submit()">Enviar</a>
                                    </p>

                                    <div id="response">

                                    </div>
                                </form>

                            </div>

                            <div class="span3">
                                <div class="contact-details">
                                    <h3>Contacto Directo</h3>
                                    <ul>
                                        <li><a href="#">Techno.dev2016@gmail.com</a></li>
                                        <li><a href="#">Techno.dev2016@hotmail.com</a></li>
                                        <li>(55) 45 66 77 65</li>
                                        <li>
                                            Techno-Dev
                                            <br>
                                            Mar Mediterraneo , 227
                                            <br>

                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- Contactanos -->
                    </div>

                </div>

                <div class="modal fade hide" id="login" role="dialog">
                    <div class="modal-dialog">

                        <div class="modal-content">
                            <div class="modal-header" style="padding:35px 50px;">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h2><span class="glyphicon glyphicon-lock"></span>Iniciar sesión</h2>
                            </div>
                            <div class="modal-body" style="padding:40px 50px;">
                                <form name="flogin" id="flogin" action="login.jsp" method="POST" onsubmit="valida();" role="form">
                                    <center><div class="form-group">
                                            <label for="username"><span class="glyphicon glyphicon-user"></span>Nombre de Usuario</label>
                                            <input type="text" name="txtUsuario" id="username" placeholder="Ingresa tu nombre de usuario" class="form-control btn-block" />
                                        </div>
                                        <div class="form-group">
                                            <label for="passsword"><span class="glyphicon glyphicon-eye-open"></span> Contraseña</label>
                                            <input type="password" name="txtContra" id="password" class="form-control  btn-block" onpaste="return false" placeholder="Ingresa tu contraseña" />
                                        </div>

                                    </center><button type="submit" name="btnIngresar" id="ingresar" class="btn btn-info btn-block"><span class="glyphicon glyphicon-off"></span>Ingresar</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <a class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>
                                <p class="text-muted text-center">¿No tienes una cuenta? <br><a href="registro.jsp" class="btn btn-link">Regístrate</a></p>
                            </div>
                        </div>

                    </div>
                </div> 
            </div>

            <!-- End Contact Section -->
            <!-- Socialize -->
            <div id="social-area" class="page">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <nav id="social">
                                <ul>
                                    <li><a href="https://twitter.com/The_Real_Techno" title="Síguenos en Twitter" target="_blank"><span class="font-icon-social-twitter"></span></a></li>
                                    <li><a href="https://www.facebook.com/TechnoDev16/" title="Síguenos en Facebook" target="_blank"><span class="font-icon-social-facebook"></span></a></li>
                                    <li><a href="https://plus.google.com/u/0/113400054013171870295?hl=es" title="Síguenos en Google Plus" target="_blank"><span class="font-icon-social-google-plus"></span></a></li>

                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Socialize -->
            <footer>
                <p class="credits">&copy;2016  <a title="Techno - Dev">Techno - Dev</a> 
                </p>
            </footer>
            <!-- End Footer -->

            <!-- Back To Top -->
            <a id="back-to-top" href="#">
                <i class="font-icon-arrow-simple-up"></i>
            </a>
            <!-- Js -->
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- jQuery -->
            <script src="_include/js/bootstrap.min.js"></script> <!-- Bootstrap -->
            <script src="_include/js/supersized.3.2.7.min.js"></script> 
            <script src="_include/js/waypoints.js"></script> 
            <script src="_include/js/waypoints-sticky.js"></script> 
            <script src="_include/js/jquery.isotope.js"></script>
            <script src="_include/js/jquery.fancybox.pack.js"></script> 
            <script src="_include/js/jquery.fancybox-media.js"></script> 
            <script src="_include/js/jquery.tweet.js"></script> <!-- Tweet -->
            <script src="_include/js/plugins.js"></script> 
            <script src="_include/js/main.js"></script> <!-- Default JS -->
            <script type="text/javascript">
                                    $(function () {
                                        $('[data-toggle="tooltip"]').tooltip()
                                    });
            </script>
        </body>
    </html>
