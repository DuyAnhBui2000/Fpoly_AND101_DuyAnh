package buiduyanh.fpoly.asm_full;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // Khai báo các thành phần ở layout
    private EditText EdtUserName_DN, EdtPassword_DN;
    private CheckBox Ckb_GhiNho;
    private Button BtnDangNhap_DN, BtnDangKy_DN;

    private String TaiKhoan, MatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ

        EdtUserName_DN = findViewById(R.id.EdtUserName_DN);
        EdtPassword_DN = findViewById(R.id.EdtPassword_DN);

        Ckb_GhiNho = findViewById(R.id.Ckb_GhiNho);

        BtnDangNhap_DN = findViewById(R.id.BtnDangNhap_DN);
        BtnDangKy_DN = findViewById(R.id.BtnDangKy_DN);


        // Lưu trạng thái của CheckBox
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isChecked", Ckb_GhiNho.isChecked());
        editor.apply();

        // Lấy trạng thái của CheckBox
        boolean isChecked = sharedPreferences.getBoolean("isChecked", false);
        Ckb_GhiNho.setChecked(isChecked);


        // Bắt sự kiện khi click vào nút đăng nhập .
        BtnDangNhap_DN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TaiKhoan = EdtUserName_DN.getText().toString().trim();
//                MatKhau = EdtPassword_DN.getText().toString().trim();
//
//                if (TaiKhoan.equals("duyanh")&& MatKhau.equals("2000")) {
//
//                    Intent intent = new Intent(getBaseContext(), QuanLyActivity.class); //Chuyển sang màn Quản lý Activity
//                    startActivity(intent);
//
//                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
//                    EdtUserName_DN.setText("");
//                    EdtPassword_DN.setText("");
//                }


                Intent mIntent = getIntent();
                Bundle bundle = mIntent.getExtras();
                if (bundle != null){
                    String username  = bundle.getString("User");
                    String pass  = bundle.getString("Pass");
                    boolean u = username.equals(EdtUserName_DN.getText().toString());
                    boolean p = pass.equals(EdtPassword_DN.getText().toString());
                    if (u&&p){
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), QuanLyActivity.class); //Chuyển sang màn Quản lý Activity
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thất bại !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Bắt sự kiện khi click vào nút đăng ký .
        BtnDangKy_DN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, DangKyActivity.class);
                startActivity(intent);

            }
        });

        Ckb_GhiNho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = Ckb_GhiNho.isChecked();
                if (isChecked) {
                    // Lưu mật khẩu
                    Toast.makeText(getApplicationContext(), "Mật khẩu đã được lưu", Toast.LENGTH_SHORT).show();
                } else {
                    // Không lưu mật khẩu
                    Toast.makeText(getApplicationContext(), "Không lưu mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}