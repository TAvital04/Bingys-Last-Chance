public class Path extends GameObject
{
    // Declare variables
        private int width, height;
    
    // Constructor
        public Path(int x, int y, int width, int height)
        {
            super(x, y);

            this.width = width;
            this.height = height;
        }

    // Enum
        public enum Type
        {
            VERTICAL, HORIZONTAL, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
        }

    // Getters/setters
        public int getWidth()
        {
            return width;
        }

        public int getHeight()
        {
            return height;
        }
}
