/*
 * TCSS 305 - PowerPaint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;

/**
 * 
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public interface Tool
{   
    /**
     * Overridden method from Tool that creates a shape given an end point,
     * Before this, the start point is set by the DrawingPanel.
     * 
     * @param theEnd is the end point.
     * @return a newly created Ellipse2D shape.
     */
    Shape createShape(Point theEnd);
    
    /**
     * Sets the start point of the tool's shape.
     * @param theStart is the start point of the Tool's shape.
     */
    void setStartPoint(Point theStart);
    
    /**
     * Returns the start point of the tool's shape.
     * @return the start point of the Tool's shape.
     */
    Point getStartPoint();
    
    /**
     * Resets the shape to an arbitrary shape far off the screen 
     * so it cannot be seen while repainting.
     * @return a new Shape far off the screen.
     */
    Shape reset();
    
    /**
     * Returns an arbitrary point.
     * @return an arbitrary point.
     */
    Point getArbitraryPoint();
    
}  
