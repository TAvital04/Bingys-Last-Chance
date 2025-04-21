// Class
public abstract class Character
{
    // Declare variables
    private int x, y;

    // Constructor
    public Character(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Character(Point p)
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
}