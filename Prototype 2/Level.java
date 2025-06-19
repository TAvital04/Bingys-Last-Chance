import java.util.*;

public class Level 
{
    // Declare variables
        private int order;
        private Maze maze;
        
        private Collider collider;

        private Player player;

        private Collider collider;

    // Constructor
        public Level(int scaleFactor, int order, Controller controller)
        {
            this.order = order;
            maze = new Maze(new HilbertCurve(new Point(0, 0), order));

            collider = new Collider(order);
            collider.addWalls(maze);

            player = new Player(maze.getStart().getX(), maze.getStart().getY(), controller, collider);
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

        public Collider getCollider()
        {
            return collider;
        }
}
