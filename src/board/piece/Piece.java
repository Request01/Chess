package board.piece;

import gui.Drawable;

/**
 *  The superclass of every piece.
 */
public abstract class Piece implements Drawable {

    /** true, if the piece belongs to the white player. */
    private boolean isWhite;

    Piece (boolean isWhite) {
        this.isWhite = isWhite;
    }

    /** Returns true, if the pieces belongs to white. false, if it is a black piece. */
    public boolean isWhite () {
        return isWhite;
    }

    /** returns the approximate value of that piece. e.g. rook five */
    public abstract float getValue ();

    /** returns the char representing that piece. if it is an empty piece, it will return ' '.
     *  Whites pieces are written with capital letters and blacks with lower letters. */
    public abstract char getChar ();

    @Override
    public String toString () {
        return "Piece: " + getChar();
    }
}
