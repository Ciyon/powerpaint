/*
 * TCSS 305 - PowerPaint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;


/**
 * The RectangleTool that creates new rectangles for the DrawingPanel.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class RectangleTool extends AbstractTool
{

    /**
     * Constructor that names the Tool as a Rectangle.
     */
    public RectangleTool()
    {
        super("Rectangle");
    }
    
    
    @Override 
    public Shape createShape(final Point theEnd)
    {
        
        final Shape rectangle = new Rectangle2D.Double(
                                        Math.min(theEnd.getX(), getStartPoint().getX()), 
                                        Math.min(theEnd.getY(), getStartPoint().getY()),
                                        Math.abs(theEnd.getX() - getStartPoint().getX()),
                                        Math.abs(theEnd.getY() - getStartPoint().getY()));
        
        return rectangle;
        
    }
    
    
    @Override
    public Shape reset()
    {
        return (Shape) new Rectangle2D.Double(getArbitraryPoint().getX(), 
                                              getArbitraryPoint().getX(),
                                              getArbitraryPoint().getX(),
                                              getArbitraryPoint().getX()).clone();
    }
    
}
