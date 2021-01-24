package chekers;




import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckersTest.
 *
 * @author  (nikolas bernal- juan pablo contreras)
 * @version (20/02/2020)
 */
public class CheckersTestC2
{    
    @Test
    public void segunBCdeberiaSeleccionar()
    {
        Checkers checkers1 = new Checkers();
        checkers1.add(false, 1, 2);
        checkers1.select(1, 2);
        assertEquals(true, checkers1.ok());
    }

    @Test
    public void segunBCnoDeberiaRemover()
    {
        Checkers checkers1 = new Checkers();
        checkers1.add(false, 4, 1);
        checkers1.remove(1, 4);
        assertFalse(checkers1.ok());
    }
}


