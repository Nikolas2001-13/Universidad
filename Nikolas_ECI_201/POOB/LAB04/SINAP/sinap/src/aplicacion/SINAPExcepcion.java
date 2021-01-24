package aplicacion;
public class SINAPExcepcion extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String CAMPO_VACIO = "Falta algun campo por llenar";
    public static final String AREA_REPETIDA = "Esta area ya existe";
    public SINAPExcepcion(String message){
        super(message);
    }
} 