package buiduyanh.fpoly.lab4_android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai3_A extends AppCompatActivity {

    private EditText EdtTen, EdtPass;
    private Button BtnDangNhap, BtnDangKy;

    private String TaiKhoan, MatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);


        EdtTen = findViewById(R.id.txtusername);
        EdtPass = findViewById(R.id.txtpassword);

        BtnDangNhap = findViewById(R.id.btndangnhap);
        BtnDangKy = findViewById(R.id.btndangky);

        BtnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = getIntent();
                Bundle bundle = mIntent.getExtras();
                if (bundle != null){
                    String username  = bundle.getString("User");
                    String pass  = bundle.getString("Pass");
                    boolean u = username.equals(EdtTen.getText().toString());
                    boolean p = pass.equals(EdtPass.getText().toString());
                    if (u&&p){
                        Toast.makeText(Bai3_A.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Bai3_A.this, "Đăng nhập thất bại !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

//        BtnDangNhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                TaiKhoan = EdtTen.getText().toString().trim();
//                MatKhau = EdtPass.getText().toString().trim();
//
//                if (TaiKhoan.equals("duyanh") && MatKhau.equals("2000")) {
//
//                    Toast.makeText(Bai3_A.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(Bai3_A.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
//                    EdtTen.setText("");
//                    EdtPass.setText("");
//                }
//            }
//        });


        BtnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Bai3_A.this, Bai3_B.class);
                startActivity(mIntent);
            }
        });
    }
}