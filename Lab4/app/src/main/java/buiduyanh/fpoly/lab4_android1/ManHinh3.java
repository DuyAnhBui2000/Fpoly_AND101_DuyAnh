package buiduyanh.fpoly.lab4_android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ManHinh3 extends AppCompatActivity {

    private TextView textViewProductNameResult;
    private TextView textViewPriceResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh3);

        textViewProductNameResult = findViewById(R.id.textViewProductNameResult);
        textViewPriceResult = findViewById(R.id.textViewPriceResult);

        // Lấy dữ liệu từ Intent
        String productName = getIntent().getStringExtra("productName");
        String price = getIntent().getStringExtra("price");

        textViewProductNameResult.setText(productName);
        textViewPriceResult.setText(price);
    }
}