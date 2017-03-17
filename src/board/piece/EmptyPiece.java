package board.piece;

import java.awt.*;

/**
 * no piece.
 */
public class EmptyPiece extends Piece {

    /** creates a new empty piece */
    public EmptyPiece () {
        super(true);
    }

    @Override
    public float getValue () {
        return 0;
    }

    @Override
    public char getChar () {
        return ' ';
    }


    @Override
    public void draw (Graphics2D g) {} // nothing to draw
}
