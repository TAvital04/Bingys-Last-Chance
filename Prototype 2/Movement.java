public class Movement
{
    // Declare variables
        private Vector velocity;

    // Constructors
        public Movement()
        {
            velocity = new Vector(0, 0);
        }

    // Functions
        public void update(int dx, int dy)
        {
            velocity.update(dx, dy);
        }
        public void friction(Vector friction)
        // The update function but specifically for friction forces
        {
            Vector result = new Vector();

            result.setHAxis(velocity.getHAxis() > 0 ? -friction.getHAxis(): velocity.getHAxis() < 0 ? friction.getHAxis(): 0);
            result.setVAxis(velocity.getVAxis() > 0 ? -friction.getVAxis(): velocity.getVAxis() < 0 ? friction.getVAxis(): 0);

            velocity.update(result);
        }

        public Point step(Point p)
        {
            int x = p.getX() + velocity.getHAxis();
            int y = p.getY() + velocity.getVAxis();

            return new Point(x, y);
        }
} 