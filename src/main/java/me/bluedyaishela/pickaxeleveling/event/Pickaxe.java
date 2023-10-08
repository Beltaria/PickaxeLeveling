package me.bluedyaishela.pickaxeleveling.event;

import me.bluedyaishela.pickaxeleveling.entity.PickaxeLevel;
import me.bluedyaishela.pickaxeleveling.utils.CheckCharacter;
import me.bluedyaishela.pickaxeleveling.utils.CheckPickaxe;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
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

    public Map<Integer, PickaxeLevel> levels = new HashMap<>();
    private final CheckPickaxe checkPickaxe = new CheckPickaxe();
    private final CheckCharacter checkCharacter = new CheckCharacter();
    private final int maxLevel = 20;

    public Pickaxe() {
        levels.put(1, new PickaxeLevel("§7Pioche du Novice", 20, Material.WOOD_PICKAXE, "§7", "§8"));
        levels.put(2, new PickaxeLevel("§7Pioche en Bois", 5, Material.WOOD_PICKAXE, "§7", "§8"));
        levels.put(3, new PickaxeLevel("§8Pioche de Pierre", 5, Material.STONE_PICKAXE, "§7", "§8"));
        levels.put(4, new PickaxeLevel("§8Pioche de Cuivre", 10, Material.STONE_PICKAXE, "§7", "§8"));
        levels.put(5, new PickaxeLevel("§fPioche de Fer", 10, Material.IRON_PICKAXE, "§7", "§8"));
        levels.put(6, new PickaxeLevel("§fPioche d'Acier", 10, Material.IRON_PICKAXE, "§7", "§8"));
        levels.put(7, new PickaxeLevel("§fPioche d'Argent", 10, Material.IRON_PICKAXE, "§7", "§8"));
        levels.put(8, new PickaxeLevel("§6Pioche d'Or", 10, Material.GOLD_PICKAXE, "§e", "§6"));
        levels.put(9, new PickaxeLevel("§6Pioche d'Émeraude", 10, Material.GOLD_PICKAXE, "§e", "§6"));
        levels.put(10, new PickaxeLevel("§6Pioche de Saphir", 10, Material.GOLD_PICKAXE, "§e", "§6"));
        levels.put(11, new PickaxeLevel("§6Pioche de Rubis", 10, Material.GOLD_PICKAXE, "§e", "§6"));
        levels.put(12, new PickaxeLevel("§9Pioche en Diamant", 10, Material.DIAMOND_PICKAXE, "§9", "§1"));
        levels.put(13, new PickaxeLevel("§9Pioche d'Obsidienne", 10, Material.DIAMOND_PICKAXE, "§9", "§1"));
        levels.put(14, new PickaxeLevel("§9Pioche d'Adamantium", 10, Material.DIAMOND_PICKAXE, "§9", "§1"));
        levels.put(15, new PickaxeLevel("§9Pioche de Mithril", 10, Material.DIAMOND_PICKAXE, "§9", "§1"));
        levels.put(16, new PickaxeLevel("§9Pioche de Titan", 10, Material.DIAMOND_PICKAXE, "§9", "§1"));
        levels.put(17, new PickaxeLevel("§fPioche §fA§as§bt§fr§aa§bl§fe", 10, Material.DIAMOND_PICKAXE, "§9", "§1"));
        levels.put(18, new PickaxeLevel("§dPioche Éthérée", 10, Material.DIAMOND_PICKAXE, "§a", "§2"));
        levels.put(19, new PickaxeLevel("§ePioche de Salomon", 10, Material.DIAMOND_PICKAXE, "§a", "§2"));
        levels.put(20, new PickaxeLevel("§dPioche Légendaire", Material.DIAMOND_PICKAXE, "§d", "§5"));
    }

    private int getPickaxeLevel(List<String> lore)
    {
        for (String line : lore)
        {
            if (line.contains("Niveau"))
            {
                List<Integer> integers = checkCharacter.getIntegersInStringByWords(line);
                return integers.get(0);
            }
        }
        return 0;
    }

    private ItemStack nextPickaxeLevel(ItemStack itemStack)
    {
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lore = itemMeta.getLore();

        int actualLevel = this.getPickaxeLevel(lore);
        int newLevel = actualLevel + 1;

        PickaxeLevel pickaxeLevel = levels.get(newLevel);

        itemStack.setType(pickaxeLevel.getMaterial());
        itemMeta.setDisplayName(pickaxeLevel.getName());
        String light_color = pickaxeLevel.getLight_color();
        String dark_color = pickaxeLevel.getDark_color();

        int index = 0;

        List<String> stringPickaxe = new ArrayList<>();
        stringPickaxe.add(light_color);
        stringPickaxe.add(dark_color);
        stringPickaxe.add(light_color);
        stringPickaxe.add(dark_color);

        List<String> stringMiner = new ArrayList<>();
        stringMiner.add(light_color);
        stringMiner.add(dark_color);
        stringMiner.add(light_color);

        List<String> stringLevel = new ArrayList<>();
        stringLevel.add(dark_color);
        stringLevel.add(light_color);
        stringLevel.add(light_color);

        List<String> stringProgression = new ArrayList<>();
        stringProgression.add(dark_color);
        stringProgression.add(light_color);
        stringProgression.add(light_color);

        List<Integer> integersLevel = new ArrayList<>();
        integersLevel.add(newLevel);
        integersLevel.add(maxLevel);

        List<Integer> integersProgression = new ArrayList<>();
        integersProgression.add(0);
        integersProgression.add(pickaxeLevel.getNecessaryBlocks());

        for (String line : lore)
        {
            if (line.contains("--"))
            {
                String bar = light_color + "§m-------" + dark_color + "§m-------" + light_color + "§m-------";
                lore.set(index, bar);
            }
            if (line.contains("Pioche")) lore.set(index, checkCharacter.getNewLoreLevelUp(stringPickaxe, line));
            if (line.contains("monde minage")) lore.set(index, checkCharacter.getNewLoreLevelUp(stringMiner, line));
            if (line.contains("Niveau"))
            {
                String levelLore = checkCharacter.getNewLoreLevelUp(stringLevel, line);
                lore.set(index, checkCharacter.setIntegersInStringByWords(integersLevel, levelLore));
            }
            if (line.contains("Progression"))
            {
                if (newLevel == 20)
                {
                    String progressionLore = stringProgression.get(0) + "» " + stringProgression.get(1) + "Blocs cassés : " + "§f" + 0;
                    lore.set(index, progressionLore);
                } else {
                    String progressionLore = checkCharacter.getNewLoreLevelUp(stringProgression, line);
                    lore.set(index, checkCharacter.setIntegersInStringByWords(integersProgression, progressionLore));
                }
            }
            index++;
        }
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);

        itemStack.setItemMeta(itemMeta);
        itemStack.setDurability((short) 0);
//        itemStack.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);

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
                if (line.contains("Blocs cassés"))
                {
                    List<Integer> listNbBlocks = checkCharacter.getIntegersInStringByWords(line);
                    int nbBlockMined = listNbBlocks.get(0);
                    int newBlocksMined = nbBlockMined + 1;
                    listNbBlocks.set(0, newBlocksMined);
                    String newLore = checkCharacter.setIntegersInStringByWords(listNbBlocks, line);
                    lore.set(index, newLore);
                }
                else if (line.contains("Progression"))
                {
                    List<Integer> integers = checkCharacter.getIntegersInStringByWords(line);

                    int firstInteger = integers.get(0);
                    int secondInteger = integers.get(1);

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
//                            integers.set(2, firstInteger);
                            integers.set(0, firstInteger);
                            String newLore = checkCharacter.setIntegersInStringByWords(integers, line);
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
