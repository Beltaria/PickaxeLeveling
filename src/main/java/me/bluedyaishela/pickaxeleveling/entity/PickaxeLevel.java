package me.bluedyaishela.pickaxeleveling.entity;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PickaxeLevel {
    private String name;
    private int necessaryBlocks;
    private Material material;

    public PickaxeLevel(String name, int necessaryBlocks, Material material)
    {
        this.name = name;
        this.necessaryBlocks = necessaryBlocks;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public int getNecessaryBlocks() {
        return necessaryBlocks;
    }

    public Material getMaterial() {
        return material;
    }
}
