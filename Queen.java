package ca.bcit.comp2526.a2b;

import javax.swing.ImageIcon;

/**
 * Queen chess piece.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Queen extends Piece {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -6335809580986067515L;
    
    // Holds the image of the queen.
    private ImageIcon image;
    
    /**
     * Sets up the queen object with its player and image.
     * @param player Player the queen belongs to.
     */
    public Queen(final Player player) {
        super(player);
        if (player.getid() == 1) {
            image = new ImageIcon("resources/Image/BlackQueen.png");
        } else {
            image = new ImageIcon("resources/Image/WhiteQueen.png");
        }
    }
    
    /**
     * Determines if a move is valid.
     * @param square square the player is trying to move to.
     * @return true if valid move, false otherwise.
     */
    public boolean isValidMove(final Square square,  final Square[][] board) {
        return (super.isValidMove(square, board) && (rookMoves(square, board) 
                || bishopMoves(square, board)));
    }
    
    private boolean rookMoves(final Square square,  final Square[][] board) {
        int selectedX = Board.getSelectedSquare().getXPos();
        int selectedY = Board.getSelectedSquare().getYPos();
        int movetoX = square.getXPos();
        int movetoY = square.getYPos();
        
        
        if (selectedX - movetoX == 0) {
            if (selectedY > movetoY) {
                for (int i = movetoY + 1; i < selectedY; i++) {
                    if (board[i][selectedX].getPiece() != null) {
                        return false;
                    }
                }
            } else {
                for (int i = movetoY - 1; i > selectedY; i--) {
                    if (board[i][selectedX].getPiece() != null) {
                        return false;
                    }
                }
            }
        } else if (selectedY - movetoY == 0) {
            if (selectedX > movetoX) {
                for (int i = movetoX + 1; i < selectedX; i++) {
                    if (board[selectedY][i].getPiece() != null) {
                        return false;
                    }
                }
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
    
    private boolean bishopMoves(final Square square,  final Square[][] board) {
        int selectedX = Board.getSelectedSquare().getXPos();
        int selectedY = Board.getSelectedSquare().getYPos();
        int movetoX = square.getXPos();
        int movetoY = square.getYPos();
        
        if (Math.abs(selectedX - movetoX) != Math.abs(selectedY - movetoY)) {
            return false;
        }
        
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
     * Returns the image of the queen.
     * @return queen image as an ImageIcon.
     */
    public ImageIcon getImage() {
        return image;
    }

}
