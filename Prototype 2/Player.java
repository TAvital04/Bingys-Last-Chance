public class Player extends Character
{
    // Declare variables
    private Controller controller;
    private Movement movement;

    // Contructor
    public Player(int x, int y, Controller controller)
    {
        super(x, y);

        this.controller = controller;
        this.movement = new Movement();
    }
    public Player(Point pos, Controller controller)
    {
        super(pos.getX(), pos.getY());

        this.controller = controller;
        this.movement = new Movement();
    }

    // Functions
    public void move()
    {
        if(controller.getUp())
        {
            movement.update(0, -1);
        }
        if(controller.getDown())
        {
            movement.update(0, 1);
        }
        if(controller.getLeft())
        {
            movement.update(-1, 0);
        }
        if(controller.getRight())
        {
            movement.update(1, 0);
        }

        setPos(movement.step(getPos()));
    }
}
