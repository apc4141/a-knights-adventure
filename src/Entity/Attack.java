package Entity;

public class Attack {

    public int attackPower;
    public DamageType damageType;

    public Attack(int attackPower, DamageType damageType) {
        this.attackPower = attackPower;
        this.damageType = damageType;
    }

    public CompoundAttack toCompound()
    {
        return new CompoundAttack(new Attack[]{this});
    }
}
