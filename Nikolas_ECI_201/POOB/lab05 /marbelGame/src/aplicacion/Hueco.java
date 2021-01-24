package aplicacion;

import java.awt.*;

public class Hueco implements Elemento {
    private int posx,posy;
    private Color color;
    public Hueco(int x,int y,Color col){
        color = col;
        posx = x;
        posy= y;
    }
    public String getType(){
        return "Hueco";
    }
    public void punto(Color col){}
    public boolean isInHueco(){
        return false ;
    }
    public Color getColor(){
        return color;
    }
    public Color colorHueco(){
        return color;
    }

}