package QuanLyDiem;

import java.io.*;
import java.util.Scanner;

/*
 * ============================
 * CLASS TRỪU TƯỢNG (ABSTRACT)
 * ============================
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

    // đa hình
    public abstract void hienThi();
}

/*
 * ============================
 * CLASS SINH VIÊN
 * ============================
 */
class SinhVien extends Nguoi {
    private static int AUTO_ID = 10000; // 5 chữ số
    // NOTE (đối chiếu yêu cầu mã SV tự động tăng): Cách làm này đúng khi chạy 1 phiên.
    // Nhưng nếu chương trình có chức năng đọc dữ liệu từ file để dùng lại,
    // thì AUTO_ID cần được cập nhật theo mã SV lớn nhất đã tồn tại (tránh sinh trùng mã sau khi chạy lại).

    private int maSV;
    private String lop;

    public SinhVien(String hoTen, String diaChi, String soDT, String lop) {
        super(hoTen, diaChi, soDT);
        this.maSV = AUTO_ID++;
        this.lop = lop;
    }

    public int getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    @Override
    public void hienThi() {
        System.out.println(maSV + " | " + hoTen + " | " + diaChi + " | " + soDT + " | " + lop);
    }
}

/*
 * ============================
 * ENUM LOẠI MÔN
 * ============================
 */
enum LoaiMon {
    DAI_CUONG, CO_SO_NGANH, CHUYEN_NGANH
}

/*
 * ============================
 * CLASS MÔN HỌC
 * ============================
 */
class MonHoc {
    private static int AUTO_ID = 100;
    // NOTE (đối chiếu yêu cầu mã môn tự động tăng): Tương tự SinhVien,
    // nếu có đọc dữ liệu cũ từ file thì cần đồng bộ AUTO_ID theo mã môn lớn nhất.

    private int maMon;
    private String tenMon;
    private int soTinChi;
    private LoaiMon loai;

    public MonHoc(String tenMon, int soTinChi, LoaiMon loai) {
        this.maMon = AUTO_ID++;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.loai = loai;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void hienThi() {
        System.out.println(maMon + " | " + tenMon + " | TC: " + soTinChi + " | " + loai);
    }
}

/*
 * ============================
 * CLASS BẢNG ĐIỂM
 * ============================
 */
class BangDiem {
    private SinhVien sv;
    private MonHoc mon;
    private double diem;

    public BangDiem(SinhVien sv, MonHoc mon, double diem) {
        this.sv = sv;
        this.mon = mon;
        this.diem = diem;
    }

    public SinhVien getSv() {
        return sv;
    }

    public MonHoc getMon() {
        return mon;
    }

    public double getDiem() {
        return diem;
    }

    public void hienThi() {
        System.out.println(sv.getHoTen() + " | " + mon.getTenMon() + " | " + diem);
    }
}

/*
 * ============================
 * CLASS MAIN
 * ============================
 */
public class QuanLyDiemSinhVien {

    static Scanner sc = new Scanner(System.in);

    // dùng mảng
    static SinhVien[] dsSV = new SinhVien[100];
    static MonHoc[] dsMH = new MonHoc[100];
    static BangDiem[] dsBD = new BangDiem[100];

    // NOTE: Mảng đang fix cứng 100 phần tử.
    // - Nếu người dùng nhập vượt quá 100 SV/MH/BD sẽ bị ArrayIndexOutOfBoundsException.
    // - Theo yêu cầu đề bài (không dùng Collection) thì vẫn có thể xử lý bằng cách:
    //   + kiểm tra trước khi thêm, hoặc
    //   + tự tăng kích thước mảng (tạo mảng mới lớn hơn và copy dữ liệu).

    static int nSV = 0, nMH = 0, nBD = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập sinh viên");
            System.out.println("2. Nhập môn học");
            System.out.println("3. Nhập bảng điểm");
            System.out.println("4. Sắp xếp");
            System.out.println("5. Tính điểm TB");
            System.out.println("6. Ghi file");
            System.out.println("7. Đọc file");
            System.out.println("0. Thoát");

            int chon = nhapSo();

            switch (chon) {
                case 1: nhapSV(); break;
                case 2: nhapMH(); break;
                case 3: nhapBD(); break;
                case 4: sapXep(); break;
                case 5: tinhTB(); break;
                case 6: ghiFile(); break;
                case 7: docFile(); break;
                case 0: return;
            }
        }
    }

    /*
     * ============================
     * NHẬP SỐ (CÓ EXCEPTION)
     * ============================
     */
    static int nhapSo() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Nhập lại số: ");
            }
        }
    }

    /*
     * ============================
     * NHẬP SINH VIÊN
     * ============================
     */
    static void nhapSV() {
        System.out.print("Số SV: ");
        int n = nhapSo();

        // NOTE: Chưa kiểm tra nSV + n có vượt quá kích thước mảng dsSV hay không.
        // Nếu nhập nhiều lần và tổng số SV > 100 thì chương trình sẽ lỗi runtime.

        for (int i = 0; i < n; i++) {
            System.out.print("Tên: ");
            String ten = sc.nextLine();

            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();

            System.out.print("SĐT: ");
            String sdt = sc.nextLine();

            System.out.print("Lớp: ");
            String lop = sc.nextLine();

            dsSV[nSV++] = new SinhVien(ten, dc, sdt, lop);
        }

        for (int i = 0; i < nSV; i++) dsSV[i].hienThi();
    }

    /*
     * ============================
     * NHẬP MÔN HỌC
     * ============================
     */
    static void nhapMH() {
        System.out.print("Số môn: ");
        int n = nhapSo();

        // NOTE: Chưa kiểm tra nMH + n có vượt quá kích thước mảng dsMH hay không.

        for (int i = 0; i < n; i++) {
            System.out.print("Tên môn: ");
            String ten = sc.nextLine();

            System.out.print("Tín chỉ: ");
            int tc = nhapSo();

            System.out.println("1.Đại cương 2.Cơ sở 3.Chuyên ngành");
            int chon = nhapSo();

            // NOTE (quan trọng): Dòng dưới có thể văng ArrayIndexOutOfBoundsException
            // nếu người dùng nhập chon không thuộc 1..3.
            // Cần validate chon trước khi truy cập LoaiMon.values().
            LoaiMon loai = LoaiMon.values()[chon - 1];

            dsMH[nMH++] = new MonHoc(ten, tc, loai);
        }

        for (int i = 0; i < nMH; i++) dsMH[i].hienThi();
    }

    /*
     * ============================
     * NHẬP BẢNG ĐIỂM
     * ============================
     */
    static void nhapBD() {
        // NOTE (đối chiếu đề bài): Đề nói "một sinh viên có thể học nhiều môn" (không bắt buộc học tất cả môn).
        // Ở đây đang nhập điểm theo dạng full SV x MH (mọi SV đều nhập điểm cho mọi môn).
        // => Lệch với bài toán quản lý thông thường (nên cho chọn SV, chọn môn, và chỉ nhập các môn SV học).
        // Ngoài ra, nếu đã nhập full 1 lần thì các lần sau gần như không thể "nhập thêm" vì sẽ bị đánh dấu trùng.

        // NOTE: Chưa kiểm tra tràn mảng dsBD (nBD có thể > 100 nếu số SV * số MH lớn).
        for (int i = 0; i < nSV; i++) {
            for (int j = 0; j < nMH; j++) {

                // kiểm tra trùng
                boolean tonTai = false;
                for (int k = 0; k < nBD; k++) {
                    if (dsBD[k].getSv() == dsSV[i] &&
                            dsBD[k].getMon() == dsMH[j]) {
                        tonTai = true;
                        break;
                    }
                }

                if (!tonTai) {
                    System.out.print(dsSV[i].getHoTen() + " - " +
                            dsMH[j].getTenMon() + " điểm: ");

                    double d;
                    while (true) {
                        try {
                            d = Double.parseDouble(sc.nextLine());
                            if (d >= 0 && d <= 10) break;
                        } catch (Exception e) {}
                        System.out.print("Nhập lại (0-10): ");
                    }

                    dsBD[nBD++] = new BangDiem(dsSV[i], dsMH[j], d);
                }
            }
        }

        for (int i = 0; i < nBD; i++) dsBD[i].hienThi();
    }

    /*
     * ============================
     * SẮP XẾP
     * ============================
     */
    static void sapXep() {
        // NOTE (thiếu so với đề bài): Mục (4) yêu cầu sắp xếp bảng điểm theo:
        // a) Họ tên sinh viên
        // b) Tên môn học
        // Hiện tại hàm này chỉ sort theo Họ tên sinh viên, chưa có lựa chọn sort theo Tên môn.
        for (int i = 0; i < nBD - 1; i++) {
            for (int j = i + 1; j < nBD; j++) {

                if (dsBD[i].getSv().getHoTen()
                        .compareTo(dsBD[j].getSv().getHoTen()) > 0) {

                    BangDiem t = dsBD[i];
                    dsBD[i] = dsBD[j];
                    dsBD[j] = t;
                }
            }
        }

        for (int i = 0; i < nBD; i++) dsBD[i].hienThi();
    }

    /*
     * ============================
     * TÍNH ĐIỂM TB
     * ============================
     */
    static void tinhTB() {
        // NOTE: Công thức đang dùng là điểm TB có trọng số theo số tín chỉ (đúng yêu cầu mục 5).
        // Tuy nhiên output hiện chỉ in Họ tên -> điểm TB.
        // Bài quản lý thường cần in theo Mã SV hoặc đầy đủ thông tin SV để tránh trùng tên.
        for (int i = 0; i < nSV; i++) {
            double tong = 0;
            int tongTC = 0;

            for (int j = 0; j < nBD; j++) {
                if (dsBD[j].getSv() == dsSV[i]) {
                    tong += dsBD[j].getDiem() *
                            dsBD[j].getMon().getSoTinChi();
                    tongTC += dsBD[j].getMon().getSoTinChi();
                }
            }

            if (tongTC > 0) {
                System.out.println(dsSV[i].getHoTen() +
                        " -> " + (tong / tongTC));
            }
        }
    }

    /*
     * ============================
     * GHI FILE
     * ============================
     */
    static void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));

            // NOTE (đối chiếu yêu cầu lưu file): Hiện tại file chỉ lưu hoTen, tenMon, diem.
            // - Không lưu Mã SV, Địa chỉ, SĐT, Lớp.
            // - Không lưu Mã môn, Số tín chỉ, Loại môn.
            // - Không lưu theo cấu trúc để có thể đọc lên và khôi phục lại object.
            // => Chưa đáp ứng đúng ý "dữ liệu được lưu vào file" của bài quản lý.

            for (int i = 0; i < nBD; i++) {
                bw.write(dsBD[i].getSv().getHoTen() + "," +
                        dsBD[i].getMon().getTenMon() + "," +
                        dsBD[i].getDiem());
                bw.newLine();
            }

            bw.close();
            System.out.println("Đã ghi file!");
        } catch (Exception e) {
            System.out.println("Lỗi ghi file");
        }
    }

    /*
     * ============================
     * ĐỌC FILE
     * ============================
     */
    static void docFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;

            // NOTE (đối chiếu yêu cầu đọc file): Hàm này chỉ đọc và in từng dòng.
            // Chưa parse để khôi phục dsSV/dsMH/dsBD, nên không thể "load lại dữ liệu" để tiếp tục quản lý.
            // Ngoài ra, khi chạy lại chương trình, AUTO_ID của SinhVien/MonHoc đang reset về 10000/100,
            // nếu có cơ chế load thật thì cần cập nhật AUTO_ID theo mã lớn nhất để tránh trùng mã.

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file");
        }
    }
}