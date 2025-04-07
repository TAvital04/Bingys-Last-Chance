// Imports
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//Class
public class HilbertCurve
{
    // Declare variables
        private LinkedHashMap<GridPoint, Integer> hilbertCurve;
        private int order;

        private GridPoint pen;
        private Vector vector;

        private int hashPos;

    // Constructors
        public HilbertCurve(Point pos, int order)
        {
            // Instantiate variables
            this.hilbertCurve = new LinkedHashMap<GridPoint, Integer>();
            this.order = order;

            this.pen = new GridPoint(pos);
            this.vector = new Vector();

            this.hashPos = 0;

            // Complete hilbert curve
            addPoint();

            generateCurve(order, Vector.RIGHT);
        }

    // Methods
        private void generateCurve(int order, double direction)
        // Generates the hilbert curve
        {

            // Base case
            if(order == 1)
            {
                baseCurve(direction);
                return;
            }

            vector.rotate(direction);
            generateCurve(order - 1, -direction);

            pen = vector.step(pen);
            addPoint();

            vector.rotate(-direction);
            generateCurve(order - 1, direction);

            pen = vector.step(pen);
            addPoint();

            generateCurve(order - 1, direction);
            vector.rotate(-direction);

            pen = vector.step(pen);
            addPoint();

            generateCurve(order - 1, -direction);
            vector.rotate(direction);
        }

        private void baseCurve(double direction)
        // This is the base case of the hilbert curve
        {
            vector.rotate(direction);

            pen = vector.step(pen);
            addPoint();

            vector.rotate(-direction);

            pen = vector.step(pen);
            addPoint();

            vector.rotate(-direction);

            pen = vector.step(pen);
            addPoint();

            vector.rotate(direction);
        }

        private void addPoint()
        // Adds a point to the hilbert curve
        {
            hilbertCurve.put(new GridPoint(pen), hashPos);

            hashPos++;
        }

    // Getters/setters
        public LinkedHashMap<GridPoint, Integer> getCurve()
        {
            return hilbertCurve;
        }

        public int getOrder()
        {
            return this.order;
        }
}