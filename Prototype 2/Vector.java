// Class
public class Vector 
{
    // Declare variables
        int magnetude;
        int angle;
        /*
        * A direction of 0 degrees faces right
        *  -this allows for me to use sin() and cos() functions more intuitively
        */

        public static final int DIAC = 360;
            // Degrees in a circle
        public static final int LEFT = -90;
        public static final int RIGHT = 90;

    // Constructor
        public Vector()
        {
            this.magnetude = 1;
            this.angle = 270;
        }
        public Vector(int magnetude, int angle)
        {
            this.magnetude = magnetude;
            this.angle = angle;
        }

    // Functions
        public Point step(Point p)
        {
            int x = p.getX() + getHAxis();
            int y = p.getY() + getVAxis();

            return new Point(x, y);
        }

        public void rotate(int direction)
        {
            this.angle = ((this.angle + direction) % DIAC); 
        }

        public int getSign(int direction)
        {
            if(direction >= 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }

    // Getters/setters  
        public int getHAxis()
        {
            return (int)(this.magnetude * Math.cos(Math.toRadians(this.angle)));
        }

        public int getVAxis()
        {
            return (int)(this.magnetude * Math.sin(Math.toRadians(this.angle)));
        }

        public void update(int dx, int dy)
        // Sets the magnitude and direction
        {
            // Updates the magnetude using the pythagorean theorem
            magnetude += (int)(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            // Updates the direction using tangeant values
            
        }
}
