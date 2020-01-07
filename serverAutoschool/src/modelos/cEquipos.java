package modelos;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import javax.swing.border.EmptyBorder;

public class cEquipos implements ActionListener, KeyListener {

    private JFrame miVentana;
    private JLabel _btnAtras;
    private Container cont;
    ldn.ejecuta ejec;
    ArrayList<ldn.Clientes> base;
    //String[] ipes = new String[26];
    private ldn.Equipos apagar[];
    private Panell elpan;
    private JPopupMenu popup[];
    private String _usr;
    public cEquipos(String usr) {
        _usr = usr;
        base = new ArrayList<ldn.Clientes>();
        apagar = new ldn.Equipos[26];
        popup = new JPopupMenu[26];
        ejec = new ldn.ejecuta();
         elpan = new Panell();
        miVentana = new JFrame();
        miVentana.setTitle("Auto-School");
        miVentana.setSize(500, 600);
        miVentana.setLocationRelativeTo(null);
        miVentana.setLayout(null);
        miVentana.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/logo.png")));
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setResizable(false);
        elpan.setImagen(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/multimedia/img/laboratorio.jpg")));
        elpan.setBorder(new EmptyBorder(5, 5, 5, 5));
        elpan.setLayout(new BorderLayout(0, 0));
        miVentana.setContentPane(elpan);
        cont = miVentana.getContentPane();
        
        muestraComponentes();
        
        miVentana.setVisible(true);
    }

    public void muestraComponentes() {
        int alto, ancho;
        
        ImageIcon imgBack = new ImageIcon(getClass().getResource("/multimedia/img/compu_off.png"));
        
        for(int i = 0; i<26;i++){
            apagar[i] = new ldn.Equipos(consultaEquipos().get(i), "");
            popup[i] = new JPopupMenu();
        }
        //apagar[0] = new ldn.Equipos("192.168.9.140", "");
        apagar[0].icono.setBounds(5, 45, 40, 40);
        //apagar[1] = new ldn.Equipos("192.168.9.141", "");
        apagar[1].icono.setBounds(5, 145, 40, 40);
        //apagar[2] = new ldn.Equipos("192.168.9.114", "");
        apagar[2].icono.setBounds(5, 240, 40, 40);
        //apagar[3] = new ldn.Equipos("192.168.9.110", "");
        apagar[3].icono.setBounds(5, 350, 40, 40);
        //apagar[4] = new ldn.Equipos("192.168.9.35", "");
        apagar[4].icono.setBounds(5, 440, 40, 40);
        
        //apagar[5] = new ldn.Equipos("192.168.9.35", "");
        apagar[5].icono.setBounds(100, 120, 40, 40);
        //apagar[6] = new ldn.Equipos("192.168.5.2", "");
        apagar[6].icono.setBounds(100, 250, 40, 40);
        //apagar[7] = new ldn.Equipos("192.168.9.35", "");
        apagar[7].icono.setBounds(100, 420, 40, 40);
        
        //apagar[8] = new ldn.Equipos("192.168.9.35", "");
        apagar[8].icono.setBounds(180, 120, 40, 40);
        //apagar[9] = new ldn.Equipos("192.168.9.35", "");
        apagar[9].icono.setBounds(180, 250, 40, 40);
        //apagar[10] = new ldn.Equipos("192.168.9.35", "");
        apagar[10].icono.setBounds(180, 420, 40, 40);
        
        //apagar[11] = new ldn.Equipos("192.168.5.2", "");
        apagar[11].icono.setBounds(290, 120, 40, 40);
        //apagar[12] = new ldn.Equipos("192.168.9.35", "");
        apagar[12].icono.setBounds(290, 250, 40, 40);
        //apagar[13] = new ldn.Equipos("192.168.9.35", "");
        apagar[13].icono.setBounds(290, 420, 40, 40);
        
        //apagar[14] = new ldn.Equipos("192.168.9.35", "");
        apagar[14].icono.setBounds(360, 120, 40, 40);
        //apagar[15] = new ldn.Equipos("192.168.9.35", "");
        apagar[15].icono.setBounds(360, 250, 40, 40);
        //apagar[16] = new ldn.Equipos("192.168.5.2", "");
        apagar[16].icono.setBounds(360, 420, 40, 40);
        
        //apagar[17] = new ldn.Equipos("192.168.9.35", "");
        apagar[17].icono.setBounds(450, 45, 40, 40);
        //apagar[18] = new ldn.Equipos("192.168.9.35", "");
        apagar[18].icono.setBounds(450, 145, 40, 40);
        //apagar[19] = new ldn.Equipos("192.168.9.35", "");
        apagar[19].icono.setBounds(450, 240, 40, 40);
        //apagar[20] = new ldn.Equipos("192.168.9.35", "");
        apagar[20].icono.setBounds(450, 340, 40, 40);
        //apagar[21] = new ldn.Equipos("192.168.5.2", "");
        apagar[21].icono.setBounds(450, 440, 40, 40);
        
        //apagar[22] = new ldn.Equipos("192.168.9.35", "");
        apagar[22].icono.setBounds(65, 2, 40, 40);
        //apagar[23] = new ldn.Equipos("192.168.9.35", "");
        apagar[23].icono.setBounds(150, 2, 40, 40);
        //apagar[24] = new ldn.Equipos("192.168.9.35", "");
        apagar[24].icono.setBounds(245, 2, 40, 40);
        //apagar[25] = new ldn.Equipos("192.168.9.35", "");
        apagar[25].icono.setBounds(335, 2, 40, 40);
        
        //_btnAtras.setRolloverEnabled(false);
        ancho = apagar[0].icono.getWidth();
        alto = apagar[0].icono.getHeight();
        ImageIcon escBack = new ImageIcon(imgBack.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        int tama = apagar.length;
        for(int i = 0; i < tama; i++)
        {
            apagar[i].icono.setIcon(escBack);
            int nomelo;
            nomelo = i;
            
            JMenuItem ip = new JMenuItem("cambiar ip");
            ip.setMnemonic(KeyEvent.VK_E);
            ip.setToolTipText("cambia la ip");
            ip.addActionListener((ActionEvent event) -> {
                String laVariable = JOptionPane.showInputDialog("nueva ip \n ip actual: "+apagar[nomelo].getIp());
                if(!(laVariable == null))
                apagar[nomelo].setIp(laVariable);
            });
            apagar[i].icono.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent evt) {
                    if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
                        if(apagar[nomelo].getState() == 0)
                        {
                            System.out.println("se prende la compu"+apagar[nomelo].getIp());
                            actualizars();
                        }
                        else
                        {
                                
                            ejec.comando(base.get(apagar[nomelo].getPocision()).getSocket_cli(), "msg * el mensaje");
                            System.out.println(base.get(apagar[nomelo].getPocision()).getIp());
                            actualizars();
                        }
                    }
                    else
                    {
                        popup[nomelo].show(evt.getComponent(),evt.getX(), evt.getY());
                        System.out.println("el clic dersho");
                    }
                }       
            });
            cont.add(apagar[i].icono);
            popup[i].add(ip);
        }
        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("Acciones");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu apps = new JMenu("Abrir aplicaciones");
        apps.setMnemonic(KeyEvent.VK_E);
        apps.setToolTipText("Abre una aplicacion en los equipos");
        JMenuItem web = new JMenuItem("Sitio web");
        web.setMnemonic(KeyEvent.VK_E);
        web.setToolTipText("Abre una página web");
        web.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            String laVariable = JOptionPane.showInputDialog("URL");
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "start chrome www."+laVariable);
            }
        
        });
        JMenu mic = new JMenu("Microsoft");
        mic.setMnemonic(KeyEvent.VK_E);
        mic.setToolTipText("Abre una aplicacion en los equipos");
        JMenuItem Word = new JMenuItem("Word");
        Word.setMnemonic(KeyEvent.VK_E);
        Word.setToolTipText("Abre una pagina web");
        Word.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "start winword");
            }
        
        });
        mic.add(Word);
        JMenuItem Pwpnt = new JMenuItem("PowerPoint");
        Pwpnt.setMnemonic(KeyEvent.VK_E);
        Pwpnt.setToolTipText("Abre una pagina web");
        Pwpnt.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "start powerpnt");
            }
        
        });
        mic.add(Pwpnt);
        JMenuItem Excel = new JMenuItem("Excel");
        Excel.setMnemonic(KeyEvent.VK_E);
        Excel.setToolTipText("Abre una pagina web");
        Excel.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "start excel");
            }
        
        });
        mic.add(Excel);
        JMenuItem Publisher = new JMenuItem("Publisher");
        Publisher.setMnemonic(KeyEvent.VK_E);
        Publisher.setToolTipText("Abre una pagina web");
        Publisher.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "start mspub");
            }
        
        });
        mic.add(Publisher);
        JMenuItem Access = new JMenuItem("Access");
        Access.setMnemonic(KeyEvent.VK_E);
        Access.setToolTipText("Abre una pagina web");
        Access.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "start msaccess");
            }
        
        });
        mic.add(Access);
        
        apps.add(mic);
        apps.add(web);
        file.add(apps);
        JMenuItem comando = new JMenuItem("Enviar comando");
        comando.setMnemonic(KeyEvent.VK_E);
        comando.setToolTipText("Ejecuta un comando MC2 en todos lo equipos");
        comando.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            String laVariable = JOptionPane.showInputDialog("Comando");
            System.out.println(tam);
            for (int i = 0; i < tam; i++) {
                if (laVariable != "") {
                    System.out.println(base.get(i).getIp());
                    ejec.comando(base.get(i).getSocket_cli(), laVariable);

                } else {
                    System.out.println("nel prro");
                }

            }
        
        });
        file.add(comando);
        JMenuItem apagar = new JMenuItem("Apagar todo");
        apagar.setMnemonic(KeyEvent.VK_E);
        apagar.setToolTipText("Apaga todos los equipos");
        apagar.addActionListener((ActionEvent event) -> {
            int tam = base.size();
            for (int i = 0; i < tam; i++) {
                ejec.comando(base.get(i).getSocket_cli(), "shutdown /s");
                actualizars();
            }
        
        });
        file.add(apagar);
        JMenuItem actualizar = new JMenuItem("Actualizar");
        actualizar.setMnemonic(KeyEvent.VK_E);
        actualizar.setToolTipText("Actualiza los equipos disponibles");
        actualizar.addActionListener((ActionEvent event) -> {
            actualizars();
            JOptionPane.showMessageDialog(null, "El sistema está actualizado");
                    System.out.println("sin host disponibles");
        });
        file.add(actualizar);

        menubar.add(file);
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
                int tam = base.size();
                for (int y = 0; y < tam; y++) {
                    try {
                        base.get(y).socket_cli.close();
                    } catch (Exception e) {
                    }
                
                }
                base.clear();
                cMenu m = new cMenu(_usr);
                miVentana.dispose();

            }
        });
        cont.add(_btnAtras);
        miVentana.setJMenuBar(menubar);
        JLabel antibug = new JLabel();
        antibug.setBounds(150, 200, 200, 50);
        cont.add(antibug);
        actualizars();
    }
    
    public void actualizars(){
            int tama = apagar.length;
            boolean exito = true;
            int i = 0;
            int tam = base.size();
            for (int y = 0; y < tam; y++) {
                try {
                    base.get(y).socket_cli.close();
                    System.out.println(prendeApaga(0,this.apagar[y].getPocision()));
                    this.apagar[y].setPocision(0);
                    this.apagar[y].setState(0);
                    ImageIcon imgBack2 = new ImageIcon(getClass().getResource("/multimedia/img/compu_off.png"));
                    ImageIcon escBack2 = new ImageIcon(imgBack2.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
                    this.apagar[y].icono.setIcon(escBack2);
                
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }
            base.clear();
            while (exito) {
                base.add(new ldn.Clientes());
                int num = base.size() - 1;
                System.out.println(num);
                exito = base.get(num).Trying();
                if (!exito) {
                    
                    base.remove(num);
                } else if (base.size() > 0) {
                    for (int y = 0; y < tama; y++) {
                        if (base.get(num).getIp().equals(this.apagar[y].getIp()))
                        {
                            this.apagar[y].setPocision(num);
                            this.apagar[y].setState(1);
                            System.out.println(prendeApaga(1,this.apagar[y].getPocision()));
                            ImageIcon imgBack2 = new ImageIcon(getClass().getResource("/multimedia/img/compu_on.png"));
                            ImageIcon escBack2 = new ImageIcon(imgBack2.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
                            this.apagar[y].icono.setIcon(escBack2);
                            
                        }
                    }
                }
                i++;
            }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

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

    private static java.util.List<java.lang.String> consultaEquipos() {
        wsequipos.WSEquipos_Service service = new wsequipos.WSEquipos_Service();
        wsequipos.WSEquipos port = service.getWSEquiposPort();
        return port.consultaEquipos();
    }

    private static String prendeApaga(int status, int posi) {
        wsequipos.WSEquipos_Service service = new wsequipos.WSEquipos_Service();
        wsequipos.WSEquipos port = service.getWSEquiposPort();
        return port.prendeApaga(status, posi);
    }
    
}
