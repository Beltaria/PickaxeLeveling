package me.bluedyaishela.pickaxeleveling;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack Pickaxe;

    public static void init()
    {
        createPickaxe();
    }

    private static void createPickaxe() {

        ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§7Pioche du débutant");

        List<String> lore = new ArrayList<>();
        lore.add("§7§m-------§8§m-------§7§m-------");
        lore.add("");
        lore.add("§7Cette §8Pioche §7te permet de §8miner");
        lore.add("§7indéfiniment dans le §8monde minage§7.");
        lore.add("");
        lore.add("§8» §7Niveau : §f1 §7/ §f20");
        lore.add("§8» §7Progression : §f0 §7/ §f100");
        lore.add("");
        lore.add("§7§m-------§8§m-------§7§m-------");

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        Pickaxe = itemStack;
    }
}
