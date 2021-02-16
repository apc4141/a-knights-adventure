package knightsadventure.entity;

import java.util.Random;

/**
 *  Class that represents basic unit that will fight and have health, inventory and stats
 */
public class Entity {

    private String name;

    private HealthManager health;

    private int strength;

    public Entity(String name, int maxHealth, int strength)
    {
        this.name = name;
        this.health = new HealthManager(maxHealth);
        this.strength = strength;
    }

    public boolean isDead()
    {
        return health.isDead();
    }

    /**
     *  Has knightsadventure.entity handle basic attack
     * @param attack CompoundAttack that consists of the damage the knightsadventure.entity should handle
     * @return Amount of damage actually taken by knightsadventure.entity
     */
    private int handleAttack(CompoundAttack attack)
    {
        return health.handleAttack(attack);
    }

    /**
     *  Will calculate correct attack it will do based on stats and equiptment
     *  and with call handleAttack() with paramater of calculated compound attack
     * @param ent Entity that handleAttack() should be called on
     * @return InteractionData object based on the event
     */
    public InteractionData doAttack(Entity ent)
    {
        //For testing purposes this is for now set to a non calculated value
        CompoundAttack attack = new Attack(strength, DamageType.PHYSICAL).toCompound();
        attack.addAttack(new Random().nextInt(50), DamageType.FIRE);

        int healthTaken = ent.handleAttack(attack);
        return new InteractionData(this, ent, attack, healthTaken);
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name+": "+health.toString();
    }
}
