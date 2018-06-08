/*
 * TCSS 305 - PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


/**
 * ActionButton creates actions for the tool buttons.
 * @author Brandon Gaetaniello
 * @version 11/22/16
 */
public class ActionButton extends AbstractAction
{    

    /**
     * The serialVersionUID for this class.
     */
    private static final long serialVersionUID = -2410779280220049557L;

    /**
     * The name for the tool of the button.
     */
    private final String myName;
    
    /**
     * The DrawingPanel object.
     */
    private final DrawingPanel myPanel;
    
    /**
     * Sets up the Action and puts values on them.
     * @param theName is the name of the button.
     * @param theIcon is the image of the button.
     * @param thePanel is the DrawingPanel object.
     */
    ActionButton(final String theName, final ImageIcon theIcon,
                 final DrawingPanel thePanel)
    
    {
        
        super(theName, theIcon);
        myPanel = thePanel;
        myName = theName;
        
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
        putValue(Action.SMALL_ICON, theIcon);
        putValue(Action.SELECTED_KEY, true);
        
    }
    
    /**
     * Asks the panel when the event occurs to set the tool as the name of the action.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) 
    {
        myPanel.setTool(myName);
    }
}
