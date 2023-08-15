package buiduyanh.fpoly.lab5_and1_cham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_Lich extends BaseAdapter {
    private ArrayList<Lich> arrLich = new ArrayList<>();
    private Context mcontext;

    public Adapter_Lich(Context context){
        this.mcontext = context;
    }

    public void setData(ArrayList<Lich> arrLich){
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
        lichViewHolder lichVHD = new lichViewHolder();
        Lich lich = arrLich.get(viTri);
        LayoutInflater minflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null){
            view = minflater.inflate(R.layout.dapter_lich, null, false);
            lichVHD.tvTieuDeAdapter = view.findViewById(R.id.tvTieuDeAdapter);
            lichVHD.tvNoiDungAdapter = view.findViewById(R.id.tvNoiDungAdapter);
            lichVHD.tvThoiGianAdapter = view.findViewById(R.id.tvNgayAdapter);

            view.setTag(lichVHD);
        }else {
            lichVHD = (lichViewHolder) view.getTag();
        }
        lichVHD.tvTieuDeAdapter.setText(lich.getTieuDe());
        lichVHD.tvNoiDungAdapter.setText(lich.getNoiDung());
        lichVHD.tvThoiGianAdapter.setText(lich.getThoiGian());
        return view;
    }

    public static class lichViewHolder{
        private TextView tvTieuDeAdapter;
        private TextView tvThoiGianAdapter;
        private TextView tvNoiDungAdapter;
        private ImageView imgXoaAdapter;
    }
}
