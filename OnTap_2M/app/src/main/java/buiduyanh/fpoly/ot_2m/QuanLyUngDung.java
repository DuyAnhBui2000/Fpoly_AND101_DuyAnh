package buiduyanh.fpoly.ot_2m;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuanLyUngDung extends AppCompatActivity {
    private ArrayList<UngDung> arrayList;
    private AdapterUngDung adapter;
    private ListView listView;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_ung_dung);

        arrayList = new ArrayList<>();
        adapter = new AdapterUngDung(this, arrayList);

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
        Dialog dialog = new Dialog(QuanLyUngDung.this);
        dialog.setContentView(R.layout.dialog_them);

        final EditText etMuc1 = dialog.findViewById(R.id.etMuc1);
        final EditText etMuc2 = dialog.findViewById(R.id.etMuc2);


        Button btnThem = dialog.findViewById(R.id.btnThemDialog);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String muc1 = etMuc1.getText().toString();
                String muc2 = etMuc2.getText().toString();


                UngDung food = new UngDung(muc1, muc2);
                arrayList.add(food);
                adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }

}