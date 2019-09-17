import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    
    private int value = 0;
    private String text;

    /**
     * Create a counter without a text prefix, initialized to zero.
     */
    public Score()
    {
        this("");
    }

    /**
     * Create a counter with a given text prefix, initialized to zero.
     */
    public Score(String prefix)
    {
        text = prefix;
        int imageWidth= (text.length() + 2) * 10;
        setImage(new GreenfootImage(imageWidth, 16));
        updateImage();
    }

    /**
     * Increment the counter value by one.
     */
    public void addScore(int value)
    {
        this.value = this.value + value;
        updateImage();
    }
    
    public void setScore(int value)
    {
        this.value = value;
        updateImage();
    }
    
    public int getValue()
    {
        return value;
    }

    /**
     * Show the current text and count on this actor's image.
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}
