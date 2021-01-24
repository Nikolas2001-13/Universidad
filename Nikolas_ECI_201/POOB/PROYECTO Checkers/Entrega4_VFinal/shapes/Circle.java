package shapes;

import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle extends Figura{

    public static double PI=3.1416;
    
    
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(String color){
        super();
        diameter = 30;
        xPosition = 75;
        yPosition = 45;
        this.color = color;
        isVisible = false;
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
     @Override
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }

    @Override
    public void changeSize(int newHeight, int newWidth) { }

    @Override
    public java.awt.Shape forma(){
        return new java.awt.geom.Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter);
    }
    
}
