package Entity;

/**
 * Represents the data for an attack interaction between two entities
 */
public class InteractionData {

    public Entity attacker;
    public Entity receiver;
    public CompoundAttack attack;
    public int healthTaken;

    public InteractionData(Entity attacker, Entity receiver, CompoundAttack attack, int healthTaken) {
        this.attacker = attacker;
        this.receiver = receiver;
        this.attack = attack;
        this.healthTaken = healthTaken;
    }
}
