package ca.bcit.comp2526.a2b;

import javax.swing.ImageIcon;

/**
 * Bishop chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Bishop extends Piece {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -1662788686117872739L;
    
    // Holds the image of the bishop.
    private ImageIcon image;
    
    /**
     * Sets up the rook object with its player and image.
     * @param player Player the rook belongs to.
     */
    public Bishop(final Player player) {
        super(player);
        if (player.getid() == 1) {
            image = new ImageIcon("resources/Image/BlackBishop.png");
        } else {
            image = new ImageIcon("resources/Image/WhiteBishop.png");
        }
    }
    
    /**
     * Determines if a move is valid.
     * @param square the square the player is trying to move to.
     * @return true if valid move, false otherwise.
     */
    public boolean isValidMove(final Square square,  final Square[][] board) {
        return (super.isValidMove(square, board) && bishopMoves(square, board));
    }
    
    // specific movement logic for the bishop movement rules.
    private boolean bishopMoves(final Square square,  final Square[][] board) {
        int selectedX = Board.getSelectedSquare().getXPos();
        int selectedY = Board.getSelectedSquare().getYPos();
        int movetoX = square.getXPos();
        int movetoY = square.getYPos();
        
        // checks if bishop is moving diagonally.
        if (Math.abs(selectedX - movetoX) != Math.abs(selectedY - movetoY)) {
            return false;
        }
        
        // checks for pieces in the direction moved in
        if (selectedX > movetoX && selectedY > movetoY) {
            for (int i = movetoX + 1, j = movetoY + 1; i < selectedX; i++, j++) {
                if (board[j][i].getPiece() != null) {
                    return false;
                } 
            }
        } else if (selectedX > movetoX && selectedY < movetoY) {
            for (int i = movetoX + 1, j = movetoY - 1; i < selectedX; i++, j--) {
                if (board[j][i].getPiece() != null) {
                    return false;
                } 
            }
        } else if (selectedX < movetoX && selectedY > movetoY) {
            for (int i = movetoX - 1, j = movetoY + 1; i > selectedX; i--, j++) {
                if (board[j][i].getPiece() != null) {
                    return false;
                } 
            }
        } else {
            for (int i = movetoX - 1, j = movetoY - 1; i > selectedX; i--, j--) {
                if (board[j][i].getPiece() != null) {
                    return false;
                } 
            }
        }
        
        
        return true;
    }
    
    /**
     * Returns the image of the bishop.
     * @return image as an ImageIcon
     */
    public ImageIcon getImage() {
        return image;
    }

}
