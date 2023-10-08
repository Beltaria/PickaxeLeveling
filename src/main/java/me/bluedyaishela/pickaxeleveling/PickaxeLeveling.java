package me.bluedyaishela.pickaxeleveling;

import me.bluedyaishela.pickaxeleveling.event.Pickaxe;
import me.bluedyaishela.pickaxeleveling.event.PickaxeOptions;
import org.bukkit.plugin.java.JavaPlugin;

public final class PickaxeLeveling extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.init();

        this.getCommand("pickaxeleveling").setExecutor(new Commands());
        this.getCommand("picklevel").setExecutor(new Commands());

        this.getServer().getPluginManager().registerEvents(new PickaxeOptions(), this);
        this.getServer().getPluginManager().registerEvents(new Pickaxe(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
