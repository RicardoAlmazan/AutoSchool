package modelos;

import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class logIn extends JFrame implements ActionListener, KeyListener{

    private JButton _ingresar;
    private JLabel _cerrar;
    private JTextField _usr;
    private JPasswordField _pswde;
    private Panell elpan;

    public logIn() {
        
        muestraComponentes();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== _ingresar) {
            String valida; 
            String usr = _usr.getText();
            String pswd = _pswde.getText();
            valida = accesoProfesor(usr, pswd);
            if (valida.equalsIgnoreCase("Bienvenido Docente")) {
                JOptionPane.showMessageDialog(null, "Accediendo al Sistema");
                modelos.cMenu menu = new modelos.cMenu(usr);
                dispose();
            } else {
                System.out.println(accesoProfesor(_usr.getText(), _pswde.getText()));
                System.out.println(_usr.getText());
                System.out.println(_pswde.getText());
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", 0);
                _usr.setText("");
                _pswde.setText("");
            }
        } else if (e.getSource() == _cerrar) {
            

        }
    }

    private void muestraComponentes() {
        elpan = new Panell();
        setTitle("Inicio de Sesión");
        setSize(795, 512);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        elpan.setImagen(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/login.jpg")));
        elpan.setBorder(new EmptyBorder(5, 5, 5, 5));
        elpan.setLayout(new BorderLayout(0, 0));
        setContentPane(elpan);
        
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 27, 27);
        AWTUtilities.setWindowShape(this, forma);

        
        //_cont.setBackground(Color.white);
        int ancho, alto;

        _ingresar = new JButton();
        _ingresar.setBounds(350, 400, 150, 37);
        _ingresar.setText("Ingresar");
        _ingresar.addActionListener(this);
        _ingresar.setBackground(new Color(131, 187, 60));
        add(_ingresar);

        _cerrar = new JLabel();
        _cerrar.setBounds(750, 10, 20, 20);
        ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/close.png"));
        ancho = _cerrar.getWidth();
        alto = _cerrar.getHeight();
        //_cerrar.setBackground(window);

        
        _cerrar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/close_shine.png"));
                int ancho = _cerrar.getWidth();
                int alto = _cerrar.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _cerrar.setIcon(escCerrar);
                super.mouseMoved(e);

            }
                });
         _cerrar.addMouseListener(new MouseAdapter() {

             @Override
            public void mousePressed(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/close_unshine.png"));
                int ancho = _cerrar.getWidth();
                int alto = _cerrar.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _cerrar.setIcon(escCerrar);
                super.mousePressed(e);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                int i = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirmación", 0);
                if (i == 0) {
                dispose();
            }

            }
        });
        ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        _cerrar.setIcon(escCerrar);
        add(_cerrar);

        _usr = new JTextField();
        _usr.addKeyListener(this);
        _usr.setBounds(300, 215, 400, 50);
        add(_usr);

        


        _pswde = new JPasswordField();
        _pswde.addKeyListener(this);
        _pswde.setBounds(300, 305, 400, 50);
        add(_pswde);
        
        JLabel antibug = new JLabel();
        antibug.setBounds(150, 200, 200, 50);
        add(antibug);
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                ImageIcon imgCerrar = new ImageIcon(getClass().getResource("/multimedia/img/close.png"));
                int ancho = _cerrar.getWidth();
                int alto = _cerrar.getHeight();
                ImageIcon escCerrar = new ImageIcon(imgCerrar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
               _cerrar.setIcon(escCerrar);
                super.mouseMoved(e);

            }

        });

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_ENTER == e.getKeyCode()) {
            String resultado = accesoProfesor(_usr.getText(), _pswde.getText());
            if (resultado.equals("Bienvenido Docente")) {
                JOptionPane.showMessageDialog(null, "Accediendo al Sistema");
                modelos.cMenu menu = new modelos.cMenu(_usr.getText());
                dispose();
            } else {
                System.out.println(accesoProfesor(_usr.getText(), _pswde.getText()));
                System.out.println(_usr.getText());
                System.out.println(_pswde.getText());
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", 0);
                _usr.setText("");
                _pswde.setText("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private static String accesoProfesor(java.lang.String usr, java.lang.String psw) {
        acceso.Acceso_Service service = new acceso.Acceso_Service();
        acceso.Acceso port = service.getAccesoPort();
        return port.accesoProfesor(usr, psw);
    }


    

 
   


}
