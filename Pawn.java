package ca.bcit.comp2526.a2b;

import javax.swing.ImageIcon;

/**
 * Pawn chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Pawn extends Piece {
    
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 5767471398066914919L;
    
    // Holds the image of the pawn.
    private ImageIcon image;

    /**
     * Sets up the pawn object with its player and image.
     * @param player Player the pawn belongs to.
     */
    public Pawn(final Player player) {
        super(player);
        if (player.getid() == 1) {
            image = new ImageIcon("resources/Image/BlackPawn.png");
        } else {
            image = new ImageIcon("resources/Image/WhitePawn.png");
        }
    }
    
    /**
     * Determines if a move is valid.
     * @param square square the player is trying to move to.
     * @return true if valid move, false otherwise.
     */
    public boolean isValidMove(final Square square,  final Square[][] board) {
        return (super.isValidMove(square, board) && pawnMoves(square, board));
    }
    
    private boolean pawnMoves(final Square square,  final Square[][] board) {
        int selectedX = Board.getSelectedSquare().getXPos();
        int selectedY = Board.getSelectedSquare().getYPos();
        int movetoX = square.getXPos();
        int movetoY = square.getYPos();
        
        if (selectedX - movetoX != 0) {
            return false;
        }
        
        if (player.getid() == 1) {
            if (selectedY == 1) {
                if (movetoY != 2 && movetoY != 3) {
                    return false;
                } else if (movetoY == 3) {
                    if (board[2][selectedX].getPiece() != null) {
                        return false;
                    }
                }
            } else {
                if ((selectedY + 1) != movetoY) {
                    return false;
                }
            }
        } else {
            if (selectedY == 6) {
                if (movetoY != 5 && movetoY != 4) {
                    return false;
                } else if (movetoY == 4) {
                    if (board[5][selectedX].getPiece() != null) {
                        return false;
                    }
                }
            } else {
                if ((selectedY - 1) != movetoY) {
                    return false;
                }
            }
        }
        
        
        
        return true;
    }
    
    /**
     * Returns the image of the pawn.
     * @return pawn image as an ImageIcon.
     */
    public ImageIcon getImage() {
        return image;
    }


}
