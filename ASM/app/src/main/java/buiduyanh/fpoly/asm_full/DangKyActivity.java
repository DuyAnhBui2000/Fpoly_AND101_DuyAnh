package buiduyanh.fpoly.asm_full;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangKyActivity extends AppCompatActivity {

    private Button  BtnTrove ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        BtnTrove = findViewById(R.id.BtnTrove_DK);

        Button btnDangKy = findViewById(R.id.BtnDangKy_DK);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText edtTenDangNhap = findViewById(R.id.EdtUserName_Dk);
//                EditText edtMatKhau = findViewById(R.id.EdtPassword1_DK);
//                EditText edtNhapLaiMatKhau = findViewById(R.id.EdtPassword2_Dk);
//
//                String tenDangNhap = edtTenDangNhap.getText().toString();
//                String matKhau = edtMatKhau.getText().toString();
//                String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString();
//
//                if (TextUtils.isEmpty(tenDangNhap) || TextUtils.isEmpty(matKhau) || TextUtils.isEmpty(nhapLaiMatKhau)) {
//                    Toast.makeText(DangKyActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                } else if (!matKhau.equals(nhapLaiMatKhau)) {
//                    Toast.makeText(DangKyActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công"+"\nTên đăng nhập: " + tenDangNhap + "\nMật khẩu: " + matKhau, Toast.LENGTH_SHORT).show();
//                }


                EditText edtTenDangNhap = findViewById(R.id.EdtUserName_Dk);
                EditText edtMatKhau = findViewById(R.id.EdtPassword1_DK);
                EditText edtNhapLaiMatKhau = findViewById(R.id.EdtPassword2_Dk);

                String tenDangNhap = edtTenDangNhap.getText().toString();
                String matKhau = edtMatKhau.getText().toString();
                String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString();

                if (TextUtils.isEmpty(tenDangNhap) || TextUtils.isEmpty(matKhau) || TextUtils.isEmpty(nhapLaiMatKhau)) {
                    Toast.makeText(DangKyActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!matKhau.equals(nhapLaiMatKhau)) {
                    Toast.makeText(DangKyActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công"+"\nTên đăng nhập: " + tenDangNhap + "\nMật khẩu: " + matKhau, Toast.LENGTH_SHORT).show();
                    Intent mIntent = new Intent(DangKyActivity.this,LoginActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("User",tenDangNhap);
                    bundle.putString("Pass",matKhau);
                    mIntent.putExtras(bundle);
                    startActivity(mIntent);
                }
            }
        });

        BtnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}