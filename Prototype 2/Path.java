public class Path
{
    // Variables
    int col, row;
    Type type;

    boolean flag;

    // Constructor
    public Path(int col, int row, Type type)
    {
        this.col = col;
        this.row = row;
        this.type = type;
    }

    // Enum
    public enum Type
    {
        VERTICAL, HORIZONTAL
    }

    // Getters/setters
    public int getCol()
    {
        return col;
    }
    public int getRow()
    {
        return row;
    }

    public Type getType()
    {
        return type;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    public boolean getFlag()
    {
        return flag;
    }

    // toString
    public String toString()
    {
        return String.format("col: %d\nrow: %d\ntype: %s\n", col, row, type);
    }
}
