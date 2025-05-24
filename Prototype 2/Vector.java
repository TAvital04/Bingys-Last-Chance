// Class
public class Vector 
{
    // Declare variables
        private int dx, dy;

    // Constructor
        public Vector()
        {
            dx = 0;
            dy = -1;
        }

        public Vector(int dx, int dy)
        {
            this.dx = dx;
            this.dy = dy;
        }

    // Functions
        public Point step(Point p)
        // Performs a vector addition on the position
        {
            int x = p.getX() + dx;
            int y = p.getY() + dy;

            return new Point(x, y);
        }

        public void rotate(int direction)
        // Performs a rotation of the vector in the given degrees
        {
            int angle;
            int magnetude;

            angle = (getAngle() + direction) % 360;
            magnetude = getMagnetude();

            dx = (int) Math.round(magnetude * ((Math.cos(Math.toRadians(angle)))));
            dy = (int) Math.round(magnetude * ((Math.sin(Math.toRadians(angle))))); 
        }

        public void update(int dx, int dy)
        // Updates the vector based on given values
        {
            this.dx += dx;
            this.dy += dy;
        }

    // Getters/setters  
        public int getHAxis()
        {
            return dx;
        }
        public int getVAxis()
        {
            return dy;
        }

        public int getMagnetude()
        {
            return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        }
        public int getAngle()
        {
            if(dx == 0)
            {
                if(dy > 0)
                {
                    return 90;
                }
                else
                {
                    return 270;
                }
            }
            else
            {
                return (int) Math.toDegrees(Math.atan2(dy, dx));
            }
        }
}
