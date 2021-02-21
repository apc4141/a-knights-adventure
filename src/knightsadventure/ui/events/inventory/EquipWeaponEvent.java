package knightsadventure.ui.events.inventory;

import knightsadventure.entity.Entity;
import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.io.Output;
import knightsadventure.ui.events.Event;

public class EquipWeaponEvent extends Event {

    private final Entity player;
    private final WeaponItem weapon;

    public EquipWeaponEvent(WeaponItem weapon, Entity player) {
        super("equip");
        this.player = player;
        this.weapon = weapon;
    }

    @Override
    public void execute() {
        player.getInventory().equip(weapon);
        Output.println(player.getName()+" equippied "+weapon.name+"!");
    }
}
