package org.academiadecodigo.bootcamp40.persistence.model;

public enum LevelType {

    LEVEL_1(1,3),

    LEVEL_2(4,6),

    LEVEL_3(7,9);

    private int min;
    private int max;

    LevelType(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }


}
