package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Canceriguena here.
 * 
 * @author (Nikolas Bernal - Juan P. Contreras) 
 * @version (10/03/2020)
 */
public class Cancerigena extends Celula
{
    /**
     * Constructor for objects of class Canceriguena
     */
    public Cancerigena(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        color=Color.green;
    }
    
    @Override
    /**
     * Se mantiene viva
    */
    public void decida(){
        super.decida();
        estadoSiguiente='v';
    } 
    
    @Override
    public String toString(){
        return "Cancerigena "+getFila()+" "+getColumma()+"\n";
    }
    
}
