package me.bluedyaishela.pickaxeleveling.entity;

public class Options {
    private final boolean isOnePerOne;
    private final boolean isTwoPerOne;
    private final boolean isTreePerTree;

    public Options(boolean isOnePerOne, boolean isTwoPerOne, boolean isTreePerTree) {
        this.isOnePerOne = isOnePerOne;
        this.isTwoPerOne = isTwoPerOne;
        this.isTreePerTree = isTreePerTree;
    }

    public boolean isOnePerOne() {
        return isOnePerOne;
    }

    public boolean isTwoPerOne() {
        return isTwoPerOne;
    }

    public boolean isTreePerTree() {
        return isTreePerTree;
    }
}
