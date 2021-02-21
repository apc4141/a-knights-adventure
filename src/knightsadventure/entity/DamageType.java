package knightsadventure.entity;

public enum DamageType {
    PHYSICAL(0, "physical", 'p'),
    FIRE(1, "fire", 'f'),
    WATER(2, "water", 'w'),
    EARTH(3, "earth", 'e'),
    MAGIC(4, "magic", 'm'),
    LIGHT(5, "light", 'l'),
    DARK(6, "dark", 'd'),
    CURSE(7, "curse", 'c');

    public int id;
    public String name;
    public char sym;

    DamageType(int id, String name, char sym) { this.id = id; this.name = name; this.sym = sym; }
}
