package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random=new Random();
    private int preDir;
    private boolean spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottle=findViewById(R.id.bottle);

    }
    public void spinBottle(View v)
    {
        if(!spin) {
            int newDir = random.nextInt(1800);
            float pivotx = bottle.getWidth() / 2;
            float pivoty = bottle.getWidth() / 2;


            Animation rotate = new RotateAnimation(preDir, newDir, pivotx, pivoty);
            rotate.setDuration(3000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                spin=false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            preDir = newDir;
            bottle.startAnimation(rotate);
        }

    }
}
