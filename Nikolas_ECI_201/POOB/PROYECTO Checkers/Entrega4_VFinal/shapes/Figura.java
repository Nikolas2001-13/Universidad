package shapes;
import java.awt.*;
/**
 * Abstract class Figura - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Figura
{
    // instance variables - replace the example below with your own
    protected String color;
    protected int width,height,xPosition,yPosition,diameter;
    protected boolean isVisible;

    public Figura(){
        width = 0;
        height = 0;
        diameter = 0;
        xPosition = 0;
        yPosition = 0;
        color = "";
        isVisible = false;
    }

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }

    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){        
        erase();
        isVisible = false;
    }
    public abstract void changeSize(int newHeight, int newWidth);
    public abstract void changeSize(int newDiameter);
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight(){
      moveHorizontal(20);
    }

    
    public void moveLeft(){
    moveHorizontal(-20);
    }

    public void moveUp(){
    moveVertical(-20);
    }

    public void moveDown(){
    moveVertical(20);
    }

    public void moveHorizontal(int distance){
    erase();
    xPosition += distance;
    draw();
    }

    public void moveVertical(int distance){
    erase();
    yPosition += distance;
    draw();
    }

    public void slowMoveHorizontal(int distance){
    int delta;
    if(distance < 0) {
    delta = -1;
    distance = -distance;
    } else {
    delta = 1;
    }

    for(int i = 0; i < distance; i++){
    xPosition += delta;
    draw();
    }
    }

    public void slowMoveVertical(int distance){
    int delta;

    if(distance < 0) {
    delta = -1;
    distance = -distance;
    } else {
    delta = 1;
    }

    for(int i = 0; i < distance; i++){
    yPosition += delta;
    draw();
    }
    }

    

    public void changeColor(String newColor){
    color = newColor;
    draw();
    }
    

    public void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, this.forma());
        }
    }

    public void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    public String getColor(){
        return color;
    }
     
    public abstract java.awt.Shape forma();
}
