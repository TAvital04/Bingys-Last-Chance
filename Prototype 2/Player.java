public class Player extends Character
{
    // Declare variables
    Controller controller;

    Vector vector = new Vector(0, 0);

    // Contructor
    public Player(int x, int y, Controller controller)
    {
        super(x, y);

        this.controller = controller;
    }
    public Player(Point pos, Controller controller)
    {
        super(pos.getX(), pos.getY());
        this.controller = controller;
    }

    // Functions
    public void move()
    {
        if(controller.getUp())
        {
            
        }
        if(controller.getDown())
        {

        }
        if(controller.getLeft())
        {

        }
        if(controller.getRight())
        {

        }
    }

    public void setPos()
    {

    }
}
