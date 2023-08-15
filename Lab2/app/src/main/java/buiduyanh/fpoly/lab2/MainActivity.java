package buiduyanh.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button BtnBai1 , BtnBai2 ,BtnBaiThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnBai1 = findViewById(R.id.BtnBai1);
        BtnBai2 = findViewById(R.id.BtnBai2);
        BtnBaiThem = findViewById(R.id.BtnBaiThem);



        BtnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai1.class);
                startActivity(intent);
            }
        });

        BtnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai2.class);
                startActivity(intent);
            }
        });

        BtnBaiThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai3.class);
                startActivity(intent);
            }
        });

    }
}