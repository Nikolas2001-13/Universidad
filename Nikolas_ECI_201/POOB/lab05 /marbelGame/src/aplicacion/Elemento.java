package aplicacion;

import java.awt.*;

public interface Elemento {

     /*
     *retorna el tipo que tiene asignado
     *@String del tipo
     */
     String getType();
     /*
     *retorna el tipo que tiene asignado
     *@param color del hueco en el que cayo
     */
     void punto(Color col);
     /*
     *retorna el tipo que tiene asignado
     *@boolean si el elemento estaa en un hueco retorna true
     */
     boolean isInHueco();
     /*
     *retorna el tipo que tiene asignado
     @return Color del color del elemento 
     */
     Color getColor();
     /*
     *retorna el tipo que tiene asignado
     *@Color del hueco en el que esta el elemento 
     */
     Color colorHueco();
}