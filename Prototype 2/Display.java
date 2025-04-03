import javax.swing.JPanel;

public class Display extends JPanel
{
    // Declare variables
    public int windowSize;
    public HilbertCurve curve;

    // Constructor
    public Display(int windowSize, int order)
    {
        this.windowSize = windowSize;

        this.curve = new HilbertCurve(order);

        displayCurve();
    }

    // Functions
    public void displayCurve()
    {
        
    }
}
