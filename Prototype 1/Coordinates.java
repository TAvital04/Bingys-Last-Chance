public class Coordinates 
{
    // Declare variables
        private int x, y;

    // Constructors
        public Coordinates(Coordinates pos)
        {
            this.x = pos.getX();
            this.y = pos.getY();
        }

        public Coordinates(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

    // Getters/Setters
        public int getX()
        {
            return this.x;
        }
        public void setX(int x)
        {
            this.x = x;
        }

        public int getY()
        {
            return this.y;
        }
        public void setY(int y)
        {
            this.y = y;
        }
}
