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
        {
            int x = p.getX() + dx;
            int y = p.getY() + dy;

            return new Point(x, y);
        }

        public void rotate(int direction)
        {
            int angle;
            int magnetude;

            if(dx == 0)
            {
                if(dy > 0)
                {
                    angle = 270;
                }
                else
                {
                    angle = 90;
                }
            }
            else
            {
                angle = (int) Math.tanh(dy/dx);
            }

            angle+= direction;

            magnetude = (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

            dx = magnetude * ((int) (Math.cos(Math.toRadians(angle))));
            dy = magnetude * ((int) (Math.sin(Math.toRadians(angle)))); 
        }

        public void update(int dx, int dy)
        {
            
        }

        public void getSign()
        {
            
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
}
