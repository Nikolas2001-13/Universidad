package chekers;




import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckersTest.
 *
 * @author  (nikolas bernal- juan pablo contreras)
 * @version (22/03/2020)
 */
public class CheckersTestC4
{    


    @Test
    public void segunBCDeberiaAgregarLibertarian()
    {
        chekers.Checkers checkers1 = new chekers.Checkers();
        checkers1.add("Libertarian", false, 2, 1);
        assertEquals(true, checkers1.ok());
    }

    @Test
    public void segunBCNoDeberiaCrearProletarianRey()
    {
        chekers.Checkers checkers1 = new chekers.Checkers();
        checkers1.add("Proletarian", true, 3, 2);
        assertEquals(false, checkers1.ok());
    }
    


    @Test
    public void segunBCNoDeberiaMatarPowerful()
    {
        chekers.Checkers checkers1 = new chekers.Checkers();
        checkers1.add(false, 2, 1);
        checkers1.add("Powerful", false, 3, 2);
        checkers1.swap();
        checkers1.move("5x14");
        assertEquals("Powerful",checkers1.juego.fichas[2][1].getType());
    }
}


