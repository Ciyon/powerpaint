/*
 * TCSS 305 - PowerPaint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * The EllipseTool that creates new lines for the DrawingPanel.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class EllipseTool extends AbstractTool
{
    /**
     * Constructor that names the Tool as an Ellipse.
     */
    public EllipseTool()
    {
        super("Ellipse");
    }
    
    /**
     * Overridden method from Tool that creates a shape given an end point,
     * Before this, the start point is set by the DrawingPanel.
     * 
     * @param theEnd is the end point.
     * @return a newly created Ellipse2D shape.
     */
    @Override 
    public Shape createShape(final Point theEnd)
    {
        
        final Shape ellipse = new Ellipse2D.Double(
                                        Math.min(theEnd.getX(), getStartPoint().getX()), 
                                        Math.min(theEnd.getY(), getStartPoint().getY()),
                                        Math.abs(theEnd.getX() - getStartPoint().getX()),
                                        Math.abs(theEnd.getY() - getStartPoint().getY()));
        return ellipse;
    }
    
    /**
     * Resets the shape to an arbitrary shape far off the screen 
     * so it cannot be seen while repainting.
     * @return a new Shape far off the screen.
     */
    @Override
    public Shape reset()
    {
        return (Shape) new Ellipse2D.Double(getArbitraryPoint().getX(),
                                            getArbitraryPoint().getX(), 
                                            getArbitraryPoint().getX(),
                                            getArbitraryPoint().getX()).clone();
    }

}
