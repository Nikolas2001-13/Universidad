package chekers;
import shapes.*;
/**
 * Clase para las fichas 
 * 
 * @author (Nikolas Bernal - Juan Pablo Contreras) 
 * @version (22/03/2020)
 */
public class Superman extends Ficha
{
    public boolean isVisible;
    private Circle ficha;
  public Superman(String color)
    {
        ficha = new Circle(color);
        ficha.changeColor(color);
        ficha.changeSize(20);
        isVisible = false;
        if(color.equals("white")){
            ficha.changeColor("cyan");
        }
        else{
            ficha.changeColor("blue");
        }
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
        if (ficha.getColor().equals("blue")){
            return "black";
        }
        else{
            return "white";
        }
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
        return "Superman";
    }
}
