package aplicacion;

import java.awt.*;

public class Barrera implements Elemento {
    private int posx,posy;
    public Barrera(int x,int y){
        posx = x;
        posy= y;
    }
    public String getType(){
        return "Barrera";
    }
    public void punto(Color col){
    }
    public boolean isInHueco(){
        return false ;
    }
    public Color getColor(){
        return Color.BLACK;
    }
    public Color colorHueco(){
        return Color.BLACK;
    }
    

}