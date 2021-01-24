import java.util.*;
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author E.C.I.
 *
 */
public class Fraccionario {
    public ArrayList<String> fraccionario;
    /**Calcula el maximo comun divisor de dos enteros
     * Lo implementaremos mediante el algoritmo recursivo
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */
  
    public static int mcd(int a,int b){
        if (a<0){
            a*=-1;
        }
        else if(b<0){
            b*=-1;
        }
        if(a==0){return b;}else if(b==0){return a;}else{
        if(a>b){int x = a % b;return mcd(b,x);}else{int x = b % a;return mcd(a,x);}        
        }
    }    
    
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {
        fraccionario=new ArrayList<String>();
        int x = mcd(numerador,denominador);
        int p = numerador/x;
        int q = denominador/x; 
        if(q<0){p*=-1;q*=-1;}
        fraccionario.add(String.valueOf(p));
        fraccionario.add(String.valueOf(q));
        
    }
    
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario (int entero) {
        fraccionario=new ArrayList<String>();
        fraccionario.add(String.valueOf(entero));
        fraccionario.add(String.valueOf(1));
    }

     /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {

    }

    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador() {
        int p =  Integer.parseInt(fraccionario.get(0));
        return p;
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        int q =  Integer.parseInt(fraccionario.get(1));
        return q;
    }
    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        int newNum = otro.numerador() *this.denominador()+otro.denominador()*this.numerador();
        int newDen = otro.denominador()*this.denominador();
        Fraccionario newf = new Fraccionario(newNum,newDen);
        return newf;
    }
    
    /**Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este-otro
     */
    public Fraccionario reste (Fraccionario otro) {
        int newNum = otro.numerador() *this.denominador()-otro.denominador()*this.numerador();
        int newDen = otro.denominador()*this.denominador();
        Fraccionario newf = new Fraccionario(newNum,newDen);
        return newf;
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        int newNum = otro.numerador() *this.numerador();
        int newDen = otro.denominador()*this.denominador();
        Fraccionario newf = new Fraccionario(newNum,newDen);
        return newf;
    }
    
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario divida (Fraccionario otro) {
        return null;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        return equals((Fraccionario)obj);
    }    
    
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matem�ticamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        int p =  Integer.parseInt(fraccionario.get(0));
        if(p==p){
            return true;
        }
        else{
            return false;
        }
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        return String.valueOf(fraccionario.get(0))+"/"+String.valueOf(fraccionario.get(1));
    }
    
}
