import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }    
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
        int total = 0;
        if(personas.size()!=0){
            for (Persona p: personas){
                try{
                total+= p.valorHora();
                }catch(EquipoExcepcion e){
                    total +=0;
                }
            }
            return total;
        }else{
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
    }
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor estimado de una persona a la que no se conoce su valor es la
     * media de los valores conocidos
     * Más del 75% del equipo debe tener valores conocidos 
     * @return el valor hora del equipo
     * @throws EquipoException si en el equipo hay una persona desconocida
     * o si no es posible calular el valor estimado
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        if(personas.size()!=0){
            int valorEquipo = 0;
            int media = valorHora()/personas.size();
            for (Persona p: personas){
                   try{
                       if (p.valorHora()==0){
                           throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
                       }
                       else{valorEquipo+= p.valorHora();}
                   }catch(EquipoExcepcion e){
                       valorEquipo+= media;
                   }
            } 
            return 0;
       }else{
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
    }   
    
}
