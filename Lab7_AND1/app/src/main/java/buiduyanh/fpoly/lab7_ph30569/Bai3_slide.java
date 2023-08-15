package buiduyanh.fpoly.lab7_ph30569;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Bai3_slide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_slide);

        ImageView Img3 = findViewById(R.id.Img3);


        // gọi phương thức để gán hiệu ứng
        Img3.setBackgroundResource(R.drawable.slide_demo);
        AnimationDrawable dra1 = (AnimationDrawable) Img3.getBackground();
        dra1.start();
    }
}