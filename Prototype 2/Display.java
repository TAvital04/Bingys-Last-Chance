import javax.swing.JPanel;
import java.awt.*;

public class Display extends JPanel
{
    // Declare variables
        private double scaleFactor;

        private Maze maze;

    // Constructors
        public Display(int windowSize, int order)
        {
            this.scaleFactor = windowSize / (Math.pow(2, order));

            this.maze = new Maze(new HilbertCurve(new Point(0, 0), order));
        }

        @Override
        public void paintComponent(Graphics graphic)
        {
            // Super call
            super.paintComponent(graphic);
            setBackground(Color.BLACK);

            // Draw
            displayMaze(graphic);

            displayEnds(graphic);
        }

    // Functions
        public void displayMaze(Graphics graphic)
        // Iterates over the keys of the hashmap
            // and draws a line between a key and it's value pair
        {
            for(GridPoint entry: maze.getMaze().keySet())
            {
                if(maze.getMaze().get(entry) != null)
                {
                    // Draw the line
                    drawLine(graphic, entry, maze.getMaze().get(entry));
                }
            }
        }
        public void drawLine(Graphics graphic, GridPoint previous, GridPoint next)
        {
            // Declare variables
            int x = (int)((previous.getX() * scaleFactor) + (scaleFactor/ 2));
            int y = -(int)((previous.getY() * scaleFactor) - (scaleFactor/ 2));
            int toX = (int)((next.getX() * scaleFactor) + (scaleFactor/ 2));
            int toY = -(int)((next.getY() * scaleFactor) - (scaleFactor/ 2));

            Graphics2D g2d = (Graphics2D)graphic;
            g2d.setStroke(new BasicStroke((float)(scaleFactor / 2 + scaleFactor / 3)));
            g2d.setColor(Color.DARK_GRAY);

            // Draw
            g2d.drawLine(x, y, toX, toY);
        }

        public void displayEnds(Graphics graphic)
        {
            // Declare variables
            int diameter = (int)(scaleFactor/4);
            int radius = diameter/2;

            int startX, startY;
            int endX, endY;

            // Start
            graphic.setColor(Color.GREEN);
            startX = (maze.getStart().getX() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            startY = (maze.getStart().getY() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            graphic.fillOval(startX, startY, diameter, diameter);

            // End
            graphic.setColor(Color.RED);
            endX = (maze.getEnd().getX() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            endY = (maze.getEnd().getY() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            graphic.fillOval(endX, endY, diameter, diameter);
        }
}
