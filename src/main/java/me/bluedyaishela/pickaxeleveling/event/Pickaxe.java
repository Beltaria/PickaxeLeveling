package me.bluedyaishela.pickaxeleveling.event;

import me.bluedyaishela.pickaxeleveling.entity.PickaxeLevel;
import me.bluedyaishela.pickaxeleveling.utils.CheckCharacter;
import me.bluedyaishela.pickaxeleveling.utils.CheckPickaxe;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pickaxe implements Listener {

    private Map<Integer, PickaxeLevel> levels = new HashMap<>();

    public Pickaxe() {
        levels.put(1, new PickaxeLevel("Pioche du Novice", 20));
        levels.put(2, new PickaxeLevel("Pioche en Bois", 50));
        levels.put(3, new PickaxeLevel("Pioche de Pierre", 100));
    }

    private int getPickaxeLevel()
    {

    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event)
    {
        Player player = event.getPlayer();
        CheckPickaxe checkPickaxe = new CheckPickaxe();
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (!checkPickaxe.getPickaxe().contains(itemStack.getType())) return;

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta != null && itemMeta.hasLore())
        {
            List<String> lore = itemMeta.getLore();

            for (String line : lore)
            {
                if (line.contains("Progression"))
                {
                    CheckCharacter checkCharacter = new CheckCharacter();
                    List<Integer> integers = checkCharacter.getTwoIntegerInString(line);

                    if (integers.size() < 2) return;

                    int firstInteger = integers.get(0);
                    int secondInteger = integers.get(1);

                    if (firstInteger < secondInteger)
                    {
                        firstInteger = firstInteger + 1;
                        if (firstInteger == secondInteger)
                        {
                            // Effectuer la montée de niveau
                        } else {
                            // Modification du lore en fonction de l'ajout
                        }
                    }
                }
            }
        }

    }
}
