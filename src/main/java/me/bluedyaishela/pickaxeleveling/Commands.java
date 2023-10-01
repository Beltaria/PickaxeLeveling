package me.bluedyaishela.pickaxeleveling;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class Commands implements CommandExecutor, TabCompleter {

    private final String __PREFIX__ = "§8[§ePickaxeLeveling§8] » §f";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;
        if (!(sender.hasPermission("op") || sender.hasPermission("pickaxeleveling.use")))
        {
            sender.sendMessage("§cVous n'avez pas la permission d'exécuter cette commande.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(__PREFIX__ + "Vous pouvez consulter l'ensemble des commandes avec §c/help §f!");
            return true;
        }

        Player player = (Player) sender;

        switch (args[0])
        {
            case "help":
                return true;
            case "give":
                player.getInventory().addItem(ItemManager.Pickaxe);
                player.sendMessage(__PREFIX__ + "Pioche obtenue avec §asuccès §f!");
                return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
