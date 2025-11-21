import greenfoot.*;

public class Explosion extends Actor
{
    private int timer = 20;
    
    public Explosion()
    {
        GreenfootImage img = new GreenfootImage(40, 40);
        img.setColor(Color.ORANGE);
        img.fillOval(0, 0, 40, 40);
        img.setColor(Color.YELLOW);
        img.fillOval(10, 10, 20, 20);
        setImage(img);
    }
    
    public void act()
    {
        timer--;
        
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + 2, img.getHeight() + 2);
        img.setTransparency(timer * 12);
        setImage(img);
        
        if(timer <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}