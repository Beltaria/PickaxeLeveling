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
        // A faire
        return 1;
    }

    private void nextPickaxeLevel()
    {
        // A faire
        return;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event)
    {
        Player player = event.getPlayer();

        player.sendMessage("0");

        CheckPickaxe checkPickaxe = new CheckPickaxe();
        ItemStack itemStack = player.getInventory().getItemInHand();

        player.sendMessage("1. Évènement fonctionnel");

        if (!checkPickaxe.getPickaxe().contains(itemStack.getType())) return;

        ItemMeta itemMeta = itemStack.getItemMeta();

        player.sendMessage("2. Vérification fonctionnelle");

        if (itemMeta != null && itemMeta.hasLore())
        {
            List<String> lore = itemMeta.getLore();
            int index = 0;

            player.sendMessage("3. Item has lore");

            for (String line : lore)
            {
                player.sendMessage("4. Boucle : " + line);
                if (line.contains("Progression"))
                {

                    player.sendMessage("4.5 - Progression : " + line);

                    CheckCharacter checkCharacter = new CheckCharacter();
                    List<Integer> integers = checkCharacter.getTwoIntegerInString(line);

//                    if (integers.size() < 2) return;

                    int firstInteger = integers.get(2);
                    int secondInteger = integers.get(4);

                    player.sendMessage("4.6 - Integers : " + firstInteger + " - " + secondInteger);

                    if (firstInteger < secondInteger)
                    {
                        firstInteger = firstInteger + 1;
                        player.sendMessage("5. Entrée : " + firstInteger);
                        if (firstInteger == secondInteger)
                        {
                            // Effectuer la montée de niveau
                        } else {
                            // Modification du lore en fonction de l'ajout
                            integers.set(2, firstInteger);
                            player.sendMessage(integers.get(2).toString());
                            String newLore = checkCharacter.setTwoIntegerInString(integers, line);
                            lore.set(index, newLore);
                            player.sendMessage("6. Modification : " + newLore);
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
