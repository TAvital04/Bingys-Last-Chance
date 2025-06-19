// Imports
import javax.swing.Timer;

import javax.swing.JFrame;

// Class
public class App
{
    // Declare variables
        private static JFrame window;

        private static final int GRID_SIZE = 16;
        private static final int WINDOW_SIZE = (GRID_SIZE * 50) + (int)(GRID_SIZE * 50 * .05);

        private static Timer timer;

        private static Display display;
        private static Controller controller;

        private static Level level;

    // Main
        public static void main(String[] args) {
            window = new JFrame("Bingy's Last Prototype");
            
            controller = new Controller();
            level = new Level(3, controller);

            display = new Display(WINDOW_SIZE, level);

            window.add(display);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(WINDOW_SIZE, WINDOW_SIZE);
            window.setVisible(true);
        
            display.setFocusable(true);
            display.requestFocus();

            display.addKeyListener(controller);
            display.setFocusable(true);

            timer = new Timer(8, e -> {
                level.update();
                //display.repaint();
            });
            timer.start();
        }
}