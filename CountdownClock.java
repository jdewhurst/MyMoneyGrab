

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
public class CountdownClock extends Actor
{
    private final int WIDTH = 100;
    private final int HEIGHT = 50;
    private final float FONT_SIZE = 22.0f;
    private int count;
    private String display;
    private int timeLimit;
    public CountdownClock()
    {
        timeLimit = 10;
        display = String.valueOf(timeLimit)+" sec";
        //display= "1:00";
        updateImage();
    }
    
    public void act()
    {
        MoneyBooth booth = (MoneyBooth) getWorld();
        int count = booth.getCount();
        count = count / 60;
        if(count >= timeLimit){
            display = "done";
            Greenfoot.stop() ;
            
        }else
        {
            display = String.valueOf(timeLimit - count)+" sec";
        }
            updateImage();
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
        image.drawString(display, 10, (HEIGHT/2)+(((int)FONT_SIZE)/4));

        setImage(image);

    }
    
}
