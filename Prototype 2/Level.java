import java.util.*;

public class Level 
{
    // Declare variables
        private int order;
        private Maze maze;

        private Player player;

        private Collider collider;

    // Constructor
        public Level(int scaleFactor, int order, Controller controller)
        {
            this.order = order;
            maze = new Maze(new HilbertCurve(new Point(0, 0), order));

            collider = new Collider(scaleFactor);
            collider.setPath(maze);

            player = new Player(maze.getStart().getX(), maze.getStart().getY(), controller);
        }

    // Functions            
        public void update()
        {
            player.move();
        }

    // Getters/Setters
        public int getOrder()
        {
            return order;
        }

        public Maze getMaze()
        {
            return maze;
        }

        public Player getPlayer()
        {
            return player;
        }

        public ArrayList<Path> getPath()
        {
            return collider.getPath();
        }
}
