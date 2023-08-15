package buiduyanh.fpoly.demo_tt;

public class SinhVien {
    private String hoten;
    private String diachi;

    public SinhVien() {
    }

    // dùng để set cứng
//    public SinhVien(String tencoso, String hoten, String diachi) {
//        this.tencoso = tencoso;
//        this.hoten = hoten;
//        this.diachi = diachi;
//    }

    public SinhVien(String hoten, String diachi) {
        this.hoten = hoten;
        this.diachi = diachi;
    }
    //

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
