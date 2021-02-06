package com.wdk.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RadioButton lucktails;
    RadioButton luckheads;

    Button flip;
    ImageView result;

    Random rng = new Random();

    int counter = 0 ;



    TextView coin;
    TextView rightguess;

    //TODO Styling ?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flip = findViewById(R.id.flip);
        result = findViewById(R.id.result);

        //TEXTVIEWS
        coin = findViewById(R.id.coin);
        rightguess = findViewById(R.id.rightguess);

        //RADIOBUTTONS
        lucktails = findViewById(R.id.lucktails);
        luckheads = findViewById(R.id.luckheads);


        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flip();
                rightguess.setText("You guessed it right "+counter+" times");

            }
        });

    }


public void flip(){
int randomNumber = rng.nextInt(2) ;




switch (randomNumber){
    case 0:

        result.setImageResource(R.drawable.euro);
        RotateAnimation rotate = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(1000);
        result.startAnimation(rotate);
        coin.setText("The coin landed on :\n Heads");

        if (luckheads.isChecked()){
            Toast.makeText(getApplicationContext(), "Success",
                    Toast.LENGTH_LONG).show();
            counter++;
        }
        else if (counter >0){
            counter--;
        }

        break;
    case 1:
        result.setImageResource(R.drawable.eurotails);
        RotateAnimation rotate2 = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotate2.setDuration(1000);
        result.startAnimation(rotate2);
        coin.setText("The coin landed on :\n Tails");

        if (lucktails.isChecked()){
            Toast.makeText(getApplicationContext(), "Success",
                    Toast.LENGTH_LONG).show();
            counter++;
        }
        else if (counter>0){
            counter--;
        }

        break;
}

}

}
