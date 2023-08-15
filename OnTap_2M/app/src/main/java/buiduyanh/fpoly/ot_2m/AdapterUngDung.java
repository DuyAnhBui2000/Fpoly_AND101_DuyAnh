package buiduyanh.fpoly.ot_2m;

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

public class AdapterUngDung extends BaseAdapter {

    private Context context;
    private ArrayList<UngDung> arrayList;

    public AdapterUngDung(Context context, ArrayList<UngDung> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
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

        TextView tvMuc1 = convertView.findViewById(R.id.tvMuc1);
        TextView tvMuc2 = convertView.findViewById(R.id.tvMuc2);

        Button btnXoa = convertView.findViewById(R.id.btnXoa);
        Button btnCapNhat = convertView.findViewById(R.id.btnCapNhat);

        final UngDung app = arrayList.get(position);

        tvMuc1.setText(app.getMuc1());
        tvMuc2.setText(app.getMuc2());


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(app);
                notifyDataSetChanged();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCapNhatDialog(app);
            }
        });

        return convertView;
    }

    private void showCapNhatDialog(final UngDung app) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_capnhat);

        final EditText etMuc1CapNhap = dialog.findViewById(R.id.etMuc1CapNhap);
        final EditText etMuc2CapNhap = dialog.findViewById(R.id.etMuc2CapNhap);


        Button btnCapNhat = dialog.findViewById(R.id.btnCapNhat);

        etMuc1CapNhap.setText(app.getMuc1());
        etMuc2CapNhap.setText(app.getMuc2());



        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String muc1 = etMuc1CapNhap.getText().toString();
                String muc2 = etMuc2CapNhap.getText().toString();


                app.setMuc1(muc1);
                app.setMuc2(muc2);


                notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
