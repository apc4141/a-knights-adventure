package knightsadventure.entity.inventory;

/**
 * Handles an items amount and the item itself
 * Helper methods to determine and change the amount
 */
public class ItemStack {

    private final Item item;
    private int amount;

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    /**
     * @return this ItemStack's item
     */
    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public int changeAmount(int deltaAmount) {
        amount += deltaAmount;
        if(amount < 0)
            return Math.abs(amount);
        return 0;
    }

    public boolean isEmpty() {
        return amount <= 0;
    }
}
