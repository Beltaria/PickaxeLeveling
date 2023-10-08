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

        ItemStack itemStack = new ItemStack(pickaxeMaterial);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(pickaxeName);

        List<String> lore = new ArrayList<>();
        lore.add(pickaxeLightColor+"§m-------"+pickaxeDarkColor+"§m-------"+pickaxeLightColor+"§m-------");
        lore.add("");
        lore.add(pickaxeLightColor+"Cette "+pickaxeDarkColor+"Pioche "+pickaxeLightColor+"te permet de "+pickaxeDarkColor+"miner");
        lore.add(pickaxeLightColor+"indéfiniment dans le "+pickaxeDarkColor+"monde minage"+pickaxeLightColor+".");
        lore.add("");
        lore.add(pickaxeDarkColor+"» "+pickaxeLightColor+"Niveau : §f1 "+pickaxeLightColor+"/ §f20");
        lore.add(pickaxeDarkColor+"» "+pickaxeLightColor+"Progression : §f0 "+pickaxeLightColor+"/ §f"+pickaxeNecessaryBlocks);
        lore.add(pickaxeDarkColor+"» "+pickaxeLightColor+"Option : §f1x1");
//        lore.add(ChatColor.DARK_GRAY + "» " + ChatColor.GRAY + "Progression : " + ChatColor.WHITE + 0 + ChatColor.GRAY + " / " + ChatColor.WHITE + 100);
        lore.add("");
        lore.add(pickaxeLightColor+"§m-------"+pickaxeDarkColor+"§m-------"+pickaxeLightColor+"§m-------");

        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);

        itemStack.setItemMeta(itemMeta);

        Pickaxe = itemStack;
    }
}
