package gui.tile;

import board.piece.EmptyPiece;
import board.piece.Piece;
import gui.Drawable;

import java.awt.*;

/**
 * The abstract implementation of a tile. This will be drawn upon the Board.
 */
public abstract class Tile implements Drawable {

    /** the tile number. Default value is -1. Every tile get's its own number from 0 to 80 */
    private int identifier = -1;

    /** the rectangle containing the tile. Upper left corner of the tile is the draw point and width and height the
     *  dimension. */
    Rectangle bounds;

    /** the piece on that tile. possible NoPiece */
    private Piece piece;

    /** Creates a new Tile of the color <code>isWhite</code>. */
    Tile (int identifier, Piece piece, int posX, int posY, int length) {
        bounds = new Rectangle(posX, posY, length, length);
        this.identifier = identifier;
        this.piece = piece;
    }


    /** Returns the number of the tile */
    public int getIdentifier () {
        return identifier;
    }

    /** Returns true, if it is an white tile. */
    public abstract boolean isWhite ();

    public Piece getPiece () {
        return piece;
    }

    /** overrieds the piece with an empty piece and returns the old piece; */
    public Piece removePiece () {
        Piece oldPiece = piece;
        piece = new EmptyPiece();
        return oldPiece;
    }


    /** the bounds of the tile. */
    public Rectangle getBounds () {
        return bounds;
    }

    /** Translates the tile with deltaX in x direction and deltaY in y direction */
    public void move (int deltaX, int deltaY) {
        bounds.translate(deltaX, deltaY);
    }

    /** Sets the absolute Location of the Tile. */
    public void setLocation (int x, int y) {
        bounds.setLocation(x, y);
    }

    /** Scales the Tile with the defined factor. It is scaled from the upper left corner. */
    public void scale (float scaleFactor) {
        bounds.setSize((int) (bounds.width * scaleFactor), (int) (bounds.height * scaleFactor));
    }

    /** Changes the length of the tile. The x and y position remain the same. */
    public void setDimension (int length) {
        bounds.setSize(length, length);
    }
}
