package presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ModoGameGUI extends JFrame{

    private int width,height;
    private Dimension screen;
    private JLabel titulo;
    private JButton regresar;
    private JButton pvp;
    private JButton cvc;
    private JButton pvc;
    private JLabel fondo;
    private File paulina = new File("");

    /**
     * constructor
     */
    public ModoGameGUI(){
        super("Poong");
        prepareElementos();
        prepareAcciones();
    }
    /**
     * prepara elementos de ModoGameGUI
     */
    public void prepareElementos(){
        setLayout(null);
        screen=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int)screen.getWidth();
        height=(int)screen.getHeight();
        this.setSize(width/2,height/2);
        ImageIcon fondo1 = new ImageIcon(paulina.getAbsolutePath()+"/POONG/Pictures/pong3.jpg");
        fondo = new JLabel(fondo1);
        fondo.setBounds(0,0,width/2,height/2);
        add(fondo);
        titulo = new JLabel ("MODOS DE JUEGO");
        titulo.setFont(new Font("Helvetica", Font.PLAIN, 35));
        titulo.setForeground(Color.RED);
        titulo.setBounds(width/8,0,400,100);
        fondo.add(titulo);

        regresar = new JButton("REGRESAR");
        pvp = new JButton("Jugador VS Jugador");
        pvc = new JButton("Jugador VS CPU");
        cvc = new JButton("CPU VS CPU");
        
        regresar.setBounds( 0, (height/2)-65, 100, 25);
        pvp.setBounds( (width/6)-200, (height/4), 150, 25);
        pvc.setBounds( (width/6)+25, (height/4), 150, 25);
        cvc.setBounds( (width/6)+250, (height/4), 150, 25);
        fondo.add(regresar);
        fondo.add(pvp);
        fondo.add(pvc);
        fondo.add(cvc);
    }
    /**
     * prepara acciones de ModoGameGUI
     */
    public void prepareAcciones(){
        salga();
        pvp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String [] args ={"a"};
                setVisible(false);
                PersonajeGUI.main(args);
            }
        });
        pvc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String [] args ={"b"};
                setVisible(false);
                CPU.main(args);
            }
        });
        cvc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String [] args ={"c"};
                setVisible(false);
                PersonajeGUI.main(args);
            }
        });

        regresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                PoongGUI.main(new String[] {});
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
        ModoGameGUI confg = new ModoGameGUI();
        confg.setVisible(true);
        confg.setLocationRelativeTo(null);
    }
    
}
