package knightsadventure.ui.events.inventory;

import knightsadventure.entity.Entity;
import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.io.Output;
import knightsadventure.ui.events.LinkEvent;

import java.util.HashMap;

/**
 * Lists all weapons
 */
public class WeaponsInventoryEvent extends LinkEvent {

    private final Entity player;

    public WeaponsInventoryEvent(Entity player) {
        super("weapons");
        this.player = player;
    }

    @Override
    public void preLink() {
        HashMap<Integer, WeaponItem> weapons = player.getInventory().getWeapons();

        for(int key : weapons.keySet()) {
            WeaponItem weapon = weapons.get(key);
            String eventName = weapon.name+(weapon.equals(player.getInventory().getWeapon())?"(equipped)":"");
            events.add(new WeaponChosenEvent(eventName, weapon, player));
        }

        Output.println("Which weapon would you like to look at?");
    }
}
