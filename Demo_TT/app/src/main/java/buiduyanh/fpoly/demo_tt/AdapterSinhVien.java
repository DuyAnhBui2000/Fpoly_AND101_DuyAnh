package buiduyanh.fpoly.demo_tt;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class AdapterSinhVien extends BaseAdapter {
    private final Context context;
    private final ArrayList<SinhVien> list;

    public AdapterSinhVien(Context context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_home, viewGroup, false);

        // Ánh xạ các thành phần giao diện
        TextView txtHt = view.findViewById(R.id.txtht);
        TextView txtDc = view.findViewById(R.id.txtdc);
        Button btnUpdate = view.findViewById(R.id.btnupdate);
        Button btnXoa = view.findViewById(R.id.btnxoa);

        // Gán dữ liệu cho các thành phần giao diện
        SinhVien sv = list.get(i);
        txtHt.setText(sv.getHoten());
        txtDc.setText(sv.getDiachi());

        // Xử lý sự kiện khi nhấn nút Xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
            }
        });

        // Xử lý sự kiện khi nhấn nút Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(sv);
            }
        });

        return view;
    }

    // Mở dialog để cập nhật thông tin sinh viên
    public void openDialog(SinhVien sv) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_update, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        // Ánh xạ các thành phần giao diện trong dialog
        EditText txtTen = view.findViewById(R.id.txtten_up);
        EditText txtDiaChi = view.findViewById(R.id.txtdiachi_up);
        Button btnUpdate = view.findViewById(R.id.btnud);

        // Gán dữ liệu hiện tại lên các thành phần giao diện
        txtTen.setText(sv.getHoten());
        txtDiaChi.setText(sv.getDiachi());

        // Xử lý sự kiện khi nhấn nút Update trong dialog
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cập nhật thông tin sinh viên
                sv.setHoten(txtTen.getText().toString());
                sv.setDiachi(txtDiaChi.getText().toString());

                dialog.dismiss();
                notifyDataSetChanged();
            }
        });
    }
}
