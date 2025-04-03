// Imports
import java.util.Map;
import java.util.HashMap;

//Class
public class HilbertCurve
{
    // Declare variables
    private int order;

    Map<Point, Integer> hilbertCurve;
    Point pen = new Point();
    Vector vector = new Vector();

    // Constructors
    public HilbertCurve(int order)
    {
        this.order = order;

        hilbertCurve = generateCurve(order);
    }

    // Methods
    public Map<Point, Integer> generateCurve(int order)
    {
        Map<Point, Integer> hilbertCurve = new HashMap<>();

        // Base case
        if(order == 1)
        {
            baseCurve(hilbertCurve);
        }

        return hilbertCurve;
    }

    public void baseCurve(Map<Point, Integer> hilbertCurve)
    {
        vector.setDirection(Vector.Direction.RIGHT);
        pen = vector.step(pen);
    }

    //Getters/setters
}