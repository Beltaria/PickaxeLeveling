package me.bluedyaishela.pickaxeleveling;

import me.bluedyaishela.pickaxeleveling.entity.PickaxeLevel;
import me.bluedyaishela.pickaxeleveling.event.Pickaxe;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static me.bluedyaishela.pickaxeleveling.event.Pickaxe pickaxe = new Pickaxe();

    public static ItemStack Pickaxe;

    public static void init()
    {
        createPickaxe();
    }

    private static void createPickaxe() {

        PickaxeLevel pickaxeLevel = pickaxe.levels.get(1);

        String pickaxeName = pickaxeLevel.getName();
        Integer pickaxeNecessaryBlocks = pickaxeLevel.getNecessaryBlocks();
        Material pickaxeMaterial = pickaxeLevel.getMaterial();
        String pickaxeLightColor = pickaxeLevel.getLight_color();
        String pickaxeDarkColor = pickaxeLevel.getDark_color();

        ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§7Pioche du débutant");

        List<String> lore = new ArrayList<>();
        lore.add("§"+pickaxeLightColor+"§m-------§"+pickaxeDarkColor+"§m-------§"+pickaxeLightColor+"§m-------");
        lore.add("");
        lore.add("§7Cette §8Pioche §7te permet de §8miner");
        lore.add("§7indéfiniment dans le §8monde minage§7.");
        lore.add("");
        lore.add("§8» §7Niveau : §f1 §7/ §f20");
        lore.add("§8» §7Progression : §f0 §7/ §f5");
//        lore.add(ChatColor.DARK_GRAY + "» " + ChatColor.GRAY + "Progression : " + ChatColor.WHITE + 0 + ChatColor.GRAY + " / " + ChatColor.WHITE + 100);
        lore.add("");
        lore.add("§7§m-------§8§m-------§7§m-------");

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        Pickaxe = itemStack;
    }
}
