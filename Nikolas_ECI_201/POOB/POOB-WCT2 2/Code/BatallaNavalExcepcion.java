
/**
 * Write a description of class BatallaNavalExcepcion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatallaNavalExcepcion extends Exception
{
    public static final String AL_NORTE_INVALIDO="No es posible mover al norte";

    public BatallaNavalExcepcion(String message)
    {
        super(message);
    }

}
