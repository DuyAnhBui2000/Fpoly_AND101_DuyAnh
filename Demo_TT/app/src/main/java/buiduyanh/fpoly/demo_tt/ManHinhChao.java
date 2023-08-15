package buiduyanh.fpoly.demo_tt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ManHinhChao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);


        // Sử dụng Handler để chuyển sang màn hình khác sau thời gian chờ
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ManHinhChao.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}