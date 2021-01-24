package presentacion;
import aplicacion.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;

public class AutomataGUI extends JFrame{	

    private JButton botonReloj;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    private JButton botonViva;
    private JButton botonLatente;
    private JMenuBar menu;
    private JFileChooser fc = new JFileChooser();
    private JMenuItem salvC = new JMenuItem("Salvar Como"),abrir,expC,imp,salir,iniciar;
    

    private FotoAutomata foto;
    private AutomataCelular automata=null;

    public AutomataGUI(AutomataCelular ac) {
        super("Automata celular");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        automata=ac;
        foto=new FotoAutomata(automata);
        setSize(new Dimension(652,700)); 
        prepareElementos();
        prepareAcciones();
        prepareAccionesMenu();

    }

    private void prepareElementos() {
        setResizable(false);

        botonReloj=new JButton("Tic-tac");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
        getContentPane().add(botonReloj,BorderLayout.SOUTH);
        expC = new JMenuItem("Exportar Como");
        abrir = new JMenuItem("Abrir");
        imp = new JMenuItem("Importar");
        iniciar = new JMenuItem("Iniciar");
        salir = new JMenuItem("Salir");
        menu = new JMenuBar();
        menu.add(salvC);
        menu.add(new JSeparator(JSeparator.NORTH));
        menu.add(expC);
        menu.add(new JSeparator(JSeparator.NORTH));
        menu.add(abrir);
        menu.add(new JSeparator(JSeparator.NORTH));
        menu.add(imp);
        menu.add(new JSeparator(JSeparator.NORTH));
        menu.add(iniciar);
        menu.add(new JSeparator(JSeparator.NORTH));
        menu.add(salir);
        setJMenuBar(menu);
        foto.repaint();
    }

    private void prepareAcciones(){

        botonReloj.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonRelojAccion();
                }
            });

    }

    private void prepareAccionesMenu(){
        opcionSalir();
        opcionSalvar();
        opcionAbrir();
        opcionIniciar();
        opcionExportar();
        opcionImportar();
        //opcionReiniciar();
    }

    public void opcionAbrir(){
        abrir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                        int val = fc.showOpenDialog(null);
                            File fichero=fc.getSelectedFile(); 
                            try{
                                automata.abra(fichero);
                                foto.actualizar();
                            }   
                            catch(AutomataException er){
                                er.getMessage();
                            }      
                        
                    }
        });

    }

    public void opcionSalvar(){
        salvC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        int val = fc.showSaveDialog(null);
                        if(val==JFileChooser.APPROVE_OPTION){
                            File fichero=fc.getSelectedFile();   
                            try{
                                automata.guardar(fichero);
                            }   
                            catch(AutomataException er){
                                er.getMessage();
                            }   
                        }
                    }
        });
    }

    public void opcionSalir(){
        salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
    }

    public void opcionIniciar(){
        iniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                automata.nuevoAuto();
                repaint();
            }
        });
    }

    public void opcionExportar(){
        expC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        int val = fc.showSaveDialog(null);
                        if(val==JFileChooser.APPROVE_OPTION){
                            File fichero=fc.getSelectedFile();   
                            try{
                                automata.exportar(fichero);
                            }   
                            catch(AutomataException er){
                                er.getMessage();
                            }   
                        }
                    }
        });
    }

    public void opcionImportar(){
        imp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        int val = fc.showOpenDialog(null);
                        if(val==JFileChooser.APPROVE_OPTION){
                            File fichero=fc.getSelectedFile(); 
                            try{
                                foto.getAutomata().importar(fichero);
                                foto.repaint();
                            }   
                            catch(AutomataException er){
                                er.getMessage();
                            }      
                        }
                    }
        });
    }

    private void botonRelojAccion() {
        automata.ticTac();
        foto.repaint();
    }

    public static void main(String[] args) {
        AutomataCelular ac=aplicacion.AutomataCelular.getAutomataCelular();
        AutomataGUI ca=new AutomataGUI(ac);
        ca.setVisible(true);

    }  
}

class FotoAutomata extends JPanel{
    public static int TAMANO=40;
    private AutomataCelular automata;

    public FotoAutomata(AutomataCelular ac) {
        setBackground(Color.white);
        automata=ac;
        setPreferredSize(new Dimension(635,635)); 		

    }

    public void setAutomata(AutomataCelular automata){
        this.automata=automata;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,automata.getLongitud()*TAMANO);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }		
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).getForma()==Elemento.CUADRADA){                  
                        if (automata.getElemento(f,c).isVivo()){
                            g.drawRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);
                        }else{
                            g.fillRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        } else {
                            g.drawOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        }
                    }
                }
            }
        }
    }

    public void actualizar(){
        automata = AutomataCelular.getAutomataCelular();
        repaint();
    }
    public AutomataCelular getAutomata(){
        return automata;
    }



}