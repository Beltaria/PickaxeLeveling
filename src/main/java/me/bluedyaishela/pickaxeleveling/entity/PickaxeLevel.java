package me.bluedyaishela.pickaxeleveling.entity;

import org.bukkit.Material;

public class PickaxeLevel {
    private String name;
    private int necessaryBlocks;
    private Material material;
    private String light_color;
    private String dark_color;

    public PickaxeLevel(String name, int necessaryBlocks, Material material)
    {
        this.name = name;
        this.necessaryBlocks = necessaryBlocks;
        this.material = material;
    }

    public PickaxeLevel(String name, int necessaryBlocks, Material material, String light_color, String dark_color) {
        this.name = name;
        this.necessaryBlocks = necessaryBlocks;
        this.material = material;
        this.light_color = light_color;
        this.dark_color = dark_color;
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

    public String getLight_color() {
        return light_color;
    }

    public String getDark_color() {
        return dark_color;
    }
}
