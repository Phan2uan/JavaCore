package QuanLyTraLuong;

import java.io.*;
import java.util.Scanner;

// ================== ABSTRACT CLASS ==================
abstract class Nguoi implements Serializable {
    protected String hoTen;
    protected String diaChi;
    protected String soDT;

    public Nguoi(String hoTen, String diaChi, String soDT) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public abstract void hienThi();
}

// ================== ENUM TRÌNH ĐỘ ==================
enum TrinhDo implements Serializable {
    GS_TS, PGS_TS, GIANG_VIEN_CHINH, THAC_SI
}

// ================== GIẢNG VIÊN ==================
class GiangVien extends Nguoi {
    private static int AUTO_ID = 100;
    private int maGV;
    private TrinhDo trinhDo;

    public GiangVien(String hoTen, String diaChi, String soDT, TrinhDo trinhDo) {
        super(hoTen, diaChi, soDT);
        this.maGV = AUTO_ID++;
        this.trinhDo = trinhDo;
    }

    // Constructor dùng khi đọc file
    public GiangVien(int maGV, String hoTen, String diaChi, String soDT, TrinhDo trinhDo) {
        super(hoTen, diaChi, soDT);
        this.maGV = maGV;
        this.trinhDo = trinhDo;
    }

    public static void capNhatAutoId(int maxId) {
        if (maxId >= AUTO_ID) AUTO_ID = maxId + 1;
    }

    public int getMaGV() { return maGV; }
    public String getHoTen() { return hoTen; }

    @Override
    public void hienThi() {
        System.out.printf("%03d | %-20s | %-15s | %-12s | %s\n",
                maGV, hoTen, diaChi, soDT, trinhDo);
    }
}

// ================== MÔN HỌC ==================
class MonHoc implements Serializable {
    private static int AUTO_ID = 100;
    private int maMon;
    private String tenMon;
    private int tongTiet;
    private int tietLyThuyet;
    private double kinhPhi;

    public MonHoc(String tenMon, int tongTiet, int tietLyThuyet, double kinhPhi) {
        this.maMon = AUTO_ID++;
        this.tenMon = tenMon;
        this.tongTiet = tongTiet;
        this.tietLyThuyet = tietLyThuyet;
        this.kinhPhi = kinhPhi;
    }

    public MonHoc(int maMon, String tenMon, int tongTiet, int tietLyThuyet, double kinhPhi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.tongTiet = tongTiet;
        this.tietLyThuyet = tietLyThuyet;
        this.kinhPhi = kinhPhi;
    }

    public static void capNhatAutoId(int maxId) {
        if (maxId >= AUTO_ID) AUTO_ID = maxId + 1;
    }

    public String getTenMon() { return tenMon; }
    public int getTongTiet() { return tongTiet; }
    public int getTietLyThuyet() { return tietLyThuyet; }
    public double getKinhPhi() { return kinhPhi; }
    public int getTietThucHanh() { return tongTiet - tietLyThuyet; }

    public void hienThi() {
        System.out.printf("%03d | %-20s | %d tiết\n", maMon, tenMon, tongTiet);
    }

    public int getMaMon() {
        return maMon;
    }
}

// ================== BẢNG KÊ KHAI ==================
class BangKeKhai implements Serializable {
    private GiangVien gv;
    private MonHoc mon;
    private int soLop;

    public BangKeKhai(GiangVien gv, MonHoc mon, int soLop) {
        this.gv = gv;
        this.mon = mon;
        this.soLop = soLop;
    }

    public GiangVien getGv() { return gv; }
    public MonHoc getMon() { return mon; }
    public int getSoLop() { return soLop; }
    public int getTongTiet() { return mon.getTongTiet() * soLop; }

    public double getTien() {
        double tienLT = mon.getTietLyThuyet() * mon.getKinhPhi();
        double tienTH = mon.getTietThucHanh() * mon.getKinhPhi() * 0.7;
        return (tienLT + tienTH) * soLop;
    }

    public void hienThi() {
        System.out.printf("%-20s | %-20s | %d lớp | %d tiết | %,10.2fđ\n",
                gv.getHoTen(), mon.getTenMon(), soLop, getTongTiet(), getTien());
    }
}

// ================== CLASS MAIN ==================
public class QuanLyTraLuongGiaoVien {
    static Scanner sc = new Scanner(System.in);
    static GiangVien[] dsGV = new GiangVien[10];
    static MonHoc[] dsMH = new MonHoc[10];
    static BangKeKhai[] dsBK = new BangKeKhai[10];
    static int nGV = 0, nMH = 0, nBK = 0;

    public static void main(String[] args) {
        docFile(); // khôi phục dữ liệu nếu có
        while (true) {
            System.out.println("\n===== QUẢN LÝ TRẢ LƯƠNG GIÁO VIÊN =====");
            System.out.println("1. Nhập môn học");
            System.out.println("2. Nhập giảng viên");
            System.out.println("3. Kê khai giảng dạy (chọn môn, số lớp)");
            System.out.println("4. Sắp xếp bảng kê khai");
            System.out.println("5. Tính tiền công chi tiết");
            System.out.println("6. Ghi file");
            System.out.println("7. Đọc file (tải lại)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int chon = nhapSo();
            switch (chon) {
                case 1: nhapMonHoc(); break;
                case 2: nhapGiangVien(); break;
                case 3: keKhai(); break;
                case 4: sapXep(); break;
                case 5: tinhTien(); break;
                case 6: ghiFile(); break;
                case 7: docFile(); break;
                case 0: return;
                default: System.out.println("Chọn 0-7!");
            }
        }
    }

    // ---------- NHẬP SỐ AN TOÀN ----------
    static int nhapSo() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại số: ");
            }
        }
    }

    static double nhapDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại số thực: ");
            }
        }
    }

    // ---------- MỞ RỘNG MẢNG ĐỘNG ----------
    static void moRongMang(Object[] arr, int size) {
        if (size >= arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            if (arr instanceof GiangVien[]) dsGV = (GiangVien[]) newArr;
            else if (arr instanceof MonHoc[]) dsMH = (MonHoc[]) newArr;   // thêm dòng này
            else if (arr instanceof BangKeKhai[]) dsBK = (BangKeKhai[]) newArr;
        }
    }

    // ---------- NHẬP MÔN HỌC ----------
    static void nhapMonHoc() {
        System.out.print("Số môn cần nhập: ");
        int n = nhapSo();
        for (int i = 0; i < n; i++) {
            System.out.println("\nMôn thứ " + (i + 1));
            System.out.print("Tên môn: ");
            String ten = sc.nextLine();
            System.out.print("Tổng số tiết: ");
            int tong = nhapSo();
            while (tong <= 0) {
                System.out.print("Tổng tiết > 0: ");
                tong = nhapSo();
            }
            System.out.print("Số tiết lý thuyết: ");
            int lt = nhapSo();
            while (lt < 0 || lt > tong) {
                System.out.print("Tiết lý thuyết (0.." + tong + "): ");
                lt = nhapSo();
            }
            System.out.print("Kinh phí mỗi tiết lý thuyết: ");
            double kp = nhapDouble();
            while (kp <= 0) {
                System.out.print("Kinh phí > 0: ");
                kp = nhapDouble();
            }
            moRongMang(dsMH, nMH + 1);
            dsMH[nMH++] = new MonHoc(ten, tong, lt, kp);
        }
        System.out.println("\n===== DANH SÁCH MÔN HỌC =====");
        for (int i = 0; i < nMH; i++) dsMH[i].hienThi();
    }

    // ---------- NHẬP GIẢNG VIÊN ----------
    static void nhapGiangVien() {
        System.out.print("Số giảng viên cần nhập: ");
        int n = nhapSo();
        for (int i = 0; i < n; i++) {
            System.out.println("\nGiảng viên thứ " + (i + 1));
            System.out.print("Họ tên: ");
            String ten = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();
            System.out.print("SĐT: ");
            String sdt = sc.nextLine();
            System.out.println("Trình độ: 1.GS_TS  2.PGS_TS  3.GIANG_VIEN_CHINH  4.THAC_SI");
            int chon = nhapSo();
            while (chon < 1 || chon > 4) {
                System.out.print("Chọn 1-4: ");
                chon = nhapSo();
            }
            TrinhDo td = TrinhDo.values()[chon - 1];
            moRongMang(dsGV, nGV + 1);
            dsGV[nGV++] = new GiangVien(ten, dc, sdt, td);
        }
        System.out.println("\n===== DANH SÁCH GIẢNG VIÊN =====");
        for (int i = 0; i < nGV; i++) dsGV[i].hienThi();
    }

    // ---------- KÊ KHAI (CHỌN MÔN, SỐ LỚP) ----------
    static void keKhai() {
        if (nGV == 0 || nMH == 0) {
            System.out.println("Cần nhập giảng viên và môn học trước!");
            return;
        }
        // Chọn giảng viên
        System.out.println("\nChọn giảng viên (nhập mã số):");
        for (int i = 0; i < nGV; i++) dsGV[i].hienThi();
        int ma = nhapSo();
        GiangVien gv = null;
        for (int i = 0; i < nGV; i++) if (dsGV[i].getMaGV() == ma) { gv = dsGV[i]; break; }
        if (gv == null) { System.out.println("Không tìm thấy giảng viên!"); return; }

        int tongTietHienTai = 0;
        // Tính tổng tiết đã kê khai của GV này
        for (int i = 0; i < nBK; i++) if (dsBK[i].getGv() == gv) tongTietHienTai += dsBK[i].getTongTiet();

        while (true) {
            System.out.println("\n--- Danh sách môn học ---");
            for (int i = 0; i < nMH; i++) dsMH[i].hienThi();
            System.out.print("Chọn môn (nhập mã môn) hoặc 0 để kết thúc: ");
            int maMon = nhapSo();
            if (maMon == 0) break;
            MonHoc mon = null;
            for (int i = 0; i < nMH; i++) if (dsMH[i].getMaMon() == maMon) { mon = dsMH[i]; break; }
            if (mon == null) { System.out.println("Mã môn không hợp lệ!"); continue; }

            // Kiểm tra xem đã kê khai môn này cho GV chưa
            boolean daCo = false;
            for (int i = 0; i < nBK; i++) {
                if (dsBK[i].getGv() == gv && dsBK[i].getMon() == mon) {
                    System.out.println("Đã kê khai môn này rồi. Bạn có muốn cập nhật số lớp? (1:Có, 0:Không)");
                    int upd = nhapSo();
                    if (upd == 1) {
                        System.out.print("Số lớp mới (1-3): ");
                        int lop = nhapSo();
                        while (lop < 1 || lop > 3) {
                            System.out.print("Số lớp từ 1 đến 3: ");
                            lop = nhapSo();
                        }
                        int tietCu = dsBK[i].getTongTiet();
                        int tietMoi = mon.getTongTiet() * lop;
                        if (tongTietHienTai - tietCu + tietMoi > 200) {
                            System.out.println("Tổng số tiết vượt quá 200! Không thể cập nhật.");
                        } else {
                            dsBK[i] = new BangKeKhai(gv, mon, lop);
                            tongTietHienTai = tongTietHienTai - tietCu + tietMoi;
                            System.out.println("Cập nhật thành công.");
                        }
                    }
                    daCo = true;
                    break;
                }
            }
            if (daCo) continue;

            // Nhập số lớp mới
            System.out.print("Số lớp (1-3): ");
            int lop = nhapSo();
            while (lop < 1 || lop > 3) {
                System.out.print("Số lớp từ 1 đến 3: ");
                lop = nhapSo();
            }
            int tietThem = mon.getTongTiet() * lop;
            if (tongTietHienTai + tietThem > 200) {
                System.out.println("Tổng tiết giảng dạy sẽ vượt 200! Không thể thêm.");
                continue;
            }
            moRongMang(dsBK, nBK + 1);
            dsBK[nBK++] = new BangKeKhai(gv, mon, lop);
            tongTietHienTai += tietThem;
            System.out.println("Đã thêm kê khai.");
        }
        // In lại bảng kê khai của GV này
        System.out.println("\n===== BẢNG KÊ KHAI CỦA " + gv.getHoTen() + " =====");
        for (int i = 0; i < nBK; i++) if (dsBK[i].getGv() == gv) dsBK[i].hienThi();
    }

    // ---------- SẮP XẾP BẢNG KÊ KHAI ----------
    static void sapXep() {
        if (nBK == 0) { System.out.println("Chưa có bảng kê khai!"); return; }
        System.out.println("Sắp xếp theo:");
        System.out.println("1. Họ tên giảng viên (tăng dần)");
        System.out.println("2. Số tiết giảng dạy mỗi môn (giảm dần)");
        int chon = nhapSo();
        for (int i = 0; i < nBK - 1; i++) {
            for (int j = i + 1; j < nBK; j++) {
                boolean canSwap = false;
                if (chon == 1) {
                    canSwap = dsBK[i].getGv().getHoTen().compareTo(dsBK[j].getGv().getHoTen()) > 0;
                } else if (chon == 2) {
                    canSwap = dsBK[i].getTongTiet() < dsBK[j].getTongTiet();
                }
                if (canSwap) {
                    BangKeKhai tmp = dsBK[i];
                    dsBK[i] = dsBK[j];
                    dsBK[j] = tmp;
                }
            }
        }
        System.out.println("\n===== BẢNG KÊ KHAI SAU SẮP XẾP =====");
        for (int i = 0; i < nBK; i++) dsBK[i].hienThi();
    }

    // ---------- TÍNH TIỀN CHI TIẾT ----------
    static void tinhTien() {
        if (nGV == 0) { System.out.println("Chưa có giảng viên!"); return; }
        System.out.println("\n===== BẢNG TÍNH LƯƠNG GIẢNG VIÊN =====");
        for (int i = 0; i < nGV; i++) {
            GiangVien gv = dsGV[i];
            System.out.println("\nGiảng viên: " + gv.getHoTen());
            double tongTien = 0;
            boolean coMon = false;
            for (int j = 0; j < nBK; j++) {
                if (dsBK[j].getGv() == gv) {
                    coMon = true;
                    System.out.printf("  %-20s | %d lớp | %d tiết | %,10.2fđ\n",
                            dsBK[j].getMon().getTenMon(), dsBK[j].getSoLop(),
                            dsBK[j].getTongTiet(), dsBK[j].getTien());
                    tongTien += dsBK[j].getTien();
                }
            }
            if (!coMon) System.out.println("  (Chưa có kê khai)");
            else System.out.printf("  TỔNG CỘNG: %,10.2fđ\n", tongTien);
        }
    }

    // ---------- GHI FILE ----------
    static void ghiFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("gv_data.dat"))) {
            oos.writeObject(dsGV);   // chỉ ghi số lượng đang dùng, nhưng mảng có thể thừa. Tốt hơn ghi cả mảng và n?
            oos.writeInt(nGV);
            oos.writeObject(dsMH);
            oos.writeInt(nMH);
            oos.writeObject(dsBK);
            oos.writeInt(nBK);
            System.out.println("Đã lưu dữ liệu vào file gv_data.dat");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // ---------- ĐỌC FILE ----------
    static void docFile() {
        File f = new File("gv_data.dat");
        if (!f.exists()) {
            System.out.println("Chưa có file dữ liệu, bắt đầu với dữ liệu rỗng.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            dsGV = (GiangVien[]) ois.readObject();
            nGV = ois.readInt();
            dsMH = (MonHoc[]) ois.readObject();
            nMH = ois.readInt();
            dsBK = (BangKeKhai[]) ois.readObject();
            nBK = ois.readInt();
            // Cập nhật AUTO_ID dựa trên mã lớn nhất
            int maxIdGV = 0, maxIdMH = 0;
            for (int i = 0; i < nGV; i++) if (dsGV[i].getMaGV() > maxIdGV) maxIdGV = dsGV[i].getMaGV();
            for (int i = 0; i < nMH; i++) if (dsMH[i].getMaMon() > maxIdMH) maxIdMH = dsMH[i].getMaMon();
            GiangVien.capNhatAutoId(maxIdGV);
            MonHoc.capNhatAutoId(maxIdMH);
            System.out.println("Đã đọc file: " + nGV + " GV, " + nMH + " môn, " + nBK + " bản ghi kê khai.");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
            // Nếu lỗi, khởi tạo mảng mới
            dsGV = new GiangVien[10];
            dsMH = new MonHoc[10];
            dsBK = new BangKeKhai[10];
            nGV = nMH = nBK = 0;
        }
    }
}