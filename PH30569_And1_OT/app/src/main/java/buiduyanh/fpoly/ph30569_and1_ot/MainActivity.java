package buiduyanh.fpoly.ph30569_and1_ot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HamChay3giay();
    }

    private void HamChay3giay(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, QuanLyGV.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}