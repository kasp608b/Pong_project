import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class Paddle extends Actor
{
    private int width;
    private int height;
    private int dx;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 1;
        setImage("leaf.jpg");
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    

    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void move()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-2);
            
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(2);
    
        }
    }
    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.BLACK);
        image.fill();
        setImage(image);
    }

}
