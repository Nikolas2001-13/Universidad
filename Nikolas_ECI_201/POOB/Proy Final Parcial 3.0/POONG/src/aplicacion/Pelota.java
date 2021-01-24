package aplicacion;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Pelota implements Serializable{
    private int x,y,nx,ny,px,py,c1,c2,nyi;
    private Poong pong;
    private String velocidad;
    /**
     * Constructor de la calse pelota
     * @param x
     * @param y
     * @param ping
     * @param vBal
     */
    public Pelota(int x,int y,Poong ping,String vBal){
        this.x = x;
        this.y = y;
        pong=ping;
        px=250;
        py=125;
        int vel = checkVel(vBal);
        velocidad=vBal;
        nx=vel;
        ny=vel;
        c1=0;
        c2=0;
        nyi=vel;
    }
    /**
     * asigna una velocidad a la pelota
     * @param vel
     * @return int
     */
    public int checkVel(String vel){
        int vx=0;
        if(vel.equals("Lenta")){
            vx= 5;
        }if(vel.equals("Rapida")){
            vx=7;
        }if(vel.equals("Incremental")){
            vx= 5;
        }
        return vx;
    }
    /**
     * retorna la pos x de la pelota
     * @return int
     */
    public int getX(){
        return px;
    }
    /**
     * retorna la pos y de la pelota
     * @return int
     */
    public int getY(){
        return py;
    }
    /**
     * retorna el valor del contador 1
     * @return int
     */
    public int getC1(){
        return c1;
    }
    /**
     * retorna el valor del contador 1
     * @return int
     */
    public int getC2(){
        return c2;
    }
    /**
     * ajusta la velocidad de la pelota
     * @param newV
     */
    public void setVel(int newV){
        nx=newV;ny=newV;
    }
    /**
     * acelera la velocidad de la pelota
     */
    public void fast(){
        nx+=nx*0.2;ny+=ny*0.2;
    }
    /**
     * normaliza la velocidad de  la pelota
     */
    public void reset(){
        if(nx<0){nx=-nyi;}if(nx>0){nx=nyi;}if(ny<0){ny=-nyi;}if(ny>0){ny=nyi;}
    }
    /**
     * obtiene la variacion del movimiento de la pelota
     * @return int
     */
    public int getNX(){
        return nx;
    }
    /**
     * mueve la pelota 
     */
    public void mover(){
        if(px<0){
            nx=-nx;
            px=250;
            py=125;
            c2+=1;
            reset();
        }if(py<0){
            ny=-ny;
            py=0;;
        }if(px>x-85){
            nx=-nx;
            px=250;
            py=125;
            c1+=1;
            reset();
        }if(py>y-125){
            ny=-ny;
            py=y-125;
        }if(colision()){
            nx=-nx;
            if(nx<0){px= getTopY()+5;}else{px= getTopx()-5;}
            if(ny<0){py+=5;}else{py+=-5;}
            if(velocidad.equals("Incremental")){
                nx+=nx*0.2;ny+=ny*0.2;
            }
        }if(colision1()){
            nx=-nx;
            px=250;
            py=125;
            if((int)(c1/2)+1>2){
                c1+=ThreadLocalRandom.current().nextInt(2,(c1/2)+1);
            }if((int)(c1/2)+1<2){
                c1+=ThreadLocalRandom.current().nextInt((c1/2)+1,2);
            }else{c1+=2;
            }
            pong.setNull();
            reset();
        }if(colision2()){
            nx=-nx;
            px=250;
            py=125;
            if((int)(c2/2)+1>2){
                c2+=ThreadLocalRandom.current().nextInt(2,(c2/2)+1);
            }if((int)(c2/2)+1<2){
                c2+=ThreadLocalRandom.current().nextInt((c2/2)+1,2);
            }else{c2+=2;
            }
            pong.setNull();
            reset();
        }
        px+=nx;py+=ny; 
    }
    /**
     * rectangulo de la hit box de la pelota
     * @return Rectangle
     */
    public Rectangle getBounds() {
        return new Rectangle(px,py, 20, 20);
    }
    /**
     * ajusta el choque de la pelota
     * @return int
     */
    public int getTopY() {
		return px - 20 ;
    }
    /**
     * ajusta el choque de la pelota
     * @return int
     */
    public int getTopx() {
		return px + 20 ;
    }
    /**
     * detecta la colision con los personajes
     * @return boolean
     */
    public boolean colision(){
        if(pong.getp1().getBounds().intersects(getBounds())||pong.getp2().getBounds().intersects(getBounds())){
            return true;
        }else{return false;}
    }
    /**
     * detecta colision con los objetos
     * @return boolean
     */
    public boolean colision1(){
        if(pong.geto1()!=null){
            if(pong.geto1().getBounds().intersects(getBounds())){
                return true;
            }else{return false;}
        }else{return false;
        }
    }
    /**
     * retorna los objetos de la pelota con los objetos
     * @return boolean
     */
    public boolean colision2(){
        if(pong.geto2()!=null){
            if(pong.geto2().getBounds().intersects(getBounds())){
                return true;
            }else{return false;}
        }else{return false;
        }
    }
    /**
     * mueve a la cpu con la pelota
     */
    public void cpu(){
        pong.getp2().setPosy(py);
    }
    /**
     * mueve a las 2 cpu con la pelota
     */
    public void cpu2(){
        pong.getp1().setPosy(py);
        pong.getp2().setPosy(py);
    }
    /**
     * obtiene la posicion y del objetivo 1
     */
    public void obj1(){
        pong.geto1().setY(py);
    }
    /**
     * obtiene la posicion y del objetivo 2
     */
    public void obj2(){
        pong.geto2().setY(py);
    }
    /**
     * vuelve string los parametros de Pelota
     * @return String
     */
    public String toString(){
        return "Pelota "+ Integer.toString(x)+" "+Integer.toString(y)+"  " +Integer.toString(nx)+"  " +Integer.toString(ny)+"  " +Integer.toString(nyi)+"  " +Integer.toString(c1)+"  " +Integer.toString(c2);
    }
    /**
     * asigna los parametros que entran a los de la calse Pelota
     * @param x
     * @param y
     * @param nx
     * @param ny
     * @param nyi
     * @param c1
     * @param c2
     */
    public void setearPel(int x,int y,int nx,int ny, int nyi, int c1, int c2){
        this.px=x;
        this.py=y;
        this.nx=nx;
        this.ny=ny;
        this.nyi=nyi;
        this.c1=c1;
        this.c2=c2;
    }

}