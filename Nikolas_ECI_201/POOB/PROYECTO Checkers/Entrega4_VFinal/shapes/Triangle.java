package shapes;

import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Triangle extends Figura{
    

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(String color){
        super();
        height = 20;
        width = 20;
        xPosition = 85;
        yPosition = 45;
        this.color = color;
    }
    
    @Override
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }
    @Override
    public void changeSize(int newDiameter){}

    /*
     * Draw the triangle with current specifications on screen.
     */

    @Override
    public java.awt.Shape forma(){
        int[] xpoints = { xPosition, xPosition + (width/2), xPosition - (width/2) };
        int[] ypoints = { yPosition, yPosition + height, yPosition + height };
        return new java.awt.Polygon(xpoints,ypoints,3);
    }
}
