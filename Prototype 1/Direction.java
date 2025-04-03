public enum Direction 
{
    UP, DOWN, LEFT, RIGHT;

    public static int vAxis(Direction direction)
    {
        if(direction == UP)
        {
            return -1;
        }
        else if(direction == DOWN)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static int hAxis(Direction direction)
    {
        if(direction == LEFT)
        {
            return -1;
        }
        else if(direction == RIGHT)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static Direction turnRight(Direction direction)
    {
        if(direction == UP)
        {
            return RIGHT;
        }
        else if(direction == RIGHT)
        {
            return DOWN;
        }
        else if(direction == DOWN)
        {
            return LEFT;
        }
        else
        {
            return UP;
        }
    }

    public static Direction turnLeft(Direction direction)
    {
        if(direction == UP)
        {
            return LEFT;
        }
        else if(direction == LEFT)
        {
            return DOWN;
        }
        else if(direction == DOWN)
        {
            return RIGHT;
        }
        else
        {
            return UP;
        }
    }

    public static Direction opposite(Direction direction)
    {
        if(direction == UP)
        {
            return DOWN;
        }
        else if(direction == RIGHT)
        {
            return LEFT;
        }
        else if(direction == DOWN)
        {
            return UP;
        }
        else
        {
            return RIGHT;
        }
    }
}
