// Chapter 16 Exercise 5
// Adding apulldown menu  and accelerators to the Edit menu

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Event;

public class SquareWindow extends JFrame {
  public SquareWindow(String title) {
    super(title);

    Toolkit theKit = this.getToolkit();
    Dimension wndSize = theKit.getScreenSize();

    // Calculate maximum side to fit comfortably within the screen
    int maxSize = 9*Math.min(wndSize.width, wndSize.height)/10;     

    setBounds((wndSize.width - maxSize)/2, (wndSize.height-maxSize)/2,  // Position.
                     maxSize, maxSize);                                 // Size.
    addButtons();                                      // Add the buttons to the window
    addMenu();                                         // Add the menubar & menu 
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void addButtons() {
    Box vBox = Box.createVerticalBox();        // Create a box to hold the buttons
      
    vBox.add(Box.createVerticalStrut(10));     // Start with a strut for spacing
    vBox.add(Box.createVerticalGlue());        // then glue

    // Add the buttons separated by glue
    JButton button = null;;
    for(int i = 1; i <= 6; i++) {
      vBox.add(button = new JButton("Button" + i));
      vBox.add(Box.createVerticalGlue());
    }
    vBox.add(Box.createVerticalStrut(10));      // Add a strut for end spacing

    // Content pane has BorderLayout by default - add vBox to the WEST
    getContentPane().add(vBox, BorderLayout.WEST);
   }

   // Create and add a  menubar
   private void addMenu() {
      JMenuBar menuBar = new JMenuBar();   // Create the menubar

      // Create the menu headings, with mnemonics:
      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenu windowMenu = new JMenu("Window");
      JMenu helpMenu = new JMenu("Help");
      
      // Create menu items to the Edit menu
      JMenuItem cut = new JMenuItem("Cut");
      JMenuItem copy = new JMenuItem("Copy");
      JMenuItem paste = new JMenuItem("Paste");
      JMenuItem selectAll = new JMenuItem("Select All");

      // Create Accelerators
      cut.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK));
      copy.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
      paste.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK));
      selectAll.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));

      // Add menu items to the edit menu
      editMenu.add(cut);      
      editMenu.add(copy);      
      editMenu.add(paste);      
      editMenu.addSeparator();      
      editMenu.add(selectAll);      

      // Create a pulldown menu within the edit pulldown menu
      JMenu findMenu = new JMenu("Find...");
      JMenuItem findInPage = new JMenuItem("In this page");
      JMenuItem findInDoc = new JMenuItem("In the document");
      findInPage.setAccelerator(KeyStroke.getKeyStroke('P', Event.CTRL_MASK));
      findInDoc.setAccelerator(KeyStroke.getKeyStroke('D', Event.CTRL_MASK));
      findMenu.add(findInPage);
      findMenu.add(findInDoc);
      editMenu.addSeparator();
      editMenu.add(findMenu);          

      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(windowMenu);
      menuBar.add(helpMenu);

      setJMenuBar(menuBar);      // Add the menubar to the window
   }

   public static void main(String[] args) {
      SquareWindow myWindow = new SquareWindow("Chapter 16 Exercise 1 - Look, I'm square...");
   }
}