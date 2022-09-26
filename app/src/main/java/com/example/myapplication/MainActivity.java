package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView imageViewDice;
    private TextView textView;
    private Random rng = new Random();
    private TextView d20Text;
    private TextView d1Text;
    private int d20sRolled = 0;
    private int d1sRolled = 0;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private boolean isAccelerometerSensorAvailable, notFirstTime = false;
    private float currentX, currentY, currentZ, lastX, lastY, lastZ, xDifference, yDifference, zDifference;
    private float shakeThreshold = 5f;
    private Vibrator vibrator;
    Animation rotateAnimation;
    //Sounds stuff
    SoundPool soundPool;
    int sound1, sound2, sound3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Get count of rolls
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        d1sRolled = sharedPref.getInt("d1sRolled", 0);
        d20sRolled = sharedPref.getInt("d20sRolled", 0);
        textView = findViewById(R.id.textView);
        textView.setText(getString(R.string.blank));
        d20Text = findViewById(R.id.d20s);
        d20Text.append(String.valueOf(d20sRolled));
        d1Text = findViewById(R.id.d1s);
        d1Text.append(String.valueOf(d1sRolled));
        imageViewDice = findViewById(R.id.image_view_dice);


        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null)
        {
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccelerometerSensorAvailable = true;
        }
        else
        {
            isAccelerometerSensorAvailable = false;
        }
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

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
                rotateAnimation();
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
                d1sRolled++;
                d1Text.setText(getString(R.string.d1s) + d1sRolled);
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
                d20sRolled++;
                d20Text.setText(getString(R.string.d20s) + d20sRolled);
                break;



        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        currentX = sensorEvent.values[0];
        currentY = sensorEvent.values[1];
        currentZ = sensorEvent.values[2];

        if(notFirstTime)
        {
            xDifference = Math.abs(lastX - currentX);
            yDifference = Math.abs(lastY - currentY);
            zDifference = Math.abs(lastZ - currentZ);

            if((xDifference > shakeThreshold && yDifference > shakeThreshold) || (xDifference > shakeThreshold && zDifference > shakeThreshold) || (yDifference > shakeThreshold && zDifference > shakeThreshold))
            {
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                rollDice();
            }

        }

        lastX = currentX;
        lastY = currentY;
        lastZ = currentZ;
        notFirstTime = true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isAccelerometerSensorAvailable)
        {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isAccelerometerSensorAvailable)
        {
            sensorManager.unregisterListener(this);
        }
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        SharedPreferences sharedPref = getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("d1sRolled", d1sRolled);
        editor.putInt("d20sRolled", d20sRolled);
        editor.apply();
    }

    private void rotateAnimation() {

        rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.rotate);
        imageViewDice.startAnimation(rotateAnimation);

    }
}