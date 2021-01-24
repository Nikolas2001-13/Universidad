package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;

public class MarbelGame {
    private Elemento[][] elementos ; 
    private Elemento[][] inicial ; 
    private int tam;
    private  List<Color> colors;
    /*
    *Constructor MarbelGame
    */
    public MarbelGame(int dimension,int b,int w){
        elementos = new Elemento[dimension][dimension];
        inicial =  new Elemento[dimension][dimension];
        tam = dimension;
        colors = new ArrayList<Color>();
        Random aleatorio = new Random(System.currentTimeMillis());
        crearC(b,dimension);
        crearH(b,dimension);
        
        for(int i=0;i<w;i++){
            int fil =   aleatorio.nextInt(dimension); 
            int col =   aleatorio.nextInt(dimension); 
            if(elementos[fil][col] == null){
                elementos[fil][col]=new Barrera(fil,col);
                inicial[fil][col]=new Barrera(fil,col);
            }else{i=i-1;}
        }
    }
    /*
    *Averigua si una canica esta en un hueco
    *@param int fil
    *@param int col
    *@return boolean
    */
    public boolean isPoint(int fil,int col){
        return elementos[fil][col].isInHueco();
    }
    /*
    *Mueve verticalmente las canicas
    *@param boolean top
    */
    public void moveV(boolean top){
        if(!top){
            for(int i=tam-1;i>=0;i--){
                for(int j=0;j<tam;j++){
                    for(int k=1;i+k<tam;k++){
                        if(elementos[i+k-1][j]!=null){
                            if(elementos[i+k-1][j].getType().equals("Canica")&&!elementos[i+k-1][j].isInHueco()){
                                if(elementos[i+k][j]==null){
                                    elementos[i+k][j]=elementos[i+k-1][j];
                                    elementos[i+k-1][j]= null;
                                }else{
                                    if(elementos[i+k][j].getType().equals("Hueco")){
                                        Color c =elementos[i+k][j].getColor();
                                        elementos[i+k][j]=null;
                                        elementos[i+k][j]=elementos[i+k-1][j];
                                        elementos[i+k][j].punto(c);
                                        elementos[i+k-1][j]= null;
                                    }else{break;}
                                }
                            }
                        }
                    }
                }
            }    
        }else{
            for(int i=0;i<tam;i++){
                for(int j=0;j<tam;j++){
                        for(int k=1;i-k>=0;k++){
                            if(elementos[i-k+1][j]!=null){
                                if(elementos[i-k+1][j].getType().equals("Canica")&&!elementos[i-k+1][j].isInHueco()){
                                    if(elementos[i-k][j]==null){
                                        elementos[i-k][j]=elementos[i-k+1][j]; 
                                        elementos[i-k+1][j]= null;
                                    }else{
                                        if(elementos[i-k][j].getType().equals("Hueco")){
                                            Color c =elementos[i-k][j].getColor();
                                            elementos[i-k][j]=null;
                                            elementos[i-k][j]=elementos[i-k+1][j];
                                            elementos[i-k][j].punto(c);
                                            elementos[i-k+1][j]= null;
                                        }else{break;}
                                    }
                                }
                            }
                        }
                }
            }
        }
    }
    /*
    *Obtiene el tipo de elemento
    *@param int fil
    *@param int col
    *@return String
    */
    public String getType(int fil,int col){
        String type;
        if(elementos[fil][col]!=null){
            type = elementos[fil][col].getType();
        }else{type="";}
        return type;
    }
    /*
    *Mueve verticalmente las canicas
    *@param boolean rigth
    */
    public void moveH(boolean rigth){
        if(!rigth){
            for(int i=0;i<tam;i++){
                for(int j=0;j<tam;j++){
                    for(int k=1;j-k>=0;k++){
                        if(elementos[i][j-k+1]!=null){
                            if(elementos[i][j-k+1].getType().equals("Canica")&&!elementos[i][j-k+1].isInHueco()){
                                if(elementos[i][j-k]==null){
                                    elementos[i][j-k]=new Canica(i-1,j+1,elementos[i][j-k+1].getColor()); 
                                    elementos[i][j-k+1]= null;
                                }else{
                                    if(elementos[i][j-k].getType().equals("Hueco")){
                                        Color c =elementos[i][j-k].getColor();
                                        elementos[i][j-k]=null;
                                        elementos[i][j-k]=elementos[i][j-k+1];
                                        elementos[i][j-k].punto(c);
                                        elementos[i][j-k+1]= null;
                                    }else{break;}
                                }
                            }
                        }
                    }
                }
            }    
        }else{
            for(int i=0;i<tam;i++){
                for(int j=tam-1;j>=0;j--){
                    for(int k=1;j+k<tam;k++){
                        if(elementos[i][j+k-1]!=null){
                            if(elementos[i][j+k-1].getType().equals("Canica")&&!elementos[i][j+k-1].isInHueco()){
                                if(elementos[i][j+k]==null){
                                    elementos[i][j+k]=new Canica(i-1,j+1,elementos[i][j+k-1].getColor()); 
                                    elementos[i][j+k-1]= null;
                                }else{
                                    if(elementos[i][j+k].getType().equals("Hueco")){
                                        Color c =elementos[i][j+k].getColor();
                                        elementos[i][j+k]=null;
                                        elementos[i][j+k]=elementos[i][j+k-1];
                                        elementos[i][j+k].punto(c);
                                        elementos[i][j+k-1]= null;
                                    }else{break;}
                                }
                            }   
                        }
                    }
                }
            }
        }
    }
    /*
    *Levanta la zona norte del tablero
    */
    public void norte(){
        moveV(false);
    }
    /*
    *Levanta la zona sur del tablero
    */
    public void sur(){
        moveV(true);
    }
    /*
    *Levanta la zona este del tablero
    */
    public void este(){
        moveH(false);
    }
    /*
    *Levanta la zona oeste del tablero
    */
    public void oeste(){
        moveH(true);
    }
    /*
    *Canicas que estan bien ubicadas
    *@return int
    */
    public int tanBien(){
        int cont = 0;
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                if(elementos[i][j]!=null){
                    if(elementos[i][j].getType().equals("Canica")&&elementos[i][j].isInHueco()&&elementos[i][j].getColor()==elementos[i][j].colorHueco()){
                        cont+=1;
                    }
                }
            }
        }
        return cont;
    }
    /*
    *Canicas que estan mal ubicadas
    *return int
    */
    public int taMal(){
        int cont = 0;
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                if(elementos[i][j]!=null){
                    if(elementos[i][j].getType().equals("Canica")&&elementos[i][j].isInHueco()&&elementos[i][j].getColor()!=elementos[i][j].colorHueco()){
                        cont+=1;
                    }
                }
            }
        }
        return cont;
    }
    /*
    *Reinicia los elementos del tablero
    */
    public void startAgain(){
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                if(inicial[i][j]!=null){
                    if(inicial[i][j].getType().equals("Canica")){
                        Color col = inicial[i][j].getColor();
                        elementos[i][j]=new Canica(i,j,col);
                        inicial[i][j]=new Canica(i,j,col);
                    }else{elementos[i][j]=inicial[i][j];}
                }else{elementos[i][j]=inicial[i][j];}
            }
        }
    }
    /*
    *retorna el color de un elemento especifico
    */
    public Color getColor(int fil,int col){
        return elementos[fil][col].getColor();
    }
    /*
    *OBTIENE el color de un hueco
    */
    public Color getColHueco(int fil,int col){
       return elementos[fil][col].colorHueco();
    }
    /*
    *crear las canicas en partes aleatorias
    */
    public void crearC(int b,int dimension){
        Random aleatorio = new Random(System.currentTimeMillis());
        for(int i=0;i<b;i++){
            int fil =   aleatorio.nextInt(dimension); 
            int col =   aleatorio.nextInt(dimension); 
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int be = rand.nextInt(255);
            Color co = new Color(r,g,be);
            colors.add(co);
            if(elementos[fil][col] == null){
                elementos[fil][col]=new Canica(fil,col,co);
                inicial[fil][col]=new Canica(fil,col,co);
            }else{i=i-1;}
        }

    }
    /*
    *crea los huecos en partes aleatorias
    */
    public void crearH(int b,int dimension){
        Random aleatorio = new Random(System.currentTimeMillis());
        for(int i=0;i<b;i++){
            int fil =   aleatorio.nextInt(dimension); 
            int col =   aleatorio.nextInt(dimension); 
            Color c ;
            if(colors.size()>0){ c = colors.remove(0);}else{c =Color.BLACK;}
            if(elementos[fil][col] == null){
                elementos[fil][col]=new Hueco(fil,col,c);
                inicial[fil][col]=new Hueco(fil,col,c);
            }else{i=i-1;}
        }

    }
    /*if(elementos[i+k][j].getType().equals("Canica")&&elementos[i+k][j].isInHueco()){
        elementos[i+k+1][j]=null;
        elementos[i+k+1][j]=elementos[i+k-1][j];
        elementos[i+k-1][j]= null;
    }else{break;}*/
}



