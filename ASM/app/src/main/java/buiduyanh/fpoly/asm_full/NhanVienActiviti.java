package buiduyanh.fpoly.asm_full;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import buiduyanh.fpoly.asm_full.Adapter.Adapter_nhanvien;
import buiduyanh.fpoly.asm_full.Database.DataBase_NhanVien;
import buiduyanh.fpoly.asm_full.Model.NhanVien;

public class NhanVienActiviti extends AppCompatActivity {

    Adapter_nhanvien adapter = new Adapter_nhanvien(NhanVienActiviti.this);
    ArrayList<NhanVien> arrayListNhanVien = new ArrayList<>();

    private ListView ListView;
    private Button BtnThemNV ;

    Button btnThemDiaLog;
    EditText EdtMaNv, EdtTenNv, EdtPhongBan;

    EditText EdtMaNvMoi, EdtTenNvMoi, EdtPhongBanMoi; //Sửa
    Button btnSuaDialog;

    private EditText Edt_Add_MaNv , Edt_Add_TenNv , Edt_Add_PhongBan ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_activiti);

        ListView = findViewById(R.id.ListView);

        fillDataToListView();
        sua();

    }

    public void themNhanVien(View view){
        Dialog dialog = new Dialog(NhanVienActiviti.this);
        dialog.setContentView(R.layout.them_nhanvien);
        EdtMaNv = dialog.findViewById(R.id.edtTieuDe);
        EdtTenNv = dialog.findViewById(R.id.edtNoiDung);
        EdtPhongBan = dialog.findViewById(R.id.edtThoiGian);
        btnThemDiaLog = dialog.findViewById(R.id.btnThemDialog);

        btnThemDiaLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    DataBase_NhanVien db = new DataBase_NhanVien(NhanVienActiviti.this);
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNv(EdtMaNv.getText().toString().trim());
                    nhanVien.setTenNv(EdtTenNv.getText().toString().trim());
                    nhanVien.setPhongBan(EdtPhongBan.getText().toString().trim());
                    if(db.them(nhanVien)){ //true
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

    public void sua(){
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(NhanVienActiviti.this);
                dialog.setContentView(R.layout.sua_nhanvien);

                EdtMaNvMoi = dialog.findViewById(R.id.edtTieuDeMoi);
                EdtTenNvMoi = dialog.findViewById(R.id.edtNoiDungMoi);
                EdtPhongBanMoi = dialog.findViewById(R.id.edtThoiGianMoi);
                btnSuaDialog = dialog.findViewById(R.id.btnSuaDialog);

                NhanVien nhanVien = arrayListNhanVien.get(position);
                EdtMaNvMoi.setHint(nhanVien.getMaNv());
                EdtTenNvMoi.setHint(nhanVien.getTenNv());
                EdtPhongBanMoi.setHint(nhanVien.getPhongBan());

                btnSuaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DataBase_NhanVien db = new DataBase_NhanVien(NhanVienActiviti.this);
                        nhanVien.setMaNv(EdtMaNvMoi.getText().toString().trim());
                        nhanVien.setTenNv(EdtTenNvMoi.getText().toString().trim());
                        nhanVien.setPhongBan(EdtPhongBanMoi.getText().toString().trim());

                        db.sua(nhanVien);
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
    public void xoa(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(NhanVienActiviti.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataBase_NhanVien db = new DataBase_NhanVien(NhanVienActiviti.this);
                int index = ListView.getPositionForView((View) view.getParent());
                NhanVien nhanVien = arrayListNhanVien.get(index);
                db.xoa(nhanVien.getId());
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
        DataBase_NhanVien db = new DataBase_NhanVien(NhanVienActiviti.this);
        arrayListNhanVien = db.getAllData();
        adapter.setData(arrayListNhanVien);
        ListView.setAdapter(adapter);
    }
    public boolean validateForm(){
        String manv = EdtMaNv.getText().toString().trim();
        String tennv = EdtTenNv.getText().toString().trim();
        String phongban = EdtPhongBan.getText().toString().trim();
        if(manv.equals("") || tennv.equals("") || phongban.equals("")){
            Toast.makeText(getApplicationContext(), "Không được để trống ", Toast.LENGTH_SHORT).show();
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