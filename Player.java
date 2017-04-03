package ca.bcit.comp2526.a2b;

import java.io.Serializable;

/**
 * Player of chess.
 * @author Yashar Nesvaderani
 * @version 1.0
 */
public class Player implements Serializable {
    
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -5594727783258461594L;

    // integer id
    private int id;
    
    // determines if it's the players turn or not
    private boolean isTurn;
    
    /**
     * Sets up a player with its id.
     * @param id of the player.
     */
    public Player(int id) {
        this.id = id;
        
        if (id != 1) {
            isTurn = true;
        }
    }
    
    /**
     * Returns the id of the player.
     * @return id as an integer.
     */
    public int getid() {
        return id;
    }
    
    /**
     * Returns true if it's the player's turn, false otherwise.
     * @return isTurn as a boolean
     */
    public boolean isTurn() {
        return isTurn;
    }
    
    /**
     * Sets the turn to be true or false
     * @param turn The value to set the turn to.
     */
    public void setTurn(boolean turn) {
        isTurn = turn;
    }

}
