package QuanLyTraLuong;

import java.util.Scanner;

/*
 * ============================
 * CLASS TRỪU TƯỢNG (ABSTRACT)
 * ============================
 * Dùng để thể hiện tính trừu tượng + đa hình
 */
abstract class Nguoi {
    protected String hoTen;
    protected String diaChi;
    protected String soDT;

    public Nguoi(String hoTen, String diaChi, String soDT) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    // phương thức trừu tượng (đa hình)
    public abstract void hienThi();
}

/*
 * ============================
 * ENUM TRÌNH ĐỘ
 * ============================
 */
enum TrinhDo {
    GS_TS, PGS_TS, GIANG_VIEN_CHINH, THAC_SI
}

/*
 * ============================
 * CLASS GIẢNG VIÊN
 * Kế thừa từ Nguoi
 * ============================
 */
class GiangVien extends Nguoi {
    private static int AUTO_ID = 100; // tự tăng ID

    private int maGV;
    private TrinhDo trinhDo;

    public GiangVien(String hoTen, String diaChi, String soDT, TrinhDo trinhDo) {
        super(hoTen, diaChi, soDT); // gọi constructor cha
        this.maGV = AUTO_ID++;
        this.trinhDo = trinhDo;
    }

    public int getMaGV() {
        return maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    // override (đa hình)
    @Override
    public void hienThi() {
        System.out.println(maGV + " | " + hoTen + " | " + diaChi + " | " + soDT + " | " + trinhDo);
    }
}

/*
 * ============================
 * CLASS MÔN HỌC
 * ============================
 */
class MonHoc {
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

    public String getTenMon() {
        return tenMon;
    }

    public int getTongTiet() {
        return tongTiet;
    }

    public int getTietLyThuyet() {
        return tietLyThuyet;
    }

    public double getKinhPhi() {
        return kinhPhi;
    }

    // số tiết thực hành = tổng - lý thuyết
    public int getTietThucHanh() {
        return tongTiet - tietLyThuyet;
    }

    public void hienThi() {
        System.out.println(maMon + " | " + tenMon + " | " + tongTiet + " tiết");
    }
}

/*
 * ============================
 * CLASS BẢNG KÊ KHAI
 * ============================
 */
class BangKeKhai {
    private GiangVien gv;
    private MonHoc mon;
    private int soLop;

    public BangKeKhai(GiangVien gv, MonHoc mon, int soLop) {
        this.gv = gv;
        this.mon = mon;
        this.soLop = soLop;
    }

    public GiangVien getGv() {
        return gv;
    }

    public MonHoc getMon() {
        return mon;
    }

    public int getSoLop() {
        return soLop;
    }

    // tổng tiết = số tiết môn * số lớp
    public int getTongTiet() {
        return mon.getTongTiet() * soLop;
    }

    // tính tiền
    public double getTien() {
        double tienLT = mon.getTietLyThuyet() * mon.getKinhPhi();
        double tienTH = mon.getTietThucHanh() * mon.getKinhPhi() * 0.7;
        return (tienLT + tienTH) * soLop;
    }

    public void hienThi() {
        System.out.println(gv.getHoTen() + " | " + mon.getTenMon() + " | lớp: " + soLop);
    }
}

/*
 * ============================
 * CLASS MAIN
 * ============================
 */
public class QuanLyTraLuongGiaoVien {

    static Scanner sc = new Scanner(System.in);

    // dùng MẢNG (đúng yêu cầu đề)
    static GiangVien[] dsGV = new GiangVien[100];
    static MonHoc[] dsMH = new MonHoc[100];
    static BangKeKhai[] dsBK = new BangKeKhai[100];

    static int nGV = 0, nMH = 0, nBK = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập môn học");
            System.out.println("2. Nhập giảng viên");
            System.out.println("3. Kê khai giảng dạy");
            System.out.println("4. Sắp xếp theo tên GV");
            System.out.println("5. Tính tiền");
            System.out.println("0. Thoát");

            int chon = sc.nextInt();

            switch (chon) {
                case 1: nhapMonHoc(); break;
                case 2: nhapGiangVien(); break;
                case 3: keKhai(); break;
                case 4: sapXep(); break;
                case 5: tinhTien(); break;
                case 0: return;
            }
        }
    }

    /*
     * ============================
     * NHẬP MÔN HỌC
     * ============================
     */
    static void nhapMonHoc() {
        System.out.print("Số môn: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Tên môn: ");
            String ten = sc.nextLine();

            System.out.print("Tổng tiết: ");
            int tong = sc.nextInt();

            System.out.print("Tiết LT: ");
            int lt = sc.nextInt();

            System.out.print("Kinh phí: ");
            double kp = sc.nextDouble(); sc.nextLine();

            dsMH[nMH++] = new MonHoc(ten, tong, lt, kp);
        }

        // in ra
        for (int i = 0; i < nMH; i++) {
            dsMH[i].hienThi();
        }
    }

    /*
     * ============================
     * NHẬP GIẢNG VIÊN
     * ============================
     */
    static void nhapGiangVien() {
        System.out.print("Số GV: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Tên: ");
            String ten = sc.nextLine();

            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();

            System.out.print("SĐT: ");
            String sdt = sc.nextLine();

            System.out.println("1.GS_TS 2.PGS_TS 3.GVC 4.ThS");
            int chon = sc.nextInt(); sc.nextLine();

            TrinhDo td = TrinhDo.values()[chon - 1];

            dsGV[nGV++] = new GiangVien(ten, dc, sdt, td);
        }

        for (int i = 0; i < nGV; i++) {
            dsGV[i].hienThi();
        }
    }

    /*
     * ============================
     * KÊ KHAI
     * ============================
     */
    static void keKhai() {
        for (int i = 0; i < nGV; i++) {
            int tongTiet = 0;

            for (int j = 0; j < nMH; j++) {
                System.out.print(dsGV[i].getHoTen() + " dạy " +
                        dsMH[j].getTenMon() + " bao nhiêu lớp: ");

                int lop = sc.nextInt();

                // kiểm tra điều kiện đề bài
                if (lop > 0 && lop <= 3) {
                    int tiet = dsMH[j].getTongTiet() * lop;

                    if (tongTiet + tiet <= 200) {
                        dsBK[nBK++] = new BangKeKhai(dsGV[i], dsMH[j], lop);
                        tongTiet += tiet;
                    }
                }
            }
        }
    }

    /*
     * ============================
     * SẮP XẾP THEO TÊN GV
     * ============================
     */
    static void sapXep() {
        for (int i = 0; i < nBK - 1; i++) {
            for (int j = i + 1; j < nBK; j++) {

                if (dsBK[i].getGv().getHoTen()
                        .compareTo(dsBK[j].getGv().getHoTen()) > 0) {

                    BangKeKhai temp = dsBK[i];
                    dsBK[i] = dsBK[j];
                    dsBK[j] = temp;
                }
            }
        }

        for (int i = 0; i < nBK; i++) {
            dsBK[i].hienThi();
        }
    }

    /*
     * ============================
     * TÍNH TIỀN
     * ============================
     */
    static void tinhTien() {
        for (int i = 0; i < nGV; i++) {
            double tong = 0;

            for (int j = 0; j < nBK; j++) {
                if (dsBK[j].getGv() == dsGV[i]) {
                    tong += dsBK[j].getTien();
                }
            }

            System.out.println(dsGV[i].getHoTen() + " -> " + tong);
        }
    }
}