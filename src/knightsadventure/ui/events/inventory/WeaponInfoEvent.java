package knightsadventure.ui.events.inventory;

import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.io.Output;
import knightsadventure.ui.events.Event;

/**
 * Display info about a specific weapon
 */
public class WeaponInfoEvent extends Event {

    private final WeaponItem weapon;

    public WeaponInfoEvent(WeaponItem weapon) {
        super("info");
        this.weapon = weapon;
    }

    @Override
    public void execute() {
        String info = weapon.getInfo();
        Output.println(info);
    }
}
