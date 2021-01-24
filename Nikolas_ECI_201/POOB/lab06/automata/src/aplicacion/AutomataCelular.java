package aplicacion;

import java.util.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class AutomataCelular implements Serializable{
    static private int LONGITUD=20;
    private Elemento[][] automata;
    private static AutomataCelular auto2 = null;
    private String[] validos = {"Barrera","Celula","BarreraAleatoria","Cancerigena","Conway","Izquierdosa"};

      
    private AutomataCelular() {
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

    public void nuevoAuto(){
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
    }

    public void guardar(File fichero) throws AutomataException{
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject(this);
            salida.close();
        } 
        catch(Exception e){
            throw new AutomataException(AutomataException.OPCION_EN_CONSTRUCCION);

        }
    }
    public void salve01(File fichero) throws AutomataException{
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject(this);
            salida.close();
        } 
        catch(Exception e){
            throw new AutomataException(AutomataException.ERROR_GUARDAR);

        }
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

    public void abra(File file) throws AutomataException{
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(file));
            auto2 = (AutomataCelular)entrada.readObject();
        }
        catch(Exception e){
            throw new AutomataException(AutomataException.OPCION_EN_CONSTRUCCION);
        }
    }
    public void abra01(File file) throws AutomataException{
        try{
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(file));
            this.auto2 = (AutomataCelular)entrada.readObject();
        }
        catch(Exception e){
            throw new AutomataException(AutomataException.ERROR_ABRIR);
        }
        
    }

    public void exportar(File file) throws AutomataException{
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(file));
            String cad = "";
            for (int f=0;f<LONGITUD;f++){
                for (int c=0;c<LONGITUD;c++){
                    if(automata[f][c]==null){
                        cad=cad;
                    }
                    else{
                        cad+=automata[f][c].toString();
                    }
                }
            }
            salida.writeObject(cad);
            salida.close();
        } 
        catch(Exception e){
            throw new AutomataException(AutomataException.OPCION_EN_CONSTRUCCION);

        }
    }
    public void exportar01(File file) throws AutomataException{
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(file));
            String cad = "";
            for (int f=0;f<LONGITUD;f++){
                for (int c=0;c<LONGITUD;c++){
                    if(automata[f][c]==null){
                        cad=cad;
                    }
                    else{
                        cad+=automata[f][c].toString();
                    }
                }
            }
            salida.writeObject(cad);
            salida.close();
        } 
        catch(Exception e){
            throw new AutomataException(AutomataException.ERROR_EXPORTAR);

        }
    }
    public void exportar02(File file) throws AutomataException{
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(file));
            String cad = "";
            for (int f=0;f<LONGITUD;f++){
                for (int c=0;c<LONGITUD;c++){
                    if(automata[f][c]==null){
                        cad=cad;
                    }
                    else{
                        cad+=automata[f][c].toString();
                    }
                }
            }
            salida.writeObject(cad);
            salida.close();
        } 
        catch(Exception e){
            throw new AutomataException(AutomataException.OPCION_EN_CONSTRUCCION);

        }
    }
    public void exportar03(File file) throws AutomataException{
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(file));
            String cad = "";
            for (int f=0;f<LONGITUD;f++){
                for (int c=0;c<LONGITUD;c++){
                    if(automata[f][c]==null){
                        cad=cad;
                    }
                    else{
                        cad+=automata[f][c].toString();
                    }
                }
            }
            salida.writeObject(cad);
            salida.close();
        } 
        catch(Exception e){
            throw new AutomataException(AutomataException.OPCION_EN_CONSTRUCCION);

        }
    }

    public void importar(File file) throws AutomataException{
        nuevoAuto();
        try{
            BufferedReader entrada =new BufferedReader( new FileReader(file));
            String linea = entrada.readLine();
            while(linea != null){
                linea = linea.trim();
                String[] partes = linea.split(" ");
                String tipo=partes[0], fil=partes[1], col=partes[2];
                int fil1 = Integer.parseInt(fil);
                int col1 = Integer.parseInt(col);
                linea = entrada.readLine();
                if(tipo.equals("Barrera")){
                    automata[fil1][col1] = new Barrera(this, fil1, col1);
                }
                else if(tipo.equals("BarreraAleatoria")){
                    automata[fil1][col1] = new BarreraAleatoria(this, fil1, col1);
                }
                else if(tipo.equals("Cancerigena")){
                    automata[fil1][col1] = new Cancerigena(this, fil1, col1);
                }
                else if(tipo.equals("Celula")){
                    automata[fil1][col1] = new Celula(this, fil1, col1);
                }
                else if(tipo.equals("Conway")){
                    automata[fil1][col1] = new Conway(this, fil1, col1);
                }
                else if(tipo.equals("Izquierdosa")){
                    automata[fil1][col1] = new Izquierdosa(this, fil1, col1);
                }
            }
        }
        catch(Exception e){
            
        }
    }
    public void importar01(File file) throws AutomataException{
        nuevoAuto();
        try{
            BufferedReader entrada =new BufferedReader( new FileReader(file));
            String linea = entrada.readLine();
            while(linea != null){
                linea = linea.trim();
                String[] partes = linea.split(" ");
                String tipo=partes[0], fil=partes[1], col=partes[2];
                int fil1 = Integer.parseInt(fil);
                int col1 = Integer.parseInt(col);
                linea = entrada.readLine();
                if(tipo.equals("Barrera")){
                    automata[fil1][col1] = new Barrera(this, fil1, col1);
                }
                else if(tipo.equals("BarreraAleatoria")){
                    automata[fil1][col1] = new BarreraAleatoria(this, fil1, col1);
                }
                else if(tipo.equals("Cancerigena")){
                    automata[fil1][col1] = new Cancerigena(this, fil1, col1);
                }
                else if(tipo.equals("Celula")){
                    automata[fil1][col1] = new Celula(this, fil1, col1);
                }
                else if(tipo.equals("Conway")){
                    automata[fil1][col1] = new Conway(this, fil1, col1);
                }
                else if(tipo.equals("Izquierdosa")){
                    automata[fil1][col1] = new Izquierdosa(this, fil1, col1);
                }
            }

        }
        catch(Exception e){
            throw new AutomataException(AutomataException.ERROR_IMPORTAR);
        }
    }
    public void importar02(File file) throws AutomataCompilador{
        nuevoAuto();
        try{
            BufferedReader entrada =new BufferedReader( new FileReader(file));
            String linea = entrada.readLine();
            int lin = 1;
            while(linea != null){
                linea = linea.trim();
                String[] partes = linea.split(" ");
                String tipo=partes[0], fil=partes[1], col=partes[2];
                int fil1 = Integer.parseInt(fil);
                int col1 = Integer.parseInt(col);
                linea = entrada.readLine();
                if(tipo.equals("Barrera")){
                    automata[fil1][col1] = new Barrera(this, fil1, col1);
                }
                else if(tipo.equals("BarreraAleatoria")){
                    automata[fil1][col1] = new BarreraAleatoria(this, fil1, col1);
                }
                else if(tipo.equals("Cancerigena")){
                    automata[fil1][col1] = new Cancerigena(this, fil1, col1);
                }
                else if(tipo.equals("Celula")){
                    automata[fil1][col1] = new Celula(this, fil1, col1);
                }
                else if(tipo.equals("Conway")){
                    automata[fil1][col1] = new Conway(this, fil1, col1);
                }
                else if(tipo.equals("Izquierdosa")){
                    automata[fil1][col1] = new Izquierdosa(this, fil1, col1);
                }
                compilador(partes,lin);
                lin+=1;
                
            }
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    public void importar03(File file) throws AutomataException{
        nuevoAuto();
        try{
            BufferedReader entrada =new BufferedReader( new FileReader(file));
            String linea = entrada.readLine();
            while(linea != null){
                linea = linea.trim();
                String[] partes = linea.split(" ");
                String tipo=partes[0], fil=partes[1], col=partes[2];
                int fil1 = Integer.parseInt(fil);
                int col1 = Integer.parseInt(col);
                linea = entrada.readLine();
                for (String s:validos){
                    if (tipo.equals(s)){
                        if(tipo.equals("Barrera")){
                            automata[fil1][col1] = new Barrera(this, fil1, col1);
                        }
                        else if(tipo.equals("BarreraAleatoria")){
                            automata[fil1][col1] = new BarreraAleatoria(this, fil1, col1);
                        }
                        else if(tipo.equals("Cancerigena")){
                            automata[fil1][col1] = new Cancerigena(this, fil1, col1);
                        }
                        else if(tipo.equals("Celula")){
                            automata[fil1][col1] = new Celula(this, fil1, col1);
                        }
                        else if(tipo.equals("Conway")){
                            automata[fil1][col1] = new Conway(this, fil1, col1);
                        }
                        else if(tipo.equals("Izquierdosa")){
                            automata[fil1][col1] = new Izquierdosa(this, fil1, col1);
                        }
                    }
                    else{
                        throw new AutomataException(AutomataException.ERROR_IMPORTAR);
                    }
                }
                
            }
        }
        catch(Exception e){
            throw new AutomataException(AutomataException.ERROR_IMPORTAR);
        }
    }

    public static AutomataCelular getAutomataCelular(){
        if(auto2==null){
            auto2 = new AutomataCelular();
        }
        return auto2;

    }

    public void compilador(String[] list, int linea) throws AutomataCompilador{
        if(list[0]!=("Barrera") && list[0]!=("BarreraAleatoria") && list[0]!=("Cancerigena") && list[0]!=("Celula") && list[0]!=("Conway") && list[0]!=("Izquierdosa")) throw new AutomataCompilador(AutomataCompilador.ELEMENTO_NO_VALIDO,linea,list[0]);
        if(Integer.parseInt(list[1])<0 || Integer.parseInt(list[1])>20) throw new AutomataCompilador(AutomataCompilador.POSICION_NO_VALIDA,linea,list[1]);
        if(Integer.parseInt(list[2])<0 || Integer.parseInt(list[2])>20) throw new AutomataCompilador(AutomataCompilador.POSICION_NO_VALIDA,linea,list[2]);

    } 

}
