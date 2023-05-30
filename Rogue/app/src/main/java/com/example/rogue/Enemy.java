package com.example.rogue;

public class Enemy
{
    public int enemyHealth, enemyPower;
    public String enemyName;

    public Enemy(int enemyHealth, int enemyPower, String enemyName) {
        this.enemyHealth = enemyHealth;
        this.enemyPower = enemyPower;
        this.enemyName = enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyPower() {
        return enemyPower;
    }

    public void setEnemyPower(int enemyPower) {
        this.enemyPower = enemyPower;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
}
