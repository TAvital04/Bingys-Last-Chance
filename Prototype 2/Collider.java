import java.util.*;

public class Collider
{
    // Declare variables
        int scaleFactor;

        ArrayList<Path> path;

    // Constructor
        public Collider(int scaleFactor)
        {
            this.scaleFactor = scaleFactor;

            path = new ArrayList<Path>();
        }

    // Getters/setters
        public ArrayList<Path> getPath()
        {
            return path;
        }
        public void setPath(Maze maze)
        // Send all the paths to the collider
        {
            // Get the path type
            Map.Entry<Point, Point> prev = null, curr = null, next = null;

            for(Map.Entry<Point, Point> entry: maze.getMap().entrySet())
            {
                if(prev == null)
                {
                    prev = entry;
                    continue;
                }
                if(curr == null)
                {
                    curr = entry;
                }


            }
        }
}