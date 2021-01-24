package aplicacion;

public class AutomataException extends Exception{

    public static final String OPCION_EN_CONSTRUCCION = "Opcion ... en construccion";
    public static final String ERROR_GUARDAR= "Error al guardar";
    public static final String ERROR_ABRIR= "Error al gabrir";
    public static final String ERROR_EXPORTAR= "Error al exportar";
    public static final String ERROR_IMPORTAR= "Error al importar";


    public AutomataException(String message){
        super(message);
    }
}