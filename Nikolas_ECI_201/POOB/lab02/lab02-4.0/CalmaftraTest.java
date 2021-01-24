import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Test de la clase Calmatfra.
 * 
 * @author Nikolas Bernal and Juan Pablo Contreras
 * @version 2/12/2020
 */
public class CalmaftraTest
{   
    //Pruebas para asigne y consulte
     @Test
        public void DeberiaAsignar() {
            assertEquals (1, Fraccionario.mcd(3, 4));
            assertEquals (1, Fraccionario.mcd(6, 35));
            assertEquals (1, Fraccionario.mcd(35, 24));
            assertEquals (1, Fraccionario.mcd(7, 5));
        }
        
     @Test
     public void noDeberiaAsignar() {
            assertEquals (1, Fraccionario.mcd(3, 4));
            assertEquals (1, Fraccionario.mcd(6, 35));
            assertEquals (1, Fraccionario.mcd(35, 24));
            assertEquals (1, Fraccionario.mcd(7, 5));
    }
    
    @Test
    public void DeberiaConsultar() {
            Calmatfra cal1 = new Calmatfra();
             int [][][] hola ={{{3,5},{4,6}},{{1,2},{3,2}}};
            cal1.asigne("a",hola);
            assertEquals ("3/5 4/6 1/2 3/2", cal1.consulta("a"));
    }
        
    @Test
    public void noDeberiaConsultar() {
            Calmatfra cal1 = new Calmatfra();
            int [][][] hola ={{{3,5},{4,6}},{{1,2},{3,2}}};
            cal1.asigne("a",hola);
            cal1.consulta("a");
            assertEquals (true,cal1.ok());
            
    }
}
