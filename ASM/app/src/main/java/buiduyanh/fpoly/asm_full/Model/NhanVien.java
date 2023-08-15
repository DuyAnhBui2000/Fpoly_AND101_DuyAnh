package buiduyanh.fpoly.asm_full.Model;

public class NhanVien {
    private int id;
    private String MaNv;
    private String TenNv;
    private String PhongBan;

    public NhanVien() {
    }

    public NhanVien(int id, String maNv, String tenNv, String phongBan) {
        this.id = id;
        MaNv = maNv;
        TenNv = tenNv;
        PhongBan = phongBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String maNv) {
        MaNv = maNv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String tenNv) {
        TenNv = tenNv;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String phongBan) {
        PhongBan = phongBan;
    }
}
