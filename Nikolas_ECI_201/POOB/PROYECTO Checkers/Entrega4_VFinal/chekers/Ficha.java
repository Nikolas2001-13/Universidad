package chekers;
import shapes.*;


/**
 * Clase para las fichas 
 * 
 * @author (Nikolas Bernal - Juan Pablo Contreras) 
 * @version (16/02/2020)
 */
public abstract class Ficha
{
    // instance variables - replace the example below with your own
    
    public boolean isVisible;
       
    
    /**
     * mueve horizontalmente
     *@param number
     */
    public abstract void moveHorizontal(int number);
    /**
     * mueve verticalmente
     *@param number
     */
    public abstract void moveVertical(int number);
    /**
     * consulta el color de la ficha
     *@return String
     */
    public abstract String getColor();
    /**
     * hace invisible la ficha
     */
    public abstract void makeInvisible();
    /**
     * hace visible la ficha
     */
    public abstract void makeVisible();
    /**
     * cambia el color de la ficha
     */
    public abstract void changeColor(String color);
    /**
     *  ficha en forma de string.
     * @return  ficha como w o b deacuerdo a su color
     */
    public String toString(){         
        String color = getColor();
        if(color.equals("white")){return "w";}else{return "b";}
    }
    /**
     * Obtiene el tipo de la ficha
     * @return String
     */
    public abstract String getType();
}
