package aplicacion;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Rectangle;
import java.io.Serializable;

public class Poder implements Serializable{
    private int time;
    protected Poong pongsito;
    /**
     * constructor de la clase
     * @param p
     */
    public Poder(Poong p){
        pongsito = p;
        time = ThreadLocalRandom.current().nextInt(10000,21000);
    }
    /**
     * retorna el tiempo del poder 
     * @return int
     */
    public int getTime(){
        time-=25;
        return time;
    }
    /**
     * hitbox del poder
     * @return Rectangle
     */
    public Rectangle getBounds() {
		return new Rectangle(275,170, 40, 40);
    }
    /**
     * efecto del poder
     */
    public void power(){}
    /**
     * mata el poder
     */
    public void killMePlis(){
        time=0;
    }
    /**
     * aparece el bloque aleatoriamente cuando se coge un poder
     * @param nx
     */
    public void bloque(int nx){
        Random rand = new Random(); 
        int rand_int1 = rand.nextInt(2);
        if(rand_int1==1){
            pongsito.newBloque(nx,275,170);
        }
        
    }
    
}