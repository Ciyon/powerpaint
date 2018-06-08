/*
 * TCSS 305 - PowerPaint
 */
package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;

/**
 * Class that stores previously made shapes and their information.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class PowerPaintShape
{
    /**
     * The shape given by the DrawingPanel.
     */
    private final Shape myShape;
    
    /**
     * The stroke of the shape.
     */
    private final BasicStroke myThickness;
    
    /**
     * The color of the shape.
     */
    private final Color myColor;
    
    /** 
     * Boolean asking if the shape is filled or not.
     */
    private final Boolean myFill;
    
    /**
     * Color of the Fill.
     */
    private final Color myFillColor;
    
    /**
     * The constructor for the PowerPaintShape object.
     * @param theShape is the shape.
     * @param theThickness is the stroke size.
     * @param theColor is the color.
     * @param theFill asks if the shape is filled or not.
     * @param theFillColor is the fill color of the shape.
     */
    public PowerPaintShape(final Shape theShape, final BasicStroke theThickness,
                           final Color theColor, final Boolean theFill,
                           final Color theFillColor)
    {
        myShape = theShape;
        myThickness = theThickness;
        myColor = theColor;
        myFill = theFill;
        myFillColor = theFillColor;
    }
    /**
     * Returns the color.
     * @return the color.
     */
    public Color getColor()
    {
        return myColor;
    }
    
    /**
     * Returns the shape.
     * @return the shape.
     */
    public Shape getShape()
    {
        return myShape;
    }
    
    /**
     * Returns the thickness stroke.
     * @return the BasicStroke of the thickness.
     */
    public BasicStroke getThickness()
    {
        return myThickness;
    }
    
    /**
     * Returns the fill color of the object.
     * @return the fill color.
     */
    public Color getFillColor()
    {
        return myFillColor;
    }
    
    /**
     * Returns the value pertaining to if the shape is filled or not.
     * @return a boolean saying if the shape is filled.
     */
    public Boolean isFilled()
    {
        return myFill;
    }
    
}
