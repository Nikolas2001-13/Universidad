package presentacion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class confiGUI extends JFrame{

    private int width,height;
    private Dimension screen;
    private JLabel ball;
    private JLabel dimension;
    private JLabel barreras;
    private JTextField ballA;
    private JTextField dimensionA;
    private JTextField barrerasA;
    private JLabel titulo;
    private JButton aceptar;
    private JButton regresar;
    private JButton colorT;
    private JButton colorL;
    private Color colorTa = Color.WHITE;
    private Color colorLi = Color.BLACK;
    private JPanel contentPane;


    public confiGUI(){
        super("MarbelGame");
        prepareElementos();
        prepareAcciones();
    }

    public void prepareElementos(){
        screen=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int)screen.getWidth();
        height=(int)screen.getHeight();
        this.setSize(width/2,height/2);
        titulo = new JLabel ("Configuracion");
        titulo.setFont(new Font("Helvetica", Font.PLAIN, 45));
        titulo.setBounds(0,0,400,100);
        add(titulo);

        ball = new JLabel ("Numero Canicas");
        ball.setFont(new Font("Helvetica", Font.PLAIN, 15));
        ball.setBounds(0,50,400,100);
        add(ball);
        ballA = new JTextField ();
        ballA.setBounds(150,85,100,25);
        add(ballA);

        dimension = new JLabel ("Dimension Tablero");
        dimension.setFont(new Font("Helvetica", Font.PLAIN, 15));
        dimension.setBounds(0,70,400,100);
        add(dimension);
        dimensionA = new JTextField ();
        dimensionA .setBounds(150,105,100,25);
        add(dimensionA);

        barreras = new JLabel ("Numero Barreras");
        barreras.setFont(new Font("Helvetica", Font.PLAIN, 15));
        barreras.setBounds(0,90,400,100);
        add(barreras);
        barrerasA = new JTextField ();
        barrerasA .setBounds(150,125,100,25);
        add(barrerasA);

        aceptar = new JButton("ACEPTAR");
        regresar = new JButton("REGRESAR");
        
        aceptar.setBounds( width/3, 220, 100, 25);
        regresar.setBounds( 0, 220, 100, 25);
        add(aceptar);
        add(regresar);

        colorT = new JButton("Cambiar Color Tablero");
        colorL = new JButton("Cambiar Color Lineas");
        
        colorT.setBounds( 0, (height/4)-30, 200, 25);
        colorL.setBounds( 0, height/4, 200, 25);
        add(colorT);
        add(colorL);

        this.getContentPane().setBackground(Color.orange);
        setLayout(null);
    }

    public void prepareAcciones(){
        salga();
        aceptar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String [] args ={dimensionA.getText(),ballA.getText(),barrerasA.getText(),String.valueOf(colorTa.getRGB()),String.valueOf(colorLi.getRGB())};
                setVisible(false);
                juegoGUI.main(args);
            }

        });


        regresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                MarbelGameGUI.main(new String[] {});
            }

        });
        colorT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                colorTa=JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
            }

        });
        colorL.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                colorLi=JColorChooser.showDialog(contentPane, "Elige un color", Color.BLACK);
            }
        });
    }

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

    public static void main(String[] args) {
        confiGUI confg = new confiGUI();
        confg.setVisible(true);
        confg.setLocationRelativeTo(null);
    }
    
}