package ca.bcit.comp2526.a2b;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * Chess board which holds all the squares.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Board extends JPanel implements Serializable {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -3683510830754653162L;

    /**
     * Number of squares in a row of the board.
     */
    public final int numSquares = 8;
    
    // length and width of board
    private final int size = 800;
    
    // array of squares on the board
    private Square[][] squares = new Square[numSquares][numSquares];
    
    // currently selected square
    private static Square selectedSquare;
    
    // Dimension of the board
    private Dimension boardSize = new Dimension(size, size);
    
    // Player 1
    private Player player1 = new Player(1);
    
    // Player 2
    private Player player2 = new Player(2);
    
    /**
     * Sets up the board with the the correct colour squares and pieces.
     */
    public Board() {
        int color = 0;
        setLayout(new GridLayout(numSquares, numSquares));
        setPreferredSize(boardSize);
        
        for (int i = 0; i < numSquares; i++) {
            for (int j = 0; j < numSquares; j++) {
                if (color == -1) {
                    color = 1;
                } else {
                    color = -1;
                }
                squares[i][j] = new Square(color, j, i);
                add(squares[i][j]);
                squares[i][j].addMouseListener(new ChessListener());
            }
            color = color * -1;
        }
        
        setUpGame();
    }
    
    /**
     * Sets up the starting position of pieces on the board.
     */
    private void setUpGame() {
        // Sets up player 1's side of the board.
        squares[0][0].setPiece(new Rook(player1));
        squares[0][1].setPiece(new Knight(player1));
        squares[0][2].setPiece(new Bishop(player1));
        squares[0][3].setPiece(new Queen(player1));
        squares[0][4].setPiece(new King(player1));
        squares[0][5].setPiece(new Bishop(player1));
        squares[0][6].setPiece(new Knight(player1));
        squares[0][7].setPiece(new Rook(player1));
        
        for (int i = 0; i < numSquares; i++) {
            squares[1][i].setPiece(new Pawn(player1));
        }
        
        // Sets up player 2's side of the board.
        squares[7][0].setPiece(new Rook(player2));
        squares[7][1].setPiece(new Knight(player2));
        squares[7][2].setPiece(new Bishop(player2));
        squares[7][4].setPiece(new Queen(player2));
        squares[7][3].setPiece(new King(player2));
        squares[7][5].setPiece(new Bishop(player2));
        squares[7][6].setPiece(new Knight(player2));
        squares[7][7].setPiece(new Rook(player2));
        
        for (int i = 0; i < numSquares; i++) {
            squares[6][i].setPiece(new Pawn(player2));
        }
        
    }


    /**
     * Returns the currently selected square.
     * @return selectedSquare as a Square.
     */
    public static Square getSelectedSquare() {
        return selectedSquare;
    }


    /**
     * Sets the currently selected square.
     * @param selectedSquare square that has been selected
     */
    public static void setSelectedSquare(final Square selectedSquare) {
        Board.selectedSquare = selectedSquare;
    }
    
    
    
    // Listener for the squares
    private class ChessListener implements MouseListener, Serializable {
        
        /**
         * Serial ID.
         */
        private static final long serialVersionUID = -9014325661340962037L;

        /**
         * Listens for a mouse click, if no square is selected, select the square clicked.
         * If a square is selected and it's a valid move, move the piece from the 
         * previously selected square to the clicked on square. Else, deselect the square.
         * @param ex mouseEvent to listen for.
         */
        @Override
        public void mouseClicked(final MouseEvent ex) {
            Square square = (Square)ex.getSource();
            
            
            // if there's no selected square.
            if (!Square.isSelected() && square.getPiece() != null) {
                Board.setSelectedSquare(square);
                Square.setSelected(true);
                square.setBackground(Color.YELLOW);
                Board.getSelectedSquare().repaint();
            // if a square has been selected and the clicked square is valid to move to             
            } else if (Square.isSelected() 
                    && Board.getSelectedSquare().getPiece().isValidMove(square, squares)) {
                Board.getSelectedSquare().getPiece().move(square);
                player1.setTurn(!player1.isTurn());
                player2.setTurn(!player2.isTurn());
                Square.setSelected(false);
                Board.getSelectedSquare().setBackground(Board.getSelectedSquare().getSquareColor());
                square.repaint();
                Board.getSelectedSquare().repaint();
            } else if (Board.getSelectedSquare() == square) {
                Square.setSelected(false);
                Board.getSelectedSquare().setBackground(Board.getSelectedSquare().getSquareColor());
                Board.getSelectedSquare().repaint();
                Board.setSelectedSquare(null);
            } else if (Board.getSelectedSquare() != null) {
                Square.setSelected(false);
                Board.getSelectedSquare().setBackground(Board.getSelectedSquare().getSquareColor());
                Board.getSelectedSquare().repaint();
                Board.setSelectedSquare(null);
            }
        }
        
        /**
         * Empty interface method to satisfy contract.
         * @param ex unused
         */
        @Override
        public void mousePressed(final MouseEvent ex) {
            // TODO Auto-generated method stub        
        }
        
        /**
         * Empty interface method to satisfy contract.
         * @param ex unused
         */
        @Override
        public void mouseReleased(final MouseEvent ex) {
            // TODO Auto-generated method stub
            
        }

        /**
         * Empty interface method to satisfy contract.
         * @param ex unused
         */
        @Override
        public void mouseEntered(final MouseEvent ex) {
            // TODO Auto-generated method stub
            
        }
        
        /**
         * Empty interface method to satisfy contract.
         * @param ex unused
         */
        @Override
        public void mouseExited(final MouseEvent ex) {
            // TODO Auto-generated method stub
            
        }
        
    }


}
