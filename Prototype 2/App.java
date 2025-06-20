// Imports
import javax.swing.JFrame;
import javax.swing.Timer;

// Class
public class App
{
    // Declare variables
        private static JFrame window;
        private static int scaleFactor;

        private static final int GRID_SIZE = 16;
        private static final int WINDOW_SIZE = (GRID_SIZE * 50) + (int)(GRID_SIZE * 50 * .05);

        private static Controller controller;

        private static Level level;
        public static int order;

        private static Display display;

        private static Timer timer;

    // Main
        public static void main(String[] args) {
            window = new JFrame("Bingy's Last Prototype");
            order = 3;
            scaleFactor = WINDOW_SIZE / (int)(Math.pow(2, order));
            
            controller = new Controller();

            level = new Level(order, controller);

            display = new Display(scaleFactor, level);

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
                display.repaint();
            });
            timer.start();
        }
}