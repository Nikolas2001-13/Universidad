package chekers;
import shapes.*;
import java.util.*;

/**
 * Clase base para los tableros que se usaran. 
 * @author (Nikolas Bernal - Juan Pablo Contreras) 
 * @version (16/02/2020)
 */
public class Tablero
{
    // instance variables - replace the example below with your own
    private int posX;
    private int posY;
    private Rectangle grande;
    private ArrayList <Rectangle>  rectangulos=new ArrayList<Rectangle>();
    public Ficha [][] fichas;
    public King [][] rey;
    public boolean isVisible;
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero()
    {
        // initialise instance variables
        fichas = new Ficha[8][8];
        rey = new King[8][8];
        grande =new Rectangle();
        grande.changeSize(240,240);
        grande.makeVisible();
        grande.changeColor("yellow");
        for (int j=0;j<4;j++){
            posX=30;
            for (int i =0; i<4;i++){
                    rectangulos.add(new Rectangle());
                    rectangulos.get(rectangulos.size()-1).changeSize(30,30);
                    rectangulos.get(rectangulos.size()-1).changeColor("red");
                    rectangulos.get(rectangulos.size()-1).moveHorizontal(posX);
                    rectangulos.get(rectangulos.size()-1).moveVertical(posY);
                    rectangulos.get(rectangulos.size()-1).makeVisible();
                    posX+=60; 
            }
            posY+=60;    
        }
        posY=30;
        for (int j=0;j<4;j++){
            posX=0;
            for (int i =0; i<4;i++){
                    rectangulos.add(new Rectangle());
                    rectangulos.get(rectangulos.size()-1).changeSize(30,30);
                    rectangulos.get(rectangulos.size()-1).changeColor("red");
                    rectangulos.get(rectangulos.size()-1).moveHorizontal(posX);
                    rectangulos.get(rectangulos.size()-1).moveVertical(posY);
                    rectangulos.get(rectangulos.size()-1).makeVisible();
                    posX+=60; 
            }
            posY+=60;    
        }
    }
    /**
     * Hace visible el tablero.
     */
    public void makeVisible(){
        
        grande.makeVisible();
        for(Rectangle rectangulo :rectangulos){
            rectangulo.makeVisible();
        }
        for(int j =0; j<=7;j++){
            for(int i =0; i<=7;i++){
                if (fichas[j][i] != null){
                    fichas[j][i].makeVisible();
                }
                if(rey[j][i] != null){
                    rey[j][i].makeVisible();
                }
            }
        }        
    }
    
    /**
     * Hace invisible el tablero.
     */
    public void makeInvisible(){
        for(Rectangle rectangulo :rectangulos){
            rectangulo.makeInvisible();
        }
        grande.makeInvisible();
        for(int j =0; j<=7;j++){
            for(int i =0; i<=7;i++){
                if (fichas[j][i] != null){
                    fichas[j][i].makeInvisible(); 
                }
                if(rey[j][i] != null){               
                    rey[j][i].makeInvisible();
                }
            }
        }
    }
    
    /**
     * Mueve horizontalmente el tablero 1.
     */
    public void moveTablero(){
        grande.moveHorizontal(350);
        for(Rectangle rectangulo :rectangulos){
            rectangulo.moveHorizontal(350);
        } 
    }
    
    /**
     * Mueve horizontalmente el tablero 2.
     */
    public void moveTablero2(){
        grande.moveHorizontal(-350);
        for(Rectangle rectangulo :rectangulos){
            rectangulo.moveHorizontal(-350);
        }       
    }
    /**
     * remueve una ficha.
     * @param ysel , xsel.
     */
    public void remove(int ysel,int xsel){
        if(fichas[ysel][xsel]!= null){
            fichas[ysel][xsel].makeInvisible(); 
            fichas[ysel][xsel] = null;  
        }else{
            if(fichas[ysel][xsel]!= null){
                rey[ysel][xsel].makeInvisible(); 
                rey[ysel][xsel] = null;
            }
        }
    }
    /**
     * remueve una ficha.
     * @param ysel , xsel.
     */
    public void removeAll(){
        for(int j =0; j<=7;j++){
            for(int i =0; i<=7;i++){
                if(fichas[j][i]!= null){
                    fichas[j][i].makeInvisible(); 
                    fichas[j][i] = null;  
                }if(rey[j][i]!= null){
                    rey[j][i].makeInvisible(); 
                    rey[j][i] = null;
                }
             }
        }
    }
     /**
     * Agrega fichas normales
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void add(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Normal(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible();    
    }
    /**
     * Agrega fichas king
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addK(int ysel,int xsel,String colorSel){
        rey[ysel][xsel]= new King(colorSel);
        rey[ysel][xsel].moveHorizontal(30*(xsel));
        rey[ysel][xsel].moveVertical(30*(ysel));
        rey[ysel][xsel].makeVisible();   
    }
    /**
     * Agrega fichas proletarian
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addP(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Proletarian(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible(); 
    }
    /**
     * Agrega fichas Lazy
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addL(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Lazy(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible(); 
    }
    /**
     * Agrega fichas libertarian
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addLi(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Libertarian(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible(); 
    }
    /**
     * Agrega fichas powerful
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addPw(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Powerful(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible(); 
    }
    /**
     * Agrega fichas hurried
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addH(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Hurried(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible(); 
    }
        /**
     * Agrega fichas superman
     * @param ysel posicion y
     * @param xsel posicion x
     * @param solorSel color
     */
    public void addS(int ysel,int xsel,String colorSel){
        fichas[ysel][xsel]= new Superman(colorSel);
        fichas[ysel][xsel].moveHorizontal(30*(xsel));
        fichas[ysel][xsel].moveVertical(30*(ysel)); 
        fichas[ysel][xsel].makeVisible(); 
    }


    /**
     * actualiza una ficha que llegue al extremo y la vuelve king
     */
    public void toKing(){        
        for(int j =0; j<=7;j++){
            for(int i =0; i<=7;i++){
                if (fichas[j][i] != null){
                    String type = fichas[j][i].getType();
                    
                    if(fichas[j][i].getColor().equals("white") && j == 0){
                        remove(j,i);
                        addK2(type,j+1,i+1,"white");
                        rey[j][i].moveHorizontal(350);
                    }else if(fichas[j][i].getColor().equals("black") && j == 7){
                        remove(j,i);
                        addK2(type,j+1,i+1,"black");
                        rey[j][i].moveHorizontal(350);
                     } 
                } 
            }
        }        
    }
    
    /**
     * Mira el tipo de la ficha
     * @param type tipo de la ficha
     * @param row fila
     * @param column columna
     * @param color color de la ficha
     */
    public void seeType(String type,int row,int column,String color){
        if (type.equals("Proletarian")){
            addP(row-1,column-1,color);
        }
        else if (type.equals("Lazy")){
            addL(row-1,column-1,color);
        }
        else if (type.equals("Libertarian")){
            addLi(row-1,column-1,color);
        }
        else if (type.equals("Powerful")){
            addPw(row-1,column-1,color);
        }
        else if (type.equals("Hurried")){
            addH(row-1,column-1,color);
        }
        else if (type.equals("Superman")){
            addS(row-1,column-1,color);
        }
        else{
            add(row-1,column-1,color);
        }
     }
     
    /**
     * Agrega los king de cada tipo de ficha
     * @param type tipo de la ficha
     * @param row fila
     * @param column columna
     * @param color color de la ficha
     */
    public void addK2(String type,int row,int column,String color){
        if (type.equals("Lazy")){
            if(color.equals("white")){color="yellow";}else{color="orange";}
        }
        else if (type.equals("Libertarian")){
            if(color.equals("white")){color="cyan";}else{color="blue";}
        }
        else if (type.equals("Powerful")){
            if(color.equals("white")){color="pink";}else{color="magenta";}
        }
        else if (type.equals("Hurried")){
            if(color.equals("white")){color="gray";}else{color="darkGray";}
        }
        addK(row-1,column-1,color);
     }

}
