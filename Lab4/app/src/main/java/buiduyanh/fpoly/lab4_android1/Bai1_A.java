package buiduyanh.fpoly.lab4_android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai1_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

       Button BtnBai1_a = findViewById(R.id.BtnBai1_A);


        BtnBai1_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Bai1_A.this,Bai1_B.class);
                startActivity(mIntent);
            }
        });

    }
}