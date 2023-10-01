package me.bluedyaishela.pickaxeleveling;

import org.bukkit.plugin.java.JavaPlugin;

public final class PickaxeLeveling extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.init();

        this.getCommand("pickaxeleveling").setExecutor(new Commands());
        this.getCommand("picklevel").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
