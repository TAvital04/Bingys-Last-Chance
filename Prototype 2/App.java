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

        private static Display display;
        private static Timer timer;

    // Main
        public static void main(String[] args) {
            window = new JFrame("Bingy's Last Prototype");
        
            display = new Display(WINDOW_SIZE, 2);
            window.add(display);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(WINDOW_SIZE, WINDOW_SIZE);
            window.setVisible(true);
        
            display.setFocusable(true);
            display.requestFocus();

            timer = new Timer(8, e -> {
                display.update();
            });
            timer.start();
        }
}