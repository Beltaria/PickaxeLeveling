package me.bluedyaishela.pickaxeleveling.event;

import me.bluedyaishela.pickaxeleveling.entity.PickaxeLevel;
import me.bluedyaishela.pickaxeleveling.utils.CheckCharacter;
import me.bluedyaishela.pickaxeleveling.utils.CheckPickaxe;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pickaxe implements Listener {

    private Map<Integer, PickaxeLevel> levels = new HashMap<>();
    private final CheckPickaxe checkPickaxe = new CheckPickaxe();
    private final CheckCharacter checkCharacter = new CheckCharacter();
    private final int maxLevel = 20;

    public Pickaxe() {
        levels.put(1, new PickaxeLevel("Pioche du Novice", 20, Material.WOOD_PICKAXE));
        levels.put(2, new PickaxeLevel("§7Pioche en Bois", 50, Material.WOOD_PICKAXE));
        levels.put(3, new PickaxeLevel("§8Pioche de Pierre", 100, Material.STONE_PICKAXE));
    }

    private int getPickaxeLevel(List<String> lore)
    {
        for (String line : lore)
        {
            if (line.contains("Niveau"))
            {
                List<Integer> integers = checkCharacter.getIntegersInString(line);
                return integers.get(2);
            }
        }
        return 0;
    }

    private ItemStack nextPickaxeLevel(ItemStack itemStack)
    {
        // A faire
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lore = itemMeta.getLore();

        int actualLevel = this.getPickaxeLevel(lore);
        int newLevel = actualLevel + 1;

        PickaxeLevel pickaxeLevel = levels.get(newLevel);

        itemStack.setType(pickaxeLevel.getMaterial());
        itemMeta.setDisplayName(pickaxeLevel.getName());

        int index = 0;

        List<Integer> integersLevel = new ArrayList<>();
        integersLevel.add(8);
        integersLevel.add(7);
        integersLevel.add(newLevel);
        integersLevel.add(7);
        integersLevel.add(this.maxLevel);

        List<Integer> integersProgression = new ArrayList<>();
        integersProgression.add(8);
        integersProgression.add(7);
        integersProgression.add(0);
        integersProgression.add(7);
        integersProgression.add(pickaxeLevel.getNecessaryBlocks());

        for (String line : lore)
        {
            if (line.contains("Niveau"))
            {
                String newLoreLevel = checkCharacter.setIntegersInString(integersLevel, line);
                lore.set(index, newLoreLevel);
            }
            if (line.contains("Progression"))
            {
                String newLoreProgression = checkCharacter.setIntegersInString(integersProgression, line);
                lore.set(index, newLoreProgression);
            }
            index++;
        }
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);

        itemStack.setItemMeta(itemMeta);
        itemStack.setDurability((short) 0);

        return itemStack;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event)
    {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInHand();

        if (!checkPickaxe.getPickaxe().contains(itemStack.getType())) return;

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta != null && itemMeta.hasLore())
        {
            List<String> lore = itemMeta.getLore();
            int index = 0;

            for (String line : lore)
            {
                if (line.contains("Progression"))
                {
                    List<Integer> integers = checkCharacter.getIntegersInString(line);

                    int firstInteger = integers.get(2);
                    int secondInteger = integers.get(4);

                    if (firstInteger < secondInteger)
                    {
                        firstInteger = firstInteger + 1;
                        if (firstInteger == secondInteger)
                        {
                            // Effectuer la montée de niveau
                            player.sendMessage("§aNiveau supérieur !");
                            ItemStack newItemStack = this.nextPickaxeLevel(itemStack);
                            player.getInventory().remove(itemStack);
                            player.getInventory().addItem(newItemStack);
                        } else {
                            integers.set(2, firstInteger);
                            String newLore = checkCharacter.setIntegersInString(integers, line);
                            lore.set(index, newLore);
                        }
                    }
                }
                index++;
            }
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
        }

    }
}
