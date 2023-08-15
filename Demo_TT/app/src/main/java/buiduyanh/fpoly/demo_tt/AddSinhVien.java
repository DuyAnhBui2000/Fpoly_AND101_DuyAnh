package buiduyanh.fpoly.demo_tt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSinhVien extends AppCompatActivity {

    private EditText txtTen;
    private EditText txtDiaChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        // Khởi tạo các thành phần giao diện
        Button btnSubmit = findViewById(R.id.btnsubmit);
        txtTen = findViewById(R.id.txtten);
        txtDiaChi = findViewById(R.id.txtdiachi);

        // Xử lý sự kiện khi nhấn nút Submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent để chuyển sang màn hình Home
                Intent intent = new Intent(AddSinhVien.this, MainActivity.class);

                // Lấy thông tin từ EditText
                String hoTen = txtTen.getText().toString();
                String diaChi = txtDiaChi.getText().toString();

                // Gửi dữ liệu qua Bundle
                Bundle bundle = new Bundle();
                bundle.putString("ht", hoTen);
                bundle.putString("dc", diaChi);
                intent.putExtras(bundle);

                // Đặt kết quả và kết thúc activity
                setResult(1, intent);
                finish();
            }
        });
    }
}