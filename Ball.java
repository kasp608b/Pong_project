import greenfoot.*;


/**
 * A Ball is a thing that bounces of walls and paddles (or at least i should).
 * 
 * @author The teachers 
 * @version 1
 */
public class Ball extends Actor
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;

    private int speed;
    private int counter;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    
    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        setImage("wombat.jpg");
        init();
    }



    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            drawScore();
            move(speed);
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkBounceOffPaddle();
            checkBounceOffTopPaddle();
            checkRestart();
        }
    }    

    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }
    
        private boolean isTouchingPaddle()
    {
        return (getOneIntersectingObject(Paddle.class)) != null;
    }
    
    private boolean isTouchingTopPaddle()
    {
        return (getOneIntersectingObject(TopPaddle.class)) != null;
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
                Greenfoot.playSound("PingPong.wav");
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                Greenfoot.playSound("PingPong.wav");
            }
        }
        else
        {
            
        }
    }
    
    private void checkBounceOffPaddle()
    {
        if (isTouchingPaddle())
        {
            hasBouncedVertically = true;
            Greenfoot.playSound("PingPong.wav");
            if (hasBouncedVertically)
            {  
                revertVertically();
                hasBouncedVertically = false;
                counter++;
                incrementScore();
                if (counter >= 10)
                {
                    speed = speed + 1;
                    counter = 0;
                }
            }
        }
        else
        {
            
        }
    }
    
    private void checkBounceOffTopPaddle()
    {
        if (isTouchingTopPaddle())
        
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                Greenfoot.playSound("PingPong.wav");
            }
        }
        else
        {
            
        }
    }

    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
            Greenfoot.playSound("gameover.mp3");
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            resetScore();
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }
    
    private Score bounceScore;
    private boolean scoreDrawn;
    public void drawScore()
    {
        if (scoreDrawn != true)
            bounceScore = new Score();
        
            getWorld().addObject(bounceScore, 100, 300);
            scoreDrawn = true;
    }
    
    public void incrementScore()
    {
            bounceScore.addScore();
    }
    
    public void resetScore()
    {
        bounceScore.resetScore();
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        speed = 2;
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }

}
