public class Wall
{
    // Variables
    int col, row;
    Type type;

    // Constructor
    public Wall(int col, int row, Type type)
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
}
