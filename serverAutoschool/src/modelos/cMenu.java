package modelos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class cMenu implements ActionListener {

    Container cont;
    private JFrame _ventana;
    private JLabel _btnEquipos;
    private JLabel _btnAlumnos;
    private JLabel _btnLaboratorio;
    private JLabel _btnHerramientas;
    private Panell elpan;
    private String _usr;

    public cMenu(String usr) {
        _usr = usr;
        elpan = new Panell();
        _ventana = new JFrame();
        _ventana.setTitle("Auto-School");
        _ventana.setSize(500, 600);
        _ventana.setLocationRelativeTo(null);
        _ventana.setLayout(null);
        _ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/logo.png")));
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        elpan.setImagen(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/fondo.jpg")));
        elpan.setBorder(new EmptyBorder(5, 5, 5, 5));
        elpan.setLayout(new BorderLayout(0, 0));
        _ventana.setContentPane(elpan);

        cont = _ventana.getContentPane();
        muestraComponentes();
        _ventana.setVisible(true);
    }

    public void muestraComponentes() {
        int alto, ancho;

        ImageIcon imgEquipos = new ImageIcon(getClass().getResource("/multimedia/img/computer.png"));

        _btnEquipos = new JLabel();
        _btnEquipos.setBounds(175, 100, 150, 150);

        ancho = _btnEquipos.getWidth();
        alto = _btnEquipos.getHeight();
        ImageIcon escEquipos = new ImageIcon(imgEquipos.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));

        _btnEquipos.setIcon(escEquipos);
         _btnEquipos.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/computer_shine.png"));
                int ancho = _btnEquipos.getWidth();
                int alto = _btnEquipos.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnEquipos.setIcon(escCerrar);
                super.mouseMoved(e);

            }
                });
         _btnEquipos.addMouseListener(new MouseAdapter() {

             @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/computer_unshine.png"));
                int ancho = _btnEquipos.getWidth();
                int alto = _btnEquipos.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnEquipos.setIcon(escCerrar);
                super.mousePressed(e);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                modelos.cEquipos equipo = new modelos.cEquipos(_usr);
                _ventana.dispose();
            

            }
        });
         _btnEquipos.setToolTipText("gestion de equipos");
        cont.add(_btnEquipos);

        ImageIcon imgAlumnos = new ImageIcon(getClass().getResource("/multimedia/img/alum.png"));

        _btnAlumnos = new JLabel();
        _btnAlumnos.setBounds(175, 300, 150, 150);

        ancho = _btnAlumnos.getWidth();
        alto = _btnAlumnos.getHeight();
        ImageIcon escAlumnos = new ImageIcon(imgAlumnos.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));

        _btnAlumnos.setIcon(escAlumnos);
          _btnAlumnos.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/alum_shine.png"));
                int ancho = _btnAlumnos.getWidth();
                int alto = _btnAlumnos.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnAlumnos.setIcon(escCerrar);
                super.mouseMoved(e);

            }
                });
         _btnAlumnos.addMouseListener(new MouseAdapter() {

             @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/alum_unshine.png"));
                int ancho = _btnAlumnos.getWidth();
                int alto = _btnAlumnos.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnAlumnos.setIcon(escCerrar);
                super.mousePressed(e);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                 modelos.alumnos alumnos = new modelos.alumnos(_usr);
                _ventana.dispose();
            

            }
        });
        _btnAlumnos.setToolTipText("Alumnos (asistencia)");
        cont.add(_btnAlumnos);

        ImageIcon imgLaboratorio = new ImageIcon(getClass().getResource("/multimedia/img/lab.png"));

        _btnLaboratorio = new JLabel();
        _btnLaboratorio.setBounds(300, 100, 150, 150);

        ancho = _btnLaboratorio.getWidth();
        alto = _btnLaboratorio.getHeight();
        ImageIcon escLaboratorio = new ImageIcon(imgLaboratorio.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));

        _btnLaboratorio.setIcon(escLaboratorio);
        _btnLaboratorio.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/lab_shine.png"));
                int ancho = _btnLaboratorio.getWidth();
                int alto = _btnLaboratorio.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnLaboratorio.setIcon(escCerrar);
                super.mouseMoved(e);

            }
                });
         _btnLaboratorio.addMouseListener(new MouseAdapter() {

             @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/lab_unshine.png"));
                int ancho = _btnLaboratorio.getWidth();
                int alto = _btnLaboratorio.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnLaboratorio.setIcon(escCerrar);
                super.mousePressed(e);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                System.out.println("Es el de lab");
            

            }
        });
        _btnLaboratorio.setToolTipText("Laboratorio (luces y aire)");
        //cont.add(_btnLaboratorio);

        ImageIcon imgHerramientas = new ImageIcon(getClass().getResource("/multimedia/img/herr.png"));

        _btnHerramientas = new JLabel();
        _btnHerramientas.setBounds(300, 300, 150, 150);

        ancho = _btnHerramientas.getWidth();
        alto = _btnHerramientas.getHeight();
        ImageIcon escHerramientas = new ImageIcon(imgHerramientas.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));

        _btnHerramientas.setIcon(escHerramientas);
         _btnHerramientas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/herr_shine.png"));
                int ancho = _btnHerramientas.getWidth();
                int alto = _btnHerramientas.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnHerramientas.setIcon(escCerrar);
                super.mouseMoved(e);

            }
                });
         _btnHerramientas.addMouseListener(new MouseAdapter() {

             @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/herr_unshine.png"));
                int ancho = _btnHerramientas.getWidth();
                int alto = _btnHerramientas.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnHerramientas.setIcon(escCerrar);
                super.mousePressed(e);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
               System.out.println("Es el de herramientas");
            

            }
        });
         _btnHerramientas.setToolTipText("herramientas (proyeccion)");
        //cont.add(_btnHerramientas);
        
        JLabel antibug = new JLabel();
        antibug.setBounds(150, 200, 200, 50);
        cont.add(antibug);
        
        _ventana.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/computer.png"));
                int ancho = _btnEquipos.getWidth();
                int alto = _btnEquipos.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnEquipos.setIcon(escCerrar);
               
               imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/lab.png"));
                 ancho = _btnLaboratorio.getWidth();
                 alto = _btnLaboratorio.getHeight();
                escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnLaboratorio.setIcon(escCerrar);
                
                imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/alum.png"));
                 ancho = _btnAlumnos.getWidth();
                 alto = _btnAlumnos.getHeight();
                escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnAlumnos.setIcon(escCerrar);
               
               imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/herr.png"));
                 ancho = _btnHerramientas.getWidth();
                 alto = _btnHerramientas.getHeight();
                escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _btnHerramientas.setIcon(escCerrar);
                super.mouseMoved(e);

            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _btnEquipos) {
        } else if (e.getSource() == _btnAlumnos) {
           
        } else if (e.getSource() == _btnLaboratorio) {
            
        } else if (e.getSource() == _btnHerramientas) {
            
        }
    }
}
