package shapes;

import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */


 
public class Rectangle extends Figura{

    

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangle(){
        super();
        height = 30;
        width = 40;
        xPosition = 70;
        yPosition = 40;
        color = "magenta";
        isVisible = false;
    }
    
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    @Override
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }
    
    @Override
    public void changeSize(int newDiameter){}
    
    @Override
    public java.awt.Shape forma(){
        return new java.awt.Rectangle(xPosition, yPosition, width, height);
    }
    
}

