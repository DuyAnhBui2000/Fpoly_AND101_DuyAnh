package buiduyanh.fpoly.demo_3;

public class Food {
    private String ten;
    private String gia;
    private String ghiChu;

    public Food(String ten, String gia, String ghiChu) {
        this.ten = ten;
        this.gia = gia;
        this.ghiChu = ghiChu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
