package aplicacion;

import java.awt.*;

public class Canica implements Elemento {
    private int posx,posy;
    private boolean point;
    private Color color;
    private Color hueco;
    public Canica(int x,int y,Color col){
        point = false;
        color = col;
        posx = x;
        posy= y;
    }
    public String getType(){
        return "Canica";
    }
    public void punto(Color col){
        point = true;
        hueco= col;
    }
    
    public boolean isInHueco(){
        return point ;
    }
    public Color getColor(){
        return color;
    }
    public Color colorHueco(){
        return hueco;
    }

}