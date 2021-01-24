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
     * @return int
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
     * @return int
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
     * @return String
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
        }if(per.equals("json")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/jason11.png";  
        }if(per.equals("veigar")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/veigar11.png";  
        }if(per.equals("super")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/superman11.png";  
        }
        return url;
    }
    /**
     * retorna la direeccion de la imagen del personaje 2
     * @param per
     * @return String
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
        }if(per.equals("json")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/jason22.png";  
        }if(per.equals("veigar")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/veigar22.png";  
        }if(per.equals("super")){
            url=paulina.getAbsolutePath()+"/POONG/Pictures/superman22.png";  
        }
        return url;
    }
    /**
     * hitbox del persoanje
     * @return Rectangle
     */
    public Rectangle getBounds() {
		return new Rectangle(x+15,y, 5, 40);
    }
    /**
     * obtiene la fortaleza del personaje
     * @return int
     */
    public int getFortaleza(){
        return Fortaleza;
    }
    /**
     * disminuye la fortaleza cuando choca con un bloque
     */
    public void bloque(){
        Fortaleza-=Fortaleza*0.5;   
    }
    /**
     * vuelve string los parametros de Personaje
     * @return String
     */
    public String toString(){
        return "Personaje "+ Integer.toString(y)+" "+Integer.toString(x)+"  " +Integer.toString(ny)+"  " +Integer.toString(time)+"  " +Integer.toString(Fortaleza)+" "+url;
    }
    /**
     * asigna los parametros que entran a los de la calse Personaje
     * @param y
     * @param x
     * @param ny
     * @param time
     * @param forta
     * @param link
     */
    public void setearPer(int y,int x,int ny,int time,int forta,String link){
        this.y=y;
        this.x=x;
        this.ny=ny;
        this.time=time;
        this.Fortaleza=forta;
        this.url=link;
    }
}