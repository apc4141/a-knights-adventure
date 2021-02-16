package Entity;

public enum DamageType {
    PHYSICAL(0),
    FIRE(1),
    WATER(2),
    EARTH(3),
    MAGIC(4),
    LIGHT(5),
    DARK(6),
    MEAT(7);

    public int id;

    DamageType(int id) { this.id = id; }
}
