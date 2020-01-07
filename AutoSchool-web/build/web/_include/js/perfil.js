function modificar(campo, boton) {
    document.getElementById(campo).disabled = false;
    document.getElementById(boton).disabled = true;
    document.getElementById('guarda').style.display = 'inline';
    document.getElementById('cancela').style.display = 'inline';
}
function cancela()
{
    parent.self.window.location = "perfilM.jsp";
}

function presionaLetras(e)
{
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";
    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
        alert('Escribe solo letras.');
        return false;
    }
}

function validaImagen(tField, iType) {
    file = tField.value;
    if (iType == 1) {
        extArray = new Array(".jpg", ".png", ".gif");
    } else {
        if (iType == 2) {
            extArray = new Array(".jpg", ".png");
        } else {
            if (iType == 3) {
                extArray = new Array(".mp3", ".wav", ".ogg", ".MIDI", ".wma", ".m4a");
            }
        }
    }

    allowSubmit = false;
    if (!file)
        return;
    while (file.indexOf("\\") != - 1)
        file = file.slice(file.indexOf("\\") + 1);
    ext = file.slice(file.indexOf(".")).toLowerCase();
    for (var i = 0; i < extArray.length; i++) {
        if (extArray[i] == ext) {
            allowSubmit = true;
            break;
        }
    }
    if (allowSubmit) {
    } else {
        tField.value = "";
        alert("Usted sólo puede subir archivos con extensiones " + (extArray.join(" ")) + "\nPor favor seleccione un nuevo archivo");
    }
}

function validarEmail(email) {
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!expr.test(email)) {
        alert("Error: La dirección de correo " + email + " es incorrecta.");
        document.getElementById('email').focus();
    }
}

function soloNumeros(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "0123456789";
    especiales = [8, 37, 39, 46];
    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
        alert('Escribe solo números.');
        return false;
    }


}