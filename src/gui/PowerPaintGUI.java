/*
 * TCSS 305 - PowerPaint
 */

package gui;

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The GUI for the PowerPaint program.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class PowerPaintGUI extends JFrame
{
    /**
     * The serialVersionUID for this class.
     */
    private static final long serialVersionUID = -7912422588612064748L;

    /**
     * The constructor names the frame and starts the GUI.
     */
    public PowerPaintGUI()
    {
        super("TCSS 305 - PowerPaint");
        startGUI();        
    }
    
    /** 
     * Method that sets up the GUI and its components.
     */
    private void startGUI()
    {
        // Sets the LookAndFeel of the JFrame.
        setLookAndFeel();
        setIconImage(new ImageIcon("./images/bobross.gif").getImage());
        
        // Instantiates the tool bar, panel, and menu bar.
        final PowerPaintToolBar toolBar = new PowerPaintToolBar();    
        final DrawingPanel panel = new DrawingPanel(this);
        final PowerPaintMenu menuBar = new PowerPaintMenu(this, panel);
        
        
        // Adds PropertyChangeListeners to the menuBar.
        addPropertyChangeListener(menuBar);
        
        // Creates the action buttons that keep track of the tools.
        final Action[] actionButtons = {new ActionButton("Line",
                                                   new ImageIcon("./images/line_bw.gif"),
                                                   panel),
                                        new ActionButton("Pencil",
                                                   new ImageIcon("./images/pencil_bw.gif"),
                                                   panel),
                                        new ActionButton("Rectangle",
                                                   new ImageIcon("./images/rectangle_bw.gif"),
                                                   panel),
                                        new ActionButton("Ellipse",
                                                   new ImageIcon("./images/ellipse_bw.gif"),
                                                   panel)};
        
        // Adds the actions to the menu bar and tool bar.
        for (final Action buttons : actionButtons) 
        {
            menuBar.createMenuButton(buttons);
            toolBar.createToolBarButton(buttons);
        }
        
        // Sets the GUI's layout.
        add(toolBar, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        setJMenuBar(menuBar);
        pack();
        setMinimumSize(getBounds().getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
         
    }
    /**
     * Sets the LookAndFeel of the JFrame to Metal.
     */
    private static void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (final UnsupportedLookAndFeelException e)
        {
            System.out.println("UnsupportedLookAndFeelException");
        } 
        catch (final ClassNotFoundException e) 
        {
            System.out.println("ClassNotFoundException");
        } 
        catch (final InstantiationException e) 
        {
            System.out.println("InstantiationException");
        }
        catch (final IllegalAccessException e) 
        {
            System.out.println("IllegalAccessException");
        }
    }
    
    /**
     * Sets the clear button to a given boolean.
     * @param theValue is either true or false depending if the clear button should be enabled.
     */
    public void setClearButton(final Boolean theValue)
    {
        firePropertyChange("clear", null, theValue);
    }
        
    /**
     * Method that fires a propertyChange when the Draw Color icon needs to be changed.
     * @param theIcon is the ColorIcon for the Draw Color button.
     */
    public void setDrawIcon(final ColorIcon theIcon)
    {
        firePropertyChange("drawicon", null, theIcon);
    }
    
    /**
     * Method that fires a propertyChange when the Fill Color icon needs to be changed.
     * @param theIcon is the ColorIcon for the Fill Color button.
     */
    public void setFillIcon(final ColorIcon theIcon)
    {
        firePropertyChange("fillicon", null, theIcon);
    }
    
    
}
