// Class
public class Vector 
{
    // Declare variables
        double magnetude;
        double angle;
        /*
        * A direction of 0 degrees faces right
        *  -this allows for me to use sin() and cos() functions more intuitively
        */

        public static final int DIAC = 360;
            // Degrees in a circle
        public static final double LEFT = -90;
        public static final double RIGHT = 90;

        // Constructors
        public Vector()
        {
            this.magnetude = 1;
            this.angle = 270;
        }

    // Functions
        public Point step(Point p)
        {
            double x = p.getX() + (this.magnetude * Math.cos(Math.toRadians(this.angle)));
            double y = p.getY() + (this.magnetude * Math.sin(Math.toRadians(this.angle)));

            return new Point(x, y);
        }

        public void rotate(double direction)
        {

            this.angle = ((this.angle + direction) % DIAC); 
        }
        public int getSign(double direction)
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
        
}
