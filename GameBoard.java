import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class GameBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends World
{
    private static final int WORLD_WIDTH = 800;
    private static final int WORLD_HEIGHT = 600;
    private Player player;
    private Creature creature;
    private int gameDifficulty;
    
    /**
     * Constructor for objects of class GameBoard.
     */
    public GameBoard()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1, true);
        
        // Load default settings.
        init();
        
    }
    
    /**
     * 
     */
    public void act()
    {
        /*
            this.showText(String.valueOf(player.getScore()), 15, 15);
            if (player.getHealth() == 0)
            {
                this.removeObject(player);
            }
        */
    }
    
    /**
     * Initializes the default settings for the GameBoard.
     */
    public void init()
    {
        player = new Player();
        player.getImage().rotate(player.getRotation() - 45); // Depends on image.
        this.addObject(player, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        
    }
    
    public void startNextWave(int amount)
    {
        if (!isWaveActive())
        {
            // Spawn a wave
        }
    }
    
    public boolean isWaveActive()
    {
        if (creature != null)
            return true;
        
        return false;
    }
    
    private void spawnWeaponAtRandomLocation(Weapon weapon)
    {
        int randomX = Greenfoot.getRandomNumber(WORLD_WIDTH);
        int randomY = Greenfoot.getRandomNumber(WORLD_HEIGHT);
        this.addObject(weapon, randomX, randomY);        
    }
    
    private void removeWeapon(Weapon weapon)
    {
        this.removeObject(weapon);
    }
    
    /**
     * Return the player currently within the GameBoard
     */
    public Player getPlayer()
    {
        return player;
    }
}
