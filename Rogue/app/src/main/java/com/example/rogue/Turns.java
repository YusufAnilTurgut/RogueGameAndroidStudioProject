package com.example.rogue;

public class Turns
{
    public int turnMeter;
    public Enemy enemy;

    public Turns(int turnMeter, Enemy enemy) {
        this.turnMeter = turnMeter;
        this.enemy = enemy;
    }

    public int getTurnMeter() {
        return turnMeter;
    }

    public void setTurnMeter(int turnMeter) {
        this.turnMeter = turnMeter;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
