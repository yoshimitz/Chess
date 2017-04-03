package ca.bcit.comp2526.a2b;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * Squares that are on a board to hold pieces.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Square extends JPanel implements Serializable {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 363851151064987425L;
    
    // piece on the square
    private Piece piece;
    
    // x position of square on board
    private int xposition;
    
    // y position of square on board
    private int yposition;
    
    // color of the square
    private Color squareColor;
    
    // if a square is selected or not.
    private static boolean isSelected = false;
    
    // piece to move from square to square.
    private static Piece globalPiece;
    
    /**
     * Sets up the square with its color and position.
     * @param color of the square
     * @param xpos position of the square
     * @param ypos position of the square
     */
    public Square(int color, int xpos, int ypos) {
        if (color == 1) {
            setSquareColor(Color.WHITE);
        } else {
            setSquareColor(Color.GRAY);
        }
        setBackground(getSquareColor());
        xposition = xpos;
        yposition = ypos;
    }
    
    /**
     * Paints the piece of the square if it exists.
     * @param square Graphics context to paint on
     */
    public void paintComponent(Graphics square) {
        super.paintComponent(square);
        if (piece != null) {
            piece.getImage().paintIcon(this, square, 0, 0);   
        }
    }
   
    /**
     * Returns the x position of the square.
     * @return x position as an integer
     */
    public int getXPos() {
        return xposition;
    }
    
    /**
     * Returns the y position of the square.
     * @return y as an integer.
     */
    public int getYPos() {
        return yposition;
    }
    
    /**
     * Sets the piece on the square.
     * @param piece to set.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    /**
     * Returns the piece on the square.
     * @return piece on the square as a Piece
     */
    public Piece getPiece() {
        return piece;
    }
    
    /**
     * Returns true if a square is selected, false otherwise.
     * @return isSelected  as a boolean
     */
    public static boolean isSelected() {
        return isSelected;
    }
    
    /**
     * Set the status of whether a square is selected or not.
     * @param isSelected what to set the status of isSelected to. 
     */
    public static void setSelected(boolean isSelected) {
        Square.isSelected = isSelected;
    }
    
    /**
     * Returns the global selected piece.
     * @return global piece as a Piece.
     */
    public static Piece getGlobalPiece() {
        return globalPiece;
    }

    /**
     * Sets the global piece.
     * @param globalPiece piece to selects
     */
    public static void setGlobalPiece(final Piece globalPiece) {
        Square.globalPiece = globalPiece;
    }
    
    /**
     * Returns the colour of the square.
     * @return color of the square as a Color.
     */
    public Color getSquareColor() {
        return squareColor;
    }

    /**
     * Sets the colour of the square.
     * @param squareColor colour to set square to.
     */
    public void setSquareColor(final Color squareColor) {
        this.squareColor = squareColor;
    }

   
}

