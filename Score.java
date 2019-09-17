import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score = 0;
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage ("Score : " + score, 24, Color.BLACK, Color.WHITE));
    }    
    
    public void addScore()
    {
        score++;
    }
    
    public void resetScore()
    {
        score = 0;
    }
}
