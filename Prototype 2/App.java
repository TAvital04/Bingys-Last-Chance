// Imports
import javax.swing.JFrame;

// Class
public class App
{
    // Declare variables
        private static final int GRID_SIZE = 16;
        private static final int WINDOW_SIZE = GRID_SIZE * 50;

        private static JFrame window;

    // Main
        public static void main(String[] args)
        {
            // Create the window
            window = new JFrame("Bingy's Last Prototype");

            // Configure the window
            window.setVisible(true);
            window.setSize(WINDOW_SIZE, WINDOW_SIZE);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(WINDOW_SIZE + (int)(WINDOW_SIZE * .05), WINDOW_SIZE + (int)(WINDOW_SIZE * .05));

            // Start the display
            Display display = new Display(WINDOW_SIZE, 1);
            window.add(display);
        }
}