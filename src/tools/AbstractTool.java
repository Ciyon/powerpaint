/*
 * TCSS 305 - PowerPaint
 */
package tools;

import java.awt.Point;

/**
 * The abstract class for the Tool objects, implements Tool.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public abstract class AbstractTool implements Tool
{    
    /**
     * An arbitrary point used to make objects that are far off the screen.
     */
    private static final Point ARBITRARY_POINT = new Point(-1000, -1000);
    
    /**
     * The start point of the Tool.
     */
    private Point myStartPoint;
        
    /**
     * The name of the tool.
     */
    private final String myName;
    
    /**
     * Constructor that takes a name and instantiates it.
     * @param theName is the name of the Tool.
     */
    public AbstractTool(final String theName)
    {
        myStartPoint = new Point();
        myName = theName;
        
    } 
    
    
    @Override
    public void setStartPoint(final Point theStart)
    {
        myStartPoint = (Point) theStart.clone();
    }
    
    
    @Override
    public Point getStartPoint()
    {
        return (Point) myStartPoint.clone();
    }
    
    
    
    @Override
    public Point getArbitraryPoint()
    {
        return (Point) ARBITRARY_POINT.clone();
    }
    
    /**
     * Returns the name of the tool.
     * @return String of the tool's name.
     */
    @Override
    public String toString()
    {
        return myName;
    }
}
