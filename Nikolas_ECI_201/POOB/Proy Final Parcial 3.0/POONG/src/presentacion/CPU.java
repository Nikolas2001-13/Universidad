package presentacion;

import javax.swing.*;
import javax.swing.border.LineBorder;

import aplicacion.PoongException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class CPU extends JFrame {

    private int width, height;
    private Dimension screen;
    private JLabel titulo;
    private JLabel j1, j2;
    private JButton regresar, siguiente;
    private JButton batman, fre, tee, bane, kar, sle;
    private JButton json, veigar, superM;
    private JComboBox modoCPU;
    private JButton Extreme;
    private JButton Sniper;
    private JButton Greedy;
    private JButton Lazy;
    private JLabel fondo;
    private String per1, per2;
    private static String modo;
    private File paulina = new File("");

    /**
     * constructor
     */
    public CPU() {
        super("Poong");
        prepareElementos();
        prepareAcciones();
    }

    /**
     * prepara elementos de CPU
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
        j2 = new JLabel("CPU");
        j2.setFont(new Font("Helvetica", Font.PLAIN, 35));
        j2.setForeground(Color.RED);
        j2.setBounds((width / 3), height / 8, 400, 100);
        fondo.add(j2);

        modoCPU = new JComboBox();
        modoCPU.addItem("Extreme");
        modoCPU.addItem("Sniper");
        modoCPU.addItem("Greedy");
        modoCPU.addItem("Lazy");
        modoCPU.setBounds(width / 3, (height / 8) + 200, 100, 25);
        fondo.add(modoCPU);

        regresar = new JButton("REGRESAR");
        siguiente = new JButton("SIGUIENTE");
        batman = new JButton("");
        tee = new JButton("");
        fre = new JButton("");
        bane = new JButton("");
        kar = new JButton("");
        sle = new JButton("");
        json = new JButton("");
        veigar = new JButton("");
        superM = new JButton("");

        regresar.setBounds(0, (height / 2) - 60, 100, 25);
        siguiente.setBounds((width / 3) + 100, (height / 2) - 60, 100, 25);
        batman.setBounds((width / 6) - 200, (height / 4), 50, 50);
        tee.setBounds((width / 6) - 135, (height / 4), 50, 50);
        fre.setBounds((width / 6) - 70, (height / 4), 50, 50);
        bane.setBounds((width / 6) - 200, (height / 4) + 65, 50, 50);
        kar.setBounds((width / 6) - 135, (height / 4) + 65, 50, 50);
        sle.setBounds((width / 6) - 70, (height / 4) + 65, 50, 50);
        json.setBounds((width / 3) - 65, (height / 4), 50, 50);
        veigar.setBounds((width / 3), (height / 4), 50, 50);
        superM.setBounds((width / 3) + 65, (height / 4), 50, 50);
        batman.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bat11.jpg"));
        fre.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/fre11.jpg"));
        tee.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/teemo11.jpg"));
        bane.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bane11.jpg"));
        kar.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/kar11.jpg"));
        sle.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/sle11.jpg"));
        json.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/Json11.jpg"));
        veigar.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/Veigar11.jpg"));
        superM.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/clark11.jpg"));
        fondo.add(regresar);
        fondo.add(siguiente);
        fondo.add(batman);
        fondo.add(tee);
        fondo.add(fre);
        fondo.add(bane);
        fondo.add(kar);
        fondo.add(sle);
        fondo.add(json);
        fondo.add(veigar);
        fondo.add(superM);

    }
    /**
     * prepara acciones de CPU
     */
    public void prepareAcciones() {
        salga();
        batman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                batman.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/bat22.jpg"));
                per1 = "bat";
                batman.setBorder(new LineBorder(Color.green));
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
                tee.setEnabled(false);
                fre.setEnabled(false);
                bane.setEnabled(false);
                kar.setEnabled(false);
                batman.setEnabled(false);
            }
        });

        json.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                json.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/Json22.jpg"));
                per2 = "json";
                json.setBorder(new LineBorder(Color.green));
                veigar.setEnabled(false);
                superM.setEnabled(false);
            }
        });
        veigar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                veigar.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/veigar22.jpg"));
                per2 = "veigar";
                veigar.setBorder(new LineBorder(Color.green));
                json.setEnabled(false);
                superM.setEnabled(false);
            }
        });
        superM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                superM.setIcon(new ImageIcon(paulina.getAbsolutePath() + "/POONG/Pictures/seleccion/clark22.jpg"));
                per2 = "super";
                superM.setBorder(new LineBorder(Color.green));
                veigar.setEnabled(false);
                json.setEnabled(false);
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
                String[] args = { modo, per1, per2, (String) modoCPU.getSelectedItem() };
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
        CPU confg = new CPU();
        confg.setVisible(true);
        confg.setLocationRelativeTo(null);
        modo= args[0];
    }
    
}
