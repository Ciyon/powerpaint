/*
 * TCSS 305 - PowerPaint
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * The class that creates the menu at the top of the GUI that holds buttons.
 * @author Brandon Gaetaniello
 * @version 11/22/2016
 */
public class PowerPaintMenu extends JMenuBar implements PropertyChangeListener
{
    /**
     * The serialVersionUID for this class.
     */
    private static final long serialVersionUID = 1937147869784006820L;

    /**
     * The default draw color, UW Purple.
     */
    private static final Color DEFAULT_DRAW_COLOR = new Color(51, 0, 111);
    
    /**
     * The default fill color, UW Gold.
     */
    private static final Color DEFAULT_FILL_COLOR = new Color(232, 211, 162);
    
    /**
     * The minor tick spacing for the thickness slider.
     */
    private static final int MINOR_TICK_SPACING = 1;

    /**
     * The major tick spacing for the thickness slider.
     */
    private static final int MAJOR_TICK_SPACING = 5;
    
    /**
     * The maximum tick value for the thickness slider.
     */
    private static final int MAXIMUM_TICK_VALUE = 20;
    
    /**
     * The File menu.
     */
    private final JMenu myFileMenu;
    
    /** 
     * The Options menu.
     */
    private final JMenu myOptionsMenu;
    
    /**
     * The Tools menu.
     */
    private final JMenu myToolsMenu;
    
    /**
     * The Help menu.
     */
    private final JMenu myHelpMenu;
   
    /**
     * The clear menu item.
     */
    private JMenuItem myClearButton;
    
    /**
     * The Draw Color menu item.
     */
    private JMenuItem myDrawColorButton;
    
    /** 
     * The Fill Color menu item.
     */
    private JMenuItem myFillColorButton;
    
    /**
     * The DrawingPanel object.
     */
    private final DrawingPanel myPanel;
    
    /**
     * The GUI object.
     */
    private final PowerPaintGUI myGUI;
    
    /**
     * The draw color.
     */
    private Color myDrawColor;
    
    /**
     * The fill color.
     */
    private Color myFillColor;
    
    /**
     * The constructor that instantiates private fields.
     * @param theGUI is the PowerPaintGUI object.
     * @param thePanel is the DrawingPanel object.
     */
    public PowerPaintMenu(final PowerPaintGUI theGUI, final DrawingPanel thePanel)
    {
        super();
        myFileMenu = new JMenu("File");
        myOptionsMenu = new JMenu("Options");
        myToolsMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        myPanel = thePanel;
        myGUI = theGUI;
        myDrawColor = DEFAULT_DRAW_COLOR;
        myFillColor = DEFAULT_FILL_COLOR;
        setup();
        
    }
    /**
     * Calls the helper methods for creating each menu.
     */
    private void setup()
    {
        createFileMenu();
        createOptionsMenu();
        createHelpMenu();
        
        // After created, they are added to the GUI.
        add(myFileMenu);
        add(myOptionsMenu);
        add(myToolsMenu);
        add(myHelpMenu);
        
    }
    
    /**
     * Creates the file menu.
     */
    private void createFileMenu()
    {
        myClearButton = new JMenuItem("Clear");
        final JMenuItem quitButton = new JMenuItem("Quit");
        
        // This ActionListener allows the button to close the application.
        quitButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent) 
            {
                myGUI.dispatchEvent(new WindowEvent(myGUI, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        // Setting mnemonic keys on the buttons.
        quitButton.setMnemonic(KeyEvent.VK_Q);
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        myClearButton.setMnemonic(KeyEvent.VK_C);
        
        // Clear button initially set to false.
        myClearButton.setEnabled(false);
        
        // Calls the GUI to clear the DrawingPanel, and sets the Clear button back to false.
        myClearButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent) 
            {
                myPanel.clear();
                myClearButton.setEnabled(false);
            }
        });
        
        myFileMenu.add(myClearButton);
        myFileMenu.addSeparator();
        myFileMenu.add(quitButton);
    }
    
    /**
     * Creates the option menu for the JFrame.
     */
    private void createOptionsMenu()
    {
        // Instantiates the buttons, along with the slider.
        final JMenu thickness = new JMenu("Thickness");
        final JCheckBoxMenuItem fillButton = new JCheckBoxMenuItem("Fill");
        myDrawColorButton = new JMenuItem("Draw Color...");
        myFillColorButton = new JMenuItem("Fill Color...");
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 
                                           MAXIMUM_TICK_VALUE, 1);
        
        myOptionsMenu.setMnemonic(KeyEvent.VK_O);
        thickness.setMnemonic(KeyEvent.VK_T);
        myDrawColorButton.setMnemonic(KeyEvent.VK_D);
        myFillColorButton.setMnemonic(KeyEvent.VK_F);
        
        // Sets the distance between the icon and the text to 5.
        myDrawColorButton.setIconTextGap(MAJOR_TICK_SPACING);
        myFillColorButton.setIconTextGap(MAJOR_TICK_SPACING);
        
        /*
         * When the Choose Color menu button is clicked, 
         * it pops open a JColorChooser then asks the 
         * GUI to set that color for the Draw Color on the DrawingPanel.
         */
        myDrawColorButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent) 
            {
                myDrawColor = JColorChooser.showDialog(null, "Draw Color Chooser",
                                                       myDrawColor);
                myPanel.setDrawColor(myDrawColor);
            }
        });
    
        /*
        * When the Choose Color menu button is clicked, 
        * it pops open a JColorChooser then asks the 
        * GUI to set that color for the Fill Color on the DrawingPanel.
        */
        myFillColorButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent) 
            {
                myFillColor = JColorChooser.showDialog(null, "Fill Color Chooser",
                                                       myFillColor);
                myPanel.setFillColor(myFillColor);
            }
        });
        
        // Sets up the slider for the thickness menu item.
        slider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(MINOR_TICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new SliderListener());
        thickness.add(slider);
        
        // Sets an accelerator on the fill button.
        fillButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                                                         ActionEvent.CTRL_MASK));
        
        // When the fill button is selected, it sets the fill to being true. Otherwise, false.
        fillButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent) 
            {
                if (fillButton.isSelected())
                {
                    
                    myPanel.setFill(true);
                }
                else
                {
                    myPanel.setFill(false);
                }
            }
        });
        
        myOptionsMenu.add(thickness);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(myDrawColorButton);
        myOptionsMenu.add(myFillColorButton);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(fillButton);
        
    }
    
    /**
     * Creates the help menu.
     */
    private void createHelpMenu()
    {
        final JMenuItem about = new JMenuItem("About...");
        
        /* 
         * Adds an action so that whenever the About... button is pressed, 
         * a JOptionPane shows up with information.
         */
        about.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent) 
            {
                JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint"
                                                     + "\nAutumn 2016"
                                                     + "\nBrandon Gaetaniello", 
                                                     "About",
                                                     JOptionPane.OK_OPTION,
                                                     new ImageIcon("./images/bobross.gif"));
                
            }
        });
        
        myHelpMenu.setMnemonic(KeyEvent.VK_H);
        myToolsMenu.setMnemonic(KeyEvent.VK_T);
        about.setMnemonic(KeyEvent.VK_A);
        myHelpMenu.add(about);
              
    }
    
    /**
     * Method for creating menu buttons when given an action.
     * @param theAction is the action for each button on the tools menu.
     */
    public void createMenuButton(final Action theAction) 
    {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        myToolsMenu.add(createdButton); 
    }
    
    /**
     * The method that a class implementing PropertyChangeListener must have.
     * It keeps track of properties changing in other classes.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) 
    {
        /**
         * This event checks to see if the event was a shape being created,
         *  causing the Clear button to be set to enabled.
         */
        if ("clear".equals(theEvent.getPropertyName())) 
        {
            myClearButton.setEnabled((Boolean) theEvent.getNewValue());
        }
        /**
         * This event checks to see if the event was the fill icon being created.
         */
        else if ("fillicon".equals(theEvent.getPropertyName()))
        {
            myFillColorButton.setIcon((ColorIcon) theEvent.getNewValue());
        }
        
        /**
         * This event checks to see if the event was the Draw icon being created.
         */
        else if ("drawicon".equals(theEvent.getPropertyName()))
        {
            myDrawColorButton.setIcon((ColorIcon) theEvent.getNewValue());
        }
    }
    
    /**
     * Private class that listens to the slider if the user moves it.
     */
    private class SliderListener implements ChangeListener
    {
        /**
         * If the state is being changed, it returns an event which is the value 
         * selected by the user when the slider is not being adjusted.
         * 
         * @param theEvent is the change when a user moves the slider.
         */
        public void stateChanged(final ChangeEvent theEvent)
        {
            final JSlider slider = (JSlider) theEvent.getSource();
            if (!slider.getValueIsAdjusting())
            {
                myPanel.setThickness(slider.getValue());
            }      
        }
    }
}
