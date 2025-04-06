public class Point
{
    // Declare variables
        double x, y;

    // Constructors
        public Point()
        {
            this.x = 0;
            this.y = 0;
        }
        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        public Point(Point p)
        {
            this.x = p.getX();
            this.y = p.getY();
        }

    // Functions
        public String toString()
        {
            return "(" + this.x + ", " + this.y + ")";
        }

    // Getters/setters
        public double getX()
        {
            return this.x;
        }
        public void setX(double x)
        {
            this.x = x;
        }

        public double getY()
        {
            return this.y;
        }
        public void setY(double y)
        {
            this.y = y;
        }
}