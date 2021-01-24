package presentacion;

import aplicacion.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;


public class juegoGUI extends JFrame{

    private int width,height,bien,mal,moves;
    private JLabel nice,bad,move;
    private Dimension screen;
    private JButton refresh;
    private JButton exit;
    private Tablero tablero;
    private int dimension2,numB,numW;
    private static Color colorTa,colorLi;
    private JButton norte,sur,este,oeste,salvar,reiniciar;
    private JFileChooser fc = new JFileChooser();
    private MarbelGame objetos ;
    

    public juegoGUI(int dimension2,int numB,int numW){
        super("MarbelGame");
        bien=0;mal=numB;moves=0;
        this.dimension2 = dimension2;
        this.numB = numB;
        this.numW = numW;
        objetos =  new MarbelGame(dimension2,numB,numW);
        tablero = new Tablero(dimension2,colorTa,colorLi,numB,numW,objetos);
        tablero.setBounds(150,0,40*dimension2,40*dimension2);
        add(tablero);
        prepareElementos();
        prepareAcciones();
        
    }
    public void  prepareElementos(){
        screen=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int)screen.getWidth();
        height=(int)screen.getHeight();
        setSize(width/2,height/2);
        refresh = new JButton("Refrescar");
        refresh.setBounds(0,135,95,30);
        add(refresh);
        exit = new JButton("Salir");
        exit.setBounds(0,225,95,30);
        add(exit);
        norte = new JButton("N");
        norte.setBounds(45,0,45,45);
        add(norte);
        sur = new JButton("S");
        sur.setBounds(45,90,45,45);
        add(sur);
        oeste = new JButton("O");
        oeste.setBounds(0,45,45,45);
        add(oeste);
        este = new JButton("E");
        este.setBounds(90,45,45,45);
        add(este);
        getContentPane().setBackground(Color.orange);
        setLayout(null);
        salvar = new JButton("Salvar");
        salvar.setBounds(0,165,95,30);
        add(salvar);
        nice= new JLabel("# de canicas bien:"+ String.valueOf(bien));
        bad = new JLabel("# de canicas mal:"+ String.valueOf(mal));
        move= new JLabel("# de movimientos:"+ String.valueOf(moves));
        nice.setBounds(0,245,140,30);
        add(nice);
        bad.setBounds(0,265,140,30);
        add(bad);
        move.setBounds(0,285,140,30);
        add(move);
        reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(0,195,95,30);
        add(reiniciar);
    }

    public void  prepareAcciones(){
        salga();
        refresh.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               refresque();
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
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int val = JOptionPane.showOptionDialog(null, "Realmente desea salir de MarbelGame?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                if(val==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        reiniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 objetos.startAgain();
                 refresque();bien=0;mal=numB;moves=0;
                 move.setText("# de movimientos:"+ String.valueOf(moves));
                 nice.setText("# de canicas bien:"+ String.valueOf(bien));
                 bad.setText("# de canicas mal:"+ String.valueOf(numB));
            }
        });
        norte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 objetos.norte();
                 refresque();
                 moves+=1;move.setText("# de movimientos:"+ String.valueOf(moves));
                 nice.setText("# de canicas bien:"+ String.valueOf(correctas()));
                 bad.setText("# de canicas mal:"+ String.valueOf(inCorrectas()));
                 
            }
        });
        sur.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                objetos.sur();
                refresque();
                moves+=1;move.setText("# de movimientos:"+ String.valueOf(moves));add(move);
                nice.setText("# de canicas bien:"+ String.valueOf(correctas()));
                bad.setText("# de canicas mal:"+ String.valueOf(inCorrectas()));
            }

        });
        este.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                objetos.este();
                refresque();
                moves+=1;move.setText("# de movimientos:"+ String.valueOf(moves));add(move);
                nice.setText("# de canicas bien:"+ String.valueOf(correctas()));
                bad.setText("# de canicas mal:"+ String.valueOf(inCorrectas()));
            }
        });
        oeste.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                objetos.oeste();
                refresque();
                moves+=1;move.setText("# de movimientos:"+ String.valueOf(moves));add(move);
                nice.setText("# de canicas bien:"+ String.valueOf(correctas()));
                bad.setText("# de canicas mal:"+ String.valueOf(inCorrectas()));
            }
        });
    }

    public int correctas(){
        return objetos.tanBien();
    }
    public int inCorrectas(){
        return objetos.taMal();
    }

    public void refresque(){
        repaint();
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
        int dimension1 = Integer.parseInt(args[0]);
        int numB = Integer.parseInt(args[1]);
        int numW = Integer.parseInt(args[2]);
         colorTa = new Color(Integer.parseInt(args[3]));
         colorLi = new Color(Integer.parseInt(args[4]));
        juegoGUI game = new juegoGUI(dimension1,numB,numW);
        game.setVisible(true);
        game.setLocationRelativeTo(null);
    }
}

class Tablero extends JPanel{
    private int dimension,b,w;
    private static int TAM;
    private Color lin;
    public MarbelGame objetos;
    
    public Tablero(int dimension,Color ta,Color li,int numB,int numW,MarbelGame mar){
        this.dimension = dimension;
        objetos = mar;
        b=numB;w=numW;
        lin=li;
        TAM = 40;
        setBackground(ta);
        setPreferredSize(new Dimension(40*dimension,40*dimension));
    }
    public void paint(Graphics g) 
    { 
        super.paintComponent(g);
        g.setColor(lin);
        // draw and display the line 
        for(int i=0;i<dimension;i++){
            g.drawLine(i*TAM, 0, i*TAM, dimension*TAM);    
        }
        for(int i=0;i<dimension;i++){
            g.drawLine(0, i*TAM, dimension*TAM, i*TAM); 
        }
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                String type = objetos.getType(i, j);
                if(type.equals("Canica")){
                    Color c = objetos.getColor(i,j);
                    g.setColor(objetos.getColor(i,j));
                    if(objetos.isPoint(i,j)){
                        g.fillOval(j*40, i*40, 20, 20);
                        g.setColor(objetos.getColHueco(i, j));
                        g.drawOval(j*40, i*40, 30, 30); 
                    }else{
                        g.fillOval(j*40, i*40, 20, 20);
                    } 
                }if(type.equals("Hueco")){
                    Color c = objetos.getColor(i,j);
                    g.setColor(c);
                    g.drawOval(j*40, i*40, 30, 30); 
                }if(type.equals("Barrera")){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*40, i*40, 40, 40); 
                }
            }
        }
    }  
}
