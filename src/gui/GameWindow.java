package gui;

import io.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * The windows, where the game is represented.
 */
public class GameWindow extends JFrame {

    private Board board;

    /** Buffering: two layers */
    private BufferStrategy buffer;

    /** The Color of the Background */
    private static final Color BACKGROUND_COLOR = new Color(21, 0, 57);

    /** the maximum area of the window in px. The task bar does not count for that.  */
    public static final int WIDTH = getWindowWidth();

    /** the maximum area of the window in px. The task bar does not count for that. */
    public static final int HEIGHT = getWindowHeight();

    /**
     * Creates a new GameWindow.
     */
    public GameWindow () {
        super("Chess Variant");
        initializeGameWindow(WIDTH, HEIGHT);

        board = new Board(80, 3, 20, 40, 16, 3);
    }

    private void initializeGameWindow (int width, int height) {
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(55, 24, 70));
        setForeground(new Color(180, 176, 228));
        setExtendedState(Frame.MAXIMIZED_BOTH);

        BufferedImage gameIcon = ImageLoader.load("gameIcon.png");
        if (gameIcon != null)
            setIconImage(gameIcon);
    }

    /** Creates a buffer strategy and saves it for the draw process later */
    public void buffering () {
        createBufferStrategy(2);
        buffer = getBufferStrategy();
    }

    private static int getWindowWidth () {
        return (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();
    }

    private static int getWindowHeight () {
        return (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
    }

    /** Gets the Graphics2D object, sets the rendering hints, draws the backgrounds, calls the screen to draw their
     *  part and finally disposes the graphics object. */
    public void draw() {
        Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

        // set some properties for the graphics object
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, getWindowWidth(), getWindowHeight());

        board.draw(g);

        g.dispose();
        buffer.show();
    }
}
