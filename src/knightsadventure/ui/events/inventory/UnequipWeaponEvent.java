package knightsadventure.ui.events.inventory;

import knightsadventure.entity.Entity;
import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.io.Output;
import knightsadventure.ui.events.Event;

public class UnequipWeaponEvent extends Event {

    private Entity player;

    public UnequipWeaponEvent(Entity player) {
        super("unequip");
        this.player = player;
    }

    @Override
    public void execute() {
        WeaponItem weapon = player.getInventory().getWeapon();
        player.getInventory().unequipWeapon();
        Output.println(player.getName()+" unequipped "+weapon.name+"!");
    }
}
