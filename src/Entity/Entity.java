package Entity;

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

    public void handleAttack(CompoundAttack attack)
    {
        health.handleAttack(attack);
    }

    public void doAttack(Entity ent)
    {
        ent.handleAttack(new Attack(strength, DamageType.PHYSICAL).toCompound());
    }

    public String healthAsString()
    {
        return health.toString();
    }
}
