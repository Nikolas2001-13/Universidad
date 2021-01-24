package chekers;
import shapes.*;

/**
 * Clase para las fichas 
 * 
 * @author (Nikolas Bernal - Juan Pablo Contreras) 
 * @version (16/02/2020)
 */
public class King 
{
    // instance variables - replace the example below with your own
    private Triangle rey;
    public boolean isVisible;
       
    /**
     * Constructor for objects of class Ficha
     */
    public King(String color)
    {
        // initialise instance variables
        rey = new Triangle(color);
        isVisible = false;
    }
    /**
     * mueve horizontalmente
     *@param number
     */
    public void moveHorizontal(int number){
        rey.moveHorizontal(number);
    }
    /**
     * mueve verticalmente
     *@param number
     */
    public void moveVertical(int number){
        rey.moveVertical(number);
    }
    /**
     * consulta el color de la ficha
     *@return String
     */
    public String getColor(){
        return rey.getColor();
    }
    /**
     * hace invisible la ficha
     */
    public void makeInvisible(){
        isVisible = false;
        rey.makeInvisible();
    }
    /**
     * hace visible la ficha
     */
    public void makeVisible(){
        isVisible = true;
        rey.makeVisible();
    }
    /**
     * cambia el color de la ficha
     */
    public void changeColor(String color){         
        rey.changeColor(color);
    }
    /**
     *  ficha en forma de string.
     * @return  ficha como w o b deacuerdo a su color
     */
    public String toString(){         
        String color = getColor();
        if(color.equals("white")){return "W";}else{return "B";}
    }
    /**
     * Obtiene el tipo de la ficha
     * @return String
     */
    public String getType(){
        return "King";
    }
}
