/*
 * TCSS 305 - PowerPaint
 */

package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * ColorIcon creates icons for the Color buttons.
 * @author Brandon Gaetaniello
 * @version 11/22/16
 */
public class ColorIcon implements Icon
{
    /**
     * The width of the icon box.
     */
    private static final int THE_WIDTH = 13;
    
    /**
     * The height of the icon box.
     */
    private static final int THE_HEIGHT = 13;
    
    /**
     * The x value of the left edge of the icon box.
     */
    private static final int X_EDGE_VALUE = 22;
    
    /**
     * The y value of the left edge of the icon box.
     */
    private static final int Y_EDGE_VALUE = 4;
    
    /**
     * The placeholder for the color of the icon.
     */
    private final Color myColor;
    
    /**
     * 
     * @param theColor is the color for the icon.
     */
    public ColorIcon(final Color theColor)
    {
        myColor = theColor;
    }
    
    /**
     * Overridden method from icon.
     * @return The icon's height.
     */
    @Override 
    public int getIconHeight()
    {
        return THE_HEIGHT;
    }
    
    /**
     * Overridden method from icon.
     * @return the icon's width
     */
    @Override
    public int getIconWidth()
    {
        return THE_WIDTH;
    }
    
    /**
     * Overridden method from icon that paints the icon using a graphics object.
     * @param theComponent is unused.
     * @param theGraphics is the graphics object to create the icon.
     * @param theX is unused.
     * @param theY is unused.
     */
    @Override
    public void paintIcon(final Component theComponent,
                          final Graphics theGraphics,
                          final int theX, final int theY)
    {
        
        /**
         *  This creates an icon based on the border being black,
         *  and then fills it with the color selected in the color choosing panel.
         */
        theGraphics.setColor(Color.BLACK);
        theGraphics.drawRect(X_EDGE_VALUE, Y_EDGE_VALUE, THE_WIDTH, THE_HEIGHT);
        theGraphics.setColor(myColor);
        theGraphics.fillRect(X_EDGE_VALUE + 1, Y_EDGE_VALUE + 1,
                             THE_WIDTH - 1, THE_HEIGHT - 1);      
    }
    
}
