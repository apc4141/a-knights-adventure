package knightsadventure.ui.events;

import knightsadventure.entity.Entity;
import knightsadventure.io.Output;
import knightsadventure.ui.events.inventory.InventoryEvent;

public class PlayerHandleMoveEvent extends LinkEvent {

    public PlayerHandleMoveEvent(Entity player, Entity target) {
        super("player handle move");

        AttackEvent attackEvent = new AttackEvent("attack", player, target);
        InventoryEvent inventoryEvent = new InventoryEvent(player);
        events.add(attackEvent);
        events.add(inventoryEvent);
        markInsignificant(inventoryEvent);
    }

    @Override
    public void preLink() {
        Output.println();
        Output.println("====================================");
        Output.println("What would you like to do?");
    }
}
