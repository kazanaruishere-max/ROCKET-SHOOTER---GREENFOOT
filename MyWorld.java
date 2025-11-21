import greenfoot.*;

public class MyWorld extends World
{
    private int timer = 0;
    private int score = 0;
    private int level = 1;
    private int spawnDelay = 60;
    
    public MyWorld()
    {    
        super(600, 400, 1);
        prepare();
        updateScore();
        updateHealth(3);
    }
    
    public void act()
    {
        timer++;
        if(timer > spawnDelay)
        {
            int y = Greenfoot.getRandomNumber(380) + 10;
            addObject(new Meteor(), 599, y);
            timer = 0;
        }
        
        if(score >= level * 10)
        {
            level++;
            if(spawnDelay > 20)
            {
                spawnDelay = spawnDelay - 5;
            }
        }
    }
    
    public void addScore(int points)
    {
        score = score + points;
        updateScore();
    }
    
    public void updateScore()
    {
        showText("Score: " + score + "  Level: " + level, 80, 20);
    }
    
    public void updateHealth(int health)
    {
        showText("Health: " + health, 520, 20);
    }
    
    public void gameOver()
    {
        showText("GAME OVER! Score: " + score, 300, 200);
        Greenfoot.stop();
    }
    
    private void prepare()
    {
        Rocket rocket = new Rocket();
        addObject(rocket, 100, 200);
    }
}