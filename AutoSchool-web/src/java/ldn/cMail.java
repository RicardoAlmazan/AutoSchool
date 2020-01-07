/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldn;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class cMail {

    //public boolean enviarCorreo(String de, String clave, String[] para, String mensaje, String asunto){
    public boolean enviarCorreo(String para, String mensaje,  String asunto) {
        boolean enviado = false;
        try {
            String de = "techno.dev2016@gmail.com";
            String clave = "charizard06";

            String host = "smtp.gmail.com";

            Properties prop = System.getProperties();

            prop.put("mail.debug", "true");
            prop.put("mail.smtp.starttls.enable", true);
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.password", clave);
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(prop, null);

            MimeMessage message = new MimeMessage(sesion);

            message.setFrom(new InternetAddress(de));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));

            message.setSubject(asunto);
            message.setContent(mensaje, "text/html");

            Transport transport = sesion.getTransport("smtp");

            transport.connect(host, de, clave);
            message.saveChanges();
            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

            enviado = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.toString());
        }

        return enviado;
    }

    public String mensajito() {
        
        String config = "https://drive.google.com/uc?export=view&id=";
        String regreso = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "<head>\n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                + "<title>Documento sin título</title>\n"
                + "<style type=\"text/css\">\n"
                + ".cssss {\n"
                + "	font-family: \"Palatino Linotype\", \"Book Antiqua\", Palatino, serif;\n"
                + "}\n"
                + ".iitti {\n"
                + "	color: #FFF;\n"
                + "}\n"
                + ".iitti {\n"
                + "	font-weight: bold;\n"
                + "}\n"
                + ".uouu {\n"
                + "	color: #FFF;\n"
                + "	font-weight: bold;\n"
                + "}\n"
                + ".uuuu {\n"
                + "	color: #39C;\n"
                + "}\n"
                + ".imgbutton{\n"
                + "  padding-left: 35%;\n"
                + "}\n"
                + ".fb{\n"
                + "\n"
                + "}\n"
                + ".tw{\n"
                + "  padding-left: 35%;\n"
                + "\n"
                + "}\n"
                + ".gp{\n"
                + "  padding-left: 32%;\n"
                + "\n"
                + "\n"
                + "\n"
                + "}\n"
                + "\n"
                + "</style>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "<center>\n"
                + "  <table width=\"617\" height=\"1050\" border=\"0\">\n"
                + "    <tr>\n"
                + "    <td height=\"30\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"203\" rowspan=\"3\">&nbsp;</td>\n"
                + "    <td height=\"140\" colspan=\"3\" align=\"center\" bgcolor=\"#FFFFFF\"><h1>Gracias por sus comentarios.\n"
                + "      </h1>\n"
                + "      <div>Los comentarios de nuestros usuarios son demasiado importantes para nosotros<br />\n"
                + "        <br />\n"
                + "        por lo que agradecemos que se haya tomado el tiempo de comentarnos.<br data-cke-eol=\"1\" />\n"
                + "    </div></td>\n"
                + "    <td height=\"203\" rowspan=\"3\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"67\" colspan=\"3\" bgcolor=\"#FFFFFF\"></td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"48\" colspan=\"3\" align=\"center\" bgcolor=\"#FFFFFF\">Lo invitamos a visitar nuestros demás trabajos.</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"261\" rowspan=\"2\">&nbsp;</td>\n"
                + "    <td width=\"243\" height=\"194\" bgcolor=\"#FFFFFF\"><a href=\"\"><img src=\"" + config + "0B5FLny8RkXOFeUtYNkNjZjFBdUE\" width=\"247\" height=\"232\" /></a></td>\n"
                + "    <td width=\"30\" rowspan=\"2\" bgcolor=\"#FFFFFF\">&nbsp;</td>\n"
                + "    <td width=\"243\" bgcolor=\"#FFFFFF\"><a href=\"\"><img src=\"" + config + "0B5FLny8RkXOFWnp3cXFhOXFEczQ\" width=\"247\" height=\"232\" /></a></td>\n"
                + "    <td rowspan=\"2\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"128\" align=\"center\" bgcolor=\"#666666\" class=\"iitti\"><br />\n"
                + "      Aprende más sobre la historia del dibujo técnico.<br />\n"
                + "      <br />\n"
                + "      (Click en la imagen)</td>\n"
                + "    <td width=\"243\" align=\"center\" bgcolor=\"#666666\" class=\"uouu\">Aprende más sobre los paises del mundo con un divertido mapa interactivo y juegos que pondran a pureba tus conocimientos.<br />\n"
                + "      (Click en la imagen)</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"77\" rowspan=\"3\">&nbsp;</td>\n"
                + "    <td height=\"58\" colspan=\"3\" bgcolor=\"#FFFFFF\"><a href=\"https://www.facebook.com/The-Real-Technology-1137866912900563/?__mref=message_bubble\"><img src=\"" + config + "0B5FLny8RkXOFQXUtcWk0MFhRRE0\" width=\"58\" class=\"fb\" height=\"58\" /></a><a href=\"https://twitter.com/The_Real_Techno\"><img src=\"" + config + "0B5FLny8RkXOFVTdibU80LXNUS1k\" class=\"tw\" width=\"58\" height=\"58\" /></a><a href=\"https://plus.google.com/u/0/113400054013171870295?hl=es\"><img src=\"" + config + "0B5FLny8RkXOFZWkydUNBMzMyQ1k\" class=\"gp\" width=\"58\" height=\"58\" /></a></td>\n"
                + "    <td rowspan=\"3\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"3\" bgcolor=\"#FFFFFF\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\" align=\"center\" bgcolor=\"#FFFFFF\"><em>Copyright © <strong class=\"uuuu\">2016 Techno - Dev</strong></em><br /></td>\n"
                + "  </tr>\n"
                + "</table>\n"
                + "  <p>&nbsp;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "</center>\n"
                + "</body>\n"
                + "</html>\n"
                + "\n"
                + "                            ";

        return regreso;
    }
    
    public String mensajito(String gametag) {
        String ip = "192.168.43.208:8080";
        String config = "https://drive.google.com/uc?export=view&id=";
        String regreso = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "<head>\n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                + "<title>Documento sin título</title>\n"
                + "<style type=\"text/css\">\n"
                + ".cssss {\n"
                + "	font-family: \"Palatino Linotype\", \"Book Antiqua\", Palatino, serif;\n"
                + "}\n"
                + ".iitti {\n"
                + "	color: #FFF;\n"
                + "}\n"
                + ".iitti {\n"
                + "	font-weight: bold;\n"
                + "}\n"
                + ".uouu {\n"
                + "	color: #FFF;\n"
                + "	font-weight: bold;\n"
                + "}\n"
                + ".uuuu {\n"
                + "	color: #39C;\n"
                + "}\n"
                + ".imgbutton{\n"
                + "  padding-left: 35%;\n"
                + "}\n"
                + ".fb{\n"
                + "\n"
                + "}\n"
                + ".tw{\n"
                + "  padding-left: 35%;\n"
                + "\n"
                + "}\n"
                + ".gp{\n"
                + "  padding-left: 32%;\n"
                + "\n"
                + "\n"
                + "\n"
                + "}\n"
                + "\n"
                + "</style>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "<center>\n"
                + "  <table width=\"617\" height=\"1050\" border=\"0\">\n"
                + "    <tr>\n"
                + "    <td height=\"30\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td width=\"36\" height=\"204\">&nbsp;</td>\n"
                + "    <td colspan=\"3\" bgcolor=\"#FFFFFF\"><img src=\"" + config + "0B5FLny8RkXOFaThuY0UzOTlSaE0\" width=\"535\" height=\"202\" /></td>\n"
                + "    <td width=\"37\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"203\" rowspan=\"3\">&nbsp;</td>\n"
                + "    <td height=\"140\" colspan=\"3\" align=\"center\" bgcolor=\"#FFFFFF\"><h1>Activación de cuenta AutoSchool.\n"
                + "      </h1>\n"
                + "      <div>Para poder disfrutar de todo lo que te brinda AutoSchool debes de activar tu cuenta.<br />\n"
                + "        <br />\n"
                + "        Solo debes dar click en el siguiente enlace.<br data-cke-eol=\"1\" />\n"
                + "    </div></td>\n"
                + "    <td height=\"203\" rowspan=\"3\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"67\" colspan=\"3\" bgcolor=\"#FFFFFF\"><a href=\"http://" + ip + "/AutoSchool-web/activaUsr?xAcc=1&usr=" + gametag +"\"><img src=\"" + config + "0B5FLny8RkXOFX1VNQVhNV1NYN2s\" class=\"imgbutton\" width=\"183\" height=\"82\" /></a></td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"48\" colspan=\"3\" align=\"center\" bgcolor=\"#FFFFFF\">De lo contrario ignora esté correo.</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"261\" rowspan=\"2\">&nbsp;</td>\n"
                + "    <td width=\"243\" height=\"194\" bgcolor=\"#FFFFFF\"><a href=\"\"><img src=\"" + config + "0B5FLny8RkXOFeUtYNkNjZjFBdUE\" width=\"247\" height=\"232\" /></a></td>\n"
                + "    <td width=\"30\" rowspan=\"2\" bgcolor=\"#FFFFFF\">&nbsp;</td>\n"
                + "    <td width=\"243\" bgcolor=\"#FFFFFF\"><a href=\"\"><img src=\"" + config + "0B5FLny8RkXOFWnp3cXFhOXFEczQ\" width=\"247\" height=\"232\" /></a></td>\n"
                + "    <td rowspan=\"2\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"128\" align=\"center\" bgcolor=\"#666666\" class=\"iitti\"><br />\n"
                + "      Aprende más sobre la historia del dibujo técnico.<br />\n"
                + "      <br />\n"
                + "      (Click en la imagen)</td>\n"
                + "    <td width=\"243\" align=\"center\" bgcolor=\"#666666\" class=\"uouu\">Aprende más sobre los paises del mundo con un divertido mapa interactivo y juegos que pondran a pureba tus conocimientos.<br />\n"
                + "      (Click en la imagen)</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"5\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"77\" rowspan=\"3\">&nbsp;</td>\n"
                + "    <td height=\"58\" colspan=\"3\" bgcolor=\"#FFFFFF\"><a href=\"https://www.facebook.com/The-Real-Technology-1137866912900563/?__mref=message_bubble\"><img src=\"" + config + "0B5FLny8RkXOFQXUtcWk0MFhRRE0\" width=\"58\" class=\"fb\" height=\"58\" /></a><a href=\"https://twitter.com/The_Real_Techno\"><img src=\"" + config + "0B5FLny8RkXOFVTdibU80LXNUS1k\" class=\"tw\" width=\"58\" height=\"58\" /></a><a href=\"https://plus.google.com/u/0/113400054013171870295?hl=es\"><img src=\"" + config + "0B5FLny8RkXOFZWkydUNBMzMyQ1k\" class=\"gp\" width=\"58\" height=\"58\" /></a></td>\n"
                + "    <td rowspan=\"3\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td height=\"21\" colspan=\"3\" bgcolor=\"#FFFFFF\">&nbsp;</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td colspan=\"3\" align=\"center\" bgcolor=\"#FFFFFF\"><em>Copyright © <strong class=\"uuuu\">2016 Techno - Dev</strong></em><br /></td>\n"
                + "  </tr>\n"
                + "</table>\n"
                + "  <p>&nbsp;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "</center>\n"
                + "</body>\n"
                + "</html>\n"
                + "\n"
                + "                            ";

        return regreso;
    }
}
