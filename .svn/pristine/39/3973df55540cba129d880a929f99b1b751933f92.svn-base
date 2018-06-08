/*
 * TCSS 305 - PowerPaint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;


/**
 * The PencilTool that creates new pencil shapes for the DrawingPanel.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class PencilTool extends AbstractTool
{
    
    /**
     * The Path2D object used for the pencil tool.
     */
    private final Path2D myPath;
    
    /**
     * Constructor that names the Tool as a Pencil.
     */
    public PencilTool() 
    {
        super("Pencil");
        myPath = new Path2D.Double();
    }
    
    @Override
    public Shape createShape(final Point theEnd)
    {
        myPath.lineTo(theEnd.getX(), theEnd.getY());
        
        return (Shape) myPath.clone();
        
    }
    
    /**
     * The PencilTool specifically overrides the setStartPoint method because
     * it has a special method for moving the path.
     * @param theStart is the start point of the shape.
     */
    @Override
    public void setStartPoint(final Point theStart)
    {
        myPath.moveTo(theStart.getX(), theStart.getY());
    }
    
    /**
     * Resets the Path2D.
     * @return a clone of the Path2D now reset.
     */
    @Override
    public Shape reset()
    {
        myPath.reset();
        return (Shape) myPath.clone();
    }
}
