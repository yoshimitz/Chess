package ca.bcit.comp2526.a2b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Frame which chess board is placed upon.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Chess extends JFrame {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 6969113332596383282L;

    // Chess Board
    private Board board = new Board();
    
    // length and width of the frame
    private static final int size = 800;
    
    // Object stream to save files.
    private ObjectOutputStream output;
    
    // Object stream to read save files.
    private ObjectInputStream input;
    
    /**
     * Sets up the Chess Frame.
     */
    public Chess() {
        setTitle("Chess");
        setSize(size, size);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(board);
        setUpMenu();
        pack();
        setVisible(true);
        setResizable(false);
    }
    
    // Sets up the save and open option on the menu bar.
    private void setUpMenu() {
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        
        JMenu file = new JMenu("File");
        
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new OpenListener()); 
        file.add(openItem);
        
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new SaveListener());
        file.add(saveItem);         
        menu.add(file);
    }
    
    // Listener for the save option on the menu.
    private class SaveListener implements ActionListener {
        
        /**
         * Opens the file chooser to save the board state.
         * @param ex the ActionEvent to listen for
         */
        @Override
        public void actionPerformed(ActionEvent ex) {
            JFileChooser choose = new JFileChooser();
            
            int returnVal = choose.showSaveDialog(getParent());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    FileOutputStream fileStream = new FileOutputStream(choose.getSelectedFile());
                    output = new ObjectOutputStream(fileStream);
                    output.writeObject(board);
                    output.close();
                } catch (IOException exception) {
                    exception.printStackTrace();;
                }
            }
        }
        
    }
    
    // Listener for the open option on the menu bar.
    private class OpenListener implements ActionListener {
        
        /**
         * Displays the file chooser choose a save to load.
         * @param ex the ActionEvent to listen for
         */
        @Override
        public void actionPerformed(ActionEvent ex) {
            JFileChooser choose = new JFileChooser();
            
            int returnVal = choose.showOpenDialog(getParent());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    FileInputStream fileStream = new FileInputStream(choose.getSelectedFile());
                    input = new ObjectInputStream(fileStream);
                    remove(board);
                    board = (Board) input.readObject();
                    add(board);
                    revalidate();
                    repaint();
                    input.close();
                } catch (IOException exception1) {
                    exception1.printStackTrace();
                } catch (ClassNotFoundException exception2) {
                    exception2.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Main method entry point.
     * @param args command line args unused
     */
    public static void main(String[] args) {
        new Chess();
    }
}
