package aplicacion;

import java.awt.event.*;
import java.io.File;
import java.io.Serializable;
import java.awt.Rectangle;

public class Personaje implements Serializable{
    private int y,x,height,width,ny,time,Fortaleza;
    private String url;
    private File paulina = new File("");

    /**
     * Constructor de la clase 
     * @param y
     * @param x
     */
    public Personaje(int y,int x){
        height = y; 
        width =x;
        ny=10;
        time = -5;
        Fortaleza = 1000;
        this.y=165;
        this.x=40;
    }
    /**
     * constructor de la clase para j2
     * @param y
     * @param x
     * @param d
     */
    public Personaje(int y,int x,boolean d){
        height = y;
        width =x;
        ny=10;
        time = -5;
        Fortaleza = 1000;
        this.x=520;
        this.y=165;
    }

    /**
     * retorna la pos y del personaje
     * @return
     */
    public int getPos(){
        return y;
    }
    /**
     * freezea al jugador
     */
    public void freeze(){
        time=2000;
        ny=0;
    }
    /**
     * slowea al jugador
     */
    public void slow(){
        time=3000;
        ny=2;
    }
    /**
     * setea la posicion y
     * @param pos
     */
    public void setPosy(int pos){
        y=pos;
    }
    /**
     * ajusata una velocidad normal 
     */
    public void normal(){
        ny=10;
        time=-5;
    }
    /**
     * retorna el tiempo 
     * @return
     */
    public int getTime(){
        return time;
    }
    /**
     * setea el tiempo
     */
    public void setTime(){
        time-=50;
    }
    /**
     * mueve al persoanje
     * @param up
     */
    public void move(boolean up){
        if(!up){
            if(y+ny<height-140){y+=ny;}else{y=height-140;}
        }else{
            if (y-ny<0){y=0;}else{y-=ny;}
        }
        Fortaleza -=1;
    }

    /**
     * retorna la direeccion de la imagen del personaje
     * @param per
     * @return
     */
    public String persoanje(String per){
        if(per.equals("bat")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/bat11.png";
        }if(per.equals("temo")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/teemo1.png";
        }if(per.equals("fre")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/fre1.png";
        }if(per.equals("ban")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/ban1.png";
        }if(per.equals("kar")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/kar1.png";
        }if(per.equals("sle")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/sle1.png";  
        }
        return url;
    }
    /**
     * retorna la direeccion de la imagen del personaje 2
     * @param per
     * @return
     */
    public String persoanje2(String per){
        if(per.equals("bat")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/bat2.png";
        }if(per.equals("temo")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/teemo2.png";
        }if(per.equals("fre")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/fre2.png";
        }if(per.equals("ban")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/ban2.png";
        }if(per.equals("kar")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/kar2.png";
        }if(per.equals("sle")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/sle2.png";  
        }
        return url;
    }
    /**
     * hitbox del persoanje
     * @return
     */
    public Rectangle getBounds() {
		return new Rectangle(x+15,y, 5, 40);
    }
    
    public int getFortaleza(){
        return Fortaleza;
    }

    public void bloque(){
        Fortaleza-=Fortaleza*0.5;   
    }
}