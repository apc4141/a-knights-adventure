package knightsadventure.ui.events.inventory;

import knightsadventure.entity.Entity;
import knightsadventure.io.Output;
import knightsadventure.ui.events.LinkEvent;
import knightsadventure.ui.events.LoopLinkEvent;

/**
 * Open your inventory event
 * Gives player basic inventory options
 */
public class InventoryEvent extends LoopLinkEvent {

    private final Entity player;

    public InventoryEvent(Entity player) {
        super("open inventory");
        this.player = player;

        WeaponsInventoryEvent wie = new WeaponsInventoryEvent(player);
        events.add(wie);
    }


    @Override
    public void preLink() {
        Output.println("What would you like to see?");
    }
}
