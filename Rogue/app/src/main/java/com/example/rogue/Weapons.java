package com.example.rogue;

public class Weapons
{
    public int max, min;
    public String Name;

    public Weapons(int max, int min, String name) {
        this.max = max;
        this.min = min;
        Name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
