/**
 * @author ECI, 2019
 *
 */
public class Matriz{

    private Fraccionario [][] matriz;
    public int longitud ;
    public int colum ;
    
    /**
     * Retorna una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     */
    
    public static boolean esMatriz (int [][][] elementos){
        return false;
    }
    /**
     * Construye una matriz.
     * @param elementos es un arreglo tridimensional de tipo int.
     */
    public Matriz (int [][][] elementos) {
        int i = elementos.length;   
        int j = elementos[0].length;
        longitud = i;
        colum = j;
        matriz = new Fraccionario[i][j];
        for(int n=0;n<i;n++){
            for(int m=0;m<j;m++){
                Fraccionario f = new Fraccionario (elementos[n][m][0],elementos[n][m][1]);
                matriz[n][m]= f;
            }
        }
    }    
    
    /**
     * Retorna una matriz dados sus elementos. 
     */
    public Matriz (Fraccionario  elementos[][]) {
        int i = elementos.length;   
        int j = elementos[0].length;
        matriz = new Fraccionario[i][j];
        for(int m=0; i<elementos.length;m++){
            for(int n=0; j<elementos[0].length;n++){
                matriz[m][n] = elementos[m][n];
            }
        }

    }
   
    
     /**
     * Retorna una matriz dada su diagonal. 
     */    
    public Matriz (Fraccionario d []){

    }    

    /**
     * Retorna una matriz de un numero repetido dada su dimension. 
     */
    public Matriz (Fraccionario e, int f, int c) {

    }
    
    /**
     * Retorna una matriz identidad dada su dimension. 
     */
    public Matriz (int n) {
    }
    
    /**
     * 
     */
    public Matriz dimension(){
        return null;
    }
    
    
    public Fraccionario get(int f, int c){   
        return matriz[f-1][c-1];
    }
    
    /**
     * Compara esta matriz con otra
     */
    public boolean equals (Matriz otra) {
        return false;
    }

    /** 
     * Compara esta matriz con otra
     */
    @Override
    public boolean equals(Object otra) {
            return false;
    }
    
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * 
    */
    @Override
    public String toString () {
          String s = "";
          return s;
    }   
    
    //Retorna la matriz con el numero de filas o columnas
    //{{{3,5},{4,6}},{{1,2},{3,2}}}
    public Matriz sume(Matriz m){
        
        Fraccionario res[][] = new Fraccionario[longitud][colum]; 
        for(int n=0;n<longitud;n++){
            for(int k=0;k<colum;k++){                
                res[n][k]=matriz[n][k].sume(m.get(n+1,k+1));                
            }
        }
        Matriz matriz2 = new Matriz(res);
        return matriz2;
    }
    
    public Matriz reste(Matriz m){
        
        Fraccionario res[][] = new Fraccionario[longitud][colum]; 
        for(int n=0;n<longitud;n++){
            for(int k=0;k<colum;k++){                
                res[n][k]=matriz[n][k].reste(m.get(n+1,k+1));                
            }
        }
        Matriz matriz2 = new Matriz(res);
        return matriz2;
    }
   
    public Matriz multiplique(Matriz m){
        
        Fraccionario res[][] = new Fraccionario[longitud][colum]; 
        for(int n=0;n<longitud;n++){
            for(int k=0;k<colum;k++){                
                res[n][k]=matriz[n][k].multiplique(m.get(n+1,k+1));                
            }
        }
        Matriz matriz2 = new Matriz(res);
        return matriz2;
    }
 
}
