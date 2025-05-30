import javax.swing.JPanel;
import java.awt.*;

public class Display extends JPanel
/*
 * -Draws all calculations on the screen in a way that is independant of
 *      previous calculations
 */
{
    // Declare variables
        private int scaleFactor;

        private Level level;

    // Constructors
        public Display(int windowSize, Level level)
        {
            scaleFactor = windowSize / (int)(Math.pow(2, level.getOrder()));

            this.level = level;
        }

    // Maze functions
        @Override
        public void paintComponent(Graphics graphic)
        /*
         * -Instantiates the graphics class
         * -Passes the graphic component to all drawing methods
         */
        {
            // Super call
            super.paintComponent(graphic);

            // Draw
            setBackground(Color.BLACK);

            displayMaze(graphic);
            displayCharacter(graphic);
        }

        public void displayMaze(Graphics graphic)
        /*
         * -Iterates over the keys of the hashmap
         *      and draws a line between a key and it's value pair
         */
        {
            for(Point entry: level.getMaze().getMap().keySet())
            {
                if(level.getMaze().getMap().get(entry) != null)
                {
                    // Draw the line
                    drawLine(graphic, entry, level.getMaze().getMap().get(entry));
                }
            }

            displayEnds(graphic);
        }
        public void drawLine(Graphics graphic, Point previous, Point next)
        // Draws a line betweeen two points
        {
            // Declare variables
            int x;
            int y;
            int toX;
            int toY;

            Graphics2D g2d;

            // Start
            x = (int)((previous.getX() * scaleFactor) + (scaleFactor/ 2));
            y = -(int)((previous.getY() * scaleFactor) - (scaleFactor/ 2));
            toX = (int)((next.getX() * scaleFactor) + (scaleFactor/ 2));
            toY = -(int)((next.getY() * scaleFactor) - (scaleFactor/ 2));

            g2d = (Graphics2D)graphic;

            g2d.setStroke(new BasicStroke((float)(scaleFactor / 2 + scaleFactor / 3)));
            g2d.setColor(Color.DARK_GRAY);

            // Draw
            g2d.drawLine(x, y, toX, toY);
            g2d.setStroke(new BasicStroke(1));
        }
        
        public void displayEnds(Graphics graphic)
        /*
         * -Displays the start and end flags on the screen
         *      -does not handle collisions
         */
        {
            // Declare variables
            int startX, startY;
            int endX, endY;

            int diameter;
            int radius;

            // Start
            diameter = (int)(scaleFactor/4);
            radius = diameter/2;

            startX = (level.getMaze().getStart().getX() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            startY = (level.getMaze().getStart().getY() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);

            graphic.setColor(Color.GREEN);
            graphic.fillOval(startX, startY, diameter, diameter);

            // End
            graphic.setColor(Color.RED);
            endX = (level.getMaze().getEnd().getX() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            endY = (level.getMaze().getEnd().getY() * (int)scaleFactor) + (int)(scaleFactor/2 - radius);
            graphic.fillOval(endX, endY, diameter, diameter);
        }

    // Character functions
        public void displayCharacter(Graphics graphic)
        /*
         * -Displays the character on the screen
         *      -does not handle movement
         *      -does not handle collisions
         */
        {
            int diameter = (int)(scaleFactor/4);

            graphic.setColor(Color.BLUE);

            graphic.fillOval(level.getPlayer().getX(), level.getPlayer().getY(), diameter, diameter);
        }
}
