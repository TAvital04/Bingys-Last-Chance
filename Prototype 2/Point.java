import java.util.Objects;

public class Point 
{
    // Declare variables
    private int x, y;
    
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

    public Point(Point pos)
    {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    // Functions
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof Point)
        {
            Point point = (Point)object;
            if(point.getX() == this.x && point.getY() == this.getY())
            {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
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
