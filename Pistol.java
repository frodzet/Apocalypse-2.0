import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pistol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pistol extends Weapon
{
    private static final int PISTOL_DAMAGE = 1;
    private static final int PISTOL_FIRE_RATE = 0;
    private static final int PISTOL_RELOAD_TIME = 1;
    private GreenfootImage weaponImage;
    
    public Pistol()
    {
        this.weaponImage = new GreenfootImage("ant.png");
        this.setImage(weaponImage);
    }
    
    public int damage()
    {
        return PISTOL_DAMAGE;
    }
    
    public int fireRate()
    {
        return PISTOL_FIRE_RATE;
    }
    
    public int reloadTime()
    {
        return PISTOL_RELOAD_TIME;
    }
}
