package com.example.rogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int playerHealth, enemyHealth, attackPower, enemyAttackPower, turnMeter = 0, lastTurn,
    fightMeter = 1;
    TextView enemyHealthTV, yourHealthTV, turnMeterTV, enemyNameTV, fightMeterTV;
    String enemyHealthStr = "Enemy Health = ";
    Button attackButton;
    ImageView enemyView;

    static public Enemy emptyEnemy = new Enemy(100, 5, "Goblin");
    static public Enemy goblin = new Enemy(100, 5, "Goblin");
    static public Enemy goblinBoss = new Enemy(200, 20,  "Goblin Boss");
    static public Weapons sword = new Weapons(10,15, "Sword");
    Turns t1 = new Turns(1, goblin);
    //Turns t2 = new Turns(2, goblin);
    //Turns t3 = new Turns(3, goblin);
    //Turns t4 = new Turns(4, goblin);
    Turns t5 = new Turns(5, goblinBoss);
    Turns emptyT = new Turns(5,emptyEnemy);

    Turns[] turnArray = {t1,t5,emptyT};

    public void setLastTurn()
    {
        lastTurn = 2;
    }
    public int setAttackPower(int max, int min){
        return min + (int) (Math.random() * (max - min + 1));
    }

    public int setPlayerHealth()
    {
        return playerHealth = 100;
    }

    public int attack(int attackPower, int enemyHealth)
    {
        attackPower = setAttackPower(sword.max, sword.min);
        int result;
        result = enemyHealth - attackPower;
        return result;
    }

    public int getAttack(int enemyAttackPower, int yourHealth)
    {

        int result;
        result = yourHealth - enemyAttackPower;
        return result;
    }

    public void setPlayer()
    {

        playerHealth = 500;
    }

    public void generateTexts()
    {
        enemyHealthTV.setText("Enemy Health = " + String.valueOf(turnArray[turnMeter].getEnemy().
                enemyHealth));
        yourHealthTV.setText("Your Health = " + String.valueOf(playerHealth));
        enemyNameTV.setText(turnArray[turnMeter].getEnemy().enemyName);
        turnMeterTV.setText(String.valueOf(turnMeter));
        fightMeterTV.setText(String.valueOf(fightMeter));
    }
    public void generateTurn(int turnMeter)
    {
       //
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enemyHealthTV = findViewById(R.id.enemyHealthBar);
        yourHealthTV = findViewById(R.id.PlayerHealthBar);
        attackButton = findViewById(R.id.attackButton);
        turnMeterTV = findViewById(R.id.turnMeterTV);
        enemyNameTV = findViewById(R.id.enemyNameTV);
        fightMeterTV = findViewById(R.id.fightMeterTV);
        enemyView = findViewById(R.id.enemyView);



        setPlayer();
        generateTurn(turnMeter);
        turnMeterTV.setText(String.valueOf(turnMeter));
        enemyNameTV.setText(turnArray[turnMeter].getEnemy().enemyName);



        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                if (playerHealth > 0 && turnArray[turnMeter].getEnemy().enemyHealth > 0)
                {
                    turnArray[turnMeter].getEnemy().enemyHealth
                            = attack(attackPower, turnArray[turnMeter].getEnemy().enemyHealth);

                    playerHealth = getAttack( turnArray[turnMeter].getEnemy().enemyPower
                            , playerHealth);
                }
                else if (playerHealth <= 0 && turnArray[turnMeter].getEnemy().enemyHealth > 0)
                {
                    Intent intent1 = new Intent(MainActivity.this, GameOverScreen.class);
                    finish();

                    startActivity(intent1); //Değişeçek
                }
                else if (playerHealth > 0 && turnArray[turnMeter].getEnemy().enemyHealth <= 0)
                {
                    turnMeter = turnMeter + 1;
                    generateTurn(turnMeter);
                    enemyView.setImageResource(R.drawable.goblinriizboss);
                }
                fightMeter += 1;
                generateTexts();




            }
        });
    }
}