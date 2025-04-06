import javax.swing.JPanel;
import java.awt.Graphics;

import java.util.LinkedHashMap;
import java.util.Map;

public class Display extends JPanel
{
    // Declare variables
        private double scaleFactor;
        private Graphics graphic;

        private HilbertCurve hilbertCurve;
        private LinkedHashMap<Point, Integer> points;

    // Constructors
        public Display(int windowSize, int order)
        {
            this.scaleFactor = windowSize / (Math.pow(2, order));

            this.hilbertCurve = new HilbertCurve(new Point(0, 0), order);
            points = hilbertCurve.getCurve();
        }

        @Override
        public void paintComponent(Graphics graphic)
        {
            this.graphic = graphic;

            displayCurve();
        }

    // Functions
        public void displayCurve()
        // Iterates over the keys of the hashmap (the points that make up the curve),
            // and draws a line between each point
        {
            Point previous = null;
            for(Map.Entry<Point, Integer> entry: points.entrySet())
            {
                if(previous != null)
                {
                    drawLine(previous, entry.getKey());
                }

                previous = entry.getKey();
            }
        }

        public void drawLine(Point previous, Point current)
        {
            int x = (int)((previous.getX() * scaleFactor) + (scaleFactor/ 2));
            int y = -(int)((previous.getY() * scaleFactor) - (scaleFactor/ 2));
            int toX = (int)((current.getX() * scaleFactor) + (scaleFactor/ 2));
            int toY = -(int)((current.getY() * scaleFactor) - (scaleFactor/ 2));

            graphic.drawLine(x, y, toX, toY);
        }
}
