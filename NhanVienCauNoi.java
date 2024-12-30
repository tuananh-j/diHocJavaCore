public class NhanVienCauNoi extends NhanVien{
    private double doanhSo;
    private double hoaHong;

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }
    public NhanVienCauNoi(){

    }

    public NhanVienCauNoi(String maNhanVien, String hoTen, double luong, double doanhSo, double hoaHong) {
        super(maNhanVien, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    @Override
    public double getThuNhap() {
        return (this.getDoanhSo() * this.getHoaHong() + this.getLuong()) - this.getThueThuNhap() ;
    }

    @Override
    public String toString() {
        return String.format("NhanVienCauNoi[maNhanVien=%s, hoTen=%s, luong=%.2f, thueThuNhap=%.2f, loiNhuan=%.2f, thuNhap=%.2f]",
                this.getMaNhanVien(), this.getHoTen(), this.getLuong(), getThueThuNhap(),this.getDoanhSo() * this.getHoaHong(), getThuNhap());
    }

    public static void main(String[] args) {
        NhanVienCauNoi nhanVienCauNoi = new NhanVienCauNoi("US01","tuananh_nh",1250,2,50);
        System.out.println(nhanVienCauNoi);
    }
}
