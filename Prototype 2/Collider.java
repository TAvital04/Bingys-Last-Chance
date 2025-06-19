public class Collider
{
    // Variables
        WallTrie walls;

    // Constructors
        public Collider(int order)
        {
            walls = new WallTrie(order);
        }

    //Functions
        public void addWalls(Maze maze)
        {
            for(Point entry: maze.getMap().keySet())
            {
                if(maze.getMap().get(entry) != null)
                {
                    // Variables
                    int col, row;
                    Wall.Type type;

                    // Determine wall type
                    if(entry.getX() == maze.getMap().get(entry).getX())
                    {
                        col = entry.getX();
                        row = Math.max(entry.getY(), maze.getMap().get(entry).getY());
                        type = Wall.Type.VERTICAL;
                    }
                    else
                    {
                        col = Math.min(entry.getX(), maze.getMap().get(entry).getX());
                        row = entry.getY();
                        type = Wall.Type.HORIZONTAL;
                    }

                    // Add the wall
                    walls.add(new Wall(col, row, type));
                }
            }
        }

    // Getters/setters
    public WallTrie getWalls()
    {
        return walls;
    }
}