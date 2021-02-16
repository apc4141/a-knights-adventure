package Entity;

import java.util.Arrays;
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
        this.absorption = new Random().nextFloat()*15;

        // Init defenses
        defenses = new int[DamageType.values().length];
        Arrays.fill(defenses, 0);
        defenses[0] = new Random().nextInt(100);
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
    public int handleAttack(CompoundAttack cattack)
    {
        int totalDamage = 0;

        for(Attack attack : cattack) {
            int damage = attack.attackPower;
            DamageType type = attack.damageType;

            damage -= defenses[type.id];
            damage = (int) Math.floor(damage * (1 - (absorption/100)));

            health -= damage;
            totalDamage += damage;
            if (health < 0) health = 0;
        }

        return totalDamage;
    }

    @Override
    public String toString()
    {
        return health+"/"+maxHealth+"HP";
    }
}
