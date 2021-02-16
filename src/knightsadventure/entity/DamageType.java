package knightsadventure.entity;

public enum DamageType {
    PHYSICAL(0, "physical", 'P'),
    FIRE(1, "fire", 'F'),
    WATER(2, "water", 'W'),
    EARTH(3, "earth", 'E'),
    MAGIC(4, "magic", 'M'),
    LIGHT(5, "light", 'L'),
    DARK(6, "dark", 'D'),
    CURSE(7, "curse", 'C');

    public int id;
    public String name;
    public char sym;

    DamageType(int id, String name, char sym) { this.id = id; this.name = name; this.sym = sym; }
}
