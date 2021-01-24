package aplicacion;


public class PoongException extends Exception{
    public static final String PUNTAJE_MAX_NULL = "No se selecciono puntaje maximo a jugar";
    public static final String  J1_NULL= "Jugador 1 no selecciono personaje";
    public static final String  J2_NULL= "Jugador 2 no selecciono personaje";
    public static final String  MODO_NULL= "El modo de juego no se ha especificado";
    public static final String  ERROR_EXPORTAR= "Error Exportando";
    public PoongException(String message){
        super(message);
    } 
}