import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed;
    private int health;
    private int armor;
    private int score;
    private Weapon startWeapon;
    private GreenfootImage startImage;
    
    private boolean isAlive;
    private Weapon currentWeapon;
    
    private int actCount;
    
    /**
     * Default constructor for Player.
     */
    public Player()
    {
        startImage = new GreenfootImage("player.png");
        init();
    }
    
    /**
     * Initializes the default settings for the player.
     */
    private void init()
    {
       speed = 2;
       health = 3;
       armor = 0;
       score = 0;
       startWeapon = new Pistol();
       currentWeapon = startWeapon;
       this.setImage(startImage);
       isAlive = true;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        turnTowardsMouse();
        pickupWeapon();
        shoot();
    }
    
    /**
     * Gets the movement speed of the player.
     */
    public int getSpeed()
    {
        return this.speed;
    }
    
    /**
     * Sets the movement speed of the player.
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    /**
     * Gets the player's health.
     */
    public int getHealth()
    {
        return this.health;
    }
    
    /**
     * Sets the player's health.
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    /**
     * Gets the player's armor.
     */
    public int getArmor()
    {
        return this.armor;
    }
    
    /**
     * Sets the player's armor.
     */
    public void setArmor(int armor)
    {
        this.armor = armor;
    }
    
    /**
     * Get's the player's current gamescore.
     */
    public int getScore()
    {
        return this.score;
    }
    
    /**
     * Sets the player's score
     */
    public void setScore(int amount)
    {
        this.score = score;
    }
    
    /**
     * Move the character in a direction using the arrow keys; left, right, up and down, or by using; W, A, S, D
     */
    public void move()
    {
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            this.setLocation(this.getX() - speed, this.getY());
        }
        
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            this.setLocation(this.getX() + speed, this.getY());
        }
        
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            this.setLocation(this.getX(), this.getY() - speed);
        }
        
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            this.setLocation(this.getX(), this.getY() + speed);
        }
    }
    
    /**
     * Turns the character (player) towards the mouse.
     */
    public void turnTowardsMouse()
    {
        if (Greenfoot.getMouseInfo() == null)
            return;
        
        this.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    
    /**
     * Kills the player.
     */
    public void kill()
    {
        isAlive = false;
    }
    
    /**
     * Picks up a weapon on the ground.
     */
    public void pickupWeapon()
    {
        Actor weapon = this.getOneIntersectingObject(Weapon.class);
        if (this.isTouching(Weapon.class))
        {   
            currentWeapon = (Weapon) weapon;
            this.getWorld().removeObject(weapon);
        }
    }
    
    /**
     * Gets the current weapon the player is using.
     */
    public Weapon getCurrentWeapon()
    {
        return currentWeapon;
    }
    
    /**
     * Shoot.
     */
    public void shoot()
    {
        // Set's the fire rate of the currently equipped weapon.
        if (actCount > 5 + currentWeapon.fireRate())
        {
            // Set space as the default key for shooting.
            if (Greenfoot.isKeyDown("space"))
            {
                Bullet bullet = new Bullet();
                bullet.setRotation(this.getRotation());
                this.getWorld().addObject(bullet, getX(), getY());
                actCount = 0;
            }
        }
        actCount++;
    }
}
