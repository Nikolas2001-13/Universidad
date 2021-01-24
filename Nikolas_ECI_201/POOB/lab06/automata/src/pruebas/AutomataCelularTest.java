package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

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
        AutomataCelular automata1 = AutomataCelular.getAutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacIzquierdosa()
    {
        AutomataCelular automata1 = AutomataCelular.getAutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacBarrera()
    {
        AutomataCelular automata1 = AutomataCelular.getAutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacCancerigena()
    {
        AutomataCelular automata1 = AutomataCelular.getAutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacConway1()
    {
        AutomataCelular automata1 = AutomataCelular.getAutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
        automata1.ticTac();
        automata1.ticTac();
    }
    @Test
    public void deberiaTicTacConwayBloque()
    {
        AutomataCelular automata1 = AutomataCelular.getAutomataCelular();
        automata1.algunosElementos();
        automata1.ticTac();
    }

    @Test
    public void noDeberiaAbrir()
    {
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.abra01(file);
            fail("No Exception");
        }
        catch(AutomataException e) {
            assertEquals(AutomataException.ERROR_ABRIR, e.getMessage());
        }
    }

    @Test
    public void noDeberiaSalvar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.salve01(file);
            fail("No Exception");
        }
        catch(AutomataException e){
            assertEquals(AutomataException.ERROR_GUARDAR, e.getMessage());
        }
    }

    @Test
    public void noDeberiaImportar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.importar01(file);
            fail("No Exception");
        }
        catch(AutomataException e){
            assertEquals(AutomataException.ERROR_IMPORTAR, e.getMessage());
        }
    }

    @Test
    public void noDeberiaExportar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.exportar01(file);
            fail("No Exception");
        }
        catch(AutomataException e){
            assertEquals(AutomataException.ERROR_EXPORTAR, e.getMessage());
        }
    }
    
}