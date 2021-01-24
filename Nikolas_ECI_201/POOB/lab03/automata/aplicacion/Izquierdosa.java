package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Izquierdosa here.
 * 
 * @author (Nikolas Bernal - Juan P. Contreras) 
 * @version (10/03/2020)
 */
public class Izquierdosa extends Celula
{
    /**
     * Constructor for objects of class Izquierdosa
     */
    public Izquierdosa(AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        color=Color.red;
    }
    
    @Override
    /**
     * Cambia el estado actual de la celula que esta a la izquierda por MUERTA, y mira si la edad es mayor o igual a 2
    */
    public void decida(){
        super.decida();
        estadoActual='m';
        if (edad()>=2){
            estadoSiguiente='m';
        } 
    }

}
