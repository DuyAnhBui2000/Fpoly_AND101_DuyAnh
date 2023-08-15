package buiduyanh.fpoly.lab4_android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ManHinh2 extends AppCompatActivity {

    private TextView textViewProductName;
    private EditText editTextPrice;
    private Button buttonGetPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);

        textViewProductName = findViewById(R.id.textViewProductName);
        editTextPrice = findViewById(R.id.editTextPrice);
        buttonGetPrice = findViewById(R.id.buttonGetPrice);

        // Lấy dữ liệu từ Intent
        String productName = getIntent().getStringExtra("productName");
        textViewProductName.setText(productName);

        buttonGetPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = editTextPrice.getText().toString();

                Intent intent = new Intent(ManHinh2.this, ManHinh3.class);
                intent.putExtra("productName", productName);
                intent.putExtra("price", price);
                startActivity(intent);
            }
        });
    }
}