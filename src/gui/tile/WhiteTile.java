package gui.tile;

import board.piece.Piece;

import java.awt.*;

/** subclass of tile: just a white tile.
 *  (but there is still no information, if there is a piece on that tile!) */
public class WhiteTile extends Tile {

    /** The background color of a white tile. */
    public static final Color BACKGROUND_COLOR_WHITE = new Color(214, 202, 118);

    /**
     * Creates a new Tile of the color <code>isWhite</code>.
     *
     * @param identifier the unique number
     * @param piece the piece on that tile
     * @param posX the x position on the screen
     * @param posY the y position on the screen
     * @param length the width of the tile
     */
    public WhiteTile (int identifier, Piece piece, int posX, int posY, int length) {
        super(identifier, piece, posX, posY, length);
    }

    @Override
    public boolean isWhite () {
        return true;
    }

    @Override
    public String toString () {
        return "WhiteTile: " + getIdentifier();
    }

    @Override
    public void draw (Graphics2D g) {
        // the tile
        g.setColor(BACKGROUND_COLOR_WHITE);
        g.fill(getBounds());

        g.setColor(Color.red);
        g.drawString("" + getIdentifier(), (int) getBounds().getCenterX() - 6, (int) getBounds().getCenterY() + 5);

        // and the piece
        getPiece().draw(g);
    }
}