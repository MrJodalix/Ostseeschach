package logic;

import javafx.geometry.Pos;

public enum Movement {
    N(new Position( 0, -1 )),
    NE(new Position( 1, -1 )),
    E(new Position( 1, 0 )),
    SE(new Position( 1, 1 )),
    S(new Position( 0, 1 )),
    SW(new Position( -1, 1 )),
    W(new Position( -1, 0 )),
    NW(new Position( -1, -1 )),

    SPNE(new Position( 1, -2 )),
    SPEN(new Position( 2, -1 )),
    SPES(new Position( 2, 1 )),
    SPSE(new Position( 1, 2 )),
    SPSW(new Position( -1, 2 )),
    SPWS(new Position( -2, 1 )),
    SPWN(new Position( -2, -1 )),
    SPNW(new Position( -1, -2 ));

    /**
     * the movement of all Stones in Positions
     */
    private final Position move;

    /**
     * construct a Movement with the positions
     *
     * @param move position of the Movement
     */
    Movement(Position move){
        this.move = move;
    }


    /**
     * gets the movement of the stone
     *
     * @return the movement of the stone
     */
    public Position getMove() {
        return move;
    }
}
