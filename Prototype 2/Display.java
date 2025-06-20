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
        public Display(int scaleFactor, Level level)
        {
            this.scaleFactor = scaleFactor;
            this.level = level;

            spawnCharacter();

            level.getCollider().getWalls().
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
            for(Path wall: level.getCollider().getWalls().toList())
            {
                drawWall(graphic, wall);
            }

            displayEnds(graphic);
        }
        public void drawWall(Graphics graphic, Path wall)
        // Uses logic to determine rectangle parameters and then draws the rectangle
        {
            int x, y, width, height;

            if(wall.getType() == Path.Type.HORIZONTAL)
            {
                x = wall.getCol() * scaleFactor;
                y = -wall.getRow() * scaleFactor;
                width = scaleFactor + ((scaleFactor-1)*scaleFactor)/scaleFactor;
                height = ((scaleFactor-1)*scaleFactor)/scaleFactor;
            }
            else
            {
                x = wall.getCol() * scaleFactor;
                y = -wall.getRow() * scaleFactor;
                width = ((scaleFactor-1)*scaleFactor)/scaleFactor;
                height = scaleFactor + ((scaleFactor-1)*scaleFactor)/scaleFactor;
            }

            graphic.fillRect(x, y, width, height);
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
        public void spawnCharacter()
        {
            int x = (level.getMaze().getStart().getX() * (int)scaleFactor) + (int)(scaleFactor/2 - scaleFactor/8);
            int y = (level.getMaze().getStart().getY() * (int)scaleFactor) + (int)(scaleFactor/2 - scaleFactor/8);

            level.getPlayer().setPos(new Point(x, y));
        }
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
