package me.bluedyaishela.pickaxeleveling.utils;

import org.bukkit.Material;

import java.util.ArrayList;

public class CheckPickaxe {

    public ArrayList<Material> getPickaxe()
    {
        ArrayList<Material> pickaxe = new ArrayList<>();

        pickaxe.add(Material.WOOD_PICKAXE);
        pickaxe.add(Material.STONE_PICKAXE);
        pickaxe.add(Material.GOLD_PICKAXE);
        pickaxe.add(Material.IRON_PICKAXE);
        pickaxe.add(Material.DIAMOND_PICKAXE);

        return pickaxe;
    }
}
