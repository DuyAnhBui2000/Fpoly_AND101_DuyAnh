package buiduyanh.fpoly.demo_3;

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

public class AdapterFood extends BaseAdapter {

    private Context context;
    private ArrayList<Food> foodList;

    public AdapterFood(Context context, ArrayList<Food> foodList) {
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
        TextView tvGia = convertView.findViewById(R.id.tvGia);
        TextView tvGhiChu = convertView.findViewById(R.id.tvGhiChu);
        Button btnXoa = convertView.findViewById(R.id.btnXoa);
        Button btnCapNhat = convertView.findViewById(R.id.btnCapNhat);

        final Food food = foodList.get(position);

        tvTen.setText(food.getTen());
        tvGia.setText(food.getGia());
        tvGhiChu.setText(food.getGhiChu());

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

    private void showCapNhatDialog(final Food food) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_capnhat);

        final EditText etTenCapNhat = dialog.findViewById(R.id.etTenCapNhat);
        final EditText etGiaCapNhat = dialog.findViewById(R.id.etGiaCapNhat);
        final EditText etGhiChuCapNhat = dialog.findViewById(R.id.etGhiChuCapNhat);
        Button btnCapNhat = dialog.findViewById(R.id.btnCapNhat);

        etTenCapNhat.setText(food.getTen());
        etGiaCapNhat.setText(food.getGia());
        etGhiChuCapNhat.setText(food.getGhiChu());

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTenCapNhat.getText().toString();
                String gia = etGiaCapNhat.getText().toString();
                String ghiChu = etGhiChuCapNhat.getText().toString();

                food.setTen(ten);
                food.setGia(gia);
                food.setGhiChu(ghiChu);

                notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
