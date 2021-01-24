package aplicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

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
     * @return
     */
    public String personaje(String per) {
        return p1.persoanje(per);
    }
    /**
     * metodo que busca la ruta que corresponde a la imagen del personaje seleccionado
     * @param per
     * @return
     */
    public String personaje2(String per) {
        return p2.persoanje2(per);
    }
    /**
     * Obtiene la pos y del jugador1
     * @return
     */
    public int getYP1() {
        return p1.getPos();
    }
    /**
     * Obtiene la pos y del jugador2
     * @return
     */
    public int getYP2() {
        return p2.getPos();
    }

    /**
     * metodo que retorna el valor del contador 1
     * @return
     */
    public int getYC1() {
        return ball.getC1();
    }

    /**
     * metodo que retorna el valor del contador 2
     * @return
     */
    public int getYC2() {
        return ball.getC2();
    }
    /**
     * metodo que obtiene la posicion en y del objetivo 1
     * @return
     */
    public int getYO1() {
        return o1.getY();
    }

    /**
     * metodo que obtiene la posicion en y del objetivo 2
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
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
    public void guardar(File fichero) throws FileNotFoundException, IOException {
        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(fichero));
        salida.writeObject(this);
        salida.close();
    }


    /**
     * Metodo que abre
     * @param file
     * @throws FileNotFoundException
     */
    public static void abra(File file) throws FileNotFoundException{
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(file));
            pong2 = (Poong)entrada.readObject();
        }
        catch(Exception e){
            //throw new FileNotFoundException();
            System.out.println(e.getMessage());
        }
        
    }
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
     * @return
     */
    public String modo(){
        return modo;
    }
    /**
     * retorna el j1
     * @return
     */
    public String j1(){
        return j1;
    }
    /**
     * retorna el j2
     * @return
     */
    public String j2(){
        return j2;
    }
    /**
     * retorna la velocidad de la pelota
     * @return
     */
    public String vel(){
        return modo;
    }
    /**
     * retorna el puntaje 
     * @return
     */
    public String punta(){
        return punta;
    }
    /**
     * 
     * @return
     */
    public static Poong getPong(){
        return pong2;
    }
    /**
     * retorna la pelota
     * @return
     */
    public Pelota getBall(){
        return ball;
    }
    /**
     * retorna al personaje 1
     * @return
     */
    public Personaje getp1(){
        return p1;
    }
    /**
     * retorna el personaje 2
     * @return
     */
    public Personaje getp2(){
        return p2;
    }
    /**
     * retorna el objeto 1
     * @return
     */
    public Objetivo geto1(){
        return o1;
    }
    /**
     * retorna el objeto 2
     * @return
     */
    public Objetivo geto2(){
        return o2;
    }

    public int getFor1(){
        return p1.getFortaleza();
    }

    public int getFor2(){
       return p2.getFortaleza();
    }
    public void newBloque(int nx,int x,int y){
        bloque= new Bloque(nx,x,y,this);
    }
    public void killBloque(){
        bloque=null;
    }
    public boolean aliveBloque(){
        if(bloque!=null){
            return true;
        }else{
            return false;
        }
    }
    public int getPXB(){
        return bloque.getpx();
    }
}