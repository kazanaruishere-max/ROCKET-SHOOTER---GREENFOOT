import greenfoot.*;

public class Meteor extends Actor
{
    private int speed;
    
    public Meteor()
    {
        speed = Greenfoot.getRandomNumber(2) + 2;
        
        int size = Greenfoot.getRandomNumber(30) + 40;
        GreenfootImage img = getImage();
        img.scale(size, size);
        setImage(img);
    }
    
    public void act()
    {
        setLocation(getX() - speed, getY());
        turn(2);
        
        if(getX() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}