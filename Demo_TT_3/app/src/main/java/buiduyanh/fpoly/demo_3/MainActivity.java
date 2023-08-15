package buiduyanh.fpoly.demo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Food> foodList;
    private AdapterFood adapter;
    private ListView listView;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = new ArrayList<>();
        adapter = new AdapterFood(this, foodList);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        btnThem = findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });
    }

    private void showAddDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_them);

        final EditText etTen = dialog.findViewById(R.id.etTen);
        final EditText etGia = dialog.findViewById(R.id.etGia);
        final EditText etGhiChu = dialog.findViewById(R.id.etGhiChu);
        Button btnThem = dialog.findViewById(R.id.btnThemDialog);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTen.getText().toString();
                String gia = etGia.getText().toString();
                String ghiChu = etGhiChu.getText().toString();

                Food food = new Food(ten, gia, ghiChu);
                foodList.add(food);
                adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}