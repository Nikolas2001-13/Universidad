package aplicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

import presentacion.JuegoGUI;

public class Poong implements Serializable {
    private Pelota ball;
    private Personaje p1, p2;
    private Objetivo o1=null,o2=null;
    private int hi;
    private static Poong pong2=null;
    private Poder sorpresa;
    private static String j1, j2, modo,vel,punta;
    private Bloque bloque;

    /**
     * Constructor de la clase Poong
     * @param x 
     * @param y 
     * @param modo2
     * @param ju1
     * @param ju2
     * @param punt
     * @param vBal
     */
    private Poong(int x, int y,String modo2,String ju1,String ju2,String punt,String vBal) {
        hi=y;
        modo=modo2;
        j1=ju1;
        j2=ju2;
        punta=punt;
        vel=vBal;
        ball = new Pelota(x, y, this,vBal);
        p1 = new Personaje(y, x);
        p2 = new Personaje(y, x, true);
        pong2=this;
    }

    /**
     * Funcion encargada del movimiento de los elementos de poong
     */
    public void movePel() {
        ball.mover();
        if(sorpresa!=null){
            sorpresa.power();
        }if(p1.getTime()<=0){
            p1.normal();
        }if(p2.getTime()<=0){
            p2.normal();
        }if(p1.getTime()>0){
            p1.setTime();
        }if(p2.getTime()>0){
            p2.setTime();
        }if(bloque!=null){
            bloque.move();
        }
    }

    /**
     * 
     * @return int de la posicion en x de la pelota
     */
    public int getXP() {
        return ball.getX();
    }

    /**
     * 
     * @return int de la posicion en y de la pelota
     */
    public int getYP() {
        return ball.getY();
    }

    /**
     * metodo encargado de mover al personaje 1
     * @param up
     */
    public void movePer(boolean up) {
        p1.move(up);
    }
    /**
     * metodo encargado de mover al personaje 2
     * @param up
     */
    public void movePer2(boolean up) {
        p2.move(up);
    }
    /**
     * metodo que busca la ruta que corresponde a la imagen del personaje seleccionado
     * @param per
     * @return String
     */
    public String personaje(String per) {
        return p1.persoanje(per);
    }
    /**
     * metodo que busca la ruta que corresponde a la imagen del personaje seleccionado
     * @param per
     * @return String
     */
    public String personaje2(String per) {
        return p2.persoanje2(per);
    }
    /**
     * Obtiene la pos y del jugador1
     * @return int
     */
    public int getYP1() {
        return p1.getPos();
    }
    /**
     * Obtiene la pos y del jugador2
     * @return int
     */
    public int getYP2() {
        return p2.getPos();
    }

    /**
     * metodo que retorna el valor del contador 1
     * @return int
     */
    public int getYC1() {
        return ball.getC1();
    }

    /**
     * metodo que retorna el valor del contador 2
     * @return int
     */
    public int getYC2() {
        return ball.getC2();
    }
    /**
     * metodo que obtiene la posicion en y del objetivo 1
     * @return int
     */
    public int getYO1() {
        return o1.getY();
    }

    /**
     * metodo que obtiene la posicion en y del objetivo 2
     * @return int
     */
    public int getOC2() {
        return o2.getY();
    }
    /**
     * Deja nulo los objetivos 
     */
    public void setNull(){
        o1 = null;
        o2= null;
    }
    /**
     * Obtiene el tiempo que lleva una sorpresa en caso de no tener sorpresa decide si crear una o no 
     * @return int
     */
    public int getTimeP(){
        int time=0;
        if(sorpresa!=null){
            if(sorpresa.getTime()<=0){
                time= sorpresa.getTime();
                sorpresa=null;
            }else{
                time= sorpresa.getTime();
            }
        }else{
            nuevoP();
        }
        
        return time;
    }
    /**
     * Decide si crea una nueva sorpresa
     */
    public void nuevoP(){
        if(sorpresa==null){
            Random rand = new Random(); 
            int rand_int1 = rand.nextInt(100);
            if(rand_int1==0){
                sorpresa = new FastBall(this);
            }if(rand_int1==1){
                sorpresa = new Turtle(this);
            }if(rand_int1==2){
                sorpresa = new Freeze(this);
            }
        }
    }
    /**
     * mira si la sorpresa sigue viva
     * @return boolean
     */
    public boolean objAliveP(){
        if(sorpresa==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * retorna el tiempo que tiene un objetivo, si no hay objetivo decide si crea uno o no 
     * @return int
     */
    public int getTime(){
        int time=0;
        if(o1!=null){
            if(o1.getTime()<=0){
                time= o1.getTime();
                o1=null; o2=null;
            }else{
                time= o1.getTime();
            }
        }else{
            nuevoO();
        }
        
        return time;
    }
    /**
     * Decide si crear un nuevo objetivo
     */
    public void nuevoO(){
        if(o1==null){
            Random rand = new Random(); 
            int rand_int1 = rand.nextInt(15);
            if(rand_int1==1){
                o1 = new Objetivo(hi, true);
                o2 = new Objetivo(hi);
            }
        }
    }
    /**
     * Revisa si los objetivos estan vivios
     * @return boolean
     */
    public boolean objAlive(){
        if(o1==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Metodo que guarda
     * @param fichero
     * @throws FileNotFoundException
     * @throws IOException
     */
    /*public void guardar(File fichero) throws FileNotFoundException, IOException {
        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(fichero));
        salida.writeObject(this);
        salida.close();
    }*/
    /*
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
    });*/
    /**
     * Metodo que abre
     * @param file
     * @throws FileNotFoundException
     */
    /*public static void abra(File file) throws FileNotFoundException{
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(file));
            pong2 = (Poong)entrada.readObject();
        }
        catch(Exception e){
            //throw new FileNotFoundException();
            System.out.println(e.getMessage());
        }
        
    }
    */

    /**
     * verifica si ya existe una instancia de poong si no la crea
     * @param x
     * @param y
     * @param modo
     * @param j1
     * @param j2
     * @param punta
     * @param vBal
     * @return Poong 
     */
    public static Poong getNewPoong(int x,int y,String modo,String j1,String j2, String punta, String vBal){
        if(pong2==null){
            return new Poong(x,y,modo,j1,j2, punta, vBal);
        }else{return pong2;}
    }
    /**
     * mueve la cpu
     */
    public void cpu(){
        ball.cpu();
    }
    /**
     * mueve las cpu
     */
    public void cpu2(){
        ball.cpu2();
    }
    /**
     * retorna el modo de juego
     * @return String
     */
    public String modo(){
        return modo;
    }
    /**
     * retorna el j1
     * @return String
     */
    public String j1(){
        return j1;
    }
    /**
     * retorna el j2
     * @return String
     */
    public String j2(){
        return j2;
    }
    /**
     * retorna la velocidad de la pelota
     * @return String
     */
    public String vel(){
        return modo;
    }
    /**
     * retorna el puntaje 
     * @return String
     */
    public String punta(){
        return punta;
    }
    /**
     * crea un nuevo pong
     * @return Poong
     */
    public static Poong getPong(){
        return pong2;
    }
    /**
     * retorna la pelota
     * @return Pelota
     */
    public Pelota getBall(){
        return ball;
    }
    /**
     * retorna al personaje 1
     * @return Personaje
     */
    public Personaje getp1(){
        return p1;
    }
    /**
     * retorna el personaje 2
     * @return Personaje
     */
    public Personaje getp2(){
        return p2;
    }
    /**
     * retorna el objeto 1
     * @return Objetivo
     */
    public Objetivo geto1(){
        return o1;
    }
    /**
     * retorna el objeto 2
     * @return Objetivo
     */
    public Objetivo geto2(){
        return o2;
    }
    /**
     * retorna la fortaleza del personaje 1
     * @return int
     */
    public int getFor1(){
        return p1.getFortaleza();
    }

    /**
     * retorna la fortaleza del personaje 1
     * @return int
     */
    public int getFor2(){
       return p2.getFortaleza();
    }
    /**
     * crea un nuevo bloque
     * @param nx
     * @param x
     * @param y
     */
    public void newBloque(int nx,int x,int y){
        bloque= new Bloque(nx,x,y,this);
    }
    /**
     * desaparece el bloque
     */
    public void killBloque(){
        bloque=null;
    }
    /**
     * mira si un bloque esta vivo o no
     * @return boolean
     */
    public boolean aliveBloque(){
        if(bloque!=null){
            return true;
        }else{
            return false;
        }
    }
    /**
     * posicion x del bloque
     * @return int
     */
    public int getPXB(){
        return bloque.getpx();
    }
    /**
     * guardar el documento
     * @param file
     * @throws PoongException
     */
    public void guardar(File file)  throws  PoongException{
        try{
            FileWriter salida = new FileWriter(file);
            String cad = modo +" "+ punta+"\n";
            if(ball!=null){
                cad+=ball.toString()+"\n";
            }
            if(p1!=null){
                cad+=p1.toString()+"\n"; 
            }
            if(p2!=null){
                cad+=p2.toString()+"\n";
            }if(o1==null){
                cad+="null"+"\n";
            }if(o1!=null){
                cad+=o1.toString()+"\n";
                cad+=o2.toString()+"\n";
            }if(bloque==null){
                cad+="null"+"\n";
            }if(bloque!=null){
                cad+=bloque.toString()+"\n";
            }   
            salida.write(cad);
            salida.close();
        } 
        catch(Exception e){
            throw new PoongException(PoongException.ERROR_EXPORTAR);

        }
    }
    /**
     * importar el documento
     * @param file
     * @throws PoongException
     */
    public void importar(File file) throws PoongException{
        try{
            BufferedReader entrada =new BufferedReader( new FileReader(file));
            for (int i=0;i<6;i++){
                String linea = entrada.readLine();
                linea = linea.trim();
                String[] partes = linea.split(" ");
                if(i==0){
                    modo=partes[0]+" "+partes[1]+" "+partes[2];
                    punta = partes[3];
                }if(i==1){
                    this.ball.setearPel(Integer.parseInt(partes[1]),Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),Integer.parseInt(partes[6]),Integer.parseInt(partes[7]));
                }
                if(i==2){
                    this.p1.setearPer(Integer.parseInt(partes[1]),Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),partes[6]);
                }
                if(i==3){
                    this.p2.setearPer(Integer.parseInt(partes[1]),Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),partes[6]);
                }
                if(i==4&&partes.length>=2){
                    o1=new Objetivo(hi);
                    this.o1.setearObj(Integer.parseInt(partes[1]),Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
                }
                if(i==5&&partes.length>=2){
                    o2=new Objetivo(hi);
                    this.o2.setearObj(Integer.parseInt(partes[1]),Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
                }
            }
        }
        catch(Exception e){

        }
    }
    /**
     * obtiene el modo de juego
     * @return String
     */
    public String getModo(){
        return this.modo();
    }
}