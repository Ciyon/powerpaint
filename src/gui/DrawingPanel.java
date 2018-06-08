/*
 * TCSS 305 - PowerPaint
 */

package gui;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tools.EllipseTool;
import tools.LineTool;
import tools.PencilTool;
import tools.RectangleTool;
import tools.Tool;


/**
 * DrawingPanel draws shapes on the JPanel based on the movement and events of the mouse.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class DrawingPanel extends JPanel
{  
    /**
     * The serialVersionUID for this class.
     */
    private static final long serialVersionUID = -6631121862495461473L;    

    /**
     * The default color, UW Purple.
     */
    private static final Color DEFAULT_DRAW_COLOR = new Color(51, 0, 111);
    
    /**
     * The default color, UW Gold.
     */
    private static final Color DEFAULT_FILL_COLOR = new Color(232, 211, 162);
    
    /**
     * The size of the JPanel.
     */
    private static final Dimension PANEL_SIZE = new Dimension(600, 400);
    
    /**
     * The GUI frame.
     */
    private final PowerPaintGUI myGUI;
    
    /**
     * The thickness of the stroke.
     */
    private BasicStroke myThickness = new BasicStroke(1);
    
    /**
     * The Graphics2D object.
     */
    private Graphics2D myG2D; 
    
    /**
     * The current shape being drawn.
     */
    private Shape myCurrentShape;
    
    /**
     * The current tool being used.
     */
    private Tool myCurrentTool;
    
    /**
     * The list of tools.
     */
    private List<Tool> myTools;
    
    /**
     * The list of stored shapes.
     */
    private final List<PowerPaintShape> myPreviousShapes;
    
    /**
     * The end point for a shape.
     */
    private Point myEndPoint;
    
    /**
     * The boolean that keeps whether or not the shape will be filled.
     */
    private Boolean myFill = false;
    
    /**
     * The boolean that tells whether or not the fill button is currently selected.
     */
    private Boolean myFillButtonSelected = false;
    
    /**
     * A constant keeping track if the paintComponent has been ran yet.
     */

    private boolean myFirstRun = true;
    
    /**
     * The draw color of the shape.
     */
    private Color myDrawColor = DEFAULT_DRAW_COLOR;
    
    /**
     * The fill color of the shape.
     */
    private Color myFillColor = DEFAULT_FILL_COLOR;
    
      
    /**
     * The constructor for setting up the DrawingPanel.
     * @param theGUI is the GUI frame.
     * 
     */
    public DrawingPanel(final PowerPaintGUI theGUI)
    {
        super();
        myGUI = theGUI;
        myPreviousShapes = new ArrayList<PowerPaintShape>();
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());
        setBackground(Color.WHITE);
        setPreferredSize(PANEL_SIZE);
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        chooseTool();
            
    }
    
    /**
     * Instantiates the tool list and the current tool.
     */
    private void chooseTool()
    {   
        myTools = new ArrayList<Tool>();
        myTools.add(new LineTool());
        myTools.add(new RectangleTool());
        myTools.add(new EllipseTool());
        myTools.add(new PencilTool());
        myCurrentTool = myTools.get(0);
    }
    
    /**
     * Sets the current tool for the paintComponent.
     * @param theTool is the tool being selected.
     */
    public void setTool(final String theTool)
    {
        for (final Tool t : myTools)
        {
            if (t.toString().equals(theTool))
            {
                myCurrentTool = t; 
            }
        }
        
    }
    
    /**
     * Sets the clear button to enabled, when there is a shape to be cleared.
     * @return Boolean representing the clear buttons state.
     */
    public Boolean setClearButton()
    {
        Boolean bool = false;
        if (!(myPreviousShapes.isEmpty()))
        {
            bool = true;
        }
        
        return bool;
    }
    
    /**
     * Clears the shapes and repaints the paintComponent.
     */
    public void clear()
    {
        myPreviousShapes.clear();
        repaint();
        
    }
    
    /**
     * the paintComponent method for the DrawingPanel, used to create shapes on the panel
     * when the mouse draws them based on the currently selected tool.
     * @param theGraphics is the graphics used to draw the shapes.
     */
    @Override
    public void paintComponent(final Graphics theGraphics)
    {
        super.paintComponent(theGraphics);
        myG2D = (Graphics2D) theGraphics;
        
        // Checks to see if this is the first run of the paint component.
        if (myFirstRun)
        {   
            /** If it is, then it sets the draw and fill icons 
             * along with setting a rendering hint for the Graphics2D object */
             
            myG2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON);
            myGUI.setFillIcon(createIcon(myFillColor));
            myGUI.setDrawIcon(createIcon(myDrawColor));
            myFirstRun = false;
        }
        
        // As long as the end point exists, then the shapes can be drawn.
        if (myEndPoint != null)
        {
            // First draws the previous shapes.
            drawPreviousShapes();
        
            // Then draws the current shape.
            drawCurrentShape();
        }  
        
    }
    
    /**
     * Helper method to draw the previous shapes.
     */
    private void drawPreviousShapes()
    {
        /* This calls all previous shapes, 
         * stored in a list of PowerPaintShapes, myPreviousShapes. */
        for (final PowerPaintShape shape: myPreviousShapes)
        {                     
            // As long as the shape has a larger stroke than 0, it can be drawn.
            if (shape.getThickness().getLineWidth() >= 0)
            {
                myG2D.setStroke(shape.getThickness());
                
                // Checks if the shape is filled, then fills if so.
                if (shape.isFilled())
                {
                    myG2D.setColor(shape.getFillColor());
                    myG2D.fill(shape.getShape());
                }
                // Draws the previous shape.
                myG2D.setColor(shape.getColor());
                myG2D.draw(shape.getShape());
            }
        }
    }
    
    /**
     * Helper method for drawing current shapes.
     */
    private void drawCurrentShape()
    {
        // As long as the shape has a larger stroke than 0, it can be drawn.
        if (myThickness.getLineWidth() >= 0)
        {
            myG2D.setStroke(myThickness);
            
            /**
             *  Checks to see if the fill button is currently selected,
             *  and because fill is limited to pencils and lines, 
             *  only rectangles and ellipses are being considered.
             */
            if (myFillButtonSelected && (myCurrentTool.toString().equals("Rectangle") 
                                      || myCurrentTool.toString().equals("Ellipse")))
            {
                myFill = true;
                myG2D.setColor(myFillColor);
                myG2D.fill(myCurrentShape); 
            }
            
            // If it doesn't meet the criteria, then it won't be filled.
            else 
            {
                myFill = false;
            }
            
            myG2D.setColor(myDrawColor);
            myG2D.draw(myCurrentShape);
        }
    }
    
    
         
    /**
     * Method that creates icons for the Menu.
     * @param theColor is the color of the icon.
     * @return a ColorIcon for the Fill Color and Draw Color buttons.
     */
    public ColorIcon createIcon(final Color theColor)
    {
        final ColorIcon icon = new ColorIcon(theColor);
        icon.paintIcon(null, myG2D, 0, 0);
        return icon;
    }
    
    /**
     * Method that sets the Draw Color of the Drawing Panel,
     * then draws an Icon for the Draw Color button.
     * @param theColor is the Color of the Draw Color.
     */
    public void setDrawColor(final Color theColor)
    {
        myDrawColor = theColor;
        myGUI.setDrawIcon(createIcon(myDrawColor));
    }
    
    /**
     * Method that sets the Fill Color of the Drawing Panel,
     * then draws an Icon for the Fill Color button.
     * @param theColor is the Color of the Fill Color.
     */
    public void setFillColor(final Color theColor)
    {
        myFillColor = theColor;
        myGUI.setFillIcon(createIcon(myFillColor)); 
    }
   
    /**
     * Method that sets whether or not the Shape is filled.
     * @param theFill is the boolean representing if the object's filled.
     */
    public void setFill(final Boolean theFill)
    {
        myFillButtonSelected = theFill;
    }
    
    /**
     * Sets the Drawing Panel's stroke size.
     * @param theStroke is an integer of which the user selected to be the stroke size.
     */
    public void setThickness(final int theStroke)
    {
        myThickness = new BasicStroke((int) theStroke);
    }
    
    /**
     * The mouse listener private class that keeps track of mouse events.
     */
    private class MyMouseListener extends MouseAdapter 
    {
      /**
       * Whenever the mouse is dragged, it sets the end point to the event location,
       * then it creates a new shape and sets it to myCurrentShape, then repaints.  
       */
        @Override
      public void mouseDragged(final MouseEvent theEvent)
        { 
            myEndPoint = (Point) theEvent.getPoint().clone();            
            myCurrentShape = myCurrentTool.createShape(myEndPoint);
            repaint();            
        }
      
      /**
       * Whenever the mouse is pressed, the mouse event creates the start 
       * point for the object and repaints.
       */
        @Override
      public void mousePressed(final MouseEvent theEvent)
        {
            myCurrentTool.setStartPoint((Point) theEvent.getPoint().clone()); 
            repaint();
        }
      
      /**
       * When the mouse is released, the shape is added to the shape collection of 
       * PowerPaintShape with all of its details, then enables the clear button
       * on the menu, and resets the current shape.
       */
        @Override
      public void mouseReleased(final MouseEvent theEvent)
        {
            myPreviousShapes.add(new PowerPaintShape(myCurrentShape, myThickness, 
                                             myDrawColor, myFill, myFillColor));
            
            myGUI.setClearButton(true);
            
            myCurrentShape = myCurrentTool.reset();
                            
        }
    }
}

