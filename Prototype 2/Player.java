public class Player extends GameObject
{
    // Declare variables
    private Controller controller;
    private Movement movement;

    private int acceleration = 3;
    private Vector friction = new Vector(2, 2);

    // Contructor
    public Player(int x, int y, Controller controller, Collider collider)
    {
        super(x, y);

        this.controller = controller;
        this.movement = new Movement();
    }
    public Player(Point pos, Controller controller, int maxVelocity)
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
            movement.update(0, -acceleration);
        }
        if(controller.getDown())
        {
            movement.update(0, acceleration);
        }
        if(controller.getLeft())
        {
            movement.update(-acceleration, 0);
        }
        if(controller.getRight())
        {
            movement.update(acceleration, 0);
        }

        movement.friction(friction);

        setPos(movement.step(getPos()));
    }
}
