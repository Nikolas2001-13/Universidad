package chekers;
import shapes.*;
/**
 * Write a description of class normal here.
 * 
 * @author (Nikolas Bernal-Juan Contreras) 
 * @version (16/03/2020)
 */
public class Normal extends Ficha
{
    private Circle ficha;
  public Normal(String color)
    {
        ficha = new Circle(color);
        ficha.changeSize(20);
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
        return "Normal";
    }
}
