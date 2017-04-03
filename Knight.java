package ca.bcit.comp2526.a2b;

import javax.swing.ImageIcon;

/**
 * Knight chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Knight extends Piece {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -2718230480462312039L;
    
    // Holds the image of the knight.
    private ImageIcon image;
    
    /**
     * Sets up the knight object with its player and image.
     * @param player Player the knight belongs to.
     */
    public Knight(final Player player) {
        super(player);
        if (player.getid() == 1) {
            image = new ImageIcon("resources/Image/BlackKnight.png");
        } else {
            image = new ImageIcon("resources/Image/WhiteKnight.png");
        }
    }
    
    /**
     * Determines if a move is valid.
     * @param square square the player is trying to move to.
     * @param board passed to the parent method, but don't need it for the knight movement
     * @return true if valid move, false otherwise.
     */
    public boolean isValidMove(final Square square, final Square[][] board) {
        return (super.isValidMove(square, board) && knightMoves(square));
    }
    
    // specific movement logic for the knight
    private boolean knightMoves(final Square square) {
        boolean valid = false;
        
        // checks for the L-shape movement
        if (Math.abs(Math.abs(Board.getSelectedSquare().getXPos()) 
                - Math.abs(square.getXPos())) == 1 
                && Math.abs(Math.abs(Board.getSelectedSquare().getYPos()) 
                        - Math.abs(square.getYPos())) == 2) {
            valid = true;
        } else if ((Math.abs(Math.abs(Board.getSelectedSquare().getXPos()) 
                - Math.abs(square.getXPos())) == 2 
                && Math.abs(Math.abs(Board.getSelectedSquare().getYPos()) 
                        - Math.abs(square.getYPos())) == 1)) {
            valid = true;
        }
        return valid;
    }
    
    /**
     * Returns the image of the knight.
     * @return knight image as an ImageIcon.
     */
    public ImageIcon getImage() {
        return image;
    }


}
