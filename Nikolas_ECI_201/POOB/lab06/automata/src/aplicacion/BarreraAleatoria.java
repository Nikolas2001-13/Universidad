package aplicacion;
import java.awt.Color;

/**
 * Write a description of class BarreraAleatoria here.
 * 
 * @author (Nikolas Bernal - Juan P. Contreras) 
 * @version (10/03/2020)
 */
public class BarreraAleatoria extends Barrera
{
    /**
     * Constructor for objects of class BarreraAleatoria
     */
    public BarreraAleatoria(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        color=Color.yellow;
    }

    @Override
    public String toString(){
        return "BarreraAleatoria "+getFila()+" "+getColumma()+"\n";
    }
    
}
