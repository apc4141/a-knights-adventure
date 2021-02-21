package knightsadventure;

import knightsadventure.entity.DamageType;
import knightsadventure.entity.Entity;
import knightsadventure.entity.NPCEntity;
import knightsadventure.entity.PlayerEntity;
import knightsadventure.entity.inventory.*;
import knightsadventure.game.Battle;
import knightsadventure.io.Input;
import knightsadventure.io.Output;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        init();



        Scanner scanner = new Scanner(System.in);
        Output.println("What shall this hero's name be?");
        String name = scanner.next();
        PlayerEntity player = new PlayerEntity(name, 350);

        WeaponItem weaponItem = new WeaponItem("Sword of Sunlight", WeaponType.STRAIGHT_SWORD);
        weaponItem.setDamage(new Random().nextInt(15), DamageType.PHYSICAL);
        weaponItem.setDamage(new Random().nextInt(15), DamageType.FIRE);
        if(name.equalsIgnoreCase("aiden")) {
            weaponItem.setDamage(new Random().nextInt(100)+100, DamageType.WATER);
        }

        player.getInventory().equip(weaponItem);

        ArmorItem armorItem = new ArmorItem("Hidden Leaf Headband", 10, 2, ArmorType.HELMET);
        armorItem.setDefense(0, DamageType.FIRE);

        WeaponItem narutoWeapon = new WeaponItem("Nine Tails Fox Chakra", WeaponType.GRIMOIRE);
        narutoWeapon.setDamage(new Random().nextInt(10), DamageType.CURSE);
        narutoWeapon.setDamage(new Random().nextInt(10), DamageType.FIRE);

        NPCEntity naruto = new NPCEntity("Naruto", 300);
        naruto.getInventory().equip(armorItem);
        naruto.getInventory().equip(narutoWeapon);

        Battle battle = new Battle(player, naruto);
        Entity loser = battle.start();

        Output.println("=======================");
        if(loser.equals(naruto)) {
            Output.println(player.getName()+" wins!");
        } else {
            Output.println("Naruto wins!");
        }
        Output.println("=======================");
    }


    private static void init() {
        Input.init();
        ItemRegistry.init();
    }
}
