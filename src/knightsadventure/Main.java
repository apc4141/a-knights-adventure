package knightsadventure;

import knightsadventure.entity.*;
import knightsadventure.entity.inventory.ArmorItem;
import knightsadventure.entity.inventory.ItemRegistry;
import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.entity.inventory.WeaponType;
import knightsadventure.entity.stats.Stat;
import knightsadventure.entity.stats.StatsManager;

import java.util.Arrays;
import java.util.Random;

import static knightsadventure.entity.inventory.ArmorType.CHESTPLATE;

public class Main {
    public static void main(String[] args) throws Exception {
        init();

        

    }


    private static void init() {
        ItemRegistry.init();
    }
}
