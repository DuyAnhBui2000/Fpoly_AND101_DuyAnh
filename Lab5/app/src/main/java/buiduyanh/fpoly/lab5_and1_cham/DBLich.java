package buiduyanh.fpoly.lab5_and1_cham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBLich extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_lich";
    public static final int VERISION = 1;

    public DBLich(@Nullable Context context) {
        super(context, DB_NAME, null, VERISION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taobang = "CREATE TABLE lich(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tieude TEXT NOT NULL," +
                "noidung TEXT NOT NULL," +
                "thoigian TEXT NOT NULL)";
        db.execSQL(taobang);
    }

    public boolean themLich(Lich lich){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tieude", lich.getTieuDe());
        values.put("noidung", lich.getNoiDung());
        values.put("thoigian", lich.getThoiGian());
        return db.insert("lich",null, values) > 0;
    }

    public boolean suaLich(Lich lich){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tieude", lich.getTieuDe());
        values.put("noidung", lich.getNoiDung());
        values.put("thoigian", lich.getThoiGian());

        return db.update("lich", values, "id=?", new String[]{String.valueOf(lich.getId())}) > 0;
    }

    public boolean xoaLich(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("lich", "id=?" , new String[]{String.valueOf(id)}) > 0;
    }

    public ArrayList<Lich> getAllData(){
        ArrayList<Lich> arrLich = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM lich";

        Cursor cs = db.rawQuery(select, null);
        while (cs.moveToNext()){
            Lich lich = new Lich();
            lich.setId(cs.getInt(0));
            lich.setTieuDe(cs.getString(1));
            lich.setNoiDung(cs.getString(2));
            lich.setThoiGian(cs.getString(3));
            arrLich.add(lich);
        }
        db.close();
        return arrLich;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
