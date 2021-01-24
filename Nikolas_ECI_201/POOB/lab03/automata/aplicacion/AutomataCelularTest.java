package aplicacion;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AutomataCelularTest.
 *
 * @author  (Nikolas Bernal - Juan Contreras)
 * @version (9/03/2020)
 */
public class AutomataCelularTest
{
    @Test
    public void deberiaTicTac()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacIzquierdosa()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacBarrera()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacCancerigena()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacConway1()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacConwayBloque()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
    }
}