import java.util.Objects;

public class GridPoint 
{
    // Declare variables
    private int x, y;
    
    // Constructors
    public GridPoint()
    {
        this.x = 0;
        this.y = 0;
    }

    public GridPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public GridPoint(Point pos)
    {
        this.x = (int)pos.getX();
        this.y = (int)pos.getY();
    }

    public GridPoint(GridPoint pos)
    {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    // Functions
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof GridPoint)
        {
            GridPoint point = (GridPoint)object;
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
