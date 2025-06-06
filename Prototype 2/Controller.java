import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener 
{
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_W: 
                upPressed = true; 
                break;
            case KeyEvent.VK_S: 
                downPressed = true; 
                break;
            case KeyEvent.VK_A: 
                leftPressed = true; 
                break;
            case KeyEvent.VK_D: 
                rightPressed = true; 
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP: 
                upPressed = false; 
                break;
            case KeyEvent.VK_S: 
            case KeyEvent.VK_DOWN:
                downPressed = false; 
                break;
            case KeyEvent.VK_A: 
            case KeyEvent.VK_LEFT:
                leftPressed = false; 
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT: 
                rightPressed = false; 
                break;
        }
    }

    @Override public void keyTyped(KeyEvent e) {}

    // Public getters
    public boolean getUp() 
    { 
        return upPressed; 
    }
    public boolean getDown() 
    { 
        return downPressed; 
    }
    public boolean getLeft() 
    { 
        return leftPressed; 
    }
    public boolean getRight() 
    { 
        return rightPressed; 
    }
}