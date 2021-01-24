package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacion.Area;
import aplicacion.SINAPExcepcion;
import aplicacion.Sinap;


public class SinapTest{

    @Test
    public void deberiaAdicionar() throws SINAPExcepcion{
        Sinap sinap = new Sinap();
        sinap.adicione("Vice City", 
        "nice","GTA","3","hola");
        assertTrue(sinap.toString()!="");
    }
    
    @Test
    public void noDeberiaAdicionar(){
        Sinap sinap = new Sinap();
        try{
        sinap.adicione("Vice City", 
        "","GTA","45","hola");
        }catch(SINAPExcepcion e){
        assertEquals("Falta algun campo por llenar", e.getMessage());
        }
    
    }

    @Test
    public void deberiaListar(){
        Sinap sinap = new Sinap();
        Area area = new Area("Parque Chicamocha", 
        "Chicamocha Parck","Santander","","Parque recreativo");
        
        sinap.adicioneDetalles(area);
       
        sinap.toString();
        assertTrue(sinap.toString()!="");
    }

    @Test
    public void noDeberiaAdicionarRepetido(){
        Sinap sinap = new Sinap();
        try{
        sinap.adicione("Vice City", 
        "Los Santos","GTA","45","hola");
        sinap.adicione("Vice City", 
        "Los Santos","GTA","45","hola");
        }catch(SINAPExcepcion e){
        assertEquals("Esta area ya existe", e.getMessage());
        }
    
    }
    @Test
    public void DeberiaConsultar(){
        Sinap sinap = new Sinap();
        try{
        sinap.adicione("Vice City", 
        "Los Santos","GTA","45","hola");
        assertTrue(sinap.busque("Vice")!=null);
        }catch(SINAPExcepcion e){
        assertEquals("Esta area ya existe", e.getMessage());
        }
    
    }
    
}