import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the worm class, and acts as the object for collection
 * 
 * Cameron Gearhart
 * 1.0 Oct 2 2024
 */
public class Worm extends Actor
{
    /**
     * Act - do whatever the Worm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        removeIfTouching();
    }
    //this removes the worm if it contacts a crab
    private void removeIfTouching()
    {
        if (isTouching(Crab.class))
        {
            getWorld().removeObject(this);
        }
    }
}

