import greenfoot.*;

public class Rocket extends Actor
{
    private int delay = 0;
    private int health = 3;
    private int invincible = 0;
    
    public void act()
    {
        handleMovement();
        handleShooting();
        checkCollision();
        updateInvincible();
    }
    
    private void handleMovement()
    {
        if(Greenfoot.isKeyDown("left") && getX() > 30)
        {
            setLocation(getX() - 4, getY());
        }
        if(Greenfoot.isKeyDown("right") && getX() < 570)
        {
            setLocation(getX() + 4, getY());
        }
        if(Greenfoot.isKeyDown("up") && getY() > 30)
        {
            setLocation(getX(), getY() - 4);
        }
        if(Greenfoot.isKeyDown("down") && getY() < 370)
        {
            setLocation(getX(), getY() + 4);
        }
    }
    
    private void handleShooting()
    {
        delay++;
        if(Greenfoot.isKeyDown("space") && delay > 15)
        {
            getWorld().addObject(new Bullet(), getX() + 25, getY());
            delay = 0;
        }
    }
    
    private void checkCollision()
    {
        if(invincible <= 0 && isTouching(Meteor.class))
        {
            removeTouching(Meteor.class);
            health--;
            invincible = 60;
            
            MyWorld world = (MyWorld)getWorld();
            world.updateHealth(health);
            
            if(health <= 0)
            {
                Explosion explosion = new Explosion();
                world.addObject(explosion, getX(), getY());
                world.removeObject(this);
                world.gameOver();
            }
        }
    }
    
    private void updateInvincible()
    {
        if(invincible > 0)
        {
            invincible--;
            if(invincible % 10 < 5)
            {
                getImage().setTransparency(100);
            }
            else
            {
                getImage().setTransparency(255);
            }
        }
    }
}