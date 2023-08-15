package buiduyanh.fpoly.lab7_ph30569;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);


        // ánh xạ
        ImageView Img2 = findViewById(R.id.Img2);

        // gọi phương thức để gán hiệu ứng
        Animation anm1 = AnimationUtils.loadAnimation(this,R.anim.rotate_clockwise);
        // bắt hiệu ứng vào Img
        Img2.startAnimation(anm1);

    }
}