public class Collider
{
    // Variables
        PathTrie walls;

    // Constructors
        public Collider(int order)
        {
            walls = new PathTrie(order);
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
                    Path.Type type;

                    // Determine wall type
                    if(entry.getX() == maze.getMap().get(entry).getX())
                    {
                        col = entry.getX();
                        row = Math.max(entry.getY(), maze.getMap().get(entry).getY());
                        type = Path.Type.VERTICAL;
                    }
                    else
                    {
                        col = Math.min(entry.getX(), maze.getMap().get(entry).getX());
                        row = entry.getY();
                        type = Path.Type.HORIZONTAL;
                    }

                    // Add the wall
                    walls.add(new Path(col, row, type));
                }
            }
        }

        public void collision(Player player)
        {
            
        }

    // Getters/setters
    public PathTrie getWalls()
    {
        return walls;
    }
}