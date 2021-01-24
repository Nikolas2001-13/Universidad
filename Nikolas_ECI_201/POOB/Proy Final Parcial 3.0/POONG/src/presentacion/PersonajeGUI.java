package presentacion;

import javax.swing.*;
import javax.swing.border.LineBorder;

import aplicacion.PoongException;

import java.io.File;
import java.awt.*;
import java.awt.event.*;

public class PersonajeGUI extends JFrame {

    private int width, height;
    private Dimension screen;
    private JLabel titulo;
    private JLabel j1, j2;
    private JButton regresar, siguiente;
    private JButton batman, fre, tee, bane, kar, sle;
    private JButton batman2, fre2, tee2, bane2, kar2, sle2;
    private JLabel fondo;
    private String per1, per2;
    private static String modo;
    private File paulina = new File("");
    
    /**
     * constructor
     */
    public PersonajeGUI() {
        super("Poong");
        prepareElementos();
        prepareAcciones();
    }

    /**
     * prepara elementos de PersonajeGUI
     */
    public void prepareElementos() {
        setLayout(null);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screen.getWidth();
        height = (int) screen.getHeight();
        this.setSize(width / 2, height / 2);
        ImageIcon fondo1 = new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/pong3.jpg");
        fondo = new JLabel(fondo1);
        fondo.setBounds(0, 0, width / 2, height / 2);
        add(fondo);
        titulo = new JLabel("SELECCION");
        titulo.setFont(new Font("Helvetica", Font.PLAIN, 35));
        titulo.setForeground(Color.RED);
        titulo.setBounds(width / 6, 0, 400, 100);
        fondo.add(titulo);
        j1 = new JLabel("J1");
        j1.setFont(new Font("Helvetica", Font.PLAIN, 35));
        j1.setForeground(Color.RED);
        j1.setBounds(width / 10, height / 8, 400, 100);
        fondo.add(j1);
        j2 = new JLabel("J2");
        j2.setFont(new Font("Helvetica", Font.PLAIN, 35));
        j2.setForeground(Color.RED);
        j2.setBounds((width / 3), height / 8, 400, 100);
        fondo.add(j2);

        regresar = new JButton("REGRESAR");
        siguiente = new JButton("SIGUIENTE");
        batman = new JButton("");
        tee = new JButton("");
        fre = new JButton("");
        bane = new JButton("");
        kar = new JButton("");
        sle = new JButton("");
        batman2 = new JButton("");
        tee2 = new JButton("");
        fre2 = new JButton("");
        bane2 = new JButton("");
        kar2 = new JButton("");
        sle2 = new JButton("");

        regresar.setBounds(0, (height / 2) - 60, 100, 25);
        siguiente.setBounds((width / 3) + 100, (height / 2) - 60, 100, 25);
        batman.setBounds((width / 6) - 200, (height / 4), 50, 50);
        tee.setBounds((width / 6) - 135, (height / 4), 50, 50);
        fre.setBounds((width / 6) - 70, (height / 4), 50, 50);
        bane.setBounds((width / 6) - 200, (height / 4) + 65, 50, 50);
        kar.setBounds((width / 6) - 135, (height / 4) + 65, 50, 50);
        sle.setBounds((width / 6) - 70, (height / 4) + 65, 50, 50);
        batman2.setBounds((width / 3) - 65, (height / 4), 50, 50);
        tee2.setBounds((width / 3), (height / 4), 50, 50);
        fre2.setBounds((width / 3) + 65, (height / 4), 50, 50);
        bane2.setBounds((width / 3) - 65, (height / 4) + 65, 50, 50);
        kar2.setBounds((width / 3), (height / 4) + 65, 50, 50);
        sle2.setBounds((width / 3) + 65, (height / 4) + 65, 50, 50);
        batman.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bat11.jpg"));
        fre.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/fre11.jpg"));
        tee.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/teemo11.jpg"));
        bane.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bane11.jpg"));
        kar.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/kar11.jpg"));
        sle.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/sle11.jpg"));
        batman2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bat11.jpg"));
        fre2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/fre11.jpg"));
        tee2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/teemo11.jpg"));
        bane2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bane11.jpg"));
        kar2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/kar11.jpg"));
        sle2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/sle11.jpg"));
        fondo.add(regresar);
        fondo.add(siguiente);
        fondo.add(batman);
        fondo.add(tee);
        fondo.add(fre);
        fondo.add(bane);
        fondo.add(kar);
        fondo.add(sle);
        fondo.add(batman2);
        fondo.add(tee2);
        fondo.add(fre2);
        fondo.add(bane2);
        fondo.add(kar2);
        fondo.add(sle2);

    }
    /**
     * prepara acciones de PersonajeGUI
     */
    public void prepareAcciones() {
        salga();
        batman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                batman.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bat22.jpg"));
                per1 = "bat";
                batman.setBorder(new LineBorder(Color.green));
                batman2.setEnabled(false);
                tee.setEnabled(false);
                fre.setEnabled(false);
                bane.setEnabled(false);
                kar.setEnabled(false);
                sle.setEnabled(false);
            }
        });
        tee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tee.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/teemo22.jpg"));
                per1 = "temo";
                tee.setBorder(new LineBorder(Color.green));
                tee2.setEnabled(false);
                batman.setEnabled(false);
                fre.setEnabled(false);
                bane.setEnabled(false);
                kar.setEnabled(false);
                sle.setEnabled(false);
            }

        });
        fre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fre.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/fre22.jpg"));
                per1 = "fre";
                fre.setBorder(new LineBorder(Color.green));
                fre2.setEnabled(false);
                tee.setEnabled(false);
                batman.setEnabled(false);
                bane.setEnabled(false);
                kar.setEnabled(false);
                sle.setEnabled(false);
            }
        });
        bane.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bane.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bane22.jpg"));
                per1 = "ban";
                bane.setBorder(new LineBorder(Color.green));
                bane2.setEnabled(false);
                tee.setEnabled(false);
                fre.setEnabled(false);
                batman.setEnabled(false);
                kar.setEnabled(false);
                sle.setEnabled(false);
            }
        });
        kar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kar.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/kar22.jpg"));
                per1 = "kar";
                kar.setBorder(new LineBorder(Color.green));
                kar2.setEnabled(false);
                tee.setEnabled(false);
                fre.setEnabled(false);
                bane.setEnabled(false);
                batman.setEnabled(false);
                sle.setEnabled(false);
            }
        });
        sle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sle.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/sle22.jpg"));
                per1 = "sle";
                sle.setBorder(new LineBorder(Color.green));
                sle2.setEnabled(false);
                tee.setEnabled(false);
                fre.setEnabled(false);
                bane.setEnabled(false);
                kar.setEnabled(false);
                batman.setEnabled(false);
            }
        });

        batman2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                batman2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bat22.jpg"));
                per2 = "bat";
                batman2.setBorder(new LineBorder(Color.green));
                batman.setEnabled(false);
                tee2.setEnabled(false);
                fre2.setEnabled(false);
                bane2.setEnabled(false);
                kar2.setEnabled(false);
                sle2.setEnabled(false);
            }
        });
        tee2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tee2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/teemo22.jpg"));
                per2 = "temo";
                tee2.setBorder(new LineBorder(Color.green));
                tee.setEnabled(false);
                batman2.setEnabled(false);
                fre2.setEnabled(false);
                bane2.setEnabled(false);
                kar2.setEnabled(false);
                sle2.setEnabled(false);
            }

        });
        fre2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fre2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/fre22.jpg"));
                per2 = "fre";
                fre2.setBorder(new LineBorder(Color.green));
                fre.setEnabled(false);
                tee2.setEnabled(false);
                batman2.setEnabled(false);
                bane2.setEnabled(false);
                kar2.setEnabled(false);
                sle2.setEnabled(false);
            }
        });
        bane2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bane2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bane22.jpg"));
                per2 = "ban";
                bane2.setBorder(new LineBorder(Color.green));
                bane.setEnabled(false);
                tee2.setEnabled(false);
                fre2.setEnabled(false);
                batman2.setEnabled(false);
                kar2.setEnabled(false);
                sle2.setEnabled(false);
            }
        });
        kar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kar2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/kar22.jpg"));
                per2 = "kar";
                kar2.setBorder(new LineBorder(Color.green));
                kar.setEnabled(false);
                tee2.setEnabled(false);
                fre2.setEnabled(false);
                bane2.setEnabled(false);
                batman2.setEnabled(false);
                sle2.setEnabled(false);
            }
        });
        sle2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sle2.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/sle22.jpg"));
                per2 = "sle";
                sle2.setBorder(new LineBorder(Color.green));
                sle.setEnabled(false);
                tee2.setEnabled(false);
                fre2.setEnabled(false);
                bane2.setEnabled(false);
                kar2.setEnabled(false);
                batman2.setEnabled(false);
            }
        });

        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ModoGameGUI.main(new String[] {});
            }
        });
        siguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] args = { modo, per1, per2 };
                setVisible(false);
                try {
                    ConfiGUI.main(args);
                } catch (PoongException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });
        
    }
    /**
     * metodo encargado de terminar el programa
     */
    public void salga(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
                int val = JOptionPane.showOptionDialog(null, "Realmente desea salir de Poong?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                if(val==JOptionPane.YES_OPTION){
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    setVisible(false);
                }
                else{
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
    }

    public static void main(String[] args) {
        PersonajeGUI confg = new PersonajeGUI();
        confg.setVisible(true);
        confg.setLocationRelativeTo(null);
        modo= args[0];
    }
    
}
