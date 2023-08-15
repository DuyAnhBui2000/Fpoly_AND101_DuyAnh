package buiduyanh.fpoly.demo_tt;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lstHome;
    private ArrayList<SinhVien> list = new ArrayList<>();
    private AdapterSinhVien adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        lstHome = findViewById(R.id.lsthome);
        Button btnAdd = findViewById(R.id.btnadd);

//        // Thêm dữ liệu vào danh sách - set cứng
//        list.add(new sinhvien("Fpoly Hà Nội", "Huy", "2 Lê Lợi"));
//        list.add(new sinhvien("Fpoly Hồ Chí Minh", "Trung", "3 Lê Lợi"));

        // Khởi tạo adapter và gán cho ListView
        adapter = new AdapterSinhVien(this, list);
        lstHome.setAdapter(adapter);

        // Lắng nghe sự kiện khi nhấn nút Add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent để chuyển sang màn hình Bai1
                Intent intent = new Intent(MainActivity.this, AddSinhVien.class);

                // Sử dụng Activity Result API để nhận dữ liệu trả về từ Bai1
                getdata.launch(intent);
            }
        });
    }

    // Khai báo và định nghĩa Activity Result Launcher
    ActivityResultLauncher<Intent> getdata = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 1) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            Bundle bundle = intent.getExtras();
                            String hoTen = bundle.getString("ht");
                            String diaChi = bundle.getString("dc");
                            String tenCS = bundle.getString("tencs");

                            // Thêm sinh viên mới vào danh sách
                            list.add(new SinhVien(hoTen, diaChi));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
}