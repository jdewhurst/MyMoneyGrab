import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class CountdownClock here.
 * 
 * @author Meg Prescott
 * @version 1.0
 */
public class CountdownClock extends Actor
{
    private final int WIDTH = 100;
    private final int HEIGHT = 50;
    private final float FONT_SIZE = 22.0f;
    private String display;
    private int seconds;
    private int cycles;

    public CountdownClock()
    {
        display = "1:00";
        seconds = 60;
        cycles = 0;
        updateImage();
    }

    public void act()
    {
        if(cycles == MoneyBooth.SPEED)
        {
            if(seconds > 0)
            {
                seconds--;
                if(seconds > 9)
                {
                    display = "0:" + seconds;
                } else {
                    display = "0:0" + seconds;
                }
                updateImage();
            } else {
                MoneyBooth mbWorld = (MoneyBooth)getWorld();
                mbWorld.endGame();
            }
            
            cycles = 0; //start the process of counting cycles again
        } else {
            cycles++;
        }
    }

    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(display, 10, (HEIGHT/2)+(((int)FONT_SIZE)/4)+3);
        setImage(image);

    }
    
    public int getSeconds()
    {
        return seconds;
    }
}



