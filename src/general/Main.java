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
        long lastUpdate = System.currentTimeMillis();
        long sleepTime = (long) (1000/framesPerSecond); // if drawn instantaneously

        // ends, when the window is closed.
        while (true) {

            gameWindow.draw();
            // other update calls

            // and sleep
            long currentUpdate = System.currentTimeMillis();
            long diff = sleepTime - (currentUpdate - lastUpdate);

            if (diff > 0) {
                try {
                    Thread.sleep(diff);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            lastUpdate = currentUpdate;
        }
    }

    public static Main getMain () {
        return main;
    }
}
