public class Turns
{
    public int turnMeter;
    public String enemyName;

    public Turns(int turnMeter, String enemyName) {
        this.turnMeter = turnMeter;
        this.enemyName = enemyName;
    }

    public int getTurnMeter() {
        return turnMeter;
    }

    public void setTurnMeter(int turnMeter) {
        this.turnMeter = turnMeter;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
}
