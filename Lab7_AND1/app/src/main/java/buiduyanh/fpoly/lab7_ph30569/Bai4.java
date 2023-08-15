package buiduyanh.fpoly.lab7_ph30569;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        ImageView Img4 = findViewById(R.id.Img4);
        TextView Tv4 = findViewById(R.id.Tv4);

        // gọi phương thức để gán hiệu ứng
        Animation anm1 = AnimationUtils.loadAnimation(this,R.anim.demo4);
        Animation anm2 = AnimationUtils.loadAnimation(this,R.anim.demo4_b);
        // bắt hiệu ứng vào Img hoặc TextView.
        Img4.startAnimation(anm1);
        Tv4.startAnimation(anm2);
    }
}