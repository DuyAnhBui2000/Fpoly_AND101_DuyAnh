package buiduyanh.fpoly.ot_sv;

public class SinhVien {
    private String Masv;
    private String HoTen;
    private int Tuoi;
    private String Sđt;


    public SinhVien() {
    }

    public SinhVien(String masv, String hoTen, int tuoi, String sđt) {
        Masv = masv;
        HoTen = hoTen;
        Tuoi = tuoi;
        Sđt = sđt;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String masv) {
        Masv = masv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }

    public String getSđt() {
        return Sđt;
    }

    public void setSđt(String sđt) {
        Sđt = sđt;
    }
}
