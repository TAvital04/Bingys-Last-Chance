public class Point
{
    // Declare variables
    int x, y;

    // Constructors
    public Point()
    {
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Point(Point p)
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