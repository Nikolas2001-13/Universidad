package chekers;

import javax.swing.JOptionPane;
import java.util.*;

/**
 * Write a description of class CheckersContest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckersContest
{   
    public static Checkers check;
    public static boolean color;
    public static ArrayList<String> moves2 = new ArrayList();
    public static ArrayList<String> adds = new ArrayList();
    /**
     * constructor de la clase checkerContest
     */
    public static void CheckersContest(){
        check= new Checkers();
        color=false;
        
    }
    
    /**
     * Resuelve el problema mostrando la solucion
     * @param recibe el character del jugador que hace el primer movimiento (B,W) y los movimientos que se realizaran
     * @return retorna los tableros, inicial y final
     */
    public static String[] solve(char player, String[] moves){
        String[] result = new String[2];
        check= new Checkers();
        if (player=='W'){
            color=true;
        }
        mirarX(moves);
        for (String s:adds){
            if (color){
               add(s, "white");
               color=false;
            }
            else{
                add(s, "black");
                color=true;
            }
        }
        check.swap();
        for (String s:moves2){
            check.move(s);
        }
        result[0]=check.write();
        result[1]=check.writeGame();
        return result;
    }
    /**
     * agrega una ficha al tablero de configuracion
     * @param recibe un string s y color.
     */
    public static void add(String s, String color){
        int i=0,j=0,x=0;
        String num1=""; 
        for (int n = 0; n<s.length();n++){
                if(s.charAt(n)=='x' ||s.charAt (n)=='-'){x =n;}}
        for(int n = 0;n<x;n++) {num1+=Character.toString(s.charAt(n));}
        i= check.filaequi(num1);j= check.columequi(num1);
        check.addSolve(true,i,j,color);
    }
    
    /**
     * Resuelve el problema mostrando el paso a paso
     * @param recibe el character del jugador que hace el primer movimiento (B,W),los movimientos que se realizaran y un boolean slow, el cual dejara ver el paso a paso del tablero inicial al final
     */
    public static void simulate(char player, String[] moves, boolean slow){
        check =new Checkers();
    }
    /**
     * mira las x (jumps) que se hacen en el string[] moves
     * @param lista de movimientos
     * @return arraylist moves2
     */
    public static ArrayList mirarX(String[] moves){
        
        for (String s: moves){
            int cont1=0;
            for (int i=0; i<s.length();i++){
                if (s.charAt(i)=='x'){cont1+=1;}
            }
            if(cont1>1){
                cortar(s);
            }
            else{
                moves2.add(s);
                adds.add(s);
            }
        }
        return moves2;
    }
    /**
     * separa los movimientos por parejas.
     * @param String s de la lista de moves
     */
    public static void cortar(String s){
        ArrayList<String> xPosition = new ArrayList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='x'){
                xPosition.add(Integer.toString(i));
            }
        }
        for(int i=0;i<xPosition.size();i++){
             if (i<3){
                 //if(i+1<xPosition.size()){
                     int j = Integer.parseInt(xPosition.get(2));
                     moves2.add(s.substring(0,j-1));
                     adds.add(s.substring(0,j-1));
                //}
             }else{
                 if(i+1<xPosition.size()){
                     int j = Integer.parseInt(xPosition.get(i+1));
                     int k = Integer.parseInt(xPosition.get(i-1));
                     moves2.add(s.substring(k+1,j-1));
                }else{
                     int k = Integer.parseInt(xPosition.get(i-1));
                     moves2.add(s.substring(k+1,xPosition.size()-1));
                }
                }
        }
    }
}
