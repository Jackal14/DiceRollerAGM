package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewDice;
    private Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDice = findViewById(R.id.image_view_dice);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    private void rollDice()
    {
        int randomNumber = rng.nextInt(20) + 1;

        switch(randomNumber)
        {
            case 1:
                imageViewDice.setImageResource(R.drawable.d1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.d2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.d3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.d4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.d5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.d6);
                break;
            case 7:
                imageViewDice.setImageResource(R.drawable.d7);
                break;
            case 8:
                imageViewDice.setImageResource(R.drawable.d8);
                break;
            case 9:
                imageViewDice.setImageResource(R.drawable.d9);
                break;
            case 10:
                imageViewDice.setImageResource(R.drawable.d10);
                break;
            case 11:
                imageViewDice.setImageResource(R.drawable.d11);
                break;
            case 12:
                imageViewDice.setImageResource(R.drawable.d12);
                break;
            case 13:
                imageViewDice.setImageResource(R.drawable.d13);
                break;
            case 14:
                imageViewDice.setImageResource(R.drawable.d14);
                break;
            case 15:
                imageViewDice.setImageResource(R.drawable.d15);
                break;
            case 16:
                imageViewDice.setImageResource(R.drawable.d16);
                break;
            case 17:
                imageViewDice.setImageResource(R.drawable.d17);
                break;
            case 18:
                imageViewDice.setImageResource(R.drawable.d18);
                break;
            case 19:
                imageViewDice.setImageResource(R.drawable.d19);
                break;
            case 20:
                imageViewDice.setImageResource(R.drawable.d20);
                break;



        }
    }
}