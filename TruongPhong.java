
public class TruongPhong extends NhanVien{
    private double luongTrachNhiem;
    public TruongPhong(){

    }

    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }

    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public TruongPhong(String maNhanVien, String hoTen, double luong, double luongTrachNhiem) {
        super(maNhanVien, hoTen, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    @Override
    public double getThuNhap(){
        return (this.getLuongTrachNhiem() + this.getLuong()) - this.getThueThuNhap();
    }

    @Override
    public String toString() {
        return String.format("TruongPhong[maNhanVien=%s, hoTen=%s, luong=%.2f, thueThuNhap=%.2f, luongTrachNhiem=%.2f, thuNhap=%.2f]",
                this.getMaNhanVien(), this.getHoTen(), this.getLuong(), getThueThuNhap(),luongTrachNhiem, getThuNhap());
    }

    public static void main(String[] args) {
        TruongPhong truongPhong = new TruongPhong("US01", "tuananh_nh", 1500, 100);
        System.out.println(truongPhong);
    }
}
