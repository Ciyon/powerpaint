/*
 * TCSS 305 - PowerPaint
 */
package gui;


import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The class that creates the ToolBar of the GUI.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class PowerPaintToolBar extends JToolBar
{
    /**
     * The serialVersionUID for this class.
     */
    private static final long serialVersionUID = 6246624583948874599L;
    
    /**
     * The Button Group that assigns the buttons to synchronize with the menu buttons.
     */
    private final ButtonGroup myButtonGroup;
    
    /**
     * The constructor, used to instantiate the button group.
     */
    public PowerPaintToolBar()
    {
        super();
        myButtonGroup = new ButtonGroup();
        
    }
    /**
     * The method that creates each button on the ToolBar, called by the GUI.
     * @param theAction is the action on each button for each Tool.
     */
    public void createToolBarButton(final Action theAction) 
    {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myButtonGroup.add(toggleButton);
        add(toggleButton);
    }
    
}
