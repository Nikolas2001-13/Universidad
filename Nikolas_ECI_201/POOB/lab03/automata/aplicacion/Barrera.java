package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Barrera here.
 * 
 * @author (Nikolas Bernal - Juan P. Contreras) 
 * @version (10/03/2020)
 */
public class Barrera implements Elemento
{
    private AutomataCelular automata;
    private int fila,columna;
    protected Color color;
    
    /**
     * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular ac,int fila, int columna)
    {
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        automata.setElemento(fila,columna,(Elemento)this);	
        color=Color.black;        
    }
    
    /**Retorna la fila del automata en que se encuentra 
    @return 
     */

    public final int getFila(){
        return fila;
    }

    /**Retorna la columna del automata en que se encuentra
    @return 
     */
    public final int getColumma(){
        return columna;
    }
    
    /**Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
    
    @Override
    public final int getForma(){
        return CUADRADA;
    }
}
