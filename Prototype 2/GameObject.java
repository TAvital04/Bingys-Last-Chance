// Class
public abstract class GameObject
{
    // Declare variables
    private int x, y;

    Vector vector = new Vector(0, 0);

    // Constructor
    public GameObject(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public GameObject(Point p)
    {
        this.x = p.getX();
        this.y = p.getY();
    }

    // Getters/setters
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

    public Point getPos()
    {
        return new Point(x, y);
    }
    public void setPos(Point pos)
    {
        x = pos.getX();
        y = pos.getY();
    }

    public Vector getVector()
    {
        return vector;
    }
}