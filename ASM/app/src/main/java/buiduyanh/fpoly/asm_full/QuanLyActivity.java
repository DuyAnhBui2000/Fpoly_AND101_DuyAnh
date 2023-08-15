package buiduyanh.fpoly.asm_full;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class QuanLyActivity extends AppCompatActivity {

    private ImageView Img_PhongBan , Img_NhanVien , Img_Thoat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);

        Img_PhongBan = findViewById(R.id.Img_CongTy);
        Img_NhanVien = findViewById(R.id.Img_NhanVien);
        Img_Thoat = findViewById(R.id.Img_Thoat);

        // Bắt sự kiện khi click vào icon phòng ban .
        Img_PhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyActivity.this, PhongBanActiviti.class);
                startActivity(intent);
            }
        });

        // Bắt sự kiện khi click vào icone nhân viên .
        Img_NhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyActivity.this, NhanVienActiviti.class);
                startActivity(intent);
            }
        });

        // Bắt sự kiện khi click vào icone thoát .
        Img_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Thoát", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}