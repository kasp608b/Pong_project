import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    public static int paddle;
    
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        
        
        if (gameStarted)
        {
            GreenfootImage background = getBackground();
            background.setColor(Color.BLACK);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 50);
            addObject(new TopPaddle(100,20),60, Greenfoot.getRandomNumber(WORLD_HEIGHT/4));
            paddle++;
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }
    /**
     * If less than one paddle in game Spawn new paddle in the top 25% of the map - 50 
     */
    public void act()
    {
        if (paddle < 1)
        {
            addObject(new TopPaddle(100,20),60, Greenfoot.getRandomNumber((WORLD_HEIGHT/4))+50);
            paddle++;
        }
    }
}
