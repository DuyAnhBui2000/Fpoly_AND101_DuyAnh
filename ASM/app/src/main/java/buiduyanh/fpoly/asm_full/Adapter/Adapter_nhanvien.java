package buiduyanh.fpoly.asm_full.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import buiduyanh.fpoly.asm_full.Model.NhanVien;
import buiduyanh.fpoly.asm_full.R;

public class Adapter_nhanvien extends BaseAdapter {

    private ArrayList<NhanVien> arrLich = new ArrayList<>();
    private Context mcontext;

    public Adapter_nhanvien(Context context){
        this.mcontext = context;
    }

    public void setData(ArrayList<NhanVien> arrLich){
        this.arrLich = arrLich;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return arrLich.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int viTri, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        NhanVien nhanVien = arrLich.get(viTri);
        LayoutInflater minflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null){
            view = minflater.inflate(R.layout.layout_icon_listview, null, false);
            viewHolder.TvMaNV = view.findViewById(R.id.TvMaNV);
            viewHolder.TvTenNV = view.findViewById(R.id.TvTenNV);
            viewHolder.TvPhongBan = view.findViewById(R.id.TvPhongBan);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.TvMaNV.setText(nhanVien.getMaNv());
        viewHolder.TvTenNV.setText(nhanVien.getTenNv());
        viewHolder.TvPhongBan.setText(nhanVien.getPhongBan());
        return view;
    }

    public static class ViewHolder{
        private TextView TvMaNV;
        private TextView TvTenNV;
        private TextView TvPhongBan;
        private TextView TvXoa;
    }
}
