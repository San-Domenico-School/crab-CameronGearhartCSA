import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 * @author CGearhart
 * @version 9/16/2024 12:16pm
 */

public class Crab extends Actor
{
    int moveSpeed = 1;
    int turnSpeed = 1;
    
    public void act()
    {
        setSpeedSetting();
        moveBasedOnInput();
        turnAtEdge();
        checkForLobsterCollision();
    }
    
    // This method changes the moveSpeed and and turnSpeed based on the keypress 1,2,3
    private void setSpeedSetting()
    {
        if (Greenfoot.isKeyDown("1"))
        {
            moveSpeed = 1;
            turnSpeed = 1;
        }
        
        if (Greenfoot.isKeyDown("2"))
        {
            moveSpeed = 3;
            turnSpeed = 3;
        }
        
        if (Greenfoot.isKeyDown("3"))
        {
            moveSpeed = 10;
            turnSpeed = 10;
        }
    }
    
    //This method takes the current speed setting defined by setSpeedSetting and moves the player accordingly
    private void moveBasedOnInput()
    {
        if (Greenfoot.isKeyDown("down"))
        {
            move(-1 * moveSpeed);
        }
        
        if (Greenfoot.isKeyDown("up")) 
        {
            move(moveSpeed);
        } 
        
        if (Greenfoot.isKeyDown("right")) 
        {
            turn(-1 * turnSpeed);
        }
        
        if (Greenfoot.isKeyDown("left")) {
            turn(turnSpeed);
        }
    }
    
    //this method checks if the crab is at the edge and then turns them 180 degrees
    public void turnAtEdge() 
    {
        if (isAtEdge() == true)
        {
            turn(180);
        }
    }
    //this method checks for lobster collision then ends the game if it is true. The crab is moved offsceen as a way to avoid a runtime error
    public void checkForLobsterCollision()
    {
        if(isTouching(Lobster.class))
        {
            setLocation(-30, -30);
            endGame();
        }
    }
    //this ends the game
    public void endGame()
    {
        Greenfoot.stop();
    }
}

