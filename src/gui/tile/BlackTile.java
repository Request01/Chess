package gui.tile;

import board.piece.Piece;

import java.awt.*;

/** subclass of tile: it's a black tile
 *  (but there is still no information, if there is a piece on that tile!) */
public class BlackTile extends Tile {

    /** The background color of a black tile. */
    public static final Color BACKGROUND_COLOR_BLACK = new Color (131, 95, 53);

    /**
     * Creates a new Tile of the color <code>isWhite</code>.
     *
     * @param identifier the unique number
     * @param piece the piece on that tile
     * @param posX the x position on the screen
     * @param posY the y position on the screen
     * @param length the width of the tile
     */
    public BlackTile (int identifier, Piece piece, int posX, int posY, int length) {
        super(identifier, piece, posX, posY, length);
    }

    @Override
    public boolean isWhite () {
        return false;
    }

    @Override
    public String toString () {
        return "BlackTile: " + getIdentifier();
    }

    @Override
    public void draw (Graphics2D g) {
        // draws the tile
        g.setColor(BACKGROUND_COLOR_BLACK);
        g.fill(getBounds());

        g.setColor(Color.red);
        g.drawString("" + getIdentifier(), (int) getBounds().getCenterX() - 6, (int) getBounds().getCenterY() + 5);

        // draws the piece on that tile
        getPiece().draw(g);
    }
}