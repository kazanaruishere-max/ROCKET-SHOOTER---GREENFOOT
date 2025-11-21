import greenfoot.*;

public class Bullet extends Actor
{
    public void act()
    {
        setLocation(getX() + 7, getY());
        
        if(getX() > 595)
        {
            getWorld().removeObject(this);
            return;
        }
        
        Actor meteor = getOneIntersectingObject(Meteor.class);
        if(meteor != null)
        {
            MyWorld world = (MyWorld)getWorld();
            world.addScore(1);
            
            Explosion explosion = new Explosion();
            world.addObject(explosion, meteor.getX(), meteor.getY());
            
            world.removeObject(meteor);
            world.removeObject(this);
        }
    }
}