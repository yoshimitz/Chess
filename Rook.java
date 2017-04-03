package ca.bcit.comp2526.a2b;

import javax.swing.ImageIcon;

/**
 * Rook chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Rook extends Piece {
  
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 5341060939577124077L;
    
    // Holds the image of the rook.
    private ImageIcon image;
    
    /**
     * Sets up the rook object with its player and image.
     * @param player Player the rook belongs to.
     */
    public Rook(final Player player) {
        super(player);
        if (player.getid() == 1) {
            image = new ImageIcon("resources/Image/BlackRook.png");
        } else {
            image = new ImageIcon("resources/Image/WhiteRook.png");
        }
    }
    
    /**
     * Determines if a move is valid.
     * @param square square the player is trying to move to.
     * @return true if valid move, false otherwise.
     */
    public boolean isValidMove(final Square square,  final Square[][] board) {
        return (super.isValidMove(square, board) && rookMoves(square, board));
    }
    
    // Specific movement logic for the rook.
    private boolean rookMoves(final Square square, final Square[][] board) {
        int selectedX = Board.getSelectedSquare().getXPos();
        int selectedY = Board.getSelectedSquare().getYPos();
        int movetoX = square.getXPos();
        int movetoY = square.getYPos();
        
        
        if (selectedX - movetoX == 0) {
            // Movement up the board
            if (selectedY > movetoY) {
                for (int i = movetoY + 1; i < selectedY; i++) {
                    if (board[i][selectedX].getPiece() != null) {
                        return false;
                    }
                }
                // Movement down the board
            } else {
                for (int i = movetoY - 1; i > selectedY; i--) {
                    if (board[i][selectedX].getPiece() != null) {
                        return false;
                    }
                }
            }
        } else if (selectedY - movetoY == 0) {
            // Movement to the right
            if (selectedX > movetoX) {
                for (int i = movetoX + 1; i < selectedX; i++) {
                    if (board[selectedY][i].getPiece() != null) {
                        return false;
                    }
                }
                // Movement to the left
            } else {
                for (int i = movetoX - 1; i > selectedX; i--) {
                    if (board[selectedY][i].getPiece() != null) {
                        return false;
                    }
                }
            }
        } else if (selectedX - movetoX != 0 && selectedY - movetoY != 0) {
            return false;
        }
       
        return true;
    }

    /**
     * Returns the image of the rook.
     * @return rook image as an ImageIcon.
     */
    public ImageIcon getImage() {
        return image;
    }

}
