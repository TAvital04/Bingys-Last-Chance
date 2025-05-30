public class Level 
{
    // Declare variables
        private int order;
        private Maze maze;

        private Player player;

    // Constructor
        public Level(int order, Controller controller)
        {
            this.order = order;
            maze = new Maze(new HilbertCurve(new Point(0, 0), order));

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
}
