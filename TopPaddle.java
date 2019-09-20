import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * Version 0.1
 * Group beast.
 */
public class TopPaddle extends Actor
{
    private int width;
    private int height;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public TopPaddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        setImage("leaf.jpg");
    }

    /**
     * Act - moves the paddle to the right of the screen, and despawns it when it touches the right side of the wall.
     */
    public void act() 
    {
        move(1);
        despawnOnWall();
    }    

    /**
     * This is the despawnOnWall Method call.
     */
    private void despawnOnWall()
    {
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
        if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0)
        {
            PingWorld.paddle = 0;
            getWorld().removeObject(this);
        }
    }
}
