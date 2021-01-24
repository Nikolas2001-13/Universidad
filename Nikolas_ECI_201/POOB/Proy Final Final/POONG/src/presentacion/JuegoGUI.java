package presentacion;

import javax.swing.*;
import aplicacion.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Year;
import java.util.Random;

public class JuegoGUI extends JFrame {

    private int width, height;
    private Dimension screen; 
    private Tablero tablero;
    private int puntaje;
    private JFileChooser fc = new JFileChooser();
    private String j1, j2, modo, bal;
    private InputMap input, input2;
    private ActionMap ap, ap2;
    private JPanel borde;
    private Timer tai;
    private boolean pause,cpu,cpu2;
    private Poong pongsito = null;
    private JMenuBar menu = new JMenuBar();
    private JMenu menu1 = new JMenu("Opciones");
    private JMenuItem salvar,pausar;
    private File paulina = new File("");

    public JuegoGUI(String modo,String ju1,String ju2,String punt,String ball){
        super("Poong");
        this.modo=modo;j1=ju1;j2=ju2;bal=ball;
        puntaje = Integer.parseInt(punt);
        prepareElementos();
        prepareAcciones();
    }
    public JuegoGUI(Poong pongChi){
        pongsito = pongChi;
        prepareElementos2();
        prepareAcciones();
    }
    public void  prepareElementos2(){
        screen=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int)screen.getWidth();
        height=(int)screen.getHeight();
        setSize((width/2)+200,(height/2)+200);
        menu.add(menu1);
        salvar = new JMenuItem("Guardar y Salir");
        pausar = new JMenuItem("Pausa");
        menu1.add(salvar);
        menu1.add(pausar);
        setJMenuBar(menu);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        System.out.println(pongsito.j1());
        tablero = new Tablero((height/2),(width/2),pongsito.j1(),pongsito.j2(),Integer.parseInt(pongsito.punta()),pongsito);
        tablero.setBounds(150,150,(width/2)-60,(height/2)-100);
        add(tablero);
        borde = new JPanel();
        borde.setBackground(Color.BLACK);
        borde.setBounds(130,130,(width/2)-20,(height/2)-60);
        add(borde);
        if(modo.equals("b")){
            input = tablero.p1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ap = tablero.p1.getActionMap();
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0, false),"up");
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0, false),"d");
            cpu=true;
        }if(modo.equals("c")){
            cpu2=true;
        }
            
        input = tablero.p1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ap = tablero.p1.getActionMap();
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0, false),"up");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0, false),"d");
        input2 = tablero.p1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ap2 = tablero.p1.getActionMap();
        input2.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0, false),"ar");
        input2.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0, false),"ab");
    }
    public void  prepareElementos(){
        screen=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int)screen.getWidth();
        height=(int)screen.getHeight();
        setSize((width/2)+200,(height/2)+200);

        borde = new JPanel();
        borde.setBackground(Color.BLACK);
        borde.setBounds(130,130,(width/2)-20,(height/2)-60);
        add(borde);

        ImageIcon icon = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/Captura.PNG");
        Image sca = icon.getImage().getScaledInstance((width/2)+200,(height/2)+200, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(sca));
        label.setBounds(0, 0, (width/2)+200,(height/2)+200);
        add(label);
        menu.add(menu1);
        salvar = new JMenuItem("Guardar y Salir");
        pausar = new JMenuItem("Pausa");
        menu1.add(salvar);
        menu1.add(pausar);
        setJMenuBar(menu);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         

        tablero = new Tablero((height/2),(width/2),j1,j2,puntaje,bal);
        tablero.setBounds(150,150,(width/2)-60,(height/2)-100);
        add(tablero);
        if(modo.equals("b")){
            input = tablero.p1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ap = tablero.p1.getActionMap();
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0, false),"up");
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0, false),"d");
            cpu=true;
        }if(modo.equals("c")){
            cpu2=true;
        }
            input = tablero.p1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ap = tablero.p1.getActionMap();
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0, false),"up");
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0, false),"d");
            input2 = tablero.p1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ap2 = tablero.p1.getActionMap();
            input2.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0, false),"ar");
            input2.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0, false),"ab");
        
        
        
       
        
    }

    public void prepareAcciones() {
        salga();
        tai = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tablero.mover();
                if (tablero.maxP()!=null) {
                    gameOver(tablero.maxP());
                }if(cpu){
                    tablero.movecpu();
                }if(cpu2){
                    tablero.movecpu2();
                }if(tablero.w1()){
                    gameOver2("El jugador 2");
                }if(tablero.w2()){
                    gameOver2("El jugador 2");
                }
            }
        });
        tai.start();

        ap.put("up", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!pause){tablero.movep1(true, false);}
            }
        });
        ap.put("d", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!pause){tablero.movep1(false, false);}
            }
        });
        ap2.put("ar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!pause){tablero.movep1(true, true);}
            }
        });
        ap2.put("ab", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!pause){tablero.movep1(false, true);}
            }
        });

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int val = fc.showSaveDialog(null);
                if (val == JFileChooser.APPROVE_OPTION) {
                    File fichero = fc.getSelectedFile();
                    pongsito = tablero.getPoong();
                    tai.stop();
                    try {
                        pongsito.guardar(fichero);
                        System.exit(ABORT);
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                        }
                    }
        });
        pausar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!pause){tai.stop();
                    pause=true;
                    pausar.setText("Reanudar");
                }else{
                    tai.restart();
                    pause=false;
                    pausar.setText("Pausar");
                }
            }

        });
    }


    
    public void refresque(){
        repaint();
    }

    
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
    public void gameOver(String jugador){
        JOptionPane.showMessageDialog(this, jugador+" alcanzo el puntaje maximo", "GAME OVER", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
    }
    public void gameOver2(String jugador){
        JOptionPane.showMessageDialog(this,jugador+" Tiene la Fortaleza de uno de los jugadorees es muy baja", "GAME OVER", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
    }

    
    public static void main(String[] args) {
        JuegoGUI game = new JuegoGUI(args[0],args[1],args[2],args[3],args[4]);
        game.setVisible(true);
        game.setLocationRelativeTo(null);
    }
}

class Tablero extends JPanel{
    private int x,y,px,py,puntaje;
    public JLabel p1,p2,bola,malla;
    public Poong pong;
    private String j1c,j2c,vBal;
    private File paulina = new File("");
    private JLabel c1,c2,o1,o2,sor ,fondo2,f1,f2,bloque;
    private Image fondo;
    
    public Tablero(int alto,int ancho,String j1,String j2,int punt,String bal){
        x = ancho;y = alto;px=50;py=50;j1c = j1;j2c=j2;puntaje=punt;vBal=bal;
        pong = Poong.getNewPoong(x,y,"Jugador VS Jugador",j1,j2,String.valueOf(puntaje), vBal);
        setBackground(Color.ORANGE);
        setLayout(null);
        System.out.println(paulina.getAbsolutePath());
        paint();
        
    }
    public Tablero(int alto,int ancho,String j1,String j2,int punt,Poong png){
        x = ancho;y = alto;px=50;py=50;puntaje=punt;j1c = j1;j2c=j2;
        setBackground(Color.CYAN);
        pong = png;
        setLayout(null);
        paint();
    } 
    public void paint() 
    { 
        dibuje();
    } 
    public void dibuje(){
        ImageIcon cr7 = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/cr722.png");
        Image sca = cr7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        cr7 = new ImageIcon(sca);
        bola= new JLabel(cr7);
        
        System.out.println(pong.getXP()+" "+pong.getYP());
        int px = pong.getXP();int py= pong.getYP();
        bola.setBounds(px, py, 20, 20);
        add(bola);
        String img1 = pong.personaje(j1c);
        String img2 = pong.personaje2(j2c);
        p1 = new JLabel(new ImageIcon(img1));
        p2 = new JLabel(new ImageIcon(img2));
        int ppy= pong.getYP1();int p2y=pong.getYP2();
        p1.setBounds(40,ppy,35,40);
        p2.setBounds(520,p2y,35,40);
        add(p1);add(p2);
        c1= new JLabel(String.valueOf(pong.getYC1()));
        c2= new JLabel(String.valueOf(pong.getYC2()));
        c1.setFont(new Font("Helvetica", Font.PLAIN, 45));
        c2.setFont(new Font("Helvetica", Font.PLAIN, 45));
        c1.setForeground(Color.WHITE);c2.setForeground(Color.BLACK);
        c1.setBounds(100, 50, 50, 50);
        c2.setBounds(420, 50, 50, 50);
        add(c1);add(c2);
        f1= new JLabel(String.valueOf(pong.getFor1())+"%");
        f2= new JLabel(String.valueOf(pong.getFor2())+"%");
        f1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        f2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        f1.setForeground(Color.RED);f2.setForeground(Color.RED);
        f1.setBounds(35, 50, 55, 55);
        f2.setBounds(355, 50, 55, 55);
        add(f1);add(f2);
        ImageIcon fon = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/fondo.jpg");
        fondo = fon.getImage().getScaledInstance( x-50, y-90, Image.SCALE_DEFAULT);
    }
    public void paintComponent(Graphics g){
        g.drawImage( fondo, 0, 0, this);
    }
    public void mover(){
        pong.movePel();
        bola.setBounds(pong.getXP(),pong.getYP(),20, 20);
        alive();
        aliveP();
        aliveB();
        c1.setText(String.valueOf(pong.getYC1()));
        c2.setText(String.valueOf(pong.getYC2()));
        c1.setForeground(Color.WHITE);c2.setForeground(Color.BLACK);
        add(c1);add(c2);
        f1.setText(String.valueOf(pong.getFor1())+"%");
        f2.setText(String.valueOf(pong.getFor2())+"%");
        f1.setForeground(Color.RED);f2.setForeground(Color.RED);
        add(f1);add(f2);
    }
    public void movep1(boolean up,boolean ju2){
        if(!ju2){
            pong.movePer(up);
            p1.setBounds(40,pong.getYP1(),35, 40);
        }else{
            pong.movePer2(up);
            p2.setBounds(520,pong.getYP2(),35, 40);
        }
    }
    public String maxP(){
        String player=null;
        if(puntaje<=pong.getYC2()){
            return "Jugador 2";
        }if(puntaje<=pong.getYC1()){
           return "Jugador1";
        }
        else{
            return null;
        }
    }
    public Poong getPoong(){
        return this.pong;
    }
    public void alive(){
        int tiempoo = pong.getTime();
        if(tiempoo>0){
            if(!pong.objAlive()){pong.nuevoO();}
            if(o1!=null){remove(o1);remove(o2);}
            ImageIcon obj = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/objetivo.png");
            Image obj2 = obj.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            o1 = new JLabel(new ImageIcon(obj2));
            o2 = new JLabel(new ImageIcon(obj2));
            o2.setBounds(0,pong.getOC2(),20,40);
            o1.setBounds(560,pong.getYO1(),20,40);
            add(o1);add(o2);
        }else{
            if(o1!=null){remove(o1);remove(o2);}
            o1= null;o2=null;
        }
        repaint();
    }
    public void aliveP(){
        int tiempoo = pong.getTimeP();
        if(tiempoo>0){
            if(!pong.objAliveP()){pong.nuevoP();}
            if(sor!=null){remove(sor); }
            ImageIcon obj = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/Sorpresa.png");
            Image obj2 = obj.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            sor = new JLabel(new ImageIcon(obj2));
            sor.setBounds(275, 170, 40, 40);
            add(sor);
        }else{
            if(sor!=null){remove(sor);}
            sor= null;
        }
        repaint();
    }
    public void movecpu(){
        pong.cpu();
        p2.setBounds(520,pong.getYP2(),35, 40);
    }
    public void movecpu2(){
        pong.cpu2();
        p1.setBounds(40,pong.getYP1(),35, 40);
        p2.setBounds(520,pong.getYP2(),35, 40);
    }
    public boolean w1(){
        if(pong.getFor2()<50){
            return true;
        }else{
            return false;
        }
    }
    public boolean w2(){
        if(pong.getFor1()<50){
            return true;
        }else{
            return false;
        }
    }

    public void aliveB(){
        if(bloque!=null){remove(bloque);} 
        if(pong.aliveBloque()){
            
            ImageIcon cr7 = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/logo.jpg");
            Image sca = cr7.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
            cr7 = new ImageIcon(sca);
            bloque= new JLabel(cr7);
            bloque.setBounds(pong.getPXB(), 170, 20, 20);
            add(bloque); 
        }
        repaint();
    }
}

