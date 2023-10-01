package me.bluedyaishela.pickaxeleveling.entity;

public class PickaxeLevel {
    private String name;
    private int necessaryBlocks;

    public PickaxeLevel(String name, int necessaryBlocks)
    {
        this.name = name;
        this.necessaryBlocks = necessaryBlocks;
    }

    public String getName() {
        return name;
    }

    public int getNecessaryBlocks() {
        return necessaryBlocks;
    }
}
