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

            displayGrid(graphic);
        }

        public void displayMaze(Graphics graphic)
        /*
         * -Iterates over the keys of the hashmap
         *      and draws a line between a key and it's value pair
         */
        {
<<<<<<< HEAD
            for(Wall wall: level.getCollider().getWalls().toList())
            {
                drawWall(graphic, wall);
=======
            // for(Point entry: level.getMaze().getMap().keySet())
            // {
            //     if(level.getMaze().getMap().get(entry) != null)
            //     {
            //         // Draw the line
            //         drawLine(graphic, entry, level.getMaze().getMap().get(entry));
                    
            //     }
            // }

            graphic.setColor(Color.RED);
            for(Path step: level.getPath())
            {
                graphic.fillRect(step.getX(), step.getY(), step.getWidth() - 10, step.getHeight()-10);
>>>>>>> b7d84030c77db8e6412bdae4aeb96db341306ea9
            }

            displayEnds(graphic);
        }
        public void drawWall(Graphics graphic, Wall wall)
        // Uses logic to determine rectangle parameters and then draws the rectangle
        {
            int x, y, width, height;

            if(wall.getType() == Wall.Type.HORIZONTAL)
            {
                x = wall.getCol() * scaleFactor + scaleFactor/4;
                y = -wall.getRow() * scaleFactor + scaleFactor/4;
                width = scaleFactor + scaleFactor/2;
                height = scaleFactor/2;
            }
            else
            {
                x = wall.getCol() * scaleFactor + scaleFactor/4;
                y = -wall.getRow() * scaleFactor + scaleFactor/4;
                width = scaleFactor/2;
                height = scaleFactor + scaleFactor/2;
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
        public void displayCharacter(Graphics graphic)
        /*
         * -Displays the character on the screen
         *      -does not handle movement
         *      -does not handle collisions
         */
        {
            int diameter = (int)(scaleFactor/4);

            graphic.setColor(Color.BLUE);

            graphic.fillOval(level.getPlayer().getX() * scaleFactor + (int)(scaleFactor/2 - scaleFactor/8), level.getPlayer().getY() * scaleFactor + (int)(scaleFactor/2 - scaleFactor/8), diameter, diameter);
        }

    public void displayGrid(Graphics graphic)
    {
        for(int i = 0; i < (int)(Math.pow(2, level.getOrder() + 1)); i++)
        {
            graphic.drawLine(0, i * 100, scaleFactor * (int)(Math.pow(2, level.getOrder())), i * 100);
            graphic.drawLine(i * 100, 0, i * 100, scaleFactor * (int)(Math.pow(2, level.getOrder())));
        }

        graphic.setColor(Color.RED);
        for(int i = 0; i < (int)(Math.pow(2, level.getOrder() + 1)); i++)
        {
            graphic.drawLine(0, i * scaleFactor, scaleFactor * (int)(Math.pow(2, level.getOrder())), i * scaleFactor);
            graphic.drawLine(i * scaleFactor, 0, i * scaleFactor, scaleFactor * (int)(Math.pow(2, level.getOrder())));
        }
    }
}
