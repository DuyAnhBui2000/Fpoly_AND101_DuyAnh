package buiduyanh.fpoly.lab4_android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManHinh1 extends AppCompatActivity {

    private Button Btn1 , Btn2 , Btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh1);

        Btn1 = findViewById(R.id.BtnBai1);
        Btn2 = findViewById(R.id.BtnBai2);
        Btn3 = findViewById(R.id.BtnBai3);


        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ManHinh1.this,Bai1_A.class);
                startActivity(mIntent);
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ManHinh1.this,MainActivity.class);
                startActivity(mIntent);
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ManHinh1.this,Bai3_A.class);
                startActivity(mIntent);
            }
        });
    }
}