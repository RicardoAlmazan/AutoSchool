/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author CECyT9
 */
public class alumnos implements ActionListener, KeyListener {

    private JFrame miVentana;
    private JLabel _btnAtras;
    private Container cont;
    private Panell elpan;
    private JScrollPane scroll;
    private JTable tablita;
    private String _usr;

    public alumnos(String usr) {
        _usr = usr;
        elpan = new Panell();
        miVentana = new JFrame();
        miVentana.setTitle("Auto-School");
        miVentana.setSize(500, 600);
        miVentana.setLocationRelativeTo(null);
        miVentana.setLayout(null);
        miVentana.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/logo.png")));
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setResizable(false);
        elpan.setImagen(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/image03.jpg")));
        elpan.setBorder(new EmptyBorder(50, 5, 5, 5));
        elpan.setLayout(new BorderLayout(0, 0));
        miVentana.setContentPane(elpan);
        cont = miVentana.getContentPane();

        muestraComponentes();

        miVentana.setVisible(true);
    }

    public void muestraComponentes() {

        String titulos[] = {
            "Nombre", "Asistencia"};
        int alto, ancho;
        ImageIcon escBack;
        ImageIcon imgBack = new ImageIcon(getClass().getResource("/multimedia/img/compu_off.png"));
        imgBack = new ImageIcon(getClass().getResource("/multimedia/img/back.png"));
        _btnAtras = new JLabel();
        _btnAtras.setBounds(0, 0, 40, 40);
        _btnAtras.setToolTipText("Volver al menú.");
        //_btnAtras.setRolloverEnabled(false);
        ancho = _btnAtras.getWidth();
        alto = _btnAtras.getHeight();
        escBack = new ImageIcon(imgBack.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        _btnAtras.setIcon(escBack);
        //_btnAtras.setBackground(Color.white);
        //_btnAtras.addActionListener(this);
        _btnAtras.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                cMenu m = new cMenu(_usr);
                miVentana.dispose();

            }
        });
        cont.add(_btnAtras);

        List<profesor.AsistAlumnos> obj;
        obj = new ArrayList<profesor.AsistAlumnos>();
        obj = asistencia(_usr);
        String datos[][];
        datos = new String[obj.size()][3];
        System.out.println(obj.size());
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).isAsistencia()) {
                datos[i][0] = obj.get(i).getNom();
                datos[i][1] = "Presente";
                //datos[i][2] = String.valueOf(true);
                //System.out.println(obj.get(i).getNom() + " " + "presente");
            } else {
                datos[i][0] = obj.get(i).getNom();
                datos[i][1] = "Ausente";
                //datos[i][2] = String.valueOf(false);
                //System.out.println(obj.get(i).getNom() + " " + "ausente");
            }

        }
        tablita = new JTable(datos, titulos);
        //renderCelda render = new renderCelda(2);
        //tablita.setDefaultRenderer(Object.class, render);
        tablita.setEnabled(false);
        scroll = new JScrollPane(tablita);
         
        cont.add(scroll);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static java.util.List<profesor.AsistAlumnos> asistencia(java.lang.String usr) {
        profesor.DatosProfesor_Service service = new profesor.DatosProfesor_Service();
        profesor.DatosProfesor port = service.getDatosProfesorPort();
        return port.asistencia(usr);
    }
}
