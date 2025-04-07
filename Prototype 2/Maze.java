// Class
import java.util.*;

public class Maze 
{
    // Declare variables
        private HilbertCurve curve;
        private LinkedHashMap<GridPoint, GridPoint> maze;

        private GridPoint start, end;

    // Constructor
        public Maze(HilbertCurve curve)
        {
            this.curve = curve;
            this.maze = new LinkedHashMap<GridPoint, GridPoint>();

            for(Map.Entry<GridPoint, Integer> entry: curve.getCurve().entrySet())
            {
                map(entry);
            }

            setEnds();
        }

    // Functions
        private void map(Map.Entry<GridPoint, Integer> entry)
        /*
         * -Take an entry
         * -Choose a random neighboring cell
         *      -must be proceeding
         * -Append them as a pair
         */
        {
            // Declare variables
            GridPoint entryLoc = entry.getKey();
            GridPoint temp;
            
            ArrayList<GridPoint> neighbors = new ArrayList<GridPoint>();

            // Find all proceeding neighbors and add them to a list
            temp = new GridPoint(entryLoc.getX(), entryLoc.getY() - 1);
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            temp = new GridPoint(entryLoc.getX(), entryLoc.getY() + 1);
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            temp = new GridPoint(entryLoc.getX() - 1, entryLoc.getY());
            if(curve.getCurve().containsKey(temp) && curve.getCurve().get(temp) > entry.getValue())
            {
                neighbors.add(temp);
            }

            temp = new GridPoint(entryLoc.getX() + 1, entryLoc.getY());
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

                start = new GridPoint(startX, startY);

                // End
                endX = (int)(Math.random() * sideLength);
                endY = (int)(Math.random() * sideLength);

                end = new GridPoint(endX, endY);
        }

    // Getters/setters
        public LinkedHashMap<GridPoint, GridPoint> getMaze()
        {
            return maze;
        }

        public LinkedHashMap<GridPoint, Integer> getCurve()
        {
            return curve.getCurve();
        }

        public GridPoint getStart()
        {
            return this.start;
        }
        public GridPoint getEnd()
        {
            return this.end;
        }
}
