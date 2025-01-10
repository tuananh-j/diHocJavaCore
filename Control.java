import java.util.*;

import java.util.stream.Collectors;

import static java.util.Collections.binarySearch;

public class Control {

    static ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String quayLai;
        do{

            System.out.println("1. Tao nhan vien moi");
            System.out.println("2. Cai dat lai nhan vien");
            System.out.println("3. Tim nhan vien");
            System.out.println("4. Sap xep nhan vien ung voi thu nhap");
            System.out.println("5. Xoa nhan vien");
            System.out.println("6. In danh sach nhan vien");
            System.out.println("7. Sap xep nhan vien ung voi ho ten");
            System.out.println("8. Tim nhan vien theo khoang luong nhap tu ban phim");
            System.out.println("9. Xuat nam nhan vien co thu nhap cao nhat");

            int luaChonChucNang;
            System.out.println("Chuc nang ban chon?");
            luaChonChucNang = scanner.nextInt();
            switch (luaChonChucNang){
                case 1 ->{
                    String luaChon; // lua chon
                    do{
                        taoNhanVien(scanner);
                        System.out.println("Tao mot nhan vien nua?");
                        System.out.println("Can 'c' - Khong Can 'kc'");
                        luaChon = scanner.nextLine();
                    }while (luaChon.equals("c"));
                }
                case 2 ->{
                    caiDatLaiNhanVien(scanner);
                }
                case 3 ->{
                    timNhanVien(scanner);
                }
                case 4 ->{
                    sapXepNhanVien_thuNhap(scanner);
                }
                case 5 ->{
                    xoaNhanVien(scanner);
                }
                case 6 ->{
                    inDanhSachNhanVien();
                }
                case 7 ->{
                    sapXepNhanVien_HoTen(scanner);
                }
                case 8 -> {
                    inNamNhanVienCoThuNhapCao(scanner);
                }
                case 9 -> {
                    timNhanVien_UngVoiKhoangLuong(scanner);
                }
                default -> {
                    System.out.println("Chuc nang khong kha dung");
                }

            }

            System.out.println("Quay lai trang menu chuc nang? ");
            System.out.println("Can 'c' - Khong Can 'kc'");
            quayLai = scanner.nextLine();
        }while (quayLai.equals("c"));
        scanner.close();
    }

    // tao moi nhan vien
    public static void taoNhanVien( Scanner scanner){
        //thong tin cua mot nhan vien can co
        String maNhanVien; // ma nhan vien
        String hoTen; // ho ten nhan vien
        double luong; // luong nhan vien duoc nhan

        //Truong Phong
        double luongTrachNhiem; // luong trach nhiem

        //Nhan vien Cau Noi
        double doanhSo; // doanh so dat duoc
        double hoaHong; // hoa hong nhan duoc

        // xac nhan nhan vien can tao
        System.out.println("Nhan vien ban can tao?");
        System.out.println("Nhan Vien 'nv' - Truong Phong 'tp' - Cau Noi 'cn'");
        String position;
        scanner = new Scanner(System.in);
        position = scanner.nextLine();

        //
        System.out.println("Ma nhan vien?");
        maNhanVien = scanner.nextLine();
        System.out.println("Ho ten nhan vien?");
        hoTen = scanner.nextLine();
        System.out.println("Luong nhan vien?");
        luong = scanner.nextDouble();
        scanner.nextLine();

        switch (position) {
            case "nv" -> {  // lambda
                NhanVien items = new NhanVien();
                items.setMaNhanVien(maNhanVien);
                items.setHoTen(hoTen);
                items.setLuong(luong);
                danhSachNhanVien.add(items);
            }
            case "tp" -> {
                TruongPhong items = new TruongPhong();
                System.out.println("Luong trach nhiem?");
                luongTrachNhiem = scanner.nextDouble();
                scanner.nextLine();
                items.setMaNhanVien(maNhanVien);
                items.setHoTen(hoTen);
                items.setLuong(luong);
                items.setLuongTrachNhiem(luongTrachNhiem);
                danhSachNhanVien.add(items);
            }
            case "cn" -> {
                NhanVienCauNoi items = new NhanVienCauNoi();
                System.out.println("Doanh so dat duoc?");
                doanhSo = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Hoa hong duoc nhan?");
                hoaHong = scanner.nextDouble();
                scanner.nextLine();
                items.setMaNhanVien(maNhanVien);
                items.setHoTen(hoTen);
                items.setLuong(luong);
                items.setDoanhSo(doanhSo);
                items.setHoaHong(hoaHong);
                danhSachNhanVien.add(items);
            }
        }
    }
    public static void inDanhSachNhanVien(){
        for(Object item : danhSachNhanVien){
            System.out.println(item);
        }
    }

    // cai dat lai thong tin nhan vien
    public static void caiDatLaiNhanVien(Scanner scanner){

        //thong tin cua mot nhan vien can co
        String maNhanVien; // ma nhan vien
        String hoTen; // ho ten nhan vien
        double luong; // luong nhan vien duoc nhan

        //Truong Phong
        double luongTrachNhiem; // luong trach nhiem

        //Nhan vien Cau Noi
        double doanhSo; // doanh so dat duoc
        double hoaHong; // hoa hong nhan duoc


        System.out.println("Ma nhan vien ban can tim ?");
        maNhanVien = scanner.nextLine();
        Object item;
        int positionNhanVien = timNhanVien_maNhanVien(maNhanVien);
        if(positionNhanVien == -1){
            System.out.println("Ma nhan vien chua dung");
            return;
        }else{
            item = danhSachNhanVien.get(positionNhanVien);
            System.out.println(item);
        }

        if(item instanceof NhanVien nhanVien){
            System.out.println("Ho ten nhan vien?");
            hoTen = scanner.nextLine();
            System.out.println("Luong nhan vien?");
            luong = scanner.nextDouble();
            scanner.nextLine();
            nhanVien.setMaNhanVien(maNhanVien);
            nhanVien.setHoTen(hoTen);
            nhanVien.setLuong(luong);
        }

        if (item instanceof TruongPhong truongPhong){
            System.out.println("Luong trach nhiem?");
            luongTrachNhiem = scanner.nextDouble();
            scanner.nextLine();
            truongPhong.setLuongTrachNhiem(luongTrachNhiem);
        } else if (item instanceof NhanVienCauNoi nhanVienCauNoi) {
            System.out.println("Doanh so dat duoc?");
            doanhSo = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Hoa hong duoc nhan?");
            hoaHong = scanner.nextDouble();
            scanner.nextLine();
            nhanVienCauNoi.setHoaHong(hoaHong);
            nhanVienCauNoi.setDoanhSo(doanhSo);
        }

    }
    public static void timNhanVien(Scanner scanner){
        String maNhanVien;
        System.out.println("Ma nhan vien ban can tim ?");
        maNhanVien = scanner.nextLine();
        int positionNhanVien = timNhanVien_maNhanVien(maNhanVien);
        if(positionNhanVien == -1){
            System.out.println("Ma nhan vien chua dung");
        }else{
            System.out.println(danhSachNhanVien.get(positionNhanVien));
        }
    }
    public static void xoaNhanVien(Scanner scanner){
        String maNhanVien;
        System.out.println("Ma nhan vien ban can xoa ?");
        maNhanVien = scanner.nextLine();
        int positionNhanVien = timNhanVien_maNhanVien(maNhanVien);
        if(positionNhanVien == -1){
            System.out.println("Ma nhan vien chua dung");
        }else{
            danhSachNhanVien.remove(positionNhanVien);
        }
    }
    public static void sapXepNhanVien_thuNhap(Scanner scanner){
        for (int i = 0; i < danhSachNhanVien.size() -1; i++){
            for (int j = i + 1; j < danhSachNhanVien.size(); j++){
                if(danhSachNhanVien.get(i).getThuNhap() > danhSachNhanVien.get(j).getThuNhap()){
                    Collections.swap(danhSachNhanVien,i,j);
                }
            }
        }
    }
    public static void sapXepNhanVien_HoTen(Scanner scanner){
        Comparator<NhanVien> comparator = (o1, o2) -> o2.getHoTen().compareToIgnoreCase(o1.getHoTen());
        danhSachNhanVien.sort(comparator);
    }
    public static int timNhanVien_maNhanVien(String maNhanVien){

        for(Object item : danhSachNhanVien){
            if(item instanceof NhanVien nhanVien){
                if(nhanVien.getMaNhanVien().equals(maNhanVien)){
                    return danhSachNhanVien.indexOf(nhanVien);
                }
            }
        }
        return -1;
    }
    public static void timNhanVien_UngVoiKhoangLuong(Scanner scanner){
        double minLuong, maxLuong;
        System.out.println("Muc luong toi thieu?");
        minLuong = Double.parseDouble(scanner.nextLine());
        System.out.println("Muc luong toi da");
        maxLuong = Double.parseDouble(scanner.nextLine());
        for(NhanVien itemNhanVien : danhSachNhanVien){
            if(itemNhanVien.getThuNhap() > minLuong && itemNhanVien.getThuNhap() < maxLuong){
                System.out.println(itemNhanVien);
            }
        }
    }
    public static void inNamNhanVienCoThuNhapCao(Scanner scanner){
        sapXepNhanVien_thuNhap(scanner);
        for(int i = 5; i > 0; i--){
            System.out.println(danhSachNhanVien.get(i));
        }
    }
}
