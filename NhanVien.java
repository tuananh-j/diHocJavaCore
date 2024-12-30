
public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoTen, double luong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public double getThueThuNhap() {
        if (this.getLuong() > 1500) {
            return this.getLuong() * 0.12;
        } else if (this.getLuong() > 1200) {
            return this.getLuong() * 0.1;
        } else {
            return 0;
        }
    }

    public double getThuNhap() {
        return this.getLuong() - this.getThueThuNhap();
    }

    @Override
    public String toString() {
        return String.format("NhanVien[maNhanVien=%s, hoTen=%s, luong=%.2f, thueThuNhap=%.2f, thuNhap=%.2f]",
                maNhanVien, hoTen, luong, getThueThuNhap(), getThuNhap());
    }

    public static void main(String[] args) {
        NhanVien nv = new NhanVien("NV01", "tuananh_nh", 1600);
        System.out.println(nv);
    }
}
