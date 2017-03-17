package general;

import gui.GameWindow;

/**
 * The main class contains the initialization and provides access between the parts of the program.
 */
public class Main {

    private static Main main;
    private GameWindow gameWindow;

    /** main method. static initializer */
    public static void main(String[] args) {
        main = new Main();
        main.run(60f);
    }

    private Main () {
        gameWindow = new GameWindow();
        gameWindow.setVisible(true);
        gameWindow.buffering();
    }

    private void run(float framesPerSecond) {

        // ends, when the window is closed.
        while (true) {
            gameWindow.draw();
            // update other stuff
        }
    }

    public static Main getMain () {
        return main;
    }
}
