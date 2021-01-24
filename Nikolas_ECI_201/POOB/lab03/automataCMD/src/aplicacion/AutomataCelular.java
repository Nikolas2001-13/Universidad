package aplicacion;
import java.util.*;
import java.awt.Color;
public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;

        
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        Elemento indiana = new Celula(this,1,1);
        Elemento OO7 = new Celula(this,2,2);
        Celula marx = new Izquierdosa(this,3,1);
        Celula hegel = new Izquierdosa(this,3,2);
        //Barrera suroeste = new Barrera(this,15,0);
        Barrera noreste = new Barrera(this,0,15);
        Cancerigena nikolas = new Cancerigena(this,1,0);
        Cancerigena juan = new Cancerigena(this,2,1);
        BarreraAleatoria barrera1 = new BarreraAleatoria(this,10,10);
        BarreraAleatoria barrera2 = new BarreraAleatoria(this,5,5);
        Elemento john = new Conway(this,5,7);
        Elemento horton = new Conway(this,5,8);
        Elemento bolque1 = new Conway(this,15,0);
        Elemento bolque2 = new Conway(this,14,0);
        Elemento bolque3 = new Conway(this,15,1);
        Elemento bolque4 = new Conway(this,14,1);
        Elemento parpadear1= new Conway(this,14,6);
        Elemento parpadear2= new Conway(this,14,7);
        Elemento parpadear3= new Conway(this,14,8);
    }
    public void ticTac(){
        for(int i=0;i<automata.length;i++){
           for(int j=0;j<automata.length;j++){
               if(automata[i][j]!=null){
                  automata[i][j].decida();
                  automata[i][j].cambie();
                  if(automata[i][j].getColor()==Color.red){
                      izquierdosa(i,j);
                  }
                  if(automata[i][j].getColor()==Color.green){
                      cancerigena(i,j);
                  }
                  if(automata[i][j].getColor()==Color.yellow){
                      barreraAleatoria(i,j);
                  }
                  
                  
                }
           } 
        }
    }
    
    /**Decide cual va a ser su  siguiente estado 
    */
    public void izquierdosa(int row, int column){
       for(int j=column+1;j<automata.length;j++){
          if (automata[row][j] != null){
                automata[row][column].decida();
           } 
       }  
    }
    
    /**
     * Cambia el estado de las celulas a la derecha de cancerigena
     * @param row
     * @param column
     */
    public void cancerigena(int row, int column){
       for(int j=column+1;j<automata.length;j++){
          if (automata[row][j] != null){
                automata[row][j].cambie();
                automata[row][j].cambie();
           } 
       }         
    }
    /**
     * crea celulas a la izquierda de la barrera
     * @param row
     * @param column
     */
    public void barreraAleatoria(int row, int column){
        if (column-1>=0 && automata[row][column-1] == null){
            Random r = new Random();
            int rand = r.nextInt(3);
            if (rand==0){
                Elemento rand1 = new Celula(this,row,column-1);
            }
            else if (rand==1){
                Celula rand1 = new Izquierdosa(this,row,column-1);
            }
            else if (rand==2){
                Cancerigena rand1 = new Cancerigena(this,row,column-1);
            }
        }
    }
}
