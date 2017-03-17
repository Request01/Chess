package gui;

import board.piece.EmptyPiece;
import gui.tile.BlackTile;
import gui.tile.Tile;
import gui.tile.WhiteTile;

import java.awt.*;

/**
 * This represents gui framework of the board. This is where the tiles are stored.
 * (0|0) is a1. (0|1) is a2. (1|0) is b1 etc.
 */
public class Board implements Drawable {

    /** the width of the Board */
    public static final int WIDTH = 10;

    /** the height of the board */
    public static final int HEIGHT = 8;

    /** the color seen in the gaps between tiles. */
    public static final Color BACKGROUND_COLOR = new Color(0, 0, 0);

    /** the data structure containing the tiles */
    private Tile[][] tiles;

    /** the bounds of the board */
    private Rectangle bounds;

    /** the gap between to tiles. */
    private int gap;
    /** the length of a tile. (it's width and height */
    private int length;
    /** the distance between the frame and the right bound of the board. */
    private int gapToFrameRight;
    /** the distance between the frame and the upper bound of the board. */
    private int gapToFrameTop;
    /** the outline thickness of the board. */
    private int outline;


    /** A board with <code>Board.WIDTH</code> columns and <code>Board.HEIGHT</code> rows.
     *  The length indicates how big tile should be and the gap the distance between two tiles.
     *  @param length the width and height of a single tile.
     *  @param gap the distance between two tiles.
     *  @param gapToFrameRight the x distance between the first tile and the window
     *  @param gapToFrameTop the y distance between the fist tile and the window
     */
    public Board (int length, int gap, int gapToFrameRight, int gapToFrameTop, int outline) {
        bounds = new Rectangle(gapToFrameRight, gapToFrameTop,
                outline + WIDTH * length + (WIDTH - 1) * gap + outline,
                outline + HEIGHT * length + (HEIGHT - 1) * gap+ outline);

        this.length = length;
        this.gap = gap;
        this.gapToFrameRight = gapToFrameRight;
        this.gapToFrameTop = gapToFrameTop;
        this.outline = outline;

        // fill the tiles.
        tiles = new Tile[WIDTH][HEIGHT];
        setupStartingPosition();
        printBoard();
    }

    /** Sets up the starting position.
     *  <b>This call will overwrite the current board position. </b>*/
    public void setupStartingPosition () {
        boolean isWhite = false;
        int id = 0;

        for (int col = 0; col < HEIGHT; col++) {
            for (int row = 0; row < WIDTH; row++) {
                int posX = gapToFrameRight + outline + row * (length + gap);
                int posY = gapToFrameTop + outline + (HEIGHT - col - 1) * (length + gap);

                // TODO: filling the tiles with the correct pieces
                if (isWhite)
                    tiles[row][col] = new WhiteTile(id, new EmptyPiece(), posX, posY, length);
                else
                    tiles[row][col] = new BlackTile(id, new EmptyPiece(), posX, posY, length);

                // debug: what is created:
                // System.out.println(tiles[row][col].getPiece().getChar() + " (" + row + "|" + col + "); id: " + id + " [" + isWhite + "]");

                isWhite = !isWhite;
                id = id + 1;
            }
            isWhite = !isWhite;
        }
    }


    /** Prints the board to the console */
    public void printBoard () {
        System.out.println();

        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < HEIGHT; col++) {
                System.out.print(tiles[row][col].getPiece().getChar());
                if (col != HEIGHT - 1)
                    System.out.print(',');
            }
            System.out.println(";");
        }
    }

    @Override
    public String toString () {
        String ret = "{";
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < HEIGHT; col++) {
                ret = ret + tiles[row][col].getPiece().getChar();
                if (col + 1 < HEIGHT)
                    ret = ret + ",";
            }
            ret = ret + ";";
        }
        return ret + "}";
    }

    @Override
    public void draw (Graphics2D g) {

        // background
        g.setColor(BACKGROUND_COLOR);
        g.fill(bounds);

        // tiles
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < HEIGHT; col++) {
                tiles[row][col].draw(g);
            }
        }
    }
}
