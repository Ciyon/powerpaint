/*
 * TCSS 305 - PowerPaint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * The LineTool that creates new lines for the DrawingPanel.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class LineTool extends AbstractTool
{
    
    /**
     * Constructor that names the Tool as a Line.
     */
    public LineTool()
    {
        super("Line");
    }
    
    @Override
    public Shape createShape(final Point theEnd)
    {
        return (Shape) new Line2D.Double(getStartPoint(), theEnd).clone();      
    }
    
    @Override
    public Shape reset()
    {
        return (Shape) new Line2D.Double(getArbitraryPoint(), getArbitraryPoint()).clone();
    }
    
    
}
