package buiduyanh.fpoly.ph30569_and1_ot.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import buiduyanh.fpoly.ph30569_and1_ot.Model.GiaoVien;
import buiduyanh.fpoly.ph30569_and1_ot.R;

public class AdapterGiaoVien extends BaseAdapter {
    private Context context;
    private ArrayList<GiaoVien> foodList;

    public AdapterGiaoVien(Context context, ArrayList<GiaoVien> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
        }

        TextView tvTen = convertView.findViewById(R.id.tvTen);
        TextView tvGia = convertView.findViewById(R.id.tvGv);
        Button btnXoa = convertView.findViewById(R.id.btnXoa);
        Button btnCapNhat = convertView.findViewById(R.id.btnCapNhat);

        final GiaoVien food = foodList.get(position);

        tvTen.setText(food.getTen());
        tvGia.setText(food.getMagv());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodList.remove(food);
                notifyDataSetChanged();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCapNhatDialog(food);
            }
        });

        return convertView;
    }

    private void showCapNhatDialog(final GiaoVien food) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_capnhat);

        final EditText etTenCapNhat = dialog.findViewById(R.id.etTenCapNhat);
        final EditText etmagv = dialog.findViewById(R.id.etMagvCapNhat);
        Button btnCapNhat = dialog.findViewById(R.id.btnCapNhat);

        etTenCapNhat.setText(food.getTen());
        etmagv.setText(food.getMagv());

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTenCapNhat.getText().toString();
                String gia = etmagv.getText().toString();

                food.setTen(ten);
                food.setMagv(gia);

                notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
