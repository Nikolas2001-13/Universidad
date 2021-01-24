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
        nnx=nx;px=x;py=y;
    }
    
    /**
     * hitbox del poder
     * @return
     */
    public Rectangle getBounds() {
		return new Rectangle(px,170, 40, 40);
    }

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

    public void power(){
        if(pongsito.getp1().getBounds().intersects(getBounds())){
            pongsito.getp1().bloque();
            killMePlis();
        }if(pongsito.getp2().getBounds().intersects(getBounds())){  
            pongsito.getp2().bloque();
            killMePlis();
        }
        
    }

    public int getpx(){
        return px;
    }
   
    public void killMePlis(){pongsito.killBloque();}
    
    
}