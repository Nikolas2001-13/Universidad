package presentacion;

import javax.swing.*;
import javax.swing.ImageIcon;

import aplicacion.Poong;
import aplicacion.PoongException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

public class PoongGUI extends JFrame {

    private int width, height;
    private Dimension screen;
    private JButton nuevo;
    private JButton abrir;
    private JButton salir;
    private JFileChooser fc = new JFileChooser();
    private JLabel fondo;
    private File paulina = new File("");
    private Poong pongsito = null;

    /**
     * constructor
     */
    public PoongGUI() {
        super("Pong");
        prepareElementos();
        prepareAcciones();
    }
    /**
     * prepara elementos de PoongGUI
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
        JLabel titulo = new JLabel("POONG");
        titulo.setFont(new Font("Helvetica", Font.PLAIN, 65));
        titulo.setForeground(Color.RED);
        titulo.setBounds((width / 7), 10, 400, 100);
        fondo.add(titulo);
        prepareElementosMenu(width, height);

    }
    /**
     * prepara los elementos del menu
     * @param width
     * @param height
     */
    public void prepareElementosMenu(int width, int height) {
        nuevo = new JButton("Jugar");
        abrir = new JButton("Abrir");
        salir = new JButton("Salir");
        nuevo.setBounds((width / 5), (height / 4) - 50, 90, 30);
        abrir.setBounds((width / 5), height / 4, 90, 30);
        salir.setBounds((width / 5), (height / 4) + 50, 90, 30);

        fondo.add(nuevo);
        fondo.add(abrir);
        fondo.add(salir);

    }
    /**
     * prepara acciones de PoongGUI
     */
    public void prepareAcciones() {
        salga();
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int val = JOptionPane.showOptionDialog(null, "Realmente desea salir de MarbelGame?", "Confirmar salida",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (val == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

        });

        abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int val = fc.showOpenDialog(null);
                if(val==JFileChooser.APPROVE_OPTION){
                    File fichero=fc.getSelectedFile();
                    pongsito = Poong.getNewPoong(width, height, "Jugador VS Jugador", "bat", "bat", "5", "Lenta");
                    try {
                        pongsito.importar(fichero);

                    } catch (PoongException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    setVisible(false);
                    JuegoGUI juego = new JuegoGUI(pongsito);
                    juego.setVisible(true);
                
                        
                } 
            }
                
        });
        
        nuevo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                ModoGameGUI.main(new String[] {});
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
    public static void main(String[] args){
        PoongGUI game = new PoongGUI();
        game.setVisible(true);
        game.setLocationRelativeTo(null);
        
    }
}



