package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Conway here.
 * 
 * @author (Nikolas Bernal - Juan P. Contreras) 
 * @version (11/03/2020)
 */
public class Conway extends Celula
{
    private int fila,columna;
    private AutomataCelular automata;
    /**
     * Constructor for objects of class Conway
     */
    public Conway(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        automata = ac;
        this.fila = fila;
        this.columna= columna;
        color=Color.blue;
        estadoActual='v';
    }
    
    /**
     * Decide cual va a ser su siguiente estado dependiendo de los vecinos vivos
     */
    public void decida(){
        int vecinasVivas=vecinos();
        if(vecinasVivas==3 && estadoActual=='m'){
            estadoSiguiente='v';
        }else if((estadoActual=='v' && vecinasVivas==2) || (estadoActual=='v' && vecinasVivas==3)){
            estadoSiguiente='v';
        }else if(vecinasVivas<2 || vecinasVivas>3){
            estadoSiguiente='m';
        }
    }
    
    /**
     * Mira las celulas vivas que estan alrededor de una celula que no esta en los bordes del tablero
     * @return int entero v con el numero de vecinos
     */
    public int vecinos(){
        int v=0;
        if(fila<15 && columna<15 && fila>0 && columna>0){
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna-1)!=null && automata.getElemento(fila+1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){v++;}    
            if(automata.getElemento(fila+1,columna+1)!=null && automata.getElemento(fila+1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna+1)!=null && automata.getElemento(fila-1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna-1)!=null && automata.getElemento(fila-1,columna-1).isVivo()){v++;}
        }
        else{v=limitesX();}
        return v;
    }
    
    /**
     * Mira las celulas vivas que estan alrededor de una celula que se encuentra en el limite superior o inferior
     * @return int entero v con el numero de vecinos
     */
    public int limitesX(){
        int v=0;
        if (fila==0 && columna>0 && columna<15){
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna-1)!=null && automata.getElemento(fila+1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna+1)!=null && automata.getElemento(fila+1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){v++;}
        }
        else if (fila==15 && columna>0 && columna<15){
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna-1)!=null && automata.getElemento(fila-1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna+1)!=null && automata.getElemento(fila-1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){v++;}
        }
        else{v=limitesY();}
        return v;
    }

    /**
     * Mira las celulas vivas que estan alrededor de una celula que se encuentra en el limite izquierdo o derecho
     * @return int entero v con el numero de vecinos
     */
    public int limitesY(){
        int v=0;
        if (columna==0 && fila>0 && fila<15){
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna+1)!=null && automata.getElemento(fila+1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna+1)!=null && automata.getElemento(fila-1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){v++;}
        }
        else if (columna==15 && fila>0 && fila<15){
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna-1)!=null && automata.getElemento(fila+1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna-1)!=null && automata.getElemento(fila-1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){v++;}
        }
        else{v=esquinas();}
        return v;
    }
    
    /**
     * Mira las celulas vivas que estan alrededor de una celula que se encuentra en alguna esquina del tablero
     * @return int entero v con el numero de vecinos
     */
    public int esquinas(){
        int v=0;
        if (fila==0 && columna==0){
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna+1)!=null && automata.getElemento(fila+1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){v++;}
        }
        else if(fila==0 && columna==15){
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna-1)!=null && automata.getElemento(fila+1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){v++;}
        }
        else if(fila==15 && columna==0){
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna+1)!=null && automata.getElemento(fila-1,columna+1).isVivo()){v++;}
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){v++;}
        }
        else if(fila==15 && columna==15){
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){v++;}
            if(automata.getElemento(fila-1,columna-1)!=null && automata.getElemento(fila-1,columna-1).isVivo()){v++;}
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){v++;}
        }
        return v;
    }
}
