public class Pen 
{
    // Declare variables
        Coordinates pos;
        Direction direction;
    
    // Constructors
        public Pen(Pen pen)
        {
            this.pos = pen.getPos();
            this.direction = pen.getDirection();
        }
        public Pen(Coordinates pos, Direction directon)
        {
            this.pos = pos;
            this.direction = directon;
        }

    // Getters/Setters
        public Coordinates getPos()
        {
            return this.pos;
        }
        public void setPos(Coordinates pos)
        {
            this.pos = new Coordinates(pos);
        }

        public Direction getDirection()
        {
            return this.direction;
        }
        public void setDirection(Direction direction)
        {
            this.direction = direction;
        }
}
