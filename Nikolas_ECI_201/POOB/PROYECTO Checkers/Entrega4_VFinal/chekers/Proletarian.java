package chekers;
import shapes.*;
/**
 * Clase para las fichas 
 * 
 * @author (Nikolas Bernal - Juan Pablo Contreras) 
 * @version (16/03/2020)
 */
public class Proletarian extends Ficha
{
    public boolean isVisible;
    private Rectangle ficha;
  public Proletarian(String color)
    {
        ficha = new Rectangle();
        ficha.moveHorizontal(5);
        ficha.changeColor(color);
        ficha.moveVertical(5);
        ficha.changeSize(20,20);
        isVisible = false;
    }
   /**
     * mueve horizontalmente
     *@param number
     */
    public void moveHorizontal(int number){
        ficha.moveHorizontal(number);
    }
    /**
     * mueve verticalmente
     *@param number
     */
    public void moveVertical(int number){
        ficha.moveVertical(number);
    }
    /**
     * consulta el color de la ficha
     *@return String
     */
    public String getColor(){
        return ficha.getColor();
    }
    /**
     * hace invisible la ficha
     */
    public void makeInvisible(){
        isVisible = false;
        ficha.makeInvisible();
    }
    /**
     * hace visible la ficha
     */
    public void makeVisible(){
        isVisible = true;
        ficha.makeVisible();
    }
    /**
     * cambia el color de la ficha
     */
    public void changeColor(String color){         
        ficha.changeColor(color);
    }
    /**
     * Obtiene el tipo de la ficha
     * @return String
     */
    public String getType(){
        return "Proletarian";
    }
}
