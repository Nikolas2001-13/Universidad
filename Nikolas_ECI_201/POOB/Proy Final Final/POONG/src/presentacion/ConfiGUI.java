package presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ConfiGUI extends JFrame{

    private int width,height;
    private Dimension screen;
    private JLabel titulo,puntaje,bal;
    private JTextField punt;
    private JComboBox ball;
    private JButton regresar,siguiente;
    private JLabel fondo;
    private static String modo,j1,j2;
    private File paulina = new File("");


    public ConfiGUI(){
        super("Poong");
        prepareElementos();
        prepareAcciones();
    }

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
        titulo = new JLabel ("OPCIONES");
        titulo.setFont(new Font("Helvetica", Font.PLAIN, 35));
        titulo.setForeground(Color.RED);
        titulo.setBounds(width/8,0,400,100);
        fondo.add(titulo);

        puntaje = new JLabel ("Seleccione el puntaje a jugar:");
        puntaje.setFont(new Font("Helvetica", Font.PLAIN, 20));
        puntaje.setForeground(Color.RED);
        puntaje.setBounds(width/8,height/8,400,100);
        fondo.add(puntaje);

        bal = new JLabel ("Seleccione la velocidad de la ball");
        bal.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bal.setForeground(Color.RED);
        bal.setBounds(width/8,(height/8)+100,400,100);
        fondo.add(bal);

        punt = new JTextField();
        punt.setBounds(width/7,(height/8),100,25);
        fondo.add(punt);
        ball=new JComboBox();
        ball.addItem("Lenta");
        ball.addItem("Rapida");
        ball.addItem("Incremental");
        ball.setBounds(width/7,(height/8)+100,100,25);
        fondo.add(ball);

        regresar = new JButton("REGRESAR");
        siguiente = new JButton("SIGUIENTE");
        
        siguiente.setBounds( (width/3)+100, (height/2)-65, 100, 25);
        regresar.setBounds( 0, (height/2)-65, 100, 25);
        
        fondo.add(regresar);
        fondo.add(siguiente);
        
    }

    public void prepareAcciones(){
        salga();
       
        siguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String [] args ={modo,j1,j2,punt.getText(),(String)ball.getSelectedItem() };
                setVisible(false);
                JuegoGUI.main(args);
            }

        });


        regresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                PersonajeGUI.main(new String[] {});
            }
        });
        
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
    public static void main(String[] args) {
        ConfiGUI confg = new ConfiGUI();
        confg.setVisible(true);
        confg.setLocationRelativeTo(null);
        modo= args[0];
        j1 = args[1];
        j2 = args[2];
    }
    
}
