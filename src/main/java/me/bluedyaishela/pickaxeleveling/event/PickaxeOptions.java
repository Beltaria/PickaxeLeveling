package me.bluedyaishela.pickaxeleveling.event;

import me.bluedyaishela.pickaxeleveling.entity.Options;
import me.bluedyaishela.pickaxeleveling.utils.CheckPickaxe;
import me.bluedyaishela.pickaxeleveling.utils.Tools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickaxeOptions implements Listener {

    public Map<Integer, Options> optionsMap = new HashMap<>();

    private final String __PREFIX__ = "§8[§ePickaxeLeveling§8] » §f";
    private static final CheckPickaxe checkPickaxe = new CheckPickaxe();
    private static final Tools tools = new Tools();

    public PickaxeOptions()
    {
        optionsMap.put(1, new Options(true, false, false));
        optionsMap.put(2, new Options(true, false, false));
        optionsMap.put(3, new Options(true, false, false));
        optionsMap.put(4, new Options(true, false, false));
        optionsMap.put(5, new Options(true, false, false));
        optionsMap.put(6, new Options(true, false, false));
        optionsMap.put(7, new Options(true, false, false));
        optionsMap.put(8, new Options(true, false, false));
        optionsMap.put(9, new Options(true, true, false));
        optionsMap.put(10, new Options(true, true, false));
        optionsMap.put(11, new Options(true, true, false));
        optionsMap.put(12, new Options(true, true, false));
        optionsMap.put(13, new Options(true, true, false));
        optionsMap.put(14, new Options(true, true, false));
        optionsMap.put(15, new Options(true, true, false));
        optionsMap.put(16, new Options(true, true, true));
        optionsMap.put(17, new Options(true, true, true));
        optionsMap.put(18, new Options(true, true, true));
        optionsMap.put(19, new Options(true, true, true));
        optionsMap.put(20, new Options(true, true, true));
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if (!(player.isSneaking())) return;

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            ItemStack itemStack = player.getInventory().getItemInHand();
            if (!checkPickaxe.getPickaxe().contains(itemStack.getType())) return;

            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta == null || !itemMeta.hasLore()) return;

            List<String> lore = itemMeta.getLore();
            int index = 0;
            for (String line : lore)
            {
                if (line.contains("Option"))
                {
                    // Récupère tout ce qui vient après le "§f" et le change
                    // Vérification du niveau de la pioche et de ses privilèges
                    // Ordre : 1x1 -> 2x1 -> 3x3 || La première valeur signifie la hauteur tandis que la seconde signifie la largeur.
                    String option = tools.getAllAfterWhiteColor(line);
                    String newLore = null;
                    String newOption = null;
                    switch (option)
                    {
                        case "1x1":
                            newOption = "2x1";
                            newLore = tools.setNewOptionInLore(newOption, line);
                            break;
                        case "2x1":
                            newOption = "3x3";
                            newLore = tools.setNewOptionInLore(newOption, line);
                            break;
                        case "3x3":
                            newOption = "1x1";
                            newLore = tools.setNewOptionInLore(newOption, line);
                    }
                    lore.set(index, newLore);
                    itemMeta.setLore(lore);
                    itemStack.setItemMeta(itemMeta);
                    player.sendMessage(__PREFIX__ + "Option changée sur §a" + newOption + " §f!");
                    return;
                }
                index++;
            }
        }
    }

}
