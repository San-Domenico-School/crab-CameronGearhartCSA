import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the enemy
 * 
 * Cameron Gearhart
 * 1.0 Oct 2 2024
 */
public class Lobster extends Actor
{
    // this field ats as an index for the movewithsetspeed method and the rotate method
    private int indexForFunctionSpeed = 0;
    // this stores wether the game is in hard mode 
    private boolean hardMode = false;
    //this is used for a constructer
    private Crab crab;
    //this stores the speed the lobster should move 
    private int moveSpeed = 3;
    //this is the constructor
    public Lobster(Crab crab)
    {
        this.crab = crab;
    }
    
    public void act()
    {
        Greenfoot.setSpeed(50);
        rotate();
        moveWithSetSpeed();
        turnAtEdge();
        checkAndChangeDifficulty();
    }
    //This is the method that moves the Lobtser and does so as a function of time if it is in hardmode.
    private void moveWithSetSpeed()
    {
        if (hardMode && indexForFunctionSpeed == 120)
        {
            moveSpeed++;
            indexForFunctionSpeed = 0;
        }
        move(moveSpeed);
    }
    //This is the method that rotates the lobster, and it also makes it follow the crab if it is in hardmode.
    private void rotate()
    {
        if (hardMode)
        {
            turnTowards(crab.getX(), crab.getY());
        } 
        else if(indexForFunctionSpeed == 60)
        {
            turn((int)(100*Math.random()-50));
            indexForFunctionSpeed = 0;
        }
        indexForFunctionSpeed++;
    }
    //this checks if the lobster is at the edge and then turns it if it returns true
    private void turnAtEdge() 
    {
        if (isAtEdge() == true)
        {
            turn(180);
        }
    }
    //this checks if the key 4 is down, then sets hardMode to true
    private void checkAndChangeDifficulty()
    {
        if(Greenfoot.isKeyDown("4"))
        {
            hardMode = true;
        }
    }
}
