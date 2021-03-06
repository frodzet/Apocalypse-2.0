import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG extends Weapon
{
    private static final int MG_DAMAGE = 1;
    private static final int MG_FIRE_RATE = 5;
    private static final int MG_RELOAD_TIME = 1;
    private GreenfootImage weaponImage;
    
    public MG()
    {
        this.weaponImage = new GreenfootImage("heavyGun.png");
        this.setImage(weaponImage);
    }
    
    public int damage()
    {
        return MG_DAMAGE;
    }
    
    public int fireRate()
    {
        return MG_FIRE_RATE;
    }
    
    public int reloadTime()
    {
        return MG_RELOAD_TIME;
    }
}
