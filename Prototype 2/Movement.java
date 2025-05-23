public class Movement
{
    // Declare variables
        private Vector acceleration;
        private Vector velocity;
        private Vector position;

    // Constructors
        public Movement()
        {
            acceleration = new Vector(0, 270);
            // velocity = new Vector(0, 270);
            // position = new Vector(0, 270);
        }

    // Functions
        public void update(int dx, int dy)
        {
            acceleration.update(dx, dy);
            // velocity.update(acceleration.getHAxis(), acceleration.getVAxis());
            // position.update(velocity.getHAxis(), acceleration.getVAxis());
        }

        public Point step(Point p)
        {
            int x = p.getX() + acceleration.getHAxis();
            int y = p.getY() + acceleration.getVAxis();

            return new Point(x, y);
        }
} 