package Entity;

/**
 *  Class that represents basic unit that will fight and have health, inventory and stats
 */
public class Entity {

    private HealthManager health;

    private int strength;

    public Entity(int maxHealth, int strength)
    {
        this.health = new HealthManager(maxHealth);
        this.strength = strength;
    }

    public boolean isDead()
    {
        return health.isDead();
    }

    /**
     *  Has entity handle basic attack
     * @param attack CompoundAttack that consists of the damage the entity should handle
     */
    public void handleAttack(CompoundAttack attack)
    {
        health.handleAttack(attack);
    }

    /**
     *  Will calculate correct attack it will do based on stats and equiptment
     *  and with call handleAttack() with paramater of calculated compound attack
     * @param ent Entity that handleAttack() should be called on
     */
    public void doAttack(Entity ent)
    {
        ent.handleAttack(new Attack(strength, DamageType.PHYSICAL).toCompound());
    }

    public String healthAsString()
    {
        return health.toString();
    }
}
