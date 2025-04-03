// Imports
import javax.swing.JPanel;
import java.awt.Graphics;

// Class
public class Display extends JPanel 
{
    // Declare variables
        private int gridSize;
        private int windowSize;
        private int scaleFactor;

        private Graphics graphic;

        private Pen pen;

        private int level;

    // Constructor
        public Display(int gridSize, int windowSize)
        {
            // Instantiate variables
                this.gridSize = gridSize;
                this.windowSize = windowSize;
                this.scaleFactor = windowSize/gridSize;

                this.pen = new Pen(new Coordinates(scaleFactor / 2, windowSize - scaleFactor / 2), Direction.UP);

                level = 5;
        }

    // Drawing Methods
        @Override
        public void paintComponent(Graphics graphic)
        // Instantiates graphic upon startup
        {
            this.graphic = graphic;

            //paintGridLines();
            hilbertCurve(level, Direction.RIGHT);
        }

        public void paintGridLines()
        {
            for(int i = 0; i < gridSize; i++)
            {
                graphic.drawLine(i * scaleFactor, 0, i * scaleFactor, windowSize);
                graphic.drawLine(0, i * scaleFactor, windowSize, i * scaleFactor);
            }
        }

        public void hilbertCurve(int step, Direction direction)
        {
            // Base case
            if(step == 1)
            {
                hilbertBase(direction);
                return;
            }

            // Hilbert curve
            turn(direction);
            hilbertCurve(step - 1, Direction.opposite(direction));
            step();
            turn(Direction.opposite(direction));
            hilbertCurve(step - 1, direction);
            step();
            hilbertCurve(step - 1, direction);
            turn(Direction.opposite(direction));
            step();
            hilbertCurve(step - 1, Direction.opposite(direction));
            turn(direction);
        }
        public void hilbertBase(Direction direction)
        {
            turn(direction);
            step();
            turn(Direction.opposite(direction));
            step();
            turn(Direction.opposite(direction));
            step();
            turn(direction);
        }

        public void step()
        // Draws a line from pen to the given direction with length scaleFactor, then reset pen
        {
            // Declare variables
            int oldX = pen.getPos().getX();
            int oldY = pen.getPos().getY();
            int newX = (oldX + (scaleFactor * Direction.hAxis(pen.getDirection())));
            int newY = (oldY + (scaleFactor * Direction.vAxis(pen.getDirection())));

            // Draw the line
            graphic.drawLine(oldX, oldY, newX, newY);

            // Reset pen
            pen.setPos(new Coordinates(newX, newY));
        }

        public void turn(Direction direction)
        {
            if(direction == Direction.RIGHT)
            {
                pen.setDirection(Direction.turnRight(pen.getDirection()));
            }
            if(direction == Direction.LEFT)
            {
                pen.setDirection(Direction.turnLeft(pen.getDirection()));
            }
        }
}
