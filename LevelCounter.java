import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCounter extends Actor
{
    private int level = 1;
    
    /**
     * Act - do whatever the LevelCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage ("Level : " + level, 24, Color.BLACK, Color.WHITE));
    }    
    
    public void addLevel()
    {
        level++;
    }
    
    public void resetLevel()
    {
        level = 1;
    }
}
