package ca.bcit.comp2526.a2b;

import javax.swing.ImageIcon;

/**
 * King chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class King extends Piece {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 3035349715136873195L;
    
    // Holds the image of the King.
    private ImageIcon image;
    
    /**
     * Sets up the king with its player and image.
     * @param player Player the king belongs to
     */
    public King(final Player player) {
        super(player);
        if (player.getid() == 1) {
            image = new ImageIcon("resources/Image/BlackKing.png");
        } else {
            image = new ImageIcon("resources/Image/WhiteKing.png");
        }
    }
    
    /**
     * Determines if a move is valid.
     * @param square square the player is trying to move to.
     * @return true if valid move, false otherwise.
     */
    public boolean isValidMove(final Square square, final Square[][] board) {
        return (super.isValidMove(square, board) && kingMoves(square, board));
    }
    
    // Specific movement logic for the king
    private boolean kingMoves(final Square square,  final Square[][] board) {
        boolean valid = false;
        
        // check to see if king is only moving one square.
        if ((Math.abs(Board.getSelectedSquare().getXPos() - square.getXPos()) == 1) 
                && (Math.abs(Board.getSelectedSquare().getYPos() - square.getYPos()) == 0)) {
            valid = true;
        } else if ((Math.abs(Board.getSelectedSquare().getXPos() - square.getXPos()) == 0) 
                && (Math.abs(Board.getSelectedSquare().getYPos() - square.getYPos()) == 1)) {
            valid = true;
        } else if ((Math.abs(Board.getSelectedSquare().getXPos() - square.getXPos()) == 1) 
                && (Math.abs(Board.getSelectedSquare().getYPos() - square.getYPos()) == 1)) {
            valid = true;
        }
        return valid;
    }
    
    /**
     * Returns the image of the king.
     * @return king image as an ImageIcon.
     */
    public ImageIcon getImage() {
        return image;
    }

}
