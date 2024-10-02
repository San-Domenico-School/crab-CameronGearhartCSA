import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    
    public CrabWorld() 
    {
        super(1000, 1000, 1, false);
        prepareScene();
    }
    
    private void prepareScene()
    {
        
        //Adds and instantiates a crab
        Crab crab = new Crab();
        addObject(crab, (int)(Math.random()* getWidth()), (int)(Math.random() * getWidth()));
        
        //Adds and instantiates a lobster
        Lobster lobster = new Lobster(crab);
        addObject(lobster,(int)(Math.random()* getWidth()), (int)(Math.random() * getWidth()));
        
        //Adds and instatiates a worm
        int x = 0;
    
        while (x<8)
        {
            addObject(new Worm(), (int)(getWidth() * Math.random()), (int)(getWidth() * Math.random()));
            x++;
        }
        
        
        
    }
    
    public void act()
    {
        checkForGameWinOrLoss();
    }
    
    private void addPlayer()
    {
        //instanciate new objects
        Crab crab = new Crab();
        
        //Add them to the world
        addObject(crab, 470, 100);
    }
    
    private void addFood()
    {
        System.out.println("Food Added");
    }
    
    private void addEnemy()
    {
        System.out.println("Enemy added");
    }
    
    public void checkForGameWinOrLoss()
    {
        if (getObjects(Worm.class).size() == 0 || getObjects(Crab.class).size() == 0)
        {
            Greenfoot.stop();
        }
    
    }
    
}


