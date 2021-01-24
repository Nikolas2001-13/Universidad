package aplicacion;

import java.util.concurrent.ThreadLocalRandom;
import java.awt.Rectangle;
import java.io.Serializable;

public class Bloque implements Serializable{
    private int nnx,px,py;
    protected Poong pongsito;
    /**
     * constructor de la clase
     * @param p
     */
    public Bloque(int nx,int x,int y,Poong p){
        pongsito = p;
        nnx=nx;
        px=x;
        py=y;
    }
    
    /**
     * hitbox del poder
     * @return Rectangle
     */
    public Rectangle getBounds() {
		return new Rectangle(px,170, 40, 40);
    }
    /**
     * movimiento del bloque
     */
    public void move(){
        if(px+nnx<0){
            killMePlis();
        }if(px+nnx>1100){
            killMePlis();
        }else{
            px+=nnx; 
        }
        power();
    }
    /**
     * elimina el bloque cuando interseca con el personaje
     */
    public void power(){
        if(pongsito.getp1().getBounds().intersects(getBounds())){
            pongsito.getp1().bloque();
            killMePlis();
        }if(pongsito.getp2().getBounds().intersects(getBounds())){  
            pongsito.getp2().bloque();
            killMePlis();
        }
        
    }
    /**
     * obtiene la posicion x
     * @return int
     */
    public int getpx(){
        return px;
    }
    /**
     * elimina el bloque
     */
    public void killMePlis(){
        pongsito.killBloque();
    }
    /**
     * vuelve string los parametros de Bloque
     * @return String
     */
    public String toString(){
        return "Bloque"+ Integer.toString(nnx)+" "+Integer.toString(px)+"  " +Integer.toString(py);
    }
    
    
}