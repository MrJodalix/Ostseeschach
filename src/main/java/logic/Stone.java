package logic;


import static logic.Movement.*;

/**
 * an Enum for better demonstrating the game Field
 *
 * @author Joshua-Scott Schöttke
 */
public enum Stone {
    MEER (0, new Movement[] { }, 0),
    HERZMUSCHEL1 (2, new Movement[] { NE, NW },1),
    HERZMUSCHEL2 (2, new Movement[] { SE, SW },2),
    MOEWE1 (4, new Movement[] { N, E, S, W },1),
    MOEWE2 (4, new Movement[] { N, E, S, W },2),
    SEESTERN1 (5, new Movement[] { N, NE, SE, SW, NW },1),
    SEESTERN2 (5, new Movement[] { NE, SE, S, SW, NW },2),
    ROBBE1 (8, new Movement[] { SPNE, SPEN, SPES, SPSE, SPSW, SPWS, SPWN, SPNW },1),
    ROBBE2 (8, new Movement[] { SPNE, SPEN, SPES, SPSE, SPSW, SPWS, SPWN, SPNW },2);


    /**
     * the value of the stone
     */
    private final int value;

    /**
     * the movement of the stone
     */
    private final Movement[] move;

    /**
     * the player
     */
    private final int player;

    /**
     * construct a stone with a value and a suit
     *
     * @param value value of the stone
     */
    Stone(int value, Movement[] move, int player) {
        this.value = value;
        this.move = move;
        this.player = player;
    }

    /**
     * gets the value of the stone
     *
     * @return the value of the stone
     */
    public int getValue() {
        return value;
    }

    /**
     * checks whether the other stone has the same value
     *
     * @param other stone to compare with
     * @return true, if the other stone has the same value, false otherwise
     */
    public boolean hasSameValue(Stone other) {
        if (other != null){
            return this.value == other.value;
        }
        return false;
    }

    /**
     * checks whether the other stone has the same value
     *
     * @param value to compare with
     * @return true, if this stone has the given value, false otherwise
     */
    public boolean hasSameValue(int value) {
        return this.value == value;
    }

    /**
     * gets the move of the stove
     * @return a Movementarray with all rule movements
     */
    public Movement[] getMove(){
        return move;
    }

    /**
     * gets the player of the stone
     * @return 1 for human, 2 for ai, 0 for water
     */
    public int getPlayer(){
        return player;
    }
}
