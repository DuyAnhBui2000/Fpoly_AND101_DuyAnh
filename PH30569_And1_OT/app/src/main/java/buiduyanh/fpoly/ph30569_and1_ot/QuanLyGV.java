package buiduyanh.fpoly.ph30569_and1_ot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import buiduyanh.fpoly.ph30569_and1_ot.Adapter.AdapterGiaoVien;
import buiduyanh.fpoly.ph30569_and1_ot.Model.GiaoVien;

public class QuanLyGV extends AppCompatActivity {

    private ArrayList<GiaoVien> gvlist ;
    private AdapterGiaoVien adapter;
    private ListView listView;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_gv);

        gvlist = new ArrayList<>();
        adapter = new AdapterGiaoVien(this, gvlist);

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
        Dialog dialog = new Dialog(QuanLyGV.this);
        dialog.setContentView(R.layout.dialog_them);

        final EditText etTen = dialog.findViewById(R.id.etTen);
        final EditText etMa = dialog.findViewById(R.id.etMagv);
        Button btnThem = dialog.findViewById(R.id.btnThemDialog);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTen.getText().toString();
                String ma = etMa.getText().toString();

                GiaoVien giaoVien = new GiaoVien(ten, ma);
                gvlist.add(giaoVien);
                adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}