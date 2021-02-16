package Entity;

import java.util.Random;

/**
 * Rules the way an entity will manage hits taken and its own health
 */
public class HealthManager {

    private int maxHealth;
    private int health;

    //Defenses
    private int[] defenses;

    private float absorption;

    public HealthManager(int maxHealth)
    {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.absorption = 0;
        defenses = new int[] { new Random().nextInt(10), 0, 0, 0, 0, 0, 0, 0 };
    }

    public boolean isDead()
    {
        return health <= 0;
    }

    /**
     * For each Attack in compound attack, the flat defense for its respective type is subtracted,
     * then base damage absorption is taken off as a percentage e.g. 5.7 absorption -> damage*=1-(5.7/100)
     * @param cattack CompoundAttack to handle
     */
    public void handleAttack(CompoundAttack cattack)
    {
        for(Attack attack : cattack.attacks) {
            int damage = attack.attackPower;
            DamageType type = attack.damageType;

            damage -= defenses[type.id];
            damage = (int) Math.floor(damage * (1 - (absorption/100)));

            health -= damage;
            if (health < 0) health = 0;
        }
    }

    @Override
    public String toString()
    {
        return "Defense: "+defenses[0]+"; Health: "+health+"/"+maxHealth;
    }
}
