package aplicacion;

public class AutomataCompilador extends Exception{

    public static final String POSICION_NO_VALIDA = "Posicion no valida";
    public static final String ELEMENTO_NO_VALIDO= "Elemento no valido";

    public AutomataCompilador(String message, int linea, String palabra){
        super("El error es "+palabra+", en la linea"+linea+", con error "+message);
    }
}