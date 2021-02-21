package knightsadventure.entity;

import knightsadventure.io.Output;
import knightsadventure.ui.events.LinkEvent;
import knightsadventure.ui.events.AttackEvent;
import knightsadventure.ui.events.PlayerHandleMoveEvent;
import knightsadventure.ui.events.inventory.InventoryEvent;

/**
 * Player entity - Entity class that the player will be in control of
 */
public class PlayerEntity extends Entity {

    public PlayerEntity(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void handleNextMove(Entity target) {
        PlayerHandleMoveEvent playerHandleMoveEvent = new PlayerHandleMoveEvent(this, target);
        playerHandleMoveEvent.execute();
    }
}
