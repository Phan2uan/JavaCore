package QuanLyMuonSachThuVien;

import java.util.Scanner;

// Lớp Bạn Đọc - Đóng gói
class BanDoc {
    private final int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String loaiBanDoc;
    private static int demMa = 10000;

    public BanDoc(String hoTen, String diaChi, String sdt, String loaiBanDoc) {
        this.maBanDoc = ++demMa;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.loaiBanDoc = loaiBanDoc;
    }

    public int getMaBanDoc() { return maBanDoc; }
    public String getHoTen() { return hoTen; }

    @Override
    public String toString() {
        return String.format("%-10d %-25s %-20s %-12s %-15s",
                maBanDoc, hoTen, diaChi, sdt, loaiBanDoc);
    }
}

// Lớp Sách - Đóng gói
class Sach {
    private final int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;
    private static int demMa = 10000;

    public Sach(String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
        this.maSach = ++demMa;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
    }

    public int getMaSach() { return maSach; }
    public String getTenSach() { return tenSach; }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %-20s %-25s %-10d",
                maSach, tenSach, tacGia, chuyenNganh, namXuatBan);
    }
}

// Lớp Chi tiết mượn
class ChiTietMuon {
    private final BanDoc banDoc;
    private final Sach sach;
    private int soLuong;
    private String tinhTrang;

    public ChiTietMuon(BanDoc banDoc, Sach sach, int soLuong, String tinhTrang) {
        this.banDoc = banDoc;
        this.sach = sach;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public BanDoc getBanDoc() { return banDoc; }
    public int getSoLuong() { return soLuong; }

    @Override
    public String toString() {
        return String.format("%-10d %-25s %-10d %-30s %-10d %-15s",
                banDoc.getMaBanDoc(), banDoc.getHoTen(), banDoc.getMaBanDoc(),
                sach.getTenSach(), soLuong, tinhTrang);
    }
}

// Lớp Quản lý mượn sách chính
class QuanLyMuonSach {
    private final BanDoc[] danhSachBanDoc;
    private final Sach[] danhSachSach;
    private final ChiTietMuon[] danhSachMuon;
    private int soLuongBanDoc;
    private int soLuongSach;
    private int soLuongMuon;
    private static final int MAX = 100;
    private static final Scanner scanner = new Scanner(System.in);

    public QuanLyMuonSach() {
        danhSachBanDoc = new BanDoc[MAX];
        danhSachSach = new Sach[MAX];
        danhSachMuon = new ChiTietMuon[MAX * 5];
        soLuongBanDoc = 0;
        soLuongSach = 0;
        soLuongMuon = 0;
    }

    private int nhapSo() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số: ");
            }
        }
    }

    private String nhapChuoi() {
        return scanner.nextLine();
    }

    // 1. Nhập danh sách đầu sách mới
    public void nhapDauSachMoi() {
        if (soLuongSach >= MAX) {
            System.out.println("Danh sách sách đã đầy!");
            return;
        }

        System.out.print("Nhập tên sách: ");
        String tenSach = nhapChuoi();
        System.out.print("Nhập tác giả: ");
        String tacGia = nhapChuoi();

        System.out.print("Nhập chuyên ngành (1-KHTN, 2-VHNT, 3-ĐTVT, 4-CNTT): ");
        int choice = nhapSo();
        String chuyenNganh = switch (choice) {
            case 1 -> "Khoa học tự nhiên";
            case 2 -> "Văn học - Nghệ thuật";
            case 3 -> "Điện tử Viễn thông";
            case 4 -> "Công nghệ thông tin";
            default -> "Khoa học tự nhiên";
        };

        System.out.print("Nhập năm xuất bản: ");
        int namXB = nhapSo();

        danhSachSach[soLuongSach++] = new Sach(tenSach, tacGia, chuyenNganh, namXB);
        System.out.println("Thêm sách thành công!");
    }

    // In danh sách đầu sách
    public void inDanhSachDauSach() {
        if (soLuongSach == 0) {
            System.out.println("Chưa có sách nào trong thư viện!");
            return;
        }
        System.out.println("\n========== DANH SÁCH ĐẦU SÁCH ==========");
        System.out.printf("%-10s %-30s %-20s %-25s %-10s\n",
                "Mã sách", "Tên sách", "Tác giả", "Chuyên ngành", "Năm XB");
        for (int i = 0; i < soLuongSach; i++) {
            System.out.println(danhSachSach[i]);
        }
    }

    // 2. Nhập danh sách bạn đọc mới
    public void nhapBanDocMoi() {
        if (soLuongBanDoc >= MAX) {
            System.out.println("Danh sách bạn đọc đã đầy!");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String hoTen = nhapChuoi();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = nhapChuoi();
        System.out.print("Nhập SĐT: ");
        String sdt = nhapChuoi();

        System.out.print("Nhập loại bạn đọc (1-Sinh viên, 2-Học viên cao học, 3-Giáo viên): ");
        int choice = nhapSo();
        String loaiBD = switch (choice) {
            case 1 -> "sinh viên";
            case 2 -> "học viên cao học";
            case 3 -> "giáo viên";
            default -> "sinh viên";
        };

        danhSachBanDoc[soLuongBanDoc++] = new BanDoc(hoTen, diaChi, sdt, loaiBD);
        System.out.println("Thêm bạn đọc thành công!");
    }

    // In danh sách bạn đọc
    public void inDanhSachBanDoc() {
        if (soLuongBanDoc == 0) {
            System.out.println("Chưa có bạn đọc nào!");
            return;
        }
        System.out.println("\n========== DANH SÁCH BẠN ĐỌC ==========");
        System.out.printf("%-10s %-25s %-20s %-12s %-15s\n",
                "Mã bạn đọc", "Họ tên", "Địa chỉ", "SĐT", "Loại bạn đọc");
        for (int i = 0; i < soLuongBanDoc; i++) {
            System.out.println(danhSachBanDoc[i]);
        }
    }

    // Kiểm tra bạn đọc đã mượn đầu sách này chưa
    private boolean daMuonSach(BanDoc bd, Sach s) {
        for (int i = 0; i < soLuongMuon; i++) {
            if (danhSachMuon[i].getBanDoc().getMaBanDoc() == bd.getMaBanDoc() &&
                    danhSachMuon[i].getBanDoc().getMaBanDoc() == s.getMaSach()) {
                return true;
            }
        }
        return false;
    }

    // Đếm số đầu sách bạn đọc đã mượn
    private int demDauSachDaMuon(BanDoc bd) {
        int count = 0;
        for (int i = 0; i < soLuongMuon; i++) {
            if (danhSachMuon[i].getBanDoc().getMaBanDoc() == bd.getMaBanDoc()) {
                count++;
            }
        }
        return count;
    }

    // 3. Lập bảng QL mượn sách
    public void lapBangMuonSach() {
        if (soLuongBanDoc == 0 || soLuongSach == 0) {
            System.out.println("Cần có bạn đọc và sách trước khi lập bảng mượn!");
            return;
        }

        inDanhSachBanDoc();
        System.out.print("Chọn mã bạn đọc: ");
        int maBD = nhapSo();

        BanDoc banDocTim = null;
        for (int i = 0; i < soLuongBanDoc; i++) {
            if (danhSachBanDoc[i].getMaBanDoc() == maBD) {
                banDocTim = danhSachBanDoc[i];
                break;
            }
        }

        if (banDocTim == null) {
            System.out.println("Không tìm thấy bạn đọc!");
            return;
        }

        if (demDauSachDaMuon(banDocTim) >= 5) {
            System.out.println("Bạn đọc đã mượn tối đa 5 đầu sách!");
            return;
        }

        inDanhSachDauSach();
        System.out.print("Chọn mã sách muốn mượn: ");
        int maSach = nhapSo();

        Sach sachTim = null;
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSachSach[i].getMaSach() == maSach) {
                sachTim = danhSachSach[i];
                break;
            }
        }

        if (sachTim == null) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        if (daMuonSach(banDocTim, sachTim)) {
            System.out.println("Bạn đọc đã mượn đầu sách này rồi!");
            return;
        }

        System.out.print("Nhập số lượng (1-3): ");
        int soLuong = nhapSo();
        if (soLuong < 1 || soLuong > 3) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }

        System.out.print("Nhập tình trạng (1-Đang mượn, 2-Đã trả, 3-Quá hạn): ");
        int tt = nhapSo();
        String tinhTrang = switch (tt) {
            case 1 -> "Đang mượn";
            case 2 -> "Đã trả";
            case 3 -> "Quá hạn";
            default -> "Đang mượn";
        };

        danhSachMuon[soLuongMuon++] = new ChiTietMuon(banDocTim, sachTim, soLuong, tinhTrang);
        System.out.println("Thêm phiếu mượn thành công!");
    }

    // In danh sách mượn
    public void inDanhSachMuonSach() {
        if (soLuongMuon == 0) {
            System.out.println("Chưa có phiếu mượn nào!");
            return;
        }
        System.out.println("\n========== DANH SÁCH MƯỢN SÁCH ==========");
        System.out.printf("%-10s %-25s %-10s %-30s %-10s %-15s\n",
                "Mã bạn đọc", "Tên bạn đọc", "Mã sách", "Tên sách", "Số lượng", "Tình trạng");
        for (int i = 0; i < soLuongMuon; i++) {
            System.out.println(danhSachMuon[i]);
        }
    }

    // 4a. Sắp xếp theo tên bạn đọc
    public void sapXepTheoTenBanDoc() {
        if (soLuongMuon <= 1) return;

        for (int i = 0; i < soLuongMuon - 1; i++) {
            for (int j = i + 1; j < soLuongMuon; j++) {
                if (danhSachMuon[i].getBanDoc().getHoTen()
                        .compareTo(danhSachMuon[j].getBanDoc().getHoTen()) > 0) {
                    ChiTietMuon temp = danhSachMuon[i];
                    danhSachMuon[i] = danhSachMuon[j];
                    danhSachMuon[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo tên bạn đọc!");
        inDanhSachMuonSach();
    }

    // 4b. Sắp xếp theo số lượng giảm dần
    public void sapXepTheoSoLuongGiamDan() {
        if (soLuongMuon <= 1) return;

        for (int i = 0; i < soLuongMuon - 1; i++) {
            for (int j = i + 1; j < soLuongMuon; j++) {
                if (danhSachMuon[i].getSoLuong() < danhSachMuon[j].getSoLuong()) {
                    ChiTietMuon temp = danhSachMuon[i];
                    danhSachMuon[i] = danhSachMuon[j];
                    danhSachMuon[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo số lượng (giảm dần)!");
        inDanhSachMuonSach();
    }

    // 5. Tìm kiếm theo tên bạn đọc
    public void timKiemTheoTenBanDoc() {
        if (soLuongMuon == 0) {
            System.out.println("Chưa có phiếu mượn nào!");
            return;
        }

        System.out.print("Nhập tên bạn đọc cần tìm: ");
        String ten = nhapChuoi();

        boolean found = false;
        System.out.println("\n========== KẾT QUẢ TÌM KIẾM ==========");
        System.out.printf("%-10s %-25s %-10s %-30s %-10s %-15s\n",
                "Mã bạn đọc", "Tên bạn đọc", "Mã sách", "Tên sách", "Số lượng", "Tình trạng");

        for (int i = 0; i < soLuongMuon; i++) {
            if (danhSachMuon[i].getBanDoc().getHoTen().toLowerCase()
                    .contains(ten.toLowerCase())) {
                System.out.println(danhSachMuon[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy bạn đọc nào!");
        }
    }
}

// Lớp Main
public class QuanLyThuVien {
    public static void main(String[] args) {
        QuanLyMuonSach ql = new QuanLyMuonSach();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== HỆ THỐNG QUẢN LÝ MƯỢN SÁCH THƯ VIỆN ==========");
            System.out.println("1. Nhập danh sách đầu sách mới");
            System.out.println("2. Nhập danh sách bạn đọc mới");
            System.out.println("3. Lập bảng quản lý mượn sách");
            System.out.println("4. In danh sách đầu sách");
            System.out.println("5. In danh sách bạn đọc");
            System.out.println("6. In danh sách mượn sách");
            System.out.println("7. Sắp xếp danh sách mượn theo tên bạn đọc");
            System.out.println("8. Sắp xếp danh sách mượn theo số lượng (giảm dần)");
            System.out.println("9. Tìm kiếm theo tên bạn đọc");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1 -> ql.nhapDauSachMoi();
                case 2 -> ql.nhapBanDocMoi();
                case 3 -> ql.lapBangMuonSach();
                case 4 -> ql.inDanhSachDauSach();
                case 5 -> ql.inDanhSachBanDoc();
                case 6 -> ql.inDanhSachMuonSach();
                case 7 -> ql.sapXepTheoTenBanDoc();
                case 8 -> ql.sapXepTheoSoLuongGiamDan();
                case 9 -> ql.timKiemTheoTenBanDoc();
                case 0 -> {
                    System.out.println("Cảm ơn đã sử dụng chương trình!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Chức năng không hợp lệ!");
            }
        }
    }
}