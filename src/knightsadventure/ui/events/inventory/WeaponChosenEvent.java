package knightsadventure.ui.events.inventory;

import knightsadventure.entity.Entity;
import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.io.Output;
import knightsadventure.ui.events.LinkEvent;
import knightsadventure.ui.events.LoopLinkEvent;

/**
 * After weapon is chosen, give options
 */
public class WeaponChosenEvent extends LoopLinkEvent {

    private final WeaponItem weapon;
    private final Entity player;

    public WeaponChosenEvent(String eventName, WeaponItem weapon, Entity player) {
        super(eventName);
        this.weapon = weapon;
        this.player = player;

        // If equipped then give unequip event
        if(player.getInventory().isEquipped(weapon)) {
            UnequipWeaponEvent uwe = new UnequipWeaponEvent(player);
            events.add(uwe);
        } else {
            EquipWeaponEvent ewe = new EquipWeaponEvent(weapon, player);
            events.add(ewe);
        }

        //Events that every weapon will have
        WeaponInfoEvent wie = new WeaponInfoEvent(weapon);
        events.add(wie);
    }

    @Override
    public void preLink() {
        Output.println("What would you like to do with this '"+weapon.name+"'?");
    }
}
