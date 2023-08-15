package buiduyanh.fpoly.lab7_ph30569;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Btn1, Btn2, Btn3,Btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1 = findViewById(R.id.Btn1);
        Btn2 = findViewById(R.id.Btn2);
        Btn3 = findViewById(R.id.Btn3);
        Btn4 = findViewById(R.id.Btn4);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, Bai1.class);
                startActivity(mIntent);
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, Bai2.class);
                startActivity(mIntent);
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, Bai3_slide.class);
                startActivity(mIntent);
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, Bai4.class);
                startActivity(mIntent);
            }
        });
    }
}