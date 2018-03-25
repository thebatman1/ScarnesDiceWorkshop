package com.lambda.scarnesdiceworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv_user_score, tv_computer_score, tv_turn_score;
    int userTurnScore, computerTurnScore, userScore, computerScore;
    Button bt_roll, bt_hold, bt_reset;
    ImageView img_dice;
    Random random = new Random(System.nanoTime());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_user_score = findViewById(R.id.tv_user_turn_score);
        tv_computer_score = findViewById(R.id.tv_computer_turn_score);
        tv_turn_score = findViewById(R.id.tv_turn_score);
        bt_roll = findViewById(R.id.bt_roll);
        bt_hold = findViewById(R.id.bt_hold);
        bt_reset = findViewById(R.id.bt_reset);
        img_dice = findViewById(R.id.img_dice_face);

        bt_roll.setOnClickListener(this);
        bt_hold.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_roll:
                int val = roll();
                setScore(val);
                break;
            case R.id.bt_hold: hold();
                break;
            case R.id.bt_reset: reset();
                break;
        }
    }

    int roll() {
        int val = random.nextInt(6) + 1;
        switch (val) {
            case 1: img_dice.setImageResource(R.drawable.dice1);
                break;
            case 2: img_dice.setImageResource(R.drawable.dice2);
                break;
            case 3: img_dice.setImageResource(R.drawable.dice3);
                break;
            case 4: img_dice.setImageResource(R.drawable.dice4);
                break;
            case 5: img_dice.setImageResource(R.drawable.dice5);
                break;
            case 6: img_dice.setImageResource(R.drawable.dice6);
                break;
        }
        return val;
    }

    void setScore(int val) {
        if (val == 1) {
            loseTurn();
        } else {
            addScore(val);
        }
    }

    void loseTurn() {
        userTurnScore = 0;
        tv_turn_score.setText("Turn score: 0");
    }

    void addScore(int val) {
        userTurnScore += val;
        tv_turn_score.setText("Turn score: " + userTurnScore);
    }

    void hold() {
        userScore += userTurnScore;
        userTurnScore = 0;
        tv_turn_score.setText("Turn score: 0");
        tv_user_score.setText("Your score: " + userScore);
    }
    
    void reset() {
        userScore = userTurnScore = 0;
        computerTurnScore = computerScore = 0;
        tv_user_score.setText("Your score: 0");
        tv_computer_score.setText("Computer score: 0");
        tv_turn_score.setText("Turn score: 0");
    }
}
