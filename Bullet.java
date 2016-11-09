import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int rotation;
    
    /**
     * Default bullet constructor.
     */
    public Bullet()
    {
        setDirection();
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveBullet();
        kill();
    }
    
    /**
     * Move's the bullet.
     */
    public void moveBullet()
    {
        move(5);
    }
    
    /**
     * The direction of the bullet.
     */
    public void setDirection()
    {
        if (Greenfoot.getMouseInfo() == null)
            return;
        
        this.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    
    /**
     * Gets the damage from the currently equipped weapon.
     */
    public int getDamage()
    {
        GameBoard gameBoard = (GameBoard) this.getWorld();
        if (gameBoard != null)
        {
            Weapon weapon = gameBoard.getPlayer().getCurrentWeapon();
            return weapon.damage();
        }
        
        return 0;
    }
    
    /**
     * Kills the creature.
     */
    public void kill()
    {
        Actor creature = this.getOneIntersectingObject(Creature.class);
        Creature newCreature = (Creature) creature;
        if (newCreature == null)
            return;
        if (newCreature.getHealth() == 0)
            creature.getWorld().removeObject(creature);
           
        newCreature.setHealth(newCreature.getHealth() - getDamage());
        this.getWorld().removeObject(this); 
    }
}
