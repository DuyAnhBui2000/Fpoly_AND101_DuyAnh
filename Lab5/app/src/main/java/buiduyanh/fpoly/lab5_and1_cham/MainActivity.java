package buiduyanh.fpoly.lab5_and1_cham;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
// KHAI BÁO
    Adapter_Lich adapter = new Adapter_Lich(MainActivity.this);
    ArrayList<Lich> arrLich = new ArrayList<>();

    Button btnThemDiaLog;
    EditText edtTieuDe, edtNoiDung, edtThoiGian;
    ListView lvLich;

    EditText edtTieuDeMoi, edtNoiDungMoi, edtThoiGianMoi; //Sửa
    Button btnSuaDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLich = findViewById(R.id.lvLich);
        fillDataToListView();
        suaLich();
    }

    public void themLich(View view){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.them_dialog);
        edtTieuDe = dialog.findViewById(R.id.edtTieuDe);
        edtNoiDung = dialog.findViewById(R.id.edtNoiDung);
        edtThoiGian = dialog.findViewById(R.id.edtThoiGian);
        btnThemDiaLog = dialog.findViewById(R.id.btnThemDialog);

        btnThemDiaLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    DBLich db = new DBLich(MainActivity.this);
                    Lich lich = new Lich();
                    lich.setTieuDe(edtTieuDe.getText().toString().trim());
                    lich.setNoiDung(edtNoiDung.getText().toString().trim());
                    lich.setThoiGian(edtThoiGian.getText().toString().trim());
                    if(db.themLich(lich)){ //true
                        Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                        fillDataToListView();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog.show();
    }

    public void suaLich(){
        lvLich.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.sua_dialog);

                edtTieuDeMoi = dialog.findViewById(R.id.edtTieuDeMoi);
                edtNoiDungMoi = dialog.findViewById(R.id.edtNoiDungMoi);
                edtThoiGianMoi = dialog.findViewById(R.id.edtThoiGianMoi);
                btnSuaDialog = dialog.findViewById(R.id.btnSuaDialog);

                Lich lich = arrLich.get(position);
                edtTieuDeMoi.setHint(lich.getTieuDe());
                edtNoiDungMoi.setHint(lich.getNoiDung());
                edtThoiGianMoi.setHint(lich.getThoiGian());

                btnSuaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBLich db = new DBLich(MainActivity.this);
                        lich.setTieuDe(edtTieuDeMoi.getText().toString().trim());
                        lich.setNoiDung(edtNoiDungMoi.getText().toString().trim());
                        lich.setThoiGian(edtThoiGianMoi.getText().toString().trim());

                        db.suaLich(lich);
                        adapter.notifyDataSetChanged();
                        fillDataToListView();
                        Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
    public void xoaGhiChu(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBLich db = new DBLich(MainActivity.this);
                int index = lvLich.getPositionForView((View) view.getParent());
                Lich lich = arrLich.get(index);
                db.xoaLich(lich.getId());
                adapter.notifyDataSetChanged();
                fillDataToListView();
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void  fillDataToListView(){
        DBLich db = new DBLich(MainActivity.this);
        arrLich = db.getAllData();
        adapter.setData(arrLich);
        lvLich.setAdapter(adapter);
    }
    public boolean validateForm(){
        String tieude = edtTieuDe.getText().toString().trim();
        String noidung = edtNoiDung.getText().toString().trim();
        String thoigian = edtThoiGian.getText().toString().trim();
        if(tieude.equals("") || noidung.equals("") || thoigian.equals("")){
            Toast.makeText(getApplicationContext(), "Không được để trống các ô nhập", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!thoigian.matches("^[0-9]{2}:([0-9]{2})([a-zA-Z]{2})+$")){
            Toast.makeText(getApplicationContext(),  "Nhập sai định dạng thời gian", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillDataToListView();
    }
}