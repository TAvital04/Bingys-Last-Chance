// Class
import java.util.*;

public class Maze 
{
    // Declare variables
        private HilbertCurve curve;
        private LinkedHashMap<Point, Point> maze;

        private Point start, end;

    // Constructor
        public Maze(HilbertCurve curve)
        {
            this.curve = curve;
            maze = new LinkedHashMap<Point, Point>();

            for(Map.Entry<Point, Integer> entry: curve.getCurve().entrySet())
            // Map all entries in the curve to the maze
            {
                map(entry);
            }

            setEnds();
        }

    // Functions
        private void map(Map.Entry<Point, Integer> entry)
        /*
         * -Take an entry
         * -Choose a random neighboring cell
         *      -must be proceeding
         * -Append them as a pair
         */
        {
            // Declare variables
            Point entryLoc = entry.getKey();
            Point temp;
            
            ArrayList<Point> neighbors = new ArrayList<Point>();

            // Find all proceeding neighbors and add them to a list
            temp = new Point(entryLoc.getX(), entryLoc.getY() - 1);
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            temp = new Point(entryLoc.getX(), entryLoc.getY() + 1);
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            temp = new Point(entryLoc.getX() - 1, entryLoc.getY());
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            temp = new Point(entryLoc.getX() + 1, entryLoc.getY());
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            // Calculate a random index in the array
            int index = (int)(Math.random() * neighbors.size());

            // Append the pair of points to the map
            if(neighbors.size() == 0)
            {
                maze.put(entry.getKey(), null);
            }
            else
            {
                maze.put(entry.getKey(), neighbors.get(index));
            }
        }

        private void setEnds()
        {
            // Declare variables
            int sideLength;

            int startX, startY;
            int endX, endY;

            // Calculate the sizelength of the square grid
            sideLength = (int)Math.pow(2, curve.getOrder());

            // Calculate random values
                // Start
                startX = (int)(Math.random() * sideLength);
                startY = (int)(Math.random() * sideLength);

                start = new Point(startX, startY);

                // End
                endX = (int)(Math.random() * sideLength);
                endY = (int)(Math.random() * sideLength);

                end = new Point(endX, endY);
        }

    // Getters/setters
        public LinkedHashMap<Point, Point> getMap()
        {
            return maze;
        }

        public Point getStart()
        {
            return this.start;
        }
        public Point getEnd()
        {
            return this.end;
        }
}
