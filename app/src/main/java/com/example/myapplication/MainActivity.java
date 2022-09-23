package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewDice;
    private TextView textView;
    private Random rng = new Random();
    SoundPool soundPool;
    int sound1, sound2, sound3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(getString(R.string.blank));
        imageViewDice = findViewById(R.id.image_view_dice);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(3)
                .setAudioAttributes(audioAttributes)
                .build();
        sound1 = soundPool.load(this, R.raw.dice, 1);
        sound2 = soundPool.load(this, R.raw.haha, 1);
        sound3 = soundPool.load(this, R.raw.victory, 1);

        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
                //soundPool.autoPause();
                soundPool.play(sound1,1, 1,0,0,1);
            }
        });
    }

    private void rollDice()
    {


        new RotateAnimation(0, 360);
        int randomNumber = rng.nextInt(20) + 1;

        switch(randomNumber)
        {
            case 1:
                imageViewDice.setImageResource(R.drawable.d1);
                textView.setText(getString(R.string.criticalFail));
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.d2);
                textView.setText(getString(R.string.blank));
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.d3);
                textView.setText(getString(R.string.blank));
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.d4);
                textView.setText(getString(R.string.blank));
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.d5);
                textView.setText(getString(R.string.blank));
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.d6);
                textView.setText(getString(R.string.blank));
                break;
            case 7:
                imageViewDice.setImageResource(R.drawable.d7);
                textView.setText(getString(R.string.blank));
                break;
            case 8:
                imageViewDice.setImageResource(R.drawable.d8);
                textView.setText(getString(R.string.blank));
                break;
            case 9:
                imageViewDice.setImageResource(R.drawable.d9);
                textView.setText(getString(R.string.blank));
                break;
            case 10:
                imageViewDice.setImageResource(R.drawable.d10);
                textView.setText(getString(R.string.blank));
                break;
            case 11:
                imageViewDice.setImageResource(R.drawable.d11);
                textView.setText(getString(R.string.blank));
                break;
            case 12:
                imageViewDice.setImageResource(R.drawable.d12);
                textView.setText(getString(R.string.blank));
                break;
            case 13:
                imageViewDice.setImageResource(R.drawable.d13);
                textView.setText(getString(R.string.blank));
                break;
            case 14:
                imageViewDice.setImageResource(R.drawable.d14);
                textView.setText(getString(R.string.blank));
                break;
            case 15:
                imageViewDice.setImageResource(R.drawable.d15);
                textView.setText(getString(R.string.blank));
                break;
            case 16:
                imageViewDice.setImageResource(R.drawable.d16);
                textView.setText(getString(R.string.blank));
                break;
            case 17:
                imageViewDice.setImageResource(R.drawable.d17);
                textView.setText(getString(R.string.blank));
                break;
            case 18:
                imageViewDice.setImageResource(R.drawable.d18);
                textView.setText(getString(R.string.blank));
                break;
            case 19:
                imageViewDice.setImageResource(R.drawable.d19);
                textView.setText(getString(R.string.blank));
                break;
            case 20:
                imageViewDice.setImageResource(R.drawable.d20);
                textView.setText(getString(R.string.criticalSuccess));
                soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;



        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}