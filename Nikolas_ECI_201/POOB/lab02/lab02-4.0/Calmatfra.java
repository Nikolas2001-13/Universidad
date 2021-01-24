/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author ESCUELA 2018-01
 */

import java.util.HashMap;
public class Calmatfra{

    private HashMap<String, Matriz> variables;
    //Consultar en el API Java la clase HashMap
    
    public Calmatfra(){
        variables = new HashMap<String, Matriz>();
    }

    /**
     * Asigna un nombra a un matriz.
     * @param variable tipo String
     * @param matriz tipo arreglo tridimensional de tipo int 
     */
    public void asigne(String variable, int [][][] matriz){  
        Matriz  a = new Matriz(matriz);
        
        variables.put(variable, a);
    }

    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        Matriz hola = variables.get(operando1);
        Matriz hola2 = variables.get(operando2);
        String cad = "";   
        if(operacion =='+'){
            Matriz newMa = hola.sume(hola2);
            variables.put(respuesta, newMa);
        }
        else if(operacion == '-'){
            Matriz newMa = hola.reste(hola2);
            variables.put(respuesta, newMa);
        }
        else if(operacion == '.'){
            Matriz newMa = hola.reste(hola2);
            variables.put(respuesta, newMa);
        }
       
    }
    
    /**
     * Consulta una matriz con respecto a su nombre asignado.
     *@param variable de tipo string.
     *@return la matriz asignada a esa varaible en forma de String.
     */
    public String consulta(String variable){ 
        Matriz hola = variables.get(variable);
        String cad = "";
        for(int i=0;i<hola.longitud;i++){
        for(int j=0;j<hola.colum;j++){
            cad += hola.get(i,j).toString()+" ";
        }
        cad+="\n ";
    }
        return cad;
    }
    
    public boolean ok(){
        return false;
    }
}
    



