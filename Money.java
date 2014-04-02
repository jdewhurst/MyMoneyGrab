import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * A Money object will pop around the screen until the user clicks on it at which point the dollar amount goes up.
 * 
 * @author Meg Prescott 
 * @version 1.0
 */
public class Money extends Actor
{
    private final int WIDTH = 100;
    private final int HEIGHT = 50;
    private final float FONT_SIZE = 22.0f;
    private int dollarValue;

    /**
     * No-arg Constructor
     */
    public Money()
    {
        this(1);
    }

    /**
     * Constructor
     * @param int value Dollar value for this money object
     */
    public Money(int value)
    {
        dollarValue = value;   
    }

    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fly();
        if (isGrabbed())
        {
            MoneyBooth booth = (MoneyBooth) getWorld();
            booth.updateScoreboard(dollarValue);
            //Scoreboard board = (Scoreboard) booth.getScoreboard();
            //board.setCash(dollarValue);
            //board.updateImage();
          getWorld().removeObject(this);
            
        }
        updateImage();
    }

    public boolean isGrabbed()
    {
        return Greenfoot.mouseClicked(this);
    }

    public void fly()
    {
        if(Greenfoot.getRandomNumber(100)>69)
        {
            turn(Greenfoot.getRandomNumber(91)-45);
        }

        checkForEdge();

        move(Greenfoot.getRandomNumber(10)+1);
    }

    public void checkForEdge()
    {
        int maxX = getWorld().getWidth() - 10;   //Highest X-value a money object can have
        int maxY = getWorld().getHeight() - 10;   //Hightest Y-value a money object can have
        
        //check to see if getting too close to the right edge
        if(getX() > maxX)
        {  turnTowards(0, getY()); }

        //check to see if getting too close to the left edge
        if(getX() < 10)
        {  turnTowards(maxX, getY()); }

        //check to see if getting too close to the bottom edge
        if(getY() > maxY)
        {  turnTowards(getX(), 0); }

        //check to see if getting too close to the left edge
        if(getY() < 10)
        {  turnTowards(getX(), maxY); }

    }
        public void updateImage()
    {
        //GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        GreenfootImage image = new GreenfootImage(getX(), getY());
        //GreenfootImage image = getImage(getX(), getY());

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString("$" + dollarValue,10,(HEIGHT/2)+(((int)FONT_SIZE)/4));

        setImage(image);

    }
}
