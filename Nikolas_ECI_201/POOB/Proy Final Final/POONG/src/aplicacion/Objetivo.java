package aplicacion;

import java.io.Serializable;
import java.util.Random;
import java.awt.Rectangle;

public class Objetivo implements Serializable {
    private int hi,x,y,tiempo; 
    /**
     * constructor de la clase objetivo
     * @param alto
     */
    public Objetivo(int alto){
        hi = alto;
        x=0;
        tiempo = 10000;
        randomY();
    }
    /**
     * constructor de la clase objetivo para el jugador 1
     * @param alto
     * @param p1
     */
    public Objetivo(int alto,boolean p1){
        hi = alto;
        x=560;
        tiempo = 10000;
        randomY();
    }
    /**
     * hubica el objetivo en una posicion y random
     */
    public void randomY(){ 
        Random rand = new Random(); 
        int rand_int1 = rand.nextInt(hi-125);
        y = rand_int1;
    }
    /**
     * retorna la pis y del objetivo
     * @return
     */
    public int getY(){
        return y;
    }
    /**
     * retorna la pos x del objetivo
     * @return
     */
    public int getX(){
        return x;
    }
    /**
     * retorna el tiempo que le queda al objetivo
     * @return
     */
    public int getTime(){
        tiempo-=25;
        return tiempo;
    }
    /**
     * retorna un rctangulo con la hit box del objetivo
     * @return
     */
    public Rectangle getBounds() {
		return new Rectangle(x,y, 20, 40);
    }
    public void setY(int newY){
        y=newY;
    }
    
}