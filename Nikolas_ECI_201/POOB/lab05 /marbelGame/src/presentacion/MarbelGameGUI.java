 package presentacion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class MarbelGameGUI extends JFrame {

    private int width,height;
    private Dimension screen;
    private JButton nuevo;
    private JButton abrir;
    private JButton salvar;
    private JButton salir;
    private JFileChooser fc = new JFileChooser();

    /*
    *Constructor de la clase
    */
    public MarbelGameGUI() {
        super("MarbelGame");
        prepareElementos();
        prepareAcciones();
    }
    /*
    *Inizializa los elementos que cargara la pantalla
    */
    public void  prepareElementos(){
        screen=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int)screen.getWidth();
        height=(int)screen.getHeight();
        this.setSize(width/2,height/2);
        JLabel titulo = new JLabel ("MarbelGame");
        titulo.setFont(new Font("Helvetica", Font.PLAIN, 65));
        titulo.setBounds((width/6)-100,10,400,100);
        add(titulo);
        this.getContentPane().setBackground(Color.orange);
        prepareElementosMenu(width,height);
        setLayout(null);
    }


    /*
    *prepara las acciones a las que podra acceder el usuario 
    */
    public void  prepareElementosMenu(int width,int height){
        nuevo = new JButton("Nuevo");
        abrir = new JButton("Abrir");
        salvar = new JButton("Salvar");
        salir = new JButton("Salir");
        nuevo.setBounds((width/6)-100,height/4,90,30);
        abrir.setBounds((width/6),height/4,90,30);
        salvar.setBounds((width/6)+100,height/4,90,30);
        salir.setBounds((width/6)+200,height/4,90,30);

        add(nuevo);
        add(abrir);
        add(salvar);
        add(salir);
        
    }
    /*
    * hace que lso elementos del menu funcionen
    */
    public void  prepareAcciones(){
        salga();
        salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int val = JOptionPane.showOptionDialog(null, "Realmente desea salir de MarbelGame?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                if(val==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }

        });


        abrir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int val = fc.showOpenDialog(null);
                if(val==JFileChooser.APPROVE_OPTION){
                    File fichero=fc.getSelectedFile();
                    //Al hacer clic se abre el archivo seleccionado              
                }
            }

        });
        salvar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int val = fc.showSaveDialog(null);
                if(val==JFileChooser.APPROVE_OPTION){
                    File fichero=fc.getSelectedFile();   
                    //Al hacer clic guarda el archivo           
                }
            }

        });
        nuevo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                confiGUI.main(new String[] {});
            }

        });
        
    }
    /*
    *prepara la salida del exit de la ventana
    */
    public void salga(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
                int val = JOptionPane.showOptionDialog(null, "Realmente desea salir de MarbelGame?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
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
        MarbelGameGUI game = new MarbelGameGUI();
        game.setVisible(true);
        game.setLocationRelativeTo(null);
        
    }
}



