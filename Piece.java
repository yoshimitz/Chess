package ca.bcit.comp2526.a2b;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Abstract chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public abstract class Piece implements Serializable {
   
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 7183283137307215717L;
    
    /**
     * Player the piece belongs to.
     */
    protected Player player;
    
    /**
     * Sets up the piece with its player.
     * @param player Player the piece belongs to.
     */
    public Piece(final Player player) {
        this.player = player;
    }
    
    /**
     * Returns the image of the piece.
     * @return image of piece as an ImageIcon
     */
    public abstract ImageIcon getImage();
    
    /**
     * Moves the piece from the selected square to the given square.
     * @param square Square to move piece to.
     */
    public void move(final Square square) {
        if (square.getPiece() == null || Board.getSelectedSquare().getPiece().player.getid() 
                != square.getPiece().player.getid()) {
            square.setPiece(this);
            Board.getSelectedSquare().setPiece(null);
        }
    }
    
    /**
     * Determines if a move to a square is valid.
     * @param square Square to check movement to.
     * @return True if valid square to move to, false otherwise.
     */
    public boolean isValidMove(final Square square, final Square[][] board) {
        boolean turn = this.getPlayer().isTurn();
        
        
        /* Checks if a previous square has been selected, 
        whether that selected square has a piece, that it's
        not trying to move to itself and that it's the player's turn
        */
        return (Square.isSelected() && Board.getSelectedSquare().getPiece() != null 
                && Board.getSelectedSquare() != square && turn);
    }
    
    /**
     * Returns the player the piece belongs to.
     * @return player as a Player.
     */
    public Player getPlayer() {
        return player;
    }
}
