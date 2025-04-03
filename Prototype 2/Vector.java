public class Vector 
{
    // Declare variables
    int magnetude;
    Direction direction;

    // Constructors
    public Vector()
    {
        this.magnetude = 1;
        this.direction = Direction.UP;
    }

    // Enums
    public enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }
    
    // Functions
    public Point step(Point p)
    {

    }

    // Getters/setters  
        // Direction
        public void setDirection(Direction direction)
        {
            this.direction = direction;
        }

        // Axies
        public int getHAxis()
        {
            if(this.direction == Direction.LEFT)
            {
                return -1;
            }
            else if(this.direction == Direction.RIGHT)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        
}
