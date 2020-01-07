<%-- 
    Document   : registro
    Created on : 09-nov-2016, 21:21:05
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*;" session="true"%>
<%
    HttpSession sesion = request.getSession();
    String usuario = "";

    if (sesion.getAttribute("usr") != null && sesion.getAttribute("xTipo").toString().equalsIgnoreCase("2")) {
        usuario = sesion.getAttribute("usr").toString();
    } else {
        out.print("<script>"
                + "var pagina = 'javascript:history.go(-1)'; "
                + "document.location.href=pagina;"
                + "</script>");

    }

%>
<!DOCTYPE html>
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



        <!-- Main Style -->
        <link href="_include/css/main.css" rel="stylesheet">

        <!-- Supersized -->
        <link href="_include/css/supersized.css" rel="stylesheet">
        <link href="_include/css/supersized.shutter.css" rel="stylesheet">

        <!-- FancyBox -->
        <link href="_include/css/fancybox/jquery.fancybox.css" rel="stylesheet">

        <!-- Font Icons -->
        <link href="_include/css/fonts.css" rel="stylesheet">



        <!-- Responsive -->

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
        <link href="_include/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="_include/css/estilos-registro.css" rel="stylesheet" type="text/css"/>
        <link href="_include/css/fileinput.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <title>Registrar</title>
    </head>
    <body>
        <div class="ole">
            <section id="jSplash">
                <div id="circle"></div>
            </section>
        </div>
        <!-- Menu -->
        <header>
            <div class="sticky-nav">
                <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

                <div id="logo">
                    <a id="goUp" href="#home-slider" title="Techno - Dev">Techno - Dev</a>
                </div>

                <nav id="menu">
                    <ul id="menu-nav">
                        <li><a href="equipos.jsp" class="external">Equipos</a></li>
                        <li><a href="main.jsp" class="external">Usuarios</a></li>
                        <li><a href="materias.jsp" class="external">Materias</a></li>
                        <li class="current"><a href="registro.jsp">Registrar</a></li>

                        <li><a href="validaLogin?cerrar=true" class="external">Cerrar sesión<%= " " + usuario%></a></li>
                    </ul>
                </nav>

            </div>
        </header>
        <div class="page">
            <div class="container boxlogin text-center jumbotron">

                <h1 style="font-size: 35px; padding-bottom: 30px;">Registro de Usuarios</h1>
                <form action="validaRegistroServ" method="POST" class="form-horizontal" name="formulario1" role="form" onsubmit="alert(niv.value)">
                    <div class="form-group nivel">
                        <label for="tipoUsr" class="col-lg-2 control-label"></label>
                        <div class="col-lg-10 form-control-static">
                            <label for="tipoUsr">Tipo de usuario.</label>

                            <select class="form-control" id="tipoUsr" name="tipoUsr" 
                                    data-toggle="tooltip" title="Defina el tipo de usuario." data-placement="right" onchange="asignTipoUsr();">

                                <option value="0">Seleccione el tipo de Usuario.</option>
                                <option value="2">Profesor</option>
                                <option value="3">Alumno</option>
                            </select>
                        </div>
                    </div>
                    <input type="hidden" id="tipoUser" name="tipoUser">
                    <div class="form-group" id="nombreDiv">
                        <label for="nombre" class="col-lg-2 control-label">Nombre:</label>
                        <div class="col-lg-10">
                            <input type="text" name="nombre" class="form-control" data-toggle="tooltip" title="Escribe tu nombre real." data-placement="right" 
                                   onkeypress="return presionaLetras(event);" id="nombre" required
                                   placeholder="Introduce tu nombre" maxlength="50" onpaste="return false;">
                            <span id="errorNombre" class=""></span>
                        </div>
                    </div>
                    <div class="form-group" id="paternoDiv">
                        <label for="paterno" class="col-lg-2 control-label">Apellido Paterno:</label>
                        <div class="col-lg-10 form-control-static">
                            <input type="text" name="paterno" class="form-control" id="paterno" onkeypress="return presionaLetras(event);"
                                   data-toggle="tooltip" title="Escribe tu apellido real." data-placement="right" required
                                   placeholder="Introduce tu apellido paterno" maxlength="20" onpaste="return false;">
                            <span id="errorPaterno" class=""></span>
                        </div>
                    </div>
                    <div class="form-group" id="maternoDiv">
                        <label for="materno" class="col-lg-2 control-label">Apellido Materno:</label>
                        <div class="col-lg-10 form-control-static">
                            <input type="text" name="materno" class="form-control" id="materno" onkeypress="return presionaLetras(event);"
                                   data-toggle="tooltip" title="Escribe tu apellido real." data-placement="right" required
                                   placeholder="Introduce tu apellido materno" maxlength="20" onpaste="return false;">
                            <span id="errorMaterno" class=""></span>
                        </div>
                    </div>
                    <div class="form-group nivel" name="muestraGrupo" id ="muestraGrupo" style="display:none">
                        <label for="elGrupo" class="col-lg-2 control-label"></label>
                        <div class="col-lg-10 form-control-static">
                            <label for="semestre">Elija su grupo:</label>

                            <select class="form-control" id="semestre" name="semestre" 
                                    data-toggle="tooltip" title="Defina su semestre." data-placement="right" >

                                <option value="0">Seleccione su semestre.</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                            <select class="form-control" id="turno" name="turno" 
                                    data-toggle="tooltip" title="Defina su turno." data-placement="right" >

                                <option value="0">Seleccione su turno.</option>
                                <option value="M">Matutino</option>
                                <option value="V">Vespertino</option>
                            </select>
                            <select class="form-control" id="grupo" name="grupo" 
                                    data-toggle="tooltip" title="Defina su grupo." data-placement="right" >

                                <option value="0">Seleccione su grupo.</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-group" id="emailDiv">
                        <label for="email" class="col-lg-2 control-label">Email:</label>
                        <div class="col-lg-10">
                            <input type="email" name="email" onchange="validarEmail(this.value)" class="form-control" id="email"
                                   data-toggle="tooltip" title="Escribe tu email real." data-placement="right" 
                                   placeholder="Introduce tu email" maxlength="100" required>
                            <span id="errorEmail" class=""></span>
                        </div>
                    </div>
                    <div class="form-group" id="gametagDiv">
                        <label for="gametag" class="col-lg-2 control-label">Nombre de Usuario: </label>
                        <div class="col-lg-10">

                            <input type="text" name="gametag" class="form-control" id="gametag" onkeypress="return sinEspeciales(event);" onchange="html_encode(this.value)"
                                   data-toggle="tooltip" title="Es requerido para acceder al sistema." data-placement="right" 
                                   placeholder="Introduce tu nombre de usuario." maxlength="30" required>
                            <span id="errorGametag" class=""></span>
                        </div>
                    </div>

                    <div class="form-group" id="contraDiv">
                        <label for="contra" class="col-lg-2 control-label">Contraseña:</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="contra" name="contra" onkeypress="return sinEspeciales(event);"
                                   data-toggle="tooltip" title="La contraseña debe contener mínimo 6 caracteres." data-placement="right" 
                                   placeholder="Contraseña" maxlength="30" required>
                            <span id="errorContra" class=""></span>
                        </div>
                    </div>
                    <div class="form-group" id="nContraDiv">
                        <label for="ncontra" class="col-lg-2 control-label">Confirma contraseña:</label>
                        <div class="col-lg-10 form-control-static">
                            <input type="password" class="form-control" id="ncontra" name="ncontra" onkeypress="return sinEspeciales(event);"
                                   data-toggle="tooltip" title="Vuelva a escribir su contraseña." data-placement="right" 
                                   placeholder="Escribe nuevamente tu contraseña" maxlength="30" required
                                   onpaste="return false">
                            <span id="errornContra" class=""></span>
                        </div>
                        <div id="errorContraN" class=""></div>
                    </div>
                    <div class="form-group" id="">
                        <textarea class="form-control" id="huella" name="huella" onkeypress="return soloNumeros(event);"
                                  data-toggle="tooltip" title="Ingrese su huella digital" data-placement="right" 
                                  placeholder="Aquí va la huella" maxlength="30" required
                                  onpaste="return false"></textarea>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-1 col-lg-10">
                            <input name="registro" id ="registro" type="submit" onclick="validarFormulario();" class="btn btn-primary" value="Registrar">
                        </div>
                    </div>


                </form>
            </div>
        </div>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- jQuery Core -->
        <script src="_include/js/login.js" type="text/javascript"></script>
        <script src="_include/js/fileinput.min.js" type="text/javascript"></script>
        <script src="CSS/tooltip.js" type="text/javascript"></script>
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

