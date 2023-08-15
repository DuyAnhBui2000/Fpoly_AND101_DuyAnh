package buiduyanh.fpoly.asm_full.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import buiduyanh.fpoly.asm_full.Model.NhanVien;

public class DataBase_NhanVien extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_nhanvien";
    public static final int VERISION = 1;

    public DataBase_NhanVien(@Nullable Context context) {
        super(context, DB_NAME, null, VERISION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taobang = "CREATE TABLE nhanvien(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "manv TEXT NOT NULL," +
                "tennv TEXT NOT NULL," +
                "phongban TEXT NOT NULL)";
        db.execSQL(taobang);
    }

    public boolean them(NhanVien nhanVien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manv", nhanVien.getMaNv());
        values.put("tennv", nhanVien.getTenNv());
        values.put("phongban", nhanVien.getPhongBan());
        return db.insert("nhanvien",null, values) > 0;
    }

    public boolean sua(NhanVien nhanVien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manv", nhanVien.getMaNv());
        values.put("tennv", nhanVien.getTenNv());
        values.put("phongban", nhanVien.getPhongBan());

        return db.update("nhanvien", values, "id=?", new String[]{String.valueOf(nhanVien.getId())}) > 0;
    }

    public boolean xoa(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("nhanvien", "id=?" , new String[]{String.valueOf(id)}) > 0;
    }

    public ArrayList<NhanVien> getAllData(){
        ArrayList<NhanVien> arrLich = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM nhanvien";

        Cursor cs = db.rawQuery(select, null);
        while (cs.moveToNext()){
            NhanVien nhanvien = new NhanVien();
            nhanvien.setId(cs.getInt(0));
            nhanvien.setMaNv(cs.getString(1));
            nhanvien.setTenNv(cs.getString(2));
            nhanvien.setPhongBan(cs.getString(3));
            arrLich.add(nhanvien);
        }
        db.close();
        return arrLich;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
