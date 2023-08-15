package buiduyanh.fpoly.lab7_ph30569;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai1 extends AppCompatActivity {

    // 2 kiểu animation chính
    // Tween animation là hiệu ứng cho 1 ảnh
    // Frame animation : áp dụng cho nhiều ảnh

    // các hiệu ứng
    // Alpha : rõ dần , mờ dần
    // scale : phòng to thu nhỏ
    // Rotate : xoay
    // Traslate : tịnh tiến

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        // ánh xạ
        ImageView Img1 = findViewById(R.id.Img1);
        TextView Tv1 = findViewById(R.id.Tv1);

        // gọi phương thức để gán hiệu ứng
        Animation anm1 = AnimationUtils.loadAnimation(this,R.anim.hieu_ung_1);
        // bắt hiệu ứng vào Img hoặc TextView.
        Img1.startAnimation(anm1);
        Tv1.startAnimation(anm1);

    }
}